package com.epam.informationHandler.component;

import java.util.List;

public interface Component {

    List<Component> getTextParts();
    String getValue();
}
