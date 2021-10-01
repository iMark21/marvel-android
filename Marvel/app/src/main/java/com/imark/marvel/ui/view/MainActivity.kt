package com.imark.marvel.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.imark.marvel.data.model.Character
import com.imark.marvel.databinding.ActivityMainBinding
import com.imark.marvel.ui.view.adapter.CharacterAdapter
import com.imark.marvel.ui.viewmodel.CharactersListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterAdapter
    private val characterList = mutableListOf<Character>()

    private val viewModel: CharactersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        viewModel.onCreate()

        viewModel.characters.observe(this, Observer {
            characterList.clear()
            characterList.addAll(it)
            adapter.notifyDataSetChanged()
        })
        viewModel.isLoading.observe(this, Observer {
            //binding.loading.isVisible = it
        })

    }

    private fun initRecyclerView() {
        adapter = CharacterAdapter(characterList)
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
        binding.rvCharacters.adapter = adapter
    }
}