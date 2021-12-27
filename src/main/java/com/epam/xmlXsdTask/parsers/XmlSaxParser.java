package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlSaxParser implements Parser {

    private static final Logger LOGGER = LogManager.getLogger(XmlSaxParser.class);

    @Override
    public List<Voucher> parse(String filePath) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            LOGGER.error("Open sax parser error" + e);
        }

        File file = new File(filePath);

        try {
            if (parser != null) {
                parser.parse(file, handler);
            }
        } catch (SAXException e) {
            LOGGER.error("Sax parsing error" + e);
        } catch (IOException e) {
            System.out.println("IO sax parsing error" + e);
        }
        return handler.getVouchers();
    }
}
