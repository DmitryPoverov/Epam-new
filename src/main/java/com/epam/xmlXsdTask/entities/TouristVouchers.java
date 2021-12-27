package com.epam.xmlXsdTask.entities;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "touristVouchers", namespace = "test")
@XmlAccessorType(XmlAccessType.FIELD)
public class TouristVouchers {

    @XmlElements({
            @XmlElement(name = "familyVoucher", namespace = "test", type = FamilyVoucher.class),
            @XmlElement(name = "businessVoucher", namespace = "test", type = BusinessVoucher.class),
    })
    private final List<Voucher> list = new ArrayList<>();

    public TouristVouchers() {
    }

    public List<Voucher> getList() {
        return list;
    }
}
