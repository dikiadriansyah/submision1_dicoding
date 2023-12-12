package com.example.submision1

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: GitUserAdapter

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var gitusers = arrayListOf<GitUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = GitUserAdapter(this)
        listItem.divider = null
        listItem.adapter = adapter


        prepare()
        addItem()

        listItem.onItemClickListener =
                AdapterView.OnItemClickListener { _, _, position, _ ->
                    val moveGitUser = GitUser(
                            gitusers[position].username,
                            gitusers[position].name,
                            gitusers[position].foto,
                            gitusers[position].perusahaan,
                            gitusers[position].lokasi,
                            gitusers[position].repository,
                            gitusers[position].pengikut,
                            gitusers[position].mengikuti
                    )

                    val moveIntentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
//                    moveIntentToDetail.putExtra(DetailActivity.DETAIL_USER, moveGitUser)
                    moveIntentToDetail.putExtra(DetailActivity.DETAIL_USER, gitusers[position])
                    startActivity(moveIntentToDetail)

                }

    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)

    }

    private fun addItem() {
        for (position in dataName.indices) {
            val gituser = GitUser(
                    dataUsername[position],
                    dataName[position],
                    dataAvatar.getResourceId(position, -1),
                    dataCompany[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataFollower[position],
                    dataFollowing[position]
            )
            gitusers.add(gituser)
        }
        adapter.gitusers = gitusers
    }
}
