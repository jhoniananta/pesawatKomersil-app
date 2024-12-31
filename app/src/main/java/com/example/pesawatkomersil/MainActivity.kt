package com.example.pesawatkomersil

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pesawatkomersil.about.About
import com.example.pesawatkomersil.plane.ListPlaneAdapter
import com.example.pesawatkomersil.plane.Plane

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlanes: RecyclerView
    private val list = ArrayList<Plane>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlanes = findViewById(R.id.rv_planes)
        rvPlanes.setHasFixedSize(true)

        list.addAll(getListPlanes())
        showRecyclerList()

//        Handler(Looper.getMainLooper()).postDelayed({
//            // Navigate to your app's main content
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 2000)
    }

    private fun getListPlanes(): ArrayList<Plane> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPlane = ArrayList<Plane>()

        for (i in dataName.indices){
            val plane = Plane(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPlane.add(plane)
        }
        return listPlane
    }

    private fun showRecyclerList() {
        rvPlanes.layoutManager = LinearLayoutManager(this)
        val listPlaneAdapter = ListPlaneAdapter(list)
        rvPlanes.adapter = listPlaneAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // Replace "main_menu" with your menu file name
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                // Navigate to About activity
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}