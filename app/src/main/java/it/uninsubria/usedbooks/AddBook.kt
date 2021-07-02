package it.uninsubria.usedbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlinx.android.synthetic.main.riga_libro.*
import kotlinx.android.synthetic.main.riga_libro.titolo


class AddBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)


        sell_button.setOnClickListener {


            val titolo = edit_titolo.text.toString()
            val autore = edit_autore.text.toString()
            val prezzo = edit_prezzo.text.toString().toInt()

            if (titolo.isNotEmpty() && autore.isNotEmpty()) {

                val book = Book(titolo, autore, 1, 1, prezzo)

                writeNewBook(book)
            }
            val book = Book(titolo, autore, 1, 1, prezzo)

            writeNewBook(book)

            Toast.makeText(this, "Il libro ${book.toString()} è stato aggiunto", Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}