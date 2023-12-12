package com.example.submision1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.listhero.view.*

class GitUserAdapter constructor(private val context: Context) : BaseAdapter() {


    var gitusers = arrayListOf<GitUser>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.listhero, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val gituser = getItem(position) as GitUser
        viewHolder.bind(gituser)
        return itemView

    }

    private inner class ViewHolder constructor(private val view: View) {
        fun bind(gitUser: GitUser) {
            with(view) {
                name_github.text = gitUser.name
                username_github.text = "@" + gitUser.username
                location.text = StringBuilder(gitUser.lokasi).append("Lokasi")
                follow.text = gitUser.pengikut+ " Followers " + gitUser.mengikuti + " Following"
                foto_user.setImageResource(gitUser.foto)
            }
        }
    }

    override fun getItem(position: Int): Any {
        return gitusers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return gitusers.size
    }

}