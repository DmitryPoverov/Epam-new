package com.epam.xmlXsdTask.entities;

import java.util.ArrayList;
import java.util.List;

public class TouristVouchers {

    private List<Voucher> list;

    public TouristVouchers() {
        list = new ArrayList<>();
    }

    public TouristVouchers(List<Voucher> list) {
        this.list = list;
    }

    public List<Voucher> getList() {
        return list;
    }

    public void setList(List<Voucher> list) {
        this.list = list;
    }
}
