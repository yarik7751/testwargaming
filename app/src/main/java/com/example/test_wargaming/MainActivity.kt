package com.example.test_wargaming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_start.view.StartFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, StartFragment.newInstance())
        fragmentTransaction.commit()
    }
}
