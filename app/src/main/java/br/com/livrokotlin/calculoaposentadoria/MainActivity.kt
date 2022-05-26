package br.com.livrokotlin.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //acessando o Spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //acessando a caixa de idade
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        //acessando o botão de calcular
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //acessando o texto de resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        //adicionando informações no spinner
        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("masculino", "feminino"))

        //implementando um listener no botão
        btn_calcular.setOnClickListener {
            //capturar o valor do spinner
            val sexo = spn_sexo.selectedItem as String

            //capturar o valor do EditText
            val idade = txt_idade.text.toString().toInt()

            //validação do sexo
            var resultado = 0
            if(sexo == "masculino") {
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }

            txt_resultado.text = "Faltam $resultado anos para você se aposentar."
        }
    }
}