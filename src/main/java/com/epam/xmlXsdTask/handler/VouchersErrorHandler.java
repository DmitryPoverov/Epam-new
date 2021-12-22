package com.epam.xmlXsdTask.handler;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class VouchersErrorHandler extends DefaultHandler {
	 private static final Logger LOGGER = LogManager.getLogger(VouchersErrorHandler.class);
    private boolean isError = false;

    public void warning(SAXParseException e) {
        LOGGER.log(Level.WARN, getLineAddress(e) + " - " + e.getMessage());
        isError = true;
    }

    public void error(SAXParseException e) {
        LOGGER.log(Level.ERROR, getLineAddress(e) + " - " + e.getMessage());
        isError = true;

    }

    public void fatalError(SAXParseException e) {
        LOGGER.log(Level.FATAL, getLineAddress(e) + " - " + e.getMessage());
        isError = true;

    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

    public boolean isErrorHappened() {
        return isError;
    }

}
