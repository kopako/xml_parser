package com.capsys;

import com.capsys.db.DbConnection;
import com.capsys.parser.SAXLocalNameCount;
import com.capsys.parser.model.ATxInf;
import com.capsys.parser.model.RcvTxInf;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Arrays;

public class Main {

    static public void main(String[] args) throws Exception {
        String filename = null;
        if (args.length == 1) {
            filename = args[0];
        } else {
            usage();
        }

        ATxInf.setConn(DbConnection.getConn());
        ATxInf.setBatchId(1);


        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new SAXLocalNameCount());
            xmlReader.parse(convertToFileURL(filename));
        } finally {
            DbConnection.getConn().commit();
            DbConnection.getConn().close();
        }


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
