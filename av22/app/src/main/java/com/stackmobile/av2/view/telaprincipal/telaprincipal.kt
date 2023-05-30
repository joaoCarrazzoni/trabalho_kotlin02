package com.stackmobile.av2.view.telaprincipal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stackmobile.av2.R
import com.stackmobile.av2.databinding.ActivityTelaprincipalBinding
import com.stackmobile.av2.view.formcadastro.formlogin.formlogin

class telaprincipal : AppCompatActivity() {

     lateinit var binding: ActivityTelaprincipalBinding
     private val db = Firebasef

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = activityTelaprincipalBinding.inflate(layoutInflate)
        setContentView(binding.root)

        binding.btDeslogar.setOnClickListener {view ->
            FirebaseAuth.getInstance().signOut()
            val voltarTelaLogin = Intent(this,formlogin::calss.java)
            StartActivity(voltarTelaLogin)
            finish()
    }
        binding.btGravarDados.setOnClickListener{

        }


}