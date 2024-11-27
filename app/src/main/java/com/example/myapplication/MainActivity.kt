package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.appelsu -> {
                val num = resources.getString(R.string.num)
                val uri = Uri.parse("tel:$num")
                val i = Intent(Intent.ACTION_CALL,uri)
                startActivity(i)
                true
            }
            R.id.appelsn -> {
                val i = Intent(this,CallActivity::class.java)
                startActivity(i)
                true
            }
            R.id.smsu -> {
                val smsManager = SmsManager.getDefault()
                val num = resources.getString(R.string.num)
                val sms = resources.getString(R.string.txtu)

                smsManager.sendTextMessage(num,null,sms,null,null)
                true
            }
            R.id.smsn ->  {
                val i = Intent(this,WriteSMS::class.java)
                startActivity(i)
                true
            }
            R.id.cameras -> true
            R.id.quitter -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
    }
}