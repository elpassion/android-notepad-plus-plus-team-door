package com.example.rafal.databasesuperapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.TwoLineListItem
import java.util.*

class NoteAdapter (val context: Context, val notes:ArrayList<Note>) : BaseAdapter() {

    companion object {
        val USED_VIEW = android.R.layout.simple_list_item_2
        val FIELD_VIEW_1 = android.R.id.text1
        val FIELD_VIEW_2 = android.R.id.text2
    }

    override fun getCount(): Int {
        return notes.size
    }

    override fun getItem(position: Int): Any {
        return notes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view : View
        if (convertView == null) {
            view = LayoutInflater.from(parent.context).inflate(USED_VIEW, parent, false)
        } else {
            view = convertView
        }
        bindItem(position, view)
        return view
    }

    private fun bindItem(position : Int, view : View) {
        val title = view.findViewById(FIELD_VIEW_1) as TextView
        val note = view.findViewById(FIELD_VIEW_2) as TextView
        title.text = notes!![position].title
        note.text = notes[position].note
    }


}
