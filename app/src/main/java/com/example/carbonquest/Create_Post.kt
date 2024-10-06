package com.example.carbonquest

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.carbonquest.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Create_Post : AppCompatActivity() {
    private lateinit var attachfile : Button
    private lateinit var imgView : ImageView
    // Store URI to preserve across configuration changes
    private var selectedImageUri: Uri? = null

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){ uri: Uri? ->
        uri?.let {
            selectedImageUri = it // Save the URI
            imgView.setImageURI(it) // Display the selected image
        } ?: run {
            // Handle the case where no image was selected
            Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        attachfile = findViewById(R.id.btnAttachFile)
        imgView = findViewById(R.id.doc_img)
        val postButton: Button = findViewById(R.id.postButton)
        val postInput: EditText = findViewById(R.id.postInput)

        // Restore the image URI if it was selected before the configuration change
        selectedImageUri?.let {
            imgView.setImageURI(it)
        }
        attachfile.setOnClickListener {
            contract.launch("image/*")
        }

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
    // Save the URI during configuration changes
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        selectedImageUri?.let {
            outState.putString("selectedImageUri", it.toString())
        }
    }

    // Restore the URI after configuration changes
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString("selectedImageUri")?.let {
            selectedImageUri = Uri.parse(it)
            imgView.setImageURI(selectedImageUri)
        }
    }
}