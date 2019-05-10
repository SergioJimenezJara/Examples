package com.example.pokebindingretrofit.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeApi {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    public static PokeApiInterface api = null;

    public static PokeApiInterface getApi() {
        if (api == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            api = retrofit.create(PokeApiInterface.class);
        }
        return api;
    }

}
