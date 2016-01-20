package com.example.rafal.databasesuperapp

import android.database.Cursor
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {

    var listview : ListView? = null
    var listAdapter : SimpleCursorAdapter? = null
    val data : Cursor by lazy { myDB.getData() }
    val myDB : NoteSQLHelper by lazy { NoteSQLHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        title = "Notepad + +"
        listview = findViewById(R.id.listView) as ListView
        listAdapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, data, myDB.getNames(), intArrayOf(android.R.id.text1, android.R.id.text2), 1)
        listview!!.adapter = listAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_save) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
