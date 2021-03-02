package com.companyname.challengeapp.ui.PrimaryScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.companyname.challengeapp.data.entities.Movies
import com.companyname.challengeapp.databinding.ItemrecyclerviewBinding

class MovieListAdapter (private val listener: ItemClickListener) : RecyclerView.Adapter<EntitlementsViewHolder>() {

    interface ItemClickListener {
        fun onClickedEntitlement(id: String)
    }

    private val items = ArrayList<Movies>()

    fun setItems(items: List<Movies>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntitlementsViewHolder {
        val binding: ItemrecyclerviewBinding = ItemrecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntitlementsViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EntitlementsViewHolder, position: Int) = holder.bind(items[position])
}

class EntitlementsViewHolder(private val itemBinding: ItemrecyclerviewBinding, private val listener: MovieListAdapter.ItemClickListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var item: Movies
    private val imageHeight = 250
    private val imageWidth = 250

    init {
        itemBinding.root.setOnClickListener(this)
    }

    //  TODO : Resize for featured need to pass an argument
    @SuppressLint("SetTextI18n")
    fun bind(item: Movies) {
        this.item = item
        itemBinding.movieName.text = item.Title
        Glide.with(itemBinding.root)
            .load(item.Poster)
            .apply(RequestOptions.overrideOf(imageHeight,imageWidth))
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickedEntitlement(item.ID)
    }
}

