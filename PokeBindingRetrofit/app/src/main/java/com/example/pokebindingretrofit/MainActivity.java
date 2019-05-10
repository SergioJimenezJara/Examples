package com.example.pokebindingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pokebindingretrofit.api.PokeApi;
import com.example.pokebindingretrofit.api.PokeApiInterface;
import com.example.pokebindingretrofit.models.Pokemon;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PokeApiInterface a = PokeApi.getApi();
        Call<Pokemon> call = a.getPokemon(1);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                 Pokemon p = response.body();
                 p.setImgURL("");
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
