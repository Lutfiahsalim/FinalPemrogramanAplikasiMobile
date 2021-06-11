package com.example.aplikasinote.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "list_note",
    foreignKeys = [ForeignKey(
        entity = Note::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("note_id"),
        onUpdate = CASCADE,
        onDelete = CASCADE
    )],
    indices = [Index(value = ["note_id"], unique = false)]
)
data class ListNote(
    var check: Boolean,
    var item: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var title: String = ""

    @ColumnInfo(name = "note_id")
    var noteId: Long = 0
}
