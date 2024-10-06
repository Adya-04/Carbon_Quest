package com.example.carbonquest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carbonquest.databinding.ActivitySigninDetailsBinding
import com.example.carbonquest.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signin_details : AppCompatActivity() {

    private lateinit var binding: ActivitySigninDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySigninDetailsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.signinBtn.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                login(username, password)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun login(username: String, password: String) {
        val request = LoginRequest(username, password)

        RetrofitClient.apiService.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    // Store the JWT token in SharedPreferences
                    saveToken(loginResponse?.token)
                    // Handle successful login
                    Toast.makeText(this@Signin_details, "Login successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@Signin_details, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    // Proceed to next activity or store token
                } else {
                    // Log the username and the error response
                    Log.e("Signin_details", "Login failed for user: $username. Error: ${response.errorBody()?.string()}")
                    Toast.makeText(this@Signin_details, "Login failed: ${response.message()}", Toast.LENGTH_LONG).show()
//                    Toast.makeText(this@Signin_details, "Login failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@Signin_details, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun saveToken(token: String?) {
        val sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("jwt_token", token)
        editor.apply()
    }
}