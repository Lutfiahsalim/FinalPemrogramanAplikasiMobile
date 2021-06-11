package com.example.aplikasinote.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplikasinote.model.DefaultNote
import com.example.aplikasinote.model.ListNote
import com.example.aplikasinote.model.Note

@Database(entities = [
    Note::class,
    DefaultNote::class,
    ListNote::class,
], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun defaultNoteDao(): DefaultNoteDao
    abstract fun listNoteDao(): ListNoteDao
}