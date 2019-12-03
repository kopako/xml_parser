package com.capsys.parser;

import com.capsys.parser.model.RcvTxInf;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SAXLocalNameCount extends DefaultHandler {

    private Map<String, Boolean> tableFlags = new HashMap<String, Boolean>() {{
        put("RcvTxInf", false);
        put("RjctTxInf", false);
        put("SntTxInf", false);
    }};
    private Object rcvTxInf = null;
    private StringBuilder data = null;

    private boolean bStartElement = false;



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (tableFlags.containsKey(qName)) {
            tableFlags.put(qName, true);
            bStartElement = true;
            // initialize Employee object and set id attribute
            try {
                rcvTxInf = Class
                        .forName("com.capsys.parser.model."+ qName)
                        .getDeclaredConstructor(null).newInstance();
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (bStartElement && Arrays.stream(rcvTxInf.getClass().getDeclaredFields())
                .map(Field::getName)
                .anyMatch(a -> a.equalsIgnoreCase(qName))) {
            Field dynamicField;
            try {
                dynamicField = rcvTxInf.getClass().getDeclaredField(qName);
                dynamicField.setAccessible(true);
                dynamicField.set(rcvTxInf, data.toString());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (tableFlags.containsKey(qName)) {
            tableFlags.replaceAll((k, v) -> false);
            bStartElement = false;
            System.out.println(rcvTxInf);
        }
    }

    @Override
    public void endDocument() throws SAXException {

    }
}