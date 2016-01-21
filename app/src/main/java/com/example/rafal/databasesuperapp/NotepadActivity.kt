package com.example.rafal.databasesuperapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

class NotepadActivity : AppCompatActivity() {
    private var note : Note? = null
    val noteTitle by lazy { findViewById(R.id.note_title) as EditText }
    val noteText by lazy { findViewById(R.id.note_text) as EditText }
    val myDB: NoteSQLHelper by lazy { NoteSQLHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notepad)
        val toolbar = findViewById(R.id.toolbar2) as Toolbar
        setSupportActionBar(toolbar)
        if (getNote()) {
            title = "Edit note"
            setUpGUI(note!!)
        } else {
            title = "Add new note"
        }
    }

    private fun getNote() : Boolean {
        val bundle = intent.extras
        if (bundle != null && bundle.containsKey("note")) {
            note = bundle.getSerializable("note") as Note
            return true
        } else {
            note = null //todo
            return false
        }
    }

    private fun setUpGUI(note : Note) {
        noteTitle.setText(note.title)
        noteText.setText(note.note)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.action_save_note) {
            if (note == null)
                myDB.insert(noteTitle.text.toString(), noteText.text.toString())
            else
                myDB.update(note!!.id, noteTitle.text.toString(), noteText.text.toString())
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

