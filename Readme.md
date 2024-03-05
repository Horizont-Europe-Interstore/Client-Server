# Client/Server

Client/Server is a project designed for native implementation of NATS and IEEE2030.5.
It supports communication over NATS and mapping of messages to IEEE2030.5 objects.

## Usage
Client/Server can be used in the project by importing the project from Maven Central or by using the JAR.

It is not standalone application, but a library that can be used in other projects. 
That is because users must implement few methods specific to their use cases.

## Mapping to the IEEE2030.5
The project contains all the classes that are used in the IEEE2030.5 standard.
Users can use these classes to map the messages to the IEEE2030.5 objects and vice versa.

Helper class `IEEEObjectFactory` is used to map the messages to the IEEE2030.5 objects and vice versa.
Methods `fromJSONToIEEE` and `fromXMLToIEEE` are used to map the messages to the IEEE2030.5 objects.
Methods `fromIEEEToJSON` and `fromIEEEToXML` are used to map the IEEE2030.5 objects to the messages.

Example of mapping a message to the IEEE2030.5 Event from JSON and then to XML is shown below:
```java
String message = """
            {
              "creationTime": 1702909917932,
              "eventStatus": {
                "currentStatus": 1,
                "dateTime": 1693216835000,
                "potentiallySuperseded": false
              },
              "interval": {
                "duration": 900,
                "start": 1693216835000
              }
            }
            """;

Event event = IEEEObjectFactory.fromJSONToIEEE(message, Event.class);

String xml = IEEEObjectFactory.fromIEEEToXML(event);
```

Example of mapping a message to the IEEE2030.5 Event from XML and then to JSON is shown below:
```java
String message = """
            <Event>
            	<creationTime>1702909917932</creationTime>
            	<EventStatus>
            		<currentStatus>1</currentStatus>
            		<dateTime>1693216835000</dateTime>
            		<potentiallySuperseded>false</potentiallySuperseded>
            	</EventStatus>
            	<interval>
            		<duration>900</duration>
            		<start>1693216835000</start>
            	</interval>
            </Event>
            """;

Event event = IEEEObjectFactory.fromXMLToIEEE(message, Event.class);

String json = IEEEObjectFactory.fromIEEEToJSON(event);
```

## NATS
The project contains the `Server` and `Client` class that is used to connect to the NATS server and to send and receive messages.

Example of using the `Server` class is shown below:
```java
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
```