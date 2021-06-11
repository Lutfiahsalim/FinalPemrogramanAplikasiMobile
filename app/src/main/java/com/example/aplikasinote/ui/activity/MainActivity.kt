package com.example.aplikasinote.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.aplikasinote.R
import com.example.aplikasinote.adapter.NoteAdapter
import com.example.aplikasinote.model.Note
import com.example.aplikasinote.ui.viewModel.MainViewModel
import com.zukron.note.ui.activity.DetailNoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, NoteAdapter.OnClickSelected {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // toolbar
        material_toolbar.title = ""
        setSupportActionBar(material_toolbar)

        // adapter
        noteAdapter = NoteAdapter(this)
        noteAdapter.setOnClickSelected(this)

        // recycler view
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, 1)
        recycler_view.layoutManager = staggeredGridLayoutManager
        recycler_view.adapter = noteAdapter

        // view model
        mainViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(MainViewModel::class.java)

        mainViewModel.mixNote.observe(this) {
            noteAdapter.mixNote = it
        }

        // floating button listener
        fab_create.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent(this@MainActivity, DetailNoteActivity::class.java)
        intent.putExtra(DetailNoteActivity.EXTRA_ACTION, Note.Action.insert)
        startActivity(intent)
    }

    override fun onClickSelected(note: Note) {
        val intent = Intent(this@MainActivity, DetailNoteActivity::class.java)
        intent.putExtra(DetailNoteActivity.EXTRA_ACTION, Note.Action.update)
        intent.putExtra(DetailNoteActivity.EXTRA_NOTE_ID, note.id)
        startActivity(intent)
    }
}