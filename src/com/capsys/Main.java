package com.capsys;

import com.capsys.parser.SAXLocalNameCount;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {

    static public void main(String[] args) throws Exception {
        String filename = null;

        for (int i = 0; i < args.length; i++) {
            filename = args[i];
            if (i != args.length - 1) {
                SAXLocalNameCount.usage();
            }
        }

        if (filename == null) {
            SAXLocalNameCount.usage();
        }

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new SAXLocalNameCount());
        xmlReader.parse(SAXLocalNameCount.convertToFileURL(filename));
    }
}
