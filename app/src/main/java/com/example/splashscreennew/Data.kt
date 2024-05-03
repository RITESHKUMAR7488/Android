package com.example.splashscreennew

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.splashscreennew.databinding.ActivityDataBinding
import com.google.firebase.database.DatabaseReference

class Data : AppCompatActivity() {
    lateinit var binding:ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this@Data,R.layout.activity_data)
        val name=intent.getStringExtra("name")
        val mail=intent.getStringExtra("email")
        if(name!= null && mail !=null){
            with(binding){
                textView.text= "welcome $name"
                btnMail.text="mail: $mail"
            }

        }else{
            Toast.makeText(this@Data,"data not found",Toast.LENGTH_SHORT).show()
        }






    }
}