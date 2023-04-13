package com.has.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calButton: Button = findViewById(R.id.calcdate)
        calButton.setOnClickListener {
        }

        val toast = Toast.makeText(this, "Seu signo é ", Toast.LENGTH_SHORT).show()
        calButton.setOnClickListener {

        }
    }

private   fun extractDateParts(dateString: String): Pair<Int, Int> {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateString)

        val calendar = Calendar.getInstance()
        calendar.time = date

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH) + 1

        return Pair(day, month)
    }

    fun getSigno() {
        val dataText: EditText = findViewById(R.id.datadado)
        val dataString = dataText.toString()
        val (day, month) = extractDateParts(dataString)


        val signo = when (month) {
            1 -> if (day <= 20) "Capricórnio" else "Aquário"
            2 -> if (day <= 19) "Aquário" else "Peixes"
            3 -> if (day <= 20) "Peixes" else "Áries"
            4 -> if (day <= 20) "Áries" else "Touro"
            5 -> if (day <= 20) "Touro" else "Gêmeos"
            6 -> if (day <= 20) "Gêmeos" else "Câncer"
            7 -> if (day <= 22) "Câncer" else "Leão"
            8 -> if (day <= 22) "Leão" else "Virgem"
            9 -> if (day <= 22) "Virgem" else "Libra"
            10 -> if (day <= 22) "Libra" else "Escorpião"
            11 -> if (day <= 21) "Escorpião" else "Sagitário"
            else -> if (day <= 21) "Sagitário" else "Capricórnio"
        }



            val signoimagem: ImageView = findViewById(R.id.imagesign)
            val drawableResource = when (signo) {
                "Áries" -> R.drawable.sign_3
                "Touro" -> R.drawable.sign_4
                "Gêmeos" -> R.drawable.sign_5
                "Câncer" -> R.drawable.sign_6
                "Leão" -> R.drawable.sign_7
                "Virgem" -> R.drawable.sign_8
                "Libra" -> R.drawable.sign_9
                "Escorpião" -> R.drawable.sign_10
                "Sagitário" -> R.drawable.sign_11
                "Capricórnio" -> R.drawable.sign_12
                "Peixes" -> R.drawable.sign_2
                else -> R.drawable.sign_1
            }
            signoimagem.setImageResource(drawableResource)


        }
    }







































