package com.example.rafal.databasesuperapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {

    var listview : ListView? = null
    //var listAdapter : ArrayAdapter<Note>? = null
    val data : ArrayList<Note>? by lazy { ArrayList<Note>()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        listview = findViewById(R.id.listView) as ListView
        title = "Notepad + +"

        data!!.add(Note("test","test"))
        data!!.add(Note("test","test"))
        data!!.add(Note("test","test"))
        data!!.add(Note("test","test"))

        //listAdapter = ArrayAdapter<Note>(this, android.R.layout.simple_list_item_2, data)
        val myAdapter = NoteAdapter(this, data!!)
        listview!!.adapter = myAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            save()
            return true
        }

        return super.onOptionsItemSelected(item)


    }

    private fun save() {

    }

}
