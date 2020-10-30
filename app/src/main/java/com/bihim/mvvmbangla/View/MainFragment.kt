package com.bihim.mvvmbangla.View

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import com.bihim.mvvmbangla.Model.DoggoModel
import com.bihim.mvvmbangla.R
import com.bihim.mvvmbangla.ViewModel.MainActivityViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragment: Fragment() {

    lateinit var mainActivityViewModel: MainActivityViewModel

    companion object{
        lateinit var imageView: ImageView
        lateinit var button: Button
        fun newInstance(): MainFragment{
            return MainFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        imageView = view.findViewById(R.id.imageView)
        button = view.findViewById(R.id.button)
        button.setOnClickListener{
            mainActivityViewModel.init()
            mainActivityViewModel.getDoggoRepository().observe(viewLifecycleOwner, {
                if (it != null) {
                    val doggoModel: DoggoModel = it
                    Log.d("URLRLRLR", "onViewCreated: " + doggoModel.message + " " + doggoModel.status)
                    imageView.load(doggoModel.message)
                } else {
                    Toast.makeText(context, "No data!!!", Toast.LENGTH_SHORT).show()
                }
            })
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

}