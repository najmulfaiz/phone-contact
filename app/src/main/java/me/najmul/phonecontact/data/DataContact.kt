package me.najmul.phonecontact.data

import me.najmul.phonecontact.R

object DataContact {
    private val nim = arrayOf(
        "201953032",
        "201953033",
    )

    private val nama = arrayOf(
        "Muhammad Najmul Faiz",
        "Marlina Oktaviani",
    )

    private val nomor_telepon = arrayOf(
        "082213933187",
        "085726506406",
    )

    private val alamat = arrayOf(
        "KUTOHARJO 4/8 PATI",
        "PATI LOR 5/3 PATI",
    )

    private val foto = intArrayOf(
        R.drawable.photo_najmulfaiz,
        R.drawable.photo_marlina,
    )
    
    val listData: ArrayList<Contact>
        get() {
            val list = arrayListOf<Contact>()
            for (position in nim.indices) {
                val contact = Contact()
                contact.nim = nim[position];
                contact.nama = nama[position];
                contact.nomor_telepon = nomor_telepon[position];
                contact.alamat = alamat[position];
                contact.foto = foto[position];
                list.add(contact)
            }
            return list
        }
}