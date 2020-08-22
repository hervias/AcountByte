package com.example.testbytefinal.webservice;

import com.example.testbytefinal.model.ListAcount;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServiceClient {
    @GET("statements")
    Call<ListAcount> getAcounts();
}
