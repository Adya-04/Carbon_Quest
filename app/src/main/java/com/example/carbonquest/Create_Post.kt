package com.example.carbonquest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.carbonquest.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Create_Post : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        val postButton: Button = findViewById(R.id.postButton)
        val postInput: EditText = findViewById(R.id.postInput)

//        postButton.setOnClickListener {
//            val content = postInput.text.toString()
//            if (content.isNotEmpty()) {
//                createPost(content)
//            }
//        }
//    }
//    private fun createPost(content: String) {
//        val post = Post(author = "User123", content = content, imageUrl = null)
//
//        RetrofitClient.apiService.createPost(post).enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                if (response.isSuccessful) {
//                    Toast.makeText(this@Create_Post, "Post created successfully", Toast.LENGTH_SHORT).show()
//                    finish() // Go back to the main activity
//                } else {
//                    Toast.makeText(this@Create_Post, "Failed to create post", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Toast.makeText(this@Create_Post, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}