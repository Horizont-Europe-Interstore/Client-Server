/*
 *  Copyright (c) 2023-2024 Sunesis and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package si.sunesis.interoperability.clientserver.server;

import ieee.std._2030_5.ns.Event;
import io.nats.client.Connection;
import io.nats.client.Options;
import lombok.extern.slf4j.Slf4j;
import si.sunesis.interoperability.common.exceptions.HandlerException;
import si.sunesis.interoperability.common.ieee2030dot5.IEEEObjectFactory;
import si.sunesis.interoperability.nats.NatsConnection;

/**
 * @author David Trafela, Sunesis
 * @since 1.0.0
 */
@Slf4j
public class Example {

    public static void main(String[] args) {
        Options options = new Options.Builder().server("nats://localhost:4222").build();

        NatsConnection natsConnection = new NatsConnection();
        try (Connection ignored = natsConnection.connectSync(options, false)) {
            Server server = new Server(natsConnection);

            server.subscribe("devices.event", message -> {
                String msg = new String(message);
                log.info("Received message: {}", msg);

                Event event = IEEEObjectFactory.fromXMLToIEEE(msg, Event.class);
                // Do something with the event

                try {
                    server.publish("events.event", IEEEObjectFactory.fromIEEEToJSON(event));
                } catch (HandlerException e) {
                    log.error("Failed to publish event", e);
                }
            });
        } catch (Exception e) {
            log.error("Failed to connect to NATS server", e);
        }
    }
}
