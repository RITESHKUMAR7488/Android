package com.example.splashscreennew

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.example.splashscreennew.databinding.ActivityMain2Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var database : DatabaseReference
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this@MainActivity2, R.layout.activity_main2)
        with(binding) {
            btnSignup.setOnClickListener {
                val name = etName.text.toString()
                val username = etId.text.toString()
                val email = etEmail.text.toString()

                val password = etPass.text.toString()
                val user=User(name,username,email,password)//class refrence

                database=FirebaseDatabase.getInstance().getReference("username")
                //child refrence
                database.child(username).setValue(user).addOnSuccessListener {
                    Toast.makeText(this@MainActivity2,"you are registered",Toast.LENGTH_SHORT).show()


                }.addOnFailureListener{
                    Toast.makeText(this@MainActivity2,"fill all ",Toast.LENGTH_SHORT).show()

                }


            }
            btnSignin.setOnClickListener{
                intent= Intent(applicationContext,Loginpage::class.java)
                startActivity(intent)



            }


        }

    }
}