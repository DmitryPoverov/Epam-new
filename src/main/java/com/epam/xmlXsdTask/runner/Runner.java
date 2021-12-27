package com.epam.xmlXsdTask.runner;

import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.exceptoin.ParserException;
import com.epam.xmlXsdTask.parsers.Parser;
import com.epam.xmlXsdTask.parsers.XmlDomParser;
import com.epam.xmlXsdTask.parsers.XmlJaxbParser;
import com.epam.xmlXsdTask.parsers.XmlSaxParser;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final String FILE_PATH = "src/main/resources/vouchers.xml";

    public static void main(String[] args) {
        List<Voucher> parseList = new ArrayList<>();

        System.out.println("\n1) Xml DOM Parser:");
        Parser xmlDomParser = new XmlDomParser();
        try {
            parseList = xmlDomParser.parse(FILE_PATH);
            for (Voucher i : parseList) {
                System.out.println(i);
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }

        System.out.println("\n2) Xml SAX Parser:");
        Parser xmlSaxParser = new XmlSaxParser();
        try {
            parseList = xmlSaxParser.parse(FILE_PATH);
        } catch (ParserException e) {
            e.printStackTrace();
        }
        for (Voucher i : parseList) {
            System.out.println(i);
        }

        System.out.println("\n3) Xml JAXB Parser:");
        Parser xmlJaxbParser = new XmlJaxbParser();
        List<Voucher> lisTouristVouchers = null;
        try {
            lisTouristVouchers = xmlJaxbParser.parse(FILE_PATH);
        } catch (ParserException e) {
            e.printStackTrace();
        }
        if (lisTouristVouchers != null) {
            for (Voucher i : lisTouristVouchers) {
                System.out.println(i);
            }
        }
    }
}
