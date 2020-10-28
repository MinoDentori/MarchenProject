package com.example.marchenproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //создание слушателя нажатий
        var navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // Внесенная вручную информаия для стартовых сказок для примиров.
        var listOfLibraryContent = ArrayList<ListOfFairyTaleContent>()
        listOfLibraryContent.add(ListOfFairyTaleContent(R.drawable.cinderella_image,"Cinderella","00:20:36","Tutor",
                "Cinderella is a young woman with blonde hair, blue eyes, and fair complexion. After her father dies..."))

        listOfLibraryContent.add(ListOfFairyTaleContent(R.drawable.image_the_three_little_pigs,"The Three Little Pigs","00:30:10","Parent",
                "Once upon a time there was an old mother pig who had three little pigs and not enough food to feed them...."))

        listOfLibraryContent.add(ListOfFairyTaleContent(R.drawable.image_the_little_mermaid,"The little Mermaid","01:00:16","Tutor",
                "The story follows the journey of a young mermaid who is willing to give up her life in the sea as a mermaid to..."))



        // Заполнение Recycler View
        var recyclerView = findViewById<RecyclerView>(R.id.rcView)
        recyclerView.adapter = AdapterOfFairyTaleLibrary( listOfLibraryContent, this)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.id_profile_button -> Toast.makeText( this, "Profile",Toast.LENGTH_SHORT).show();
            R.id.id_reports_button -> Toast.makeText( this, "Reports",Toast.LENGTH_SHORT).show();
            R.id.id_children_button -> Toast.makeText( this, "Children",Toast.LENGTH_SHORT).show();
            R.id.id_fairy_tales_button -> Toast.makeText( this, "FairyTales",Toast.LENGTH_SHORT).show();
            R.id.id_settings_button -> Toast.makeText( this, "Settings",Toast.LENGTH_SHORT).show();
            R.id.id_help_button -> Toast.makeText( this, "Help",Toast.LENGTH_SHORT).show();
            R.id.id_log_out_button -> Toast.makeText( this, "LogOut",Toast.LENGTH_SHORT).show();
        }
        return true
    }
}