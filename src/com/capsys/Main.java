package com.capsys;

import com.capsys.parser.SAXLocalNameCount;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {

    static public void main(String[] args) throws Exception {
        String filename = null;
        if (args.length == 1) filename = args[0];
        else usage();

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new SAXLocalNameCount());
        xmlReader.parse(convertToFileURL(filename));

    }

    private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }

    private static void usage() {
        System.err.println("Usage: SAXLocalNameCount <file.xml>");
        System.err.println("       -usage or -help = this message");
        System.exit(1);
    }
}
