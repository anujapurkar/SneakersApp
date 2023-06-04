package com.example.anujasneakersapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anujasneakersapp.R
import com.example.anujasneakersapp.databinding.ActivityMainBinding
import com.example.anujasneakersapp.model.SneakerListModel
import com.example.anujasneakersapp.repository.SneakerRepository
import com.example.anujasneakersapp.repository.SneakerViewModelFactory
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var sneakerAdapter: SneakerAdapter
    private var textCartItemCount: TextView? = null
    var mCartItemCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieRepository = SneakerRepository(this)

        val viewModel: SneakerListViewModel by viewModels {
            SneakerViewModelFactory(movieRepository)
        }
        viewModel.getSneakerList()
        viewModel.getSneakerLiveData().observe(this, Observer {
            if (it != null) {
                setAdapterData(it)
            } else {
                Toast.makeText(this, "Error loading Sneakers data", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun setAdapterData(sneakerList: List<SneakerListModel>) {
        binding.sneakerRecyclerView.layoutManager = GridLayoutManager(this, 2)
        sneakerAdapter = SneakerAdapter(this, sneakerList) { position: Int ->
            intent = Intent(this, SneakerDetailsActivity::class.java)
            intent.putExtra("sneakerObject", Gson().toJson(sneakerList[position]))
            startActivity(intent)
        }

        binding.sneakerRecyclerView.adapter = sneakerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        var menuItem: MenuItem? = menu?.findItem(R.id.action_cart)
        var actionView: View? = menuItem?.actionView;
        textCartItemCount = actionView?.findViewById(R.id.cart_badge)

        actionView?.setOnClickListener { view ->
            menuItem?.let { onOptionsItemSelected(it) }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_cart -> {
                startActivity(Intent(this, CartActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onResume() {
        super.onResume()
        mCartItemCount = AppCart.getList().size
        textCartItemCount?.text = mCartItemCount.toString()
    }
}