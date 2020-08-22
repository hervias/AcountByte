package com.example.testbytefinal.model;

import com.google.gson.annotations.SerializedName;

public class Acount {
    @SerializedName("description")
    private String name;

    @SerializedName("date")
    private String date;

    @SerializedName("amount")
    private String amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
