package com.example.carbonquest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val posts: MutableList<Postdata>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val likeIcon: ImageView = itemView.findViewById(R.id.like_icon)
        val authorTextView: TextView = itemView.findViewById(R.id.username)
        val contentTextView: TextView = itemView.findViewById(R.id.Description)
        val postImageView: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.name)
        val profileIconImg : ImageView = itemView.findViewById(R.id.profile_icon_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.contentTextView.text = post.content
        holder.authorTextView.text = post.author
        holder.name.text = post.name

        // Set initial like icon based on post's liked status
        val isLiked = post.isLiked
        if (isLiked) {
            holder.likeIcon.setImageResource(R.drawable.heart_fill_svgrepo_com)
        } else {
            holder.likeIcon.setImageResource(R.drawable.instagram_like)
        }

        // Handle the like icon click
        holder.likeIcon.setOnClickListener {
            post.isLiked = !post.isLiked // Toggle the like status
            if (post.isLiked) {
                holder.likeIcon.setImageResource(R.drawable.heart_fill_svgrepo_com)
            } else {
                holder.likeIcon.setImageResource(R.drawable.instagram_like)
            }
        }

        // Set image from drawable if available
        when (position) {
            0 -> holder.postImageView.setImageResource(R.drawable.planting_tree)  // Replace with your actual drawable resource
            1 -> holder.postImageView.setImageResource(R.drawable.evehiclefinal)
            2 -> holder.postImageView.setImageResource(R.drawable.cyclefinal)
            else -> holder.postImageView.setImageResource(R.drawable.planting_tree)  // Fallback/default image
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}
