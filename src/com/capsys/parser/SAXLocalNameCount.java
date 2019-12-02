package com.capsys.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SAXLocalNameCount extends DefaultHandler {

    private Map<String, Boolean> tableFlags = new HashMap<String, Boolean>() {{
        put("RcvTxInf", false);
        put("RjctTxInf", false);
        put("SntTxInf", false);
    }};

    public void startDocument() throws SAXException {
        System.out.println("= startDocument");
    }

    public void endDocument() throws SAXException {
        System.out.println("= endDocument");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (tableFlags.containsKey(localName) && !tableFlags.get(localName)) {
            System.out.println("* startElement: " + localName);
            tableFlags.put(localName, true);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (tableFlags.containsKey(localName) && tableFlags.containsValue(true)) {
            System.out.println("* endElement: " + localName);
            tableFlags.replaceAll((k, v) -> false);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tableFlags.containsValue(true)) {
            System.out.println("- Start invoke");
            System.out.println(new String(ch, start, length));
            System.out.println("- End invoke");
        }
    }

    public static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }

    public static void usage() {
        System.err.println("Usage: SAXLocalNameCount <file.xml>");
        System.err.println("       -usage or -help = this message");
        System.exit(1);
    }
}