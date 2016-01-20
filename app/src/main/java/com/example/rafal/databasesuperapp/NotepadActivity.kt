package com.example.rafal.databasesuperapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

class NotepadActivity : AppCompatActivity() {

    val noteTitle by lazy { findViewById(R.id.note_title) as EditText }
    val noteText by lazy { findViewById(R.id.note_text) as EditText }
    val myDB: NoteSQLHelper by lazy { NoteSQLHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notepad)

        val toolbar = findViewById(R.id.toolbar2) as Toolbar
        setSupportActionBar(toolbar)

        title = "Add new note"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.action_save_note) {
            myDB.insert(noteTitle.text.toString(), noteText.text.toString())
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

