package com.example.passwords

import android.content.Intent

object constant {

    fun getdatatypes(): ArrayList<data_types>{
        val datalist = ArrayList<data_types>()

        val data1 = data_types("aadityakumar3089","aaditya", 1)
        datalist.add(data1)

        val data2 = data_types("aryan", "aryan20", 2)
        datalist.add(data2)

        return datalist
    }
}