package com.example.aplikasinote.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.aplikasinote.model.MixNote
import com.example.aplikasinote.repo.NoteRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NoteRepository.getInstance(application)

    val mixNote: LiveData<MixNote> = repository.getMixNote()
}