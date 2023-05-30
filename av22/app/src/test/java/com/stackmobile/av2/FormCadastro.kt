package com.stackmobile.av2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.red
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.stackmobile.av2.databinding.ActivityFormCadastroBinding

class formCadastro : AppCompatActivity(){
    private lateinit var binding: ActivityFormCadastroBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastrar.setOnClickListener {view ->

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preencha todos os campos!" ,Snackbar.LENGTH_SHORT )
                snackbar.show()
                snackbar.setBackgroundTint(titleColor.red)*************************************


            }else{

                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful){
                        val snackbar = Snackbar.make(view, "Cadastro concluido!" ,Snackbar.LENGTH_SHORT )
                        snackbar.show()
                        snackbar.setBackgroundTint(titleColor.red)
                        binding.editEmail.setText("")
                        binding.editSenha.setText("")
                    }

                }.addOnFailureListener {exception ->
                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com no minimo 6 caracteres!"
                        is FirebaseAuthInvalidCredentialsException ->"Digite um email valido!"
                        is FirebaseAuthUserCollisionException -> "Estaconta ja foi cadastrada"
                        is FirebaseNetworkException -> "Sem conexão com a internet"
                        else ->"Erro ao cadastrar usuario"

                    }
                    val snackbar = Snackbar.make(view,mensagemErro,Snackbar.LENGTH_SHORT )
                    snackbar.show()
                    snackbar.setBackgroundTint(titleColor.red)
                }

                }

            }
        }

    }












