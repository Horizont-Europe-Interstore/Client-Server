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
package si.sunesis.interoperability.clientserver.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.ieee._2030.ObjectFactory;
import org.ieee._2030.TimeType;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author David Trafela, Sunesis
 * @since 1.0.0
 */
@Slf4j
public class IEEEObjectFactory {

    private IEEEObjectFactory() {
        throw new IllegalStateException("Utility class");
    }

    @SneakyThrows
    public static <T> T fromXMLToIEEE(String xml, Class<T> type) {
        if (!xml.contains("xmlns")) {
            xml = xml.replace("<" + type.getSimpleName() + ">", "<"
                    + type.getSimpleName() + " xmlns=\"http://ieee.org/2030.5\">");
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        return ((JAXBElement<T>) jaxbContext.createUnmarshaller()
                .unmarshal(new StringReader(xml)))
                .getValue();
    }

    @SneakyThrows
    public static <T> String fromIEEEToXML(T element, Class<T> objectClass) {
        StringWriter stringWriter = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // format the XML output
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        QName qName = new QName("http://ieee.org/2030.5", objectClass.getSimpleName());
        JAXBElement<T> root = new JAXBElement<>(qName, objectClass, element);

        jaxbMarshaller.marshal(root, stringWriter);

        return stringWriter.toString();
    }

    @SneakyThrows
    public static <T> T fromJSONToIEEE(String json, Class<T> objectClass) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(TimeType.class, new TimeTypeAdapter())
                .create();

        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> originalMap = gson.fromJson(json, type);

        Map<String, Object> newMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : originalMap.entrySet()) {
            newMap.put(entry.getKey().substring(0, 1).toLowerCase() + entry.getKey().substring(1), entry.getValue());
        }

        String newJsonInput = gson.toJson(newMap);

        return gson.fromJson(newJsonInput, objectClass);
    }

    public static String fromIEEEToJSON(Object object) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(TimeType.class, new TimeTypeAdapter())
                .setPrettyPrinting()
                .create();

        return gson.toJson(object);
    }

    private static class TimeTypeAdapter extends TypeAdapter<TimeType> {

        @Override
        public void write(JsonWriter jsonWriter, TimeType timeType) throws IOException {
            if (timeType == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(timeType.getValue());
            }
        }

        @Override
        public TimeType read(JsonReader jsonReader) throws IOException {
            if (jsonReader != null) {
                TimeType timeType = new TimeType();
                timeType.setValue(jsonReader.nextLong());
                return timeType;
            } else {
                return null;
            }
        }
    }
}
