package sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author raptor
 *         date: 10.03.16
 */
public class ReadXMLFileSAX {
    public static Object readXML(String xmlFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

//            LogSAXHandler handler = new LogSAXHandler();
            SAXHandler handler = new SAXHandler();
            saxParser.parse(xmlFile, handler);

            return handler.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
