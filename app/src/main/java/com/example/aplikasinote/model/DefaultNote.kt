package com.example.aplikasinote.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "default_note",
    foreignKeys = [ForeignKey(
        entity = Note::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("note_id"),
        onUpdate = CASCADE,
        onDelete = CASCADE
    )],
    indices = [Index(value = ["note_id"], unique = true)]
)
data class DefaultNote(
    var body: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var title: String = ""

    @ColumnInfo(name = "note_id")
    var noteId: Long = 0
}