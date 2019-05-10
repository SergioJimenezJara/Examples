package com.example.pokebindingretrofit.models;

import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;

public class Pokemons extends BaseObservable {

    private MutableLiveData<List<Pokemon>> breeds = new MutableLiveData<>();

    public MutableLiveData<List<Pokemon>> getBreeds() {
        return breeds;
    }

    public void setBreeds(MutableLiveData<List<Pokemon>> breeds) {
        this.breeds = breeds;
    }
}
