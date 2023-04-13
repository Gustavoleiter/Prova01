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

        // Encontra o botão de calcular a data e define um listener para ele
        val calButton: Button = findViewById(R.id.calcdate)
        calButton.setOnClickListener {
            // Chama a função getSigno() quando o botão é clicado
            getSigno()
        }

        // Cria uma mensagem de "Seu signo é" para exibir como Toast
        val toast = Toast.makeText(this, "Seu signo é ", Toast.LENGTH_SHORT)

        // Define um segundo listener para o botão de calcular data para exibir a mensagem de Toast
        calButton.setOnClickListener {
            toast.show()
        }
    }

    // Função que extrai o dia e o mês da data fornecida
    private fun extractDateParts(dateString: String): Pair<Int, Int> {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateString)

        val calendar = Calendar.getInstance()
        calendar.time = date

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH) + 1

        return Pair(day, month)
    }

    // Função que obtém o signo com base na data fornecida e exibe a imagem correspondente
    fun getSigno() {
        val dataText: EditText = findViewById(R.id.datadado)
        val dataString = dataText.text.toString()

        // Extrai o dia e o mês da data fornecida
        val (day, month) = extractDateParts(dataString)

        // Usa a data para determinar o signo correspondente
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

        // Encontra a ImageView para exibir a imagem correspondente ao signo
        val signoimagem: ImageView = findViewById(R.id.imagesign)

        // Usa o nome do signo para determinar o recurso de imagem correspondente
        val drawableResource = signo
    }
}






































