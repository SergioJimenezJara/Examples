package com.example.roomwordsample.viewModel;

import android.app.Application;

import com.example.roomwordsample.model.Word;
import com.example.roomwordsample.repository.WordRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {
    private WordRepository repository;
    private LiveData<List<Word>> words;

    public WordViewModel(@NonNull Application application) {
        super(application);
        this.repository = new WordRepository(application);
        this.words = repository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() { return words; }

    public void insert(Word word) { repository.insert(word); }
}
