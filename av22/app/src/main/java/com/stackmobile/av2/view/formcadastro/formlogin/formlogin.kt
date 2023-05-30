package com.stackmobile.av2.view.formcadastro.formlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.red
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.stackmobile.av2.R
import com.stackmobile.av2.databinding.ActivityFormloginBinding
import com.stackmobile.av2.view.formcadastro.Formcadastro
import com.stackmobile.av2.view.telaprincipal.telaprincipal

class formlogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormloginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntar.setOnClickListener {view ->
          val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {

                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.show()
                snackbar.setBackgroundTint(titleColor.red)

            }else{
                auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener {autenticacao ->
                if (autenticacao.isSuccessful) {
                    navegartelaprincipal()
                }

                }.addOnFailureListener {
                    val snackbar =
                        Snackbar.make(view, "Erro ao fazer o login do usuario", Snackbar.LENGTH_SHORT)
                    snackbar.show()
                    snackbar.setBackgroundTint(titleColor.red)

                }
            }
        }

        binding.txtTelacadastro.setOnClickListener {
            val intent = Intent(this,Formcadastro::class.java)
            startActivity(intent)
        }
    }
    private fun navegartelaprincipal(){
        val intent = intent(this,telaprincipal::class.java)
        startActivity(intent)
        finish()
    }

    private fun intent(formlogin: formlogin, java: Class<telaprincipal>): Intent? {


    }
}