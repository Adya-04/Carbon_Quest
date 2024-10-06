package com.example.carbonquest

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carbonquest.network.RetrofitClient
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recycler_view)

        // Create a list of dummy posts
        val dummyPosts = listOf(
            Postdata(author = "philip0789", content = "Tips to get started on planting forest trees and grow the environment!", imageUrl = null, name = "Philip"),
            Postdata(author = "kerry_0897", content = "I just purchased an electric vehicle today, and I'm excited to reduce my daily carbon emissions by around 20%! #GreenSteps #CarbonReduction", imageUrl = null, name = "Kerry"),
            Postdata(author = "Phenos@123", content = "I’ve started cycling to the office, reducing my daily carbon emissions by 20%! Every pedal helps contribute to a greener environment. Let's take steps towards sustainability together!", imageUrl = null, name = "Phenos"),
            Postdata(author = "Foros0987", content = "Check out my new electric car!", imageUrl = null, name = "Foros")
        )

        postAdapter = PostAdapter(dummyPosts.toMutableList())
        recyclerView.adapter = postAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set the title of the Toolbar
        supportActionBar?.title = "Carbon Quest Community Hub"


//        recyclerView = findViewById(R.id.recycler_view)
//        postAdapter = PostAdapter(mutableListOf())
//        recyclerView.adapter = postAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        fetchPosts()

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, Create_Post::class.java)
            startActivity(intent)
        }

    }
//    private fun fetchPosts() {
//        RetrofitClient.apiService.getPosts().enqueue(object : Callback<List<Post>> {
//            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//                if (response.isSuccessful) {
//                    val posts = response.body() ?: emptyList()
//                    postAdapter.updatePosts(posts)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Failed to load posts", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}
