package me.najmul.phonecontact

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import me.najmul.phonecontact.data.Contact

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NIM = "nim"
        const val EXTRA_NAMA = "nama"
        const val EXTRA_NOMOR_TELEPON = "nomor_telepon"
        const val EXTRA_ALAMAT = "alamat"
        const val EXTRA_FOTO = "foto"

        /**
         * Fungsi untuk membuat intent baru yang meneruskan data (passing object)
         *
         * @param context
         * @param contact
         */
        fun newIntent(context: Context, contact: Contact): Intent {
            val detailIntent = Intent(context, DetailActivity::class.java)

            Log.d("TEST", contact.toString());

            detailIntent.putExtra(EXTRA_NIM, contact.nim)
            detailIntent.putExtra(EXTRA_NAMA, contact.nama)
            detailIntent.putExtra(EXTRA_NOMOR_TELEPON, contact.nomor_telepon)
            detailIntent.putExtra(EXTRA_ALAMAT, contact.alamat)
            detailIntent.putExtra(EXTRA_FOTO, contact.foto)

            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // inisialisasi data dari extra intent
        val nimValue = intent.extras?.getString(EXTRA_NIM)
        val namaValue = intent.extras?.getString(EXTRA_NAMA)
        val nomorTeleponValue = intent.extras?.getString(EXTRA_NOMOR_TELEPON)
        val alamatValue = intent.extras?.getString(EXTRA_ALAMAT)
        val fotoValue = intent.extras?.getInt(EXTRA_FOTO)

        // inisialisasi widget yang berada pada layout
        val foto = findViewById<ImageView>(R.id.contact_foto)
        val nim = findViewById<TextView>(R.id.contact_nim)
        val nama = findViewById<TextView>(R.id.contact_nama)
        val nomor_telepon = findViewById<TextView>(R.id.contact_nomor_telepon)
        val alamat = findViewById<TextView>(R.id.contact_alamat)

        // Mengubah konten yang berada pada tiap widget
        Glide
            .with(this)
            .load(fotoValue)
            .centerCrop()
            .into(foto)

        nim.text = nimValue
        nama.text = namaValue
        nomor_telepon.text = nomorTeleponValue
        alamat.text = alamatValue
    }
}