package com.example.rafal.databasesuperapp

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {

    val listView by lazy { findViewById(R.id.listView) as ListView }
    var listAdapter : SimpleCursorAdapter? = null
    val data : Cursor by lazy { myDB.getData() }
    val myDB : NoteSQLHelper by lazy { NoteSQLHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar1) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            val intent = Intent(this, NotepadActivity::class.java)
            startActivity(intent)
        }

        title = "Notepad + +"
        listAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, data, myDB.getNames(), intArrayOf(android.R.id.text1, android.R.id.text2), 1)
        listView.adapter = listAdapter

        myDB.insert("test", "test")

//        listView.setOnItemClickListener { adapterView, view, i, l ->  }

    }



}
