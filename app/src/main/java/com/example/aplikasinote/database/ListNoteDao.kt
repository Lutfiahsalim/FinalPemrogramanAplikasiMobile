package com.example.aplikasinote.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aplikasinote.model.ListNote

@Dao
interface ListNoteDao {
    @Query("SELECT * FROM list_note WHERE note_id = :id ")
    suspend fun getAll(id: Long): List<ListNote>

    @Insert
    suspend fun insert(listNote: List<ListNote>)
}