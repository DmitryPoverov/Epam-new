package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.TouristVouchers;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.exceptoin.ParserException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class XmlJaxbParser implements Parser {

    @Override
    public List<Voucher> parse(String filePath) throws ParserException {

        List<Voucher> listOfVouchers;

        try {
            JAXBContext context = JAXBContext.newInstance(TouristVouchers.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader(filePath);
            TouristVouchers touristVouchers = (TouristVouchers) unmarshaller.unmarshal(reader);
            listOfVouchers = touristVouchers.getList();

        } catch (JAXBException | FileNotFoundException e) {
            throw new ParserException("Jaxb parsing exception", e);
        }
        return listOfVouchers;
    }
}
