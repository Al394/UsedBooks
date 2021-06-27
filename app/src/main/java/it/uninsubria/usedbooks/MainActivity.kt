package it.uninsubria.usedbooks

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var mDB: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottone.setOnClickListener {
            readBooks()
            Log.i("Prova", "Maronna")


        }

        mDB = FirebaseDatabase.getInstance().reference


//
//        val narm = mDB.database.reference
//
//        val prza = narm.child("Book").orderByChild("titolo")
//
//
//        testo.text = prza.toString()
//
        val b = Book("Alala", 1, 1)
//        val f = Book("Prova", 2, 1)
//        val z = Book("Pierino frazz",12,31)
//        val ff: String = readBooks()


        writeNewBook(b)
//        writeNewBook(z)
//        writeNewBook(f)


    }
}