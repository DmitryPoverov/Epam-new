package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.TouristVouchers;
import com.epam.xmlXsdTask.exceptoin.ParserException;
import com.epam.xmlXsdTask.handler.SaxParserHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlSaxParser implements Parser{

    @Override
    public List<Voucher> parse(String filePath) throws ParserException {
        return null;
    }

    public TouristVouchers parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser error" + e);
            return null;
        }

        File file = new File("src/main/resources/vouchers.xml");

        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e);
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error" + e);
            return null;
        }

        return handler.getTouristVouchers();
    }
}
