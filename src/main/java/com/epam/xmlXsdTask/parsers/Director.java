package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.exceptoin.ParserException;
import com.epam.xmlXsdTask.validator.VouchersValidator;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private Parser parser;
    private VouchersValidator vouchersValidator;

    public Director(Parser parser, VouchersValidator vouchersValidator) {
        this.parser = parser;
        this.vouchersValidator = vouchersValidator;
    }

    public List<Voucher> parseXml(String xmlPath, String xsdPath) throws ParserException {
        List<Voucher> listOfVouchers = new ArrayList<>();
        if (vouchersValidator.isValid(xmlPath, xsdPath)) {
            listOfVouchers = parser.parse(xmlPath);
        }
        return listOfVouchers;
    }
}