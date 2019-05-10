package com.example.pokebindingretrofit.api;

import com.example.pokebindingretrofit.models.Pokemon;
import com.example.pokebindingretrofit.models.Pokemons;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApiInterface {
    @GET("pokemon/?offset=0&limit=151")
    Call<Pokemons> getAllPokemons();

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);
}
