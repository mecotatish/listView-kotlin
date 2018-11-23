package com.makariosfayez.jesusdiciples

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.makariosfayez.jesusdiciples.R.attr.content
import kotlinx.android.synthetic.main.custom_listview.view.*

class CustomAdapter(private var cont : Context ,var resource : Int , var items: ArrayList<data>): ArrayAdapter<data>(cont , resource , items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val infater = LayoutInflater.from(cont)
        val view = infater.inflate(resource , parent , false)
        val item = getItem(position)
        view.messName.text = item.name
        view.messDisc.text = item.disc
        view.messImage.setImageResource(item.Image)

        view.messShare.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type= "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, item.name +"\n${item.disc}" + item.Image )
            cont.startActivity(Intent.createChooser(shareIntent , cont.getString(R.string.send_to)))
        }

        view.messDetail.setOnClickListener {

        }
        return view
    }

}

