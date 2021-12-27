package com.epam.xmlXsdTask.entities.associatedClasses.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "mealType")
@XmlEnum
public enum MealType {
    @XmlEnumValue("AI")
    AI,
    @XmlEnumValue("BB")
    BB,
    @XmlEnumValue("HB")
    HB
}
