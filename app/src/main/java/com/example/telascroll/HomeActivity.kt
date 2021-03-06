package com.example.telascroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val users = mutableListOf<User>()

        val user1 = User("https://randomuser.me/api/portraits/men/38.jpg", "@cesar.rodrigues", "Me manda os arquivos", 10)
        val user2 = User("https://randomuser.me/api/portraits/men/37.jpg", "@edu.misina", "Boa noite")
        val user3 = User("https://randomuser.me/api/portraits/men/2.jpg", "@vinicius.trapia", "Vinicius Trápia")
        val user4 = User("https://randomuser.me/api/portraits/men/90.jpg", "@jonatas", "Jonatas")
        val user5 = User("https://randomuser.me/api/portraits/men/19.jpg", "@lincoln", "Lincoln")
        val user11 = User("https://randomuser.me/api/portraits/men/19.jpg", "@cesar.rodrigues", "César Rodrigues")
        val user21 = User("https://randomuser.me/api/portraits/men/19.jpg", "@edu.misina", "Eduardo Misina", 20)
        val user31 = User("https://randomuser.me/api/portraits/men/19.jpg", "@vinicius.trapia", "Vinicius Trápia")
        val user41 = User("https://randomuser.me/api/portraits/men/19.jpg", "@jonatas", "Jonatas")
        val user51 = User("https://randomuser.me/api/portraits/men/19.jpg", "@lincoln", "Lincoln", 100)
        val user12 = User("https://randomuser.me/api/portraits/men/19.jpg", "@cesar.rodrigues", "César Rodrigues")
        val user22 = User("https://randomuser.me/api/portraits/men/19.jpg", "@edu.misina", "Eduardo Misina")
        val user32 = User("https://randomuser.me/api/portraits/men/19.jpg", "@vinicius.trapia", "Vinicius Trápia")
        val user42 = User("https://randomuser.me/api/portraits/men/19.jpg", "@jonatas", "Jonatas")
        val user52 = User("https://randomuser.me/api/portraits/men/19.jpg", "@lincoln", "Lincoln")

        users.addAll(listOf(user1, user2, user3, user4, user5, user11, user21,
            user31, user41, user51, user12, user22, user32, user42, user52))

        findViewById<RecyclerView>(R.id.rvHomeUserList).apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = MainAdapter(users) { position ->
                val intent = Intent(this@HomeActivity, UserPaymentActivity::class.java)
                intent.putExtra(KEY_INTENT_USER, users[position])
                startActivity(intent)
            }
        }
    }
    companion object {
        const val KEY_INTENT_USER = "user"
    }
}

