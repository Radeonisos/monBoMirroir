package com.entreprise.davfou.monmirroir.data.rest.clientWs;

import com.entreprise.davfou.monmirroir.data.rest.methodeRest.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by davidfournier on 04/06/2017.
 */

public  class  ClientRetrofit {



    public ClientRetrofit() {

    }


    public static ApiInterface getClient(){
        ApiInterface apiInterface;

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        apiInterface = new Retrofit.Builder()
                .baseUrl(ApiInterface.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiInterface.class);

        return apiInterface;
    }


}
