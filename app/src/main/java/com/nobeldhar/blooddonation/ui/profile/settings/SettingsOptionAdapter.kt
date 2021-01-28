package com.nobeldhar.blooddonation.ui.profile.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nobeldhar.blooddonation.BR
import com.nobeldhar.blooddonation.R
import com.nobeldhar.blooddonation.databinding.RowSettingsBinding
import com.nobeldhar.blooddonation.utils.CustomOnClickListener

class SettingsOptionAdapter(val optionList: List<String>, val customOnClickListener: CustomOnClickListener ) : RecyclerView.Adapter<SettingsOptionAdapter.MyViewHOlder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHOlder {
        val binding = DataBindingUtil.inflate<RowSettingsBinding>(LayoutInflater.from(parent.context), R.layout.row_settings, parent, false)
        binding.listener = customOnClickListener
        return MyViewHOlder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHOlder, position: Int) {
        val str = optionList[position]
        holder.bind(str)
    }

    override fun getItemCount(): Int {
        return optionList.size
    }

    inner class MyViewHOlder(val binding: RowSettingsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(string: String){
            binding.setVariable(BR.settingsOption, string)
            binding.executePendingBindings();
        }
    }


}