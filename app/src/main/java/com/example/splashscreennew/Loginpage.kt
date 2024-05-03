package com.example.splashscreennew

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.splashscreennew.databinding.ActivityLoginpageBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Loginpage : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    private lateinit var binding: ActivityLoginpageBinding
    companion object{
        const val KEY1 ="com.example.splashscreennew.Loginpage.mail"
        const val KEY2 ="com.example.splashscreennew.Loginpage.name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this@Loginpage, R.layout.activity_loginpage)
        with(binding) {
            btnSignin.setOnClickListener {
                val userNameString = etUsername.text.toString()
                if (userNameString.isNotEmpty()) {
                    readData(userNameString)
                } else {
                    Toast.makeText(this@Loginpage, "please enter user name", Toast.LENGTH_SHORT)
                        .show()

                }


            }

        }

    }

    private fun readData(userNameString: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("username")
        databaseReference.child(userNameString).get().addOnSuccessListener {
            if (it.exists()){
                // passs intent
                val email=it.child("email").value
                val name =it.child("name").value
                val intentwelcome = Intent(this@Loginpage,Data::class.java)
                intentwelcome.putExtra("name",name.toString())
                intentwelcome.putExtra("email",email.toString())
                startActivity(intentwelcome)

            }else{
                Toast.makeText(this@Loginpage,"user does not exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this@Loginpage, "failed", Toast.LENGTH_SHORT).show()
        }

    }

}
