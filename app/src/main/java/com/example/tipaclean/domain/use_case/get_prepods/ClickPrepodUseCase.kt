package com.example.tipaclean.domain.use_case.get_prepods

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.tipaclean.R
import com.example.tipaclean.data.PrepodDataBase
import com.example.tipaclean.domain.model.PrepodSaved


class ClickPrepodUseCase(val context:Context,val prepod: PrepodSaved) {
    val db = Room.databaseBuilder(
        context,
        PrepodDataBase::class.java, "database"
    ).allowMainThreadQueries().build()
    val userDao = db.prepodDao()

    fun Click(){
        val dialog = Dialog(context)
        dialog.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_fragment)
        val ok = dialog.findViewById<Button>(R.id.ok)
        val image = dialog.findViewById<ImageView>(R.id.img)

        Glide.with(context).load(prepod.photoLink).circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(image)

        val Surname = dialog.findViewById<TextView>(R.id.surname)
        Surname.text = prepod.lastName
        val Name = dialog.findViewById<TextView>(R.id.name)
        Name.text = prepod.firstName
        val FTVO = dialog.findViewById<TextView>(R.id.fathername)
        FTVO.text = prepod.middleName
        val RNK = dialog.findViewById<TextView>(R.id.rank)
        RNK.text = prepod.rank
        val DPT = dialog.findViewById<TextView>(R.id.dept)
        DPT.text = prepod.academicDepartment
        ok.setOnClickListener{
            dialog.hide()
        }
        dialog.show()

        val uslist = userDao.getAll()
        for (a in uslist){
            if(a.id == prepod.id)
                return
        }
        if(hasConnection(context))userDao.insertAll(prepod)
    }
    fun hasConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        if (wifiInfo != null && wifiInfo.isConnected) {
            return true
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if (wifiInfo != null && wifiInfo.isConnected) {
            return true
        }
        wifiInfo = cm.activeNetworkInfo
        return if (wifiInfo != null && wifiInfo.isConnected) {
            true
        } else false
    }
}