package com.epam.xmlXsdTask.entities.associatedClasses.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "roomType")
@XmlEnum
public enum RoomType {
    @XmlEnumValue("single")
    SINGLE,
    @XmlEnumValue("double")
    DOUBLE,
    @XmlEnumValue("triple")
    TRIPLE
}