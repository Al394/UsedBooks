package it.uninsubria.usedbooks

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

//    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        mDatabase = FirebaseDatabase.getInstance().reference
//
//        val narm = mDatabase.database.reference
//
//        val prza = narm.child("Book").orderByChild("titolo")
//
//
//        testo.text = prza.toString()
//
//        val b = Book("Prova", 1, 1)
//        val f = Book("Prova", 2, 1)
//        val z = Book("Pierino frazz",12,31)
//        val ff: String = readBooks()

//        button.setOnClickListener {
//            Toast.makeText(applicationContext, ff,Toast.LENGTH_SHORT).show()
//        }


        //writeNewBook(b)
//        writeNewBook(z)
//        writeNewBook(f)


    }
}