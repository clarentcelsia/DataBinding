package com.example.bindingdata

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bindingdata.adapter.RecyclerComment
import com.example.bindingdata.data.SimpleViewModel
import com.example.bindingdata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(SimpleViewModel::class.java)
    }

    private val commList: ArrayList<String> = ArrayList()
    private lateinit var commAdapter: RecyclerComment
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this  // use Fragment.viewLifecycleOwner for fragments
        binding.viewmodel = viewModel

    }

    override fun onResume() {
        super.onResume()

        setAdapter()
    }

    fun setAdapter() {
        commAdapter = RecyclerComment(commList)
        binding.rvComment.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            setHasFixedSize(true)
            adapter = commAdapter
        }
    }


    fun Submit(view: View) {
        val texts = binding.etComment.text.toString()
        commList.add(texts)
        commAdapter.notifyDataSetChanged()

        binding.etComment.text.clear()
        binding.tvComment.text = commList.size.toString()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }


}