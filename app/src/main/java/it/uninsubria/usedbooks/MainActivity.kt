package it.uninsubria.usedbooks

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    private val mBook: ArrayList<Book> = ArrayList()
    private val mAdapter: BookAdapter = BookAdapter(this, mBook)
    private var mDB: DatabaseReference = FirebaseDatabase.getInstance().getReference("Books")
    private lateinit var mBookChildListener: ChildEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        list_item.adapter = mAdapter


        button.setOnClickListener {
            val intent = Intent(this, AddBook::class.java)
            startActivity(intent)
        }


        writeNewBook(
            Book(
                "Salmo e un sacco di altre persone che vagavano per i boschi",
                "autore",
                111,
                -100,
                12
            )
        )
        Log.i(TAG, "Working with ${Thread.currentThread().name}")


    }

    override fun onStart() {
        super.onStart()

        mBookChildListener = getBookEventListener()
        mDB.addChildEventListener(mBookChildListener)

    }

    private fun getBookEventListener(): ChildEventListener {
        return object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                Log.d(TAG, "onChildAdded: " + snapshot.key!!)
                val newBook = snapshot.getValue(Book::class.java)
                mBook.add(newBook!!)
                mAdapter.notifyDataSetChanged()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                Log.d(TAG, "onChildChanged:  " + snapshot.key)
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                Log.d(TAG, "onChildRemoved:  " + snapshot.key)
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                Log.d(TAG, "onChildMoved: " + snapshot.key)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
    }

    override fun onStop() {
        super.onStop()
        mDB.removeEventListener(mBookChildListener)
    }
}

//private fun Query.addChildEventListener(function: () -> Unit) {
//
//}

