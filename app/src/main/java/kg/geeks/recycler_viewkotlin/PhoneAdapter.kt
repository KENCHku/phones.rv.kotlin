package kg.geeks.recycler_viewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geeks.recycler_viewkotlin.databinding.ItemPhoneBinding
import kg.geeks.recycler_viewkotlin.model.Phone

class PhoneAdapter(private val arrayList: ArrayList<Phone>,
                   private val onClicked: (position: Int) -> Unit
                   ): RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        return PhoneViewHolder(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

        override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.onBind()
        }

    override fun getItemCount(): Int = arrayList.size

   inner class PhoneViewHolder(private val binding: ItemPhoneBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(){

            itemView.setOnClickListener {
                onClicked(position)
            }

            val item = arrayList[adapterPosition]

            Glide.with(binding.imageViewItemPhone).load(item.image).into(binding.imageViewItemPhone)
            binding.textViewTitleItemPhone.text = item.brand
            binding.textViewPriceItemPhone.text = item.price.toString()//cause price is Int type
        }
    }
}