package com.epam.informationHandler.parser;

import com.epam.informationHandler.component.Component;

public interface Parser {

    Component parse(String text);
}
