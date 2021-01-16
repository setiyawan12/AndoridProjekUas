package yayang.setiyawan.uasmobile

import android.content.Intent
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import yayang.setiyawan.uasmobile.utilities.WisataUtils
import kotlinx.android.synthetic.main.activity_dashboard.*
import java.util.*

class DashboardActivity : AppCompatActivity(){
    private lateinit var greetTextView : TextView
    private lateinit var greetImageView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        greetTextView = findViewById(R.id.greetText)
        greetImageView = findViewById(R.id.greetImg)
        greeting()
        wisata()
        kelola()
        Logout()
    }
    private fun Logout(){
        Logout.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java)).also{
                WisataUtils.clearToken(this)
                finish()
            }
        }
    }
    fun wisata(){
        btn_wisata.setOnClickListener {
            startActivity(Intent(this, WisataActivity::class.java))
        }
    }
    fun kelola(){
        setting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }
    }

    private fun greeting() {
        val calendar = Calendar.getInstance()
        val timeOfDay = calendar[Calendar.HOUR_OF_DAY]
        if (timeOfDay >= 0 && timeOfDay < 12) {
            greetTextView.setText("Selamat Pagi")
            greetTextView.setTextColor(Color.GRAY)
            greetImageView.setImageResource(R.drawable.greet1)
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            greetTextView.setText("Selamat Siang")
            greetTextView.setTextColor(Color.GRAY)
            greetImageView.setImageResource(R.drawable.greet1)
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            greetTextView.setText("Selamat Sore")
            greetTextView.setTextColor(Color.GRAY)
            greetImageView.setImageResource(R.drawable.greet1)
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            greetTextView.setText("Selamat Malam")
            greetTextView.setTextColor(Color.GRAY)
            greetImageView.setImageResource(R.drawable.greet1
            )
        }
    }

    

}