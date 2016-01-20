package com.example.rafal.databasesuperapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.TwoLineListItem

import java.util.ArrayList

/**
 * Created by kit on 20/01/16.
 */
class NoteAdapter (val context: Context, val notes:ArrayList<Note>) : BaseAdapter() {

    override fun getCount(): Int {
        return notes!!.size
    }

    override fun getItem(position: Int): Any {
        return notes!![position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        // todo co za burdel
        val twoLineListItem: TwoLineListItem

        if (convertView == null) {
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            twoLineListItem = inflater.inflate(
                    android.R.layout.simple_list_item_2, null) as TwoLineListItem
        } else {
            twoLineListItem = convertView as TwoLineListItem
        }

        val text1 = twoLineListItem.text1
        val text2 = twoLineListItem.text2

        text1.text = notes!![position].title
        text2.text = notes[position].note

        return twoLineListItem
    }

}
