package si.sunesis.interoperability.clientserver.common.test;

import lombok.extern.slf4j.Slf4j;
import org.ieee._2030.Event;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import si.sunesis.interoperability.clientserver.common.IEEEObjectFactory;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IEEETest {

    private static final String serverXMLInput = """
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

    private static final String serverXMLInput2 = """
            <EventStatus>
            		<currentStatus>1</currentStatus>
            		<dateTime>1693216835000</dateTime>
            		<potentiallySuperseded>false</potentiallySuperseded>
            	</EventStatus>
            """;

    private static final String serverJsonInput = """
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

    @Test
    public void testA() {
        // XML to IEEE
        Event event = IEEEObjectFactory.fromXMLToIEEE(serverXMLInput, Event.class);

        Assert.assertNotNull(event);

        Assert.assertEquals(1702909917932L, event.getCreationTime().getValue());
    }

    @Test
    public void testB() {
        // XML to IEEE to JSON
        Event event = IEEEObjectFactory.fromXMLToIEEE(serverXMLInput, Event.class);

        String json = IEEEObjectFactory.fromIEEEToJSON(event);
        log.info("JSON: \n{}", json);

        Assert.assertEquals(serverJsonInput.trim(), json);
    }

    @Test
    public void testC() {
        // JSON to IEEE
        Event event = IEEEObjectFactory.fromJSONToIEEE(serverJsonInput, Event.class);

        Assert.assertNotNull(event);

        Assert.assertEquals(1702909917932L, event.getCreationTime().getValue());
    }
}
