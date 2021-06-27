package it.uninsubria.usedbooks

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.*


private lateinit var mDB: DatabaseReference

data class Book(
    val titolo: String? = null,
    val latitudine: Int? = null,
    val longitudine: Int? = null,
    val prezzo: Int? = null
) {

    override fun toString(): String {
        return "$titolo"
    }
}


fun writeNewBook(book: Book) {

    mDB = FirebaseDatabase.getInstance().getReference("Books")

    mDB.push().setValue(book).addOnSuccessListener {
        Log.i("Firebase", "Libro $book inserito")

    }
        .addOnFailureListener {
            Log.e("Firebase:", "Libro $book non inserito")
        }
}

fun readBooks() {

}