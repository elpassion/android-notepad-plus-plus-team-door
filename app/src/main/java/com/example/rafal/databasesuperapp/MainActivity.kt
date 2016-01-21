package com.example.rafal.databasesuperapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ListView
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {

    val listView by lazy { findViewById(R.id.listView) as ListView }
    //var listAdapter : SimpleCursorAdapter? = null
    //val data : Cursor by lazy { myDB.getData() }
    val myDB : NoteSQLHelper by lazy { NoteSQLHelper(this) }
    val data : ArrayList<Note> by lazy { myDB.getData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar1) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            runActivity(null)
        }

        title = "Notepad + +"
        //listAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, data, myDB.getNames(), intArrayOf(android.R.id.text1, android.R.id.text2), 1)
        listView.adapter = NoteAdapter(this, data)

        //myDB.insert("test", "test")

        listView.setOnItemClickListener { adapterView, view, position, id ->
            runActivity(data[position])
        }

    }

    private fun runActivity(extras : Serializable?) {
        val intent = Intent(this, NotepadActivity::class.java)
        if (extras != null)
            intent.putExtra("note", extras)
        startActivity(intent)
    }

}
