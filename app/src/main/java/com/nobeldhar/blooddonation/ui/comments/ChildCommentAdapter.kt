package com.nobeldhar.blooddonation.ui.comments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nobeldhar.blooddonation.BR
import com.nobeldhar.blooddonation.R
import com.nobeldhar.blooddonation.data.local.entities.Comment
import com.nobeldhar.blooddonation.databinding.RowChildBinding
import com.nobeldhar.blooddonation.utils.CustomOnClickListener

class ChildCommentAdapter(
    val childList: List<Comment.Child>,
    val customOnClickListener: CustomOnClickListener,
    val comment: Comment,
    val userId: Int
) :
    RecyclerView.Adapter<ChildCommentAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<RowChildBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_child,
            parent,
            false
        )
        return MyViewHolder(binding, customOnClickListener, comment)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val child = childList[position]
        if (child.user.id == userId){
            holder.binding.idUpdate.visibility = View.VISIBLE
        }
        holder.bind(child)
    }

    override fun getItemCount(): Int {
        return childList.size
    }

    class MyViewHolder(
        val binding: RowChildBinding,
        val customOnClickListener: CustomOnClickListener,
        val comment: Comment
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(any: Any) {
            binding.setVariable(BR.child, any)
            binding.setVariable(BR.listener, customOnClickListener)
            binding.setVariable(BR.comment, comment)
            binding.executePendingBindings();
        }
    }
}