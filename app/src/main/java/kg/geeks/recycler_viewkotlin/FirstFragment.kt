package kg.geeks.recycler_viewkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geeks.recycler_viewkotlin.databinding.FragmentFirstBinding
import kg.geeks.recycler_viewkotlin.model.Phone

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val arrayListPhones = ArrayList<Phone>()
    private lateinit var adapter: PhoneAdapter
    private val fragment = SecondFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadListData()
        initAdapter()
    }

    private fun loadListData() {
        arrayListPhones.add(
            Phone(
                "https://www.myphone.kg/files/media/18/18966.webp",
                "Samsung",
                19000,
                "Brand new model for better experience of android developers"
            )
        )
        arrayListPhones.add(
            Phone(
                "https://support.apple.com/library/content/dam/edam/applecare/images/en_US/iphone/iphone-14-pro-max-colors.png",
                "Iphone",
                20000,
                "Brand new 14pro for better experience of ios developers"
            )
        )
        arrayListPhones.add(
            Phone(
                "https://login.kg/image/cache/catalog/new/Phones/Huawei/P50%20Pro/huawei-p50-pro-0-500x500.jpg",
                "Huawei",
                15000,
                "Brand new model for better experience of chinese developers"
            )
        )
        arrayListPhones.add(
            Phone(
                "https://softech.kg/image/cache/4e8674b566edfec9ab741ebdeaebd1c2.png",
                "Xiaomi",
                11000,
                "Brand new xiaomi for better experience of android developers"
            )
        )
        arrayListPhones.add(
            Phone(
                "https://softech.kg/image/cache/934722f2ab1480bd874679177bf90e88.jpg",
                "Poco",
                15000,
                "Brand new poco for better experience of android developers"
            )
        )
        arrayListPhones.add(
            Phone(
                "https://media.wired.co.uk/photos/606db121d9c09fc47d4c20ff/1:1/w_1280,h_1280,c_limit/Blackberry1.jpg",
                "BlackBerry",
                100000,
                "Brand new model for better experience"
            )
        )
        arrayListPhones.add(Phone("", "Iphone"))
        arrayListPhones.add(Phone(brand = "Poco"))
    }

    private fun initAdapter() {
        adapter = PhoneAdapter(arrayListPhones, this::onClick)
        binding.recyclerViewFf.adapter = adapter
    }

    private fun onClick(position: Int) {
        val bundle = Bundle()

        val objectInfo = arrayListPhones[position]

        bundle.putParcelable("phone", objectInfo)
        fragment.arguments = bundle

        println(objectInfo.brand.toString())
        navigateToSecondFragment()
    }

    private fun navigateToSecondFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_main, fragment)
            .addToBackStack(null)
            .commit()
    }
}
