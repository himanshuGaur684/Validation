package com.gaur.validation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gaur.validation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var _binding:ActivityMainBinding?=null
    val binding:ActivityMainBinding
    get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnValidate.setOnClickListener {
            val loginUiData = LoginUiData(
                name =  binding.edName.text.toString(),
                email =  binding.edMail.text.toString(),
                password = binding.edPassword.text.toString()
            )

            if(loginUiData.isvalid){
                Toast.makeText(this,"valid",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"not valid",Toast.LENGTH_SHORT).show()
            }


        }


    }

    override fun onDestroy() {
        _binding=null
        super.onDestroy()
    }
}