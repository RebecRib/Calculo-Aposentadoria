package com.rebeca.calculodeaposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.rebeca.calculodeaposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf<String>("Feminino" , "Masculino" )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.button.setOnClickListener {

            val idade = binding.edittextidade.text.toString().toInt()

            val genero = binding.spinner.selectedItem.toString()

            var resultado: Int

            if (genero == "Masculino") {
                resultado = 65 - idade
            } else {
                resultado = 62 - idade
            }

            if (resultado < 0) {
                binding.textView.text = "Você já deveria estar aposentado."
            } else {
                binding.textView.text = "Faltam $resultado anos para você se aposentar."
            }
        }
    }
}