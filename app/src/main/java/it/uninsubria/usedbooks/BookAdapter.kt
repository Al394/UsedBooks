package it.uninsubria.usedbooks

import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BookAdapter(private val context: Context, private val data: ArrayList<Book>) : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var newView = convertView
        if (convertView == null) {
            newView = LayoutInflater.from(context).inflate(R.layout.riga_libro, parent, false)
        }
        if (newView != null) {
            val titolo = newView.findViewById<TextView>(R.id.titolo)
            val prezzo = newView.findViewById<TextView>(R.id.prezzo)
            val mTitolo = data[position].titolo
            val mPrezzo = data[position].prezzo.toString()
            titolo.text = mTitolo
            prezzo.text = "$mPrezzo €"

        }
        return newView
    }


}