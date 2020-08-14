package com.example.teste_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val fragment1 = Fragment1()
    val fragment2 = Fragment2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(layout.id, fragment1)
        transaction.commit()

        navigation_view.setNavigationChangeListener { view, position ->
            val transaction1 = supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, 0, 0)

            if(position == 0) {
                transaction1.replace(layout.id, fragment1)
                transaction1.commit()
            }else {
                transaction1.replace(layout.id, fragment2)
                transaction1.commit()
            }
        }

    }

}