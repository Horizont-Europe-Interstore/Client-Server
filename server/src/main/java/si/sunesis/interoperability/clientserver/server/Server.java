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

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import si.sunesis.interoperability.nats.AbstractNatsRequestHandler;
import si.sunesis.interoperability.nats.NatsConnection;

/**
 * Server class for IEEE2030.5 communication over NATS.
 * This class extends AbstractNatsRequestHandler to handle NATS messaging for server-side communications.
 * It allows EMS systems to communicate with devices using the IEEE2030.5 protocol through NATS.
 * 
 * @author David Trafela, Sunesis
 * @since 1.0.0
 */
@Getter
@Slf4j
public class Server extends AbstractNatsRequestHandler {

    /**
     * NATS connection used for communication with devices.
     */
    private final NatsConnection natsConnection;

    /**
     * Constructs a new Server instance with the specified NATS connection.
     *
     * @param natsConnection The NATS connection to use for communication
     */
    public Server(NatsConnection natsConnection) {
        super(natsConnection);

        this.natsConnection = natsConnection;
    }

    /**
     * Processes a stream request received from the NATS stream.
     * Override this method to implement custom stream request handling logic for EMS systems.
     *
     * @param subject The subject the message was received on
     * @param bytes The message payload as a byte array
     * @return The response to be sent back, or null if no response is needed
     */
    @Override
    public String processStreamRequest(String subject, byte[] bytes) {
        return null;
    }

    /**
     * Processes a reply request received from the NATS request-reply pattern.
     * Override this method to implement custom request-reply handling logic for EMS systems.
     *
     * @param subject The subject the message was received on
     * @param bytes The message payload as a byte array
     * @return The response to be sent back, or null if no response is needed
     */
    @Override
    public String processReplyRequest(String subject, byte[] bytes) {
        return null;
    }
}
