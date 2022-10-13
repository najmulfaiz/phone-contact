package me.najmul.phonecontact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import me.najmul.phonecontact.data.Contact
import me.najmul.phonecontact.data.DataContact

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private var contactList: ArrayList<Contact> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi ListView
        listView = findViewById(R.id.listView)

        // Menambahkan data dari data source yang sudah dibuat ke list
        contactList.addAll(DataContact.listData)

        // Atur adapter dari listView dengan custom adapter
        val adapter = ContactAdapter(this, contactList)
        listView.adapter = adapter

        // Menambah interaksi dari user berupa klik pada item
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedContact = contactList[position]
            val detailIntent = DetailActivity.newIntent(this, selectedContact)
            startActivity(detailIntent)
        }
    }
}