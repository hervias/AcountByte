package com.example.testbytefinal.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListAcount {
    @SerializedName("statement")
    private List<Acount> statement;

    public List<Acount> getStatement() {
        return statement;
    }

    public void setStatement(List<Acount> statement) {
        this.statement = statement;
    }
}
