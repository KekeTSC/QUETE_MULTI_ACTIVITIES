package com.example.apprenti.blablawild;

import java.util.Date;

public class TripResultModel {
    private String name;
    private Date date;
    private int prix;

    public TripResultModel(String name, Date date, int prix) {
        this.name = name;
        this.date = date;
        this.prix = prix;
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.date;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
