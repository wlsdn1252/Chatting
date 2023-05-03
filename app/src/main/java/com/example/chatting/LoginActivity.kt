package com.example.chatting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chatting.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //회원가입 버튼
        binding.signUpButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "미입력 했어용", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // 회원가입 성공 시
                        Toast.makeText(this, "회원가입 성공여", Toast.LENGTH_SHORT).show()
                    } else {
                        // 회원가입 실패 시
                        Toast.makeText(this, "회원가입 실패여", Toast.LENGTH_SHORT).show()
                    }
                }

            // 로그인 버튼
            binding.signInButton.setOnClickListener {
                val email = binding.emailEditText.text.toString()
                val password = binding.passwordEditText.text.toString()

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "로그인 실패요ㅁㅁㅁㅁㅁ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                Firebase.auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // 로그인 성공시
                            val intnet = Intent(this, MainActivity::class.java)
                            startActivity(intnet)
                            finish()

                        } else {
                            // 로그인 실패시
                            Log.d("로그인 액티비티", task.exception.toString())
                            Toast.makeText(this, "로그인에 실패", Toast.LENGTH_SHORT).show()

                        }
                    }
            }
        }
    }
}

