package com.aafanasev.fonoapi.sample;

import com.aafanasev.fonoapi.DeviceEntity;
import com.aafanasev.fonoapi.retrofit.FonoApiFactory;
import com.aafanasev.fonoapi.retrofit.FonoApiService;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class JavaSample {

    // TODO: https://fonoapi.freshpixl.com/token/generate
    private static final String TOKEN = "";

    public static void main(String[] args) throws IOException {
        showcaseRetrofit();
    }

    private static void showcaseRetrofit() throws IOException {
        FonoApiService api = new FonoApiFactory().create();

        Response<List<DeviceEntity>> response = api.getLatest(TOKEN, "samsung", 1).execute();
        response.body().forEach(device -> System.out.println("First device: " + device.getDeviceName()));
    }

}
