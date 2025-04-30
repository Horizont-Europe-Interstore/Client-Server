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
 * Example class demonstrating how to use the Server class for IEEE2030.5 communication.
 * This class shows how to connect to a NATS server, subscribe to messages, process IEEE2030.5 events,
 * and publish responses using the Server component.
 * 
 * @author David Trafela, Sunesis
 * @since 1.0.0
 */
@Slf4j
public class Example {

    /**
     * Main method that demonstrates the usage of the Server class.
     * This example shows how to:
     * 1. Connect to a NATS server
     * 2. Create a Server instance
     * 3. Subscribe to device events
     * 4. Convert IEEE2030.5 XML messages to Java objects
     * 5. Convert Java objects back to JSON format and publish
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Configure NATS connection options with server URL
        Options options = new Options.Builder().server("nats://localhost:4222").build();

        // Create NATS connection
        NatsConnection natsConnection = new NatsConnection();
        try (Connection ignored = natsConnection.connectSync(options, false)) {
            // Initialize the Server with the NATS connection
            Server server = new Server(natsConnection);

            // Subscribe to device events on the "devices.event" subject
            server.subscribe("devices.event", message -> {
                // Convert byte array to string
                String msg = new String(message);
                log.info("Received message: {}", msg);

                // Parse XML message to IEEE2030.5 Event object
                Event event = IEEEObjectFactory.fromXMLToIEEE(msg, Event.class);
                // Do something with the event

                try {
                    // Convert Event object to JSON and publish to "events.event" subject
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
