package com.example.aplikasinote.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.aplikasinote.model.DefaultNote
import com.example.aplikasinote.model.ListNote
import com.example.aplikasinote.repo.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NoteRepository.getInstance(application)
    private val _noteId: MutableLiveData<Long> = MutableLiveData()

    val defaultNote: LiveData<DefaultNote> = Transformations
        .switchMap(_noteId) {
            repository.getDefaultNote(it)
        }

    val listNote: LiveData<List<ListNote>> = Transformations
        .switchMap(_noteId) {
            repository.getListNote(it)
        }

    fun setNoteId(id: Long) {
        if (_noteId.value == id) {
            return
        }
        _noteId.value = id
    }
}