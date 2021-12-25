package com.epam.xmlXsdTask.runner;

import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.exceptoin.ParserException;
import com.epam.xmlXsdTask.parsers.XmlDomParser;
import com.epam.xmlXsdTask.parsers.XmlSaxParser;

import java.util.List;

public class Runner {

    private static final String FILE_PATH = "src/main/resources/vouchers.xml";

    public static void main(String[] args) {
        List<Voucher> parseList;

        System.out.println("\n1) Xml DOM Parser:");
        XmlDomParser xmlDomParser = new XmlDomParser();
        try {
            parseList = xmlDomParser.parse(FILE_PATH);
            for (Voucher i : parseList) {
                System.out.println(i);
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }

        System.out.println("\n2) Xml SAX Parser:");
        XmlSaxParser xmlSaxParser = new XmlSaxParser();
        parseList = xmlSaxParser.parse(FILE_PATH);
        for (Voucher i : parseList) {
            System.out.println(i);
        }
    }
}
