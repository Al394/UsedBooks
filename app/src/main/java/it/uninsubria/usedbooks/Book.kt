package it.uninsubria.usedbooks

import android.util.Log
import com.google.firebase.database.*
import kotlin.concurrent.thread

private var TAG = "Book"
private var mDB: DatabaseReference = FirebaseDatabase.getInstance().getReference("Books")

data class Book(
    val titolo: String? = null,
    val autore: String? = null,
    val latitudine: Int? = null,
    val longitudine: Int? = null,
    val prezzo: Int? = null,
) {


    override fun toString(): String {
        return "$titolo"
    }
}


fun writeNewBook(book: Book) {


    Log.i(TAG, "Working with ${Thread.currentThread().name}")
    mDB.push().setValue(book).addOnSuccessListener {
        Log.i(TAG, "Libro $book inserito")

    }
        .addOnFailureListener {
            Log.e(TAG, "Libro $book non inserito")
        }

}