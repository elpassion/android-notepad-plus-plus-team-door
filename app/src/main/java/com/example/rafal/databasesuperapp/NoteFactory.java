package com.example.rafal.databasesuperapp;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class NoteFactory {

    public static List<Note> makeNotes(Cursor cursor) {
        List<Note> items = new ArrayList<Note>();

        if (cursor != null) {
            // add items to the list
            for (cursor.moveToFirst(); cursor.isAfterLast() == false; cursor.moveToNext()) {
                items.add(
                        new Note(cursor.getString(1), cursor.getString(2), cursor.getString(0))
                );
            }
        }
        return items;
    }
}
