package com.example.bindingdata.data

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bindingdata.R

class SimpleViewModel: ViewModel() {

    private val _name = MutableLiveData("Johny Deep")
    private var _likes = MutableLiveData(0)
    private var _comment = MutableLiveData(0)
    private val _image = MutableLiveData(R.drawable.nature)
    private var _content = MutableLiveData("Write Here")

//    private val commList: ArrayList<String> = ArrayList()

    val name: LiveData<String> = _name
    var likes: LiveData<Int> = _likes
    var comment: LiveData<Int> = _comment
    val image: LiveData<Int> = _image
    var content: LiveData<String> = _content


    fun onLikes(){
        _likes.value = (_likes.value?:0)+1

    }

    fun onComment(){
        _comment.value = (_comment.value?:0)+1
    }


}