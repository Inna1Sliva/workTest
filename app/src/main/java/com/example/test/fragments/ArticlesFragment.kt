package com.example.test.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.ReadActivity
import com.example.test.adapter.ModelAdapter
import com.example.test.databinding.FragmentArticlesBinding
import com.example.test.model.Model
import java.lang.reflect.Array.getInt

class ArticlesFragment : Fragment() {
private var _binding:FragmentArticlesBinding?=null
    private val binding get() = _binding
    private var modelList:ArrayList<Model> = ArrayList()
    private lateinit var  modelAdapter: ModelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticlesBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.apply {
            recycler.layoutManager = LinearLayoutManager(requireContext())
            modelAdapter = ModelAdapter(getModelList())
            recycler.adapter = modelAdapter
            modelAdapter.onItemClick ={
                val intent = Intent(requireContext(),ReadActivity::class.java)
                intent.putExtra("list", it)
                startActivity(intent)
            }
        }

    }
    private fun getModelList():ArrayList<Model>{
        modelList.add(Model(0,getString(R.string.title_text),R.drawable.photo1,getString(R.string.data_title),getString(R.string.discriptiontitle1),getString(R.string.discriptiontitle2)))
        modelList.add(Model(1, getString(R.string.title_model),R.drawable.model, getString(R.string.data_model),getString(R.string.model_discription),getString(R.string.model_discription2)))
    return modelList
    }
}