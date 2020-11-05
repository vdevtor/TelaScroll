package com.example.telascroll

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.scroll_screen_main.view.*

class MainAdapter(
    private val userList: List<User>,
    private val onItemClicked: (Int) -> Unit

) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        Log.i("RecyclerView", "onCreateViewHolder")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.scroll_screen_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        Log.i("RecyclerView", "onBindViewHolder - $position")
        holder.bind(userList[position], onItemClicked)
    }


    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User, onItemClicked: (Int) -> Unit) = with(itemView) {
            //todo carregar imagem
            Glide.with(itemView.context).load(user.userProfileAvatar).into(ivAvatar)

            if (user.notificacao > 0) {
                tvNot.text = "${user.notificacao}"
                tvNot.isVisible = true
            }

           tvUsuario.text = user.userId
            tvMensagem.text = user.userMensagem
            vgMainItemContainer.setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
                user.notificacao = 0
            }
        }

    }
}