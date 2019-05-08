package com.example.retrofit_example;

import com.example.retrofit_example.model.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Client {
    @GET("users/{user}/repos")
    Call<List<Repository>> reposForUser(@Path("user") String user);
}
