package com.example.chatting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentUser = Firebase.auth.currentUser

        // 만약 매인액티비티에 들어왔는데 로그인이 안되어있다면
        // 로그인 액티비티로 이동하라
        // 굳이 메니페스토에서 액티비티를 설정할 필요가 없다.
        if(currentUser == null){
            // 로그인 안되있음
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}