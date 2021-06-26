package it.uninsubria.usedbooks

import com.google.firebase.database.*


private lateinit var mDB: DatabaseReference

data class Book(
        val titolo:String? = null,
        val latitudine: Int? = null,
        val longitudine: Int? = null) {

        override fun toString(): String {
            return "$titolo"
        }
    }


    fun writeNewBook(book: Book) {

        mDB = FirebaseDatabase.getInstance().reference

        mDB.child("Books").push().setValue(book)
}
//
//fun readBooks() {
//
//    mDB = FirebaseDatabase.getInstance().reference
//    val key: String = mDB.key.toString()
//    return mDB.parent
//}
