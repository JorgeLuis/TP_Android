package edu.algo3.pois.service;



import com.google.gson.JsonObject;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Aangus 01/11/2016.
 */

public interface ServicePois {

    @GET("/pois")
    Call<List<JsonObject>> getPois();

}
