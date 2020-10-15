package com.drj.viewpager2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drj.viewpager2.R
import com.drj.viewpager2.model.IntroSlide
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(val context: Context, val introSlide: List<IntroSlide>) :
    RecyclerView.Adapter<ViewPagerAdapter.MyViewPagerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewPagerHolder {

        val v: View = LayoutInflater.from(context).inflate(R.layout.item_view_pager, parent, false)
        return MyViewPagerHolder(v)

    }

    override fun getItemCount(): Int {
        return introSlide.size
    }

    override fun onBindViewHolder(holder: MyViewPagerHolder, position: Int) {
        val currentPositions = introSlide[position]
        holder.bind(currentPositions)

    }


    class MyViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(introSlide: IntroSlide){
            itemView.tv_title.text = introSlide.title
            itemView.tv_descriptions.text = introSlide.description
            itemView.iv_Picture.setImageResource(introSlide.icon)
        }
    }

}