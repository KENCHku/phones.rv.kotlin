package kg.geeks.recycler_viewkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kg.geeks.recycler_viewkotlin.databinding.FragmentSecondBinding
import kg.geeks.recycler_viewkotlin.model.Phone

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
    }

    private fun getData() {
        val bundle = arguments
        if (bundle != null) {
            val phone = bundle.getParcelable<Phone>("phone")

            if (phone != null) {
                Glide.with(this).load(phone.image).into(binding.imageViewDetail)
                binding.textViewTitleDetail.text = phone.brand
                binding.textViewPriceDetail.text = phone.price.toString()
                binding.textViewSubtitleDetail.text = phone.description
            }
        }
    }
}