package com.example.roomwordsample.dao;

import com.example.roomwordsample.model.Word;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WordDao {
    @Insert
    public void insert(Word word);

    @Query("DELETE FROM word_table")
    public void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    public LiveData<List<Word>> getAllWords();
}
