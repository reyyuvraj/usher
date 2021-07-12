package com.example.usher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.usher.databinding.HomeBinding

class Home: Fragment() {

    private lateinit var binding: HomeBinding
    /*var imageArray: ArrayList<Int> = ArrayList()
    var carousel: CarouselView? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*imageArray.add(R.drawable.sample)
        imageArray.add(R.drawable.sample)
        imageArray.add(R.drawable.sample)
        imageArray.add(R.drawable.sample)

        carousel = binding.carousel

        carousel!!.pageCount = imageArray.size
        carousel!!.setImageListener(image)*/
    }

    //var image = ImageListener {position, imageView -> imageView.setImageResource(imageArray[position])  }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButtonSearch.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_to_search)
        }
    }
}