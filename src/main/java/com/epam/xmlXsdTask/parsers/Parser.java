package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.exceptoin.ParserException;

import java.util.List;

public interface Parser {
    List<Voucher> parse(String filePath) throws ParserException;
}
