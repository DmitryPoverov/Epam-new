package com.epam.xmlXsdTask.validator;

import com.epam.xmlXsdTask.handler.VoucherErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class VouchersValidator {
    private static final Logger LOGGER = LogManager.getLogger(VouchersValidator.class);
    public static void main(String[] args) {
        VouchersValidator test = new VouchersValidator();
        test.isValid("src/main/resources/vouchers.xml", "src/main/resources/vouchersSchema.xsd");
    }

    public boolean isValid(String xmlPath, String xsdPath) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        boolean isValid = true;

        try {
            File xsdFile = new File(xsdPath);

            Schema schema = schemaFactory.newSchema(xsdFile);
            Source source = new StreamSource(xmlPath);

            Validator validator = schema.newValidator();
            VoucherErrorHandler errorHandler = new VoucherErrorHandler();
            validator.setErrorHandler(errorHandler);
            validator.validate(source);

            if (errorHandler.isErrorHappened()) {
                isValid = false;
            }

            LOGGER.info(String.format("File %s is valid.", xmlPath));

        } catch (SAXException | IOException e) {
            LOGGER.info(String.format("File %s is not valid.", xmlPath), e);
        }
        return isValid;
    }
}
