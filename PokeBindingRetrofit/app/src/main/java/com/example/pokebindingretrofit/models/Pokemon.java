package com.example.pokebindingretrofit.models;

import androidx.databinding.BaseObservable;

public class Pokemon extends BaseObservable {
    int id;
    String name;
    String imgURL;

    public Pokemon(int id, String name, String imgURL) {
        this.id = id;
        this.name = name;
        this.imgURL = imgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
