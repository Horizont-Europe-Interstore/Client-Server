package si.sunesis.interoperability.clientserver.server;

import io.nats.client.Options;
import lombok.extern.slf4j.Slf4j;
import org.ieee._2030.Event;
import si.sunesis.interoperability.clientserver.common.IEEEObjectFactory;
import si.sunesis.interoperability.nats.NatsConnection;

import java.io.IOException;

@Slf4j
public class Example {

    public static void main(String[] args) {
        Options options = new Options.Builder().server("nats://localhost:4222").build();

        NatsConnection natsConnection = new NatsConnection();
        try {
            natsConnection.connectSync(options, false);

            Server server = new Server(natsConnection);

            server.subscribe("devices.event", message -> {
                String msg = new String(message);
                log.info("Received message: {}", msg);

                Event event = IEEEObjectFactory.fromXMLToIEEE(msg, Event.class);
                // Do something with the event

                server.publish("events.event", IEEEObjectFactory.fromIEEEToJSON(event));
            });
        } catch (IOException | InterruptedException e) {
            log.error("Failed to connect to NATS server", e);
        }
    }
}
