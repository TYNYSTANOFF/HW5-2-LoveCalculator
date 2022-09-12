package com.example.lovecalculate.fragment.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculate.databinding.ItemHistoryBinding
import com.example.lovecalculate.network.model.LoveModel

class HistoryAdapter(private var list : List<LoveModel>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    var onClick:  ((LoveModel)->Unit)? = null

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.tvFname.text = loveModel.firstName
            binding.tvSname.text = loveModel.secondName

//           itemView.setOnClickListener {
//               onClick?.invoke(adapterPosition)
//               return@setOnClickListener true
           }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
     return list.size
    }

}
