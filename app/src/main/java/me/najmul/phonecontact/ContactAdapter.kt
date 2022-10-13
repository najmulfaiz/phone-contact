package me.najmul.phonecontact

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import me.najmul.phonecontact.data.Contact

class ContactAdapter (private val context: Context, private val dataSource: ArrayList<Contact>): BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        // Cek apakah tamplan sudah ada, jika true maka tidak perlu meng-inflate dari layout
        // dan memanggil fungsi findViewById() lagi
        if (convertView == null) {
            view = inflater.inflate(R.layout.row_item, parent, false)

            holder = ViewHolder()
            holder.namaContact = view.findViewById(R.id.nama) as TextView

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val namaContact = holder.namaContact

        // Mengambil data matkul yang sesuai
        val contact = getItem(position) as Contact

        // Mengubah konten tiap elemen widget
        namaContact.text = contact.nama

        return view
    }

    private class ViewHolder {
        lateinit var namaContact: TextView
    }
}