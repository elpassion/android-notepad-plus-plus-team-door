package com.example.rafal.databasesuperapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class NoteSQLHelper(context: Context) : SQLiteOpenHelper(context, NoteSQLHelper.DATABASE_NAME, null, 2) {
    //private val hp: HashMap<Any, Any>? = null

    companion object {
        const val DATABASE_NAME = "NyNotes.db"
        const val TABLE_NAME = "notes"
        const val COLUMN_ID = "_id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_NOTE = "note"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table $TABLE_NAME ($COLUMN_ID integer primary key, $COLUMN_TITLE text, $COLUMN_NOTE text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insert(title: String, note: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_TITLE, title)
        contentValues.put(COLUMN_NOTE, note)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return true
    }

    fun update(id: String, title: String, note: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_TITLE, title)
        contentValues.put(COLUMN_NOTE, note)
        db.update(TABLE_NAME, contentValues, "$COLUMN_ID = ?", arrayOf(id))
        db.close()
        return true
    }

    fun getData(): ArrayList<Note> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("select * from $TABLE_NAME", null)
        val response : ArrayList<Note> = NoteFactory.makeNotes(cursor) as ArrayList<Note>
        db.close()
        return response
    }

    fun getNames() : Array<String> {
        return arrayOf(COLUMN_TITLE, COLUMN_NOTE, COLUMN_ID)
    }
    /*

    fun getData(): Cursor {
        val db = this.readableDatabase
        val res = db.rawQuery("select * from $TABLE_NAME", null)
        db.close()
        return res
    }


    fun numberOfRows(): Int {
        val db = this.readableDatabase
        val numRows = DatabaseUtils.queryNumEntries(db, TABLE_NAME).toInt()
        return numRows
    }



    fun deleteContact(id: Int): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME,
                "id = ? ",
                arrayOf(Integer.toString(id)))
    } */

}




