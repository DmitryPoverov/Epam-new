package com.epam.xmlXsdTask.runner;

import com.epam.xmlXsdTask.entities.TouristVouchers;
import com.epam.xmlXsdTask.parsers.XmlSaxParser;

public class Main {
    public static void main(String[] args) {

        XmlSaxParser parser = new XmlSaxParser();
        TouristVouchers touristVouchers = parser.parse();
        System.out.println("touristVouchers: " + touristVouchers);
    }
}
