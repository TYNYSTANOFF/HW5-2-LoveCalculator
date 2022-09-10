package com.example.lovecalculate.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.FragmentHomeBinding
import com.example.lovecalculate.network.model.LoveModel
import com.example.lovecalculate.ui.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        navController = NavHostFragment.findNavController(this)

    }

    private fun initClickers() {
        with(binding) {
            okBtn.setOnClickListener {
                val firstName = binding.firstEd.text.toString()
                val secondName = binding.secondEd.text.toString()
                App.loveApi.getPercentage(firstName, secondName)
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful) {
                                val loveModel = response.body()
                                val bundle = Bundle()
                                bundle.putSerializable("key", loveModel)
                                findNavController().navigate(R.id.secondFragment, bundle)
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                        }

                    })
//                private  val repository = Repository()
//
//                fun fillLoveModel(firstName:String, secondName:String) : MutableLiveData<LoveModel> {
//                    return repository.getLoveModel(firstName, secondName)
//
//                }
            }
        }
    }

}