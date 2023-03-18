package com.example.tipaclean.presentation.prepod_list.components.PrepodListFrag

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tipaclean.R
import com.example.tipaclean.databinding.FragmentPrepodListBinding
import com.example.tipaclean.databinding.PrepodItemBinding
import com.example.tipaclean.domain.model.PrepodSaved
import com.example.tipaclean.domain.use_case.get_prepods.ClickPrepodUseCase
import com.example.tipaclean.domain.use_case.get_prepods.GetPrepodsUseCase
import java.io.File
import java.io.FileOutputStream

class PrepodListAdapter(val context:Context) :  RecyclerView.Adapter<PrepodListAdapter.ViewHolder>(),View.OnClickListener{
    var dataSet : List<PrepodSaved> = emptyList()
    lateinit var binding : PrepodItemBinding
    class ViewHolder(val binding:PrepodItemBinding) : RecyclerView.ViewHolder(binding.root) {}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    binding = PrepodItemBinding.inflate(inflater,parent,false)
    binding.root.setOnClickListener(this)
    return ViewHolder(binding)
}
override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
    var a :List<String>

    viewHolder.binding.name.text = dataSet[position].firstName
    viewHolder.binding.surname.text = dataSet[position].lastName
    viewHolder.binding.Fatherstvo.text = dataSet[position].middleName
    viewHolder.binding.rank.text = dataSet[position].rank

    viewHolder.binding.dept.text = dataSet[position].academicDepartment
    viewHolder.itemView.tag = dataSet[position]
    Glide.with(viewHolder.binding.imaga).load(dataSet[position].photoLink).circleCrop()
        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_launcher_foreground)
        .into(viewHolder.binding.imaga)
}
override fun onClick(p:View){
    ClickPrepodUseCase(context,p.tag as PrepodSaved).Click();
}
fun setList(list:List<PrepodSaved>){
    dataSet = list
    notifyDataSetChanged()
}
override fun getItemCount() = dataSet.size

}