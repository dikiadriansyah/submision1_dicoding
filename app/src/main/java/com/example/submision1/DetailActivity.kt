package com.example.submision1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.detail_user.*


class DetailActivity : AppCompatActivity() {

    companion object{
        const val DETAIL_USER = "detail_user"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_user)

        supportActionBar?.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val users = intent.getParcelableExtra(DETAIL_USER) as GitUser

        foto_user.setImageResource(users.foto)
        nama_user.text = users.name.toString()
        username_github.text = StringBuilder("@${users.username}")

        bt1.text = """
            ${users.repository.toString()}
            Repository
        """.trimIndent()
        bt2.text = """
            ${users.pengikut.toString()} 
            Follower
        """.trimIndent()
        bt3.text = """
            ${users.mengikuti.toString()} 
            Following
        """.trimIndent()
        location.text = "Location : ${users.lokasi.toString()}"


    }

}
