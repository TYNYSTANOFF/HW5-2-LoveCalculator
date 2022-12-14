package com.example.lovecalculate.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculate.Prefs
import com.example.lovecalculate.R
import com.example.lovecalculate.databinding.ItemBoardBinding
import javax.inject.Inject

class BoardAdapter(val context: Context, val navController: NavController) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {
   @Inject
   private lateinit var prefs :Prefs

    private val text = arrayListOf(
        "Тебе одиноко?",
        "Тебе грустно?",
        "В этом приложении ты сможешь подсчитать совместимость",
        "И найти себе идеальну пару"
    )
    private val ImageView= arrayListOf(
        R.raw.lottie_alone,
        R.raw.lottie_sad,
        R.raw.lottie_love_slots,
        R.raw.lottie_love
    )




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = 4


    inner class BoardViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvText.text = text[position]
            binding.imageView.setAnimation(ImageView[position])
        }
    }
}






