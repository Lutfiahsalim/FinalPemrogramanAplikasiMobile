package com.example.aplikasinote.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.aplikasinote.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM note WHERE type IN (${Note.Type.defaultNote}, ${Note.Type.longNote}) ORDER BY id DESC")
    suspend fun getAllDefaultNotes(): List<Note>

    @Query("SELECT * FROM note WHERE type = ${Note.Type.listNote} ORDER BY id DESC")
    suspend fun getAllListNotes(): List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNote(id: Long): Note

    @Insert
    suspend fun insert(note: Note): Long

    @Update
    suspend fun update(note: Note)

    @Query("DELETE FROM note WHERE id = :id")
    suspend fun delete(id: Long)
}