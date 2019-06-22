package com.example.ticketfast.Activity

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.ticketfast.Model.CreditCard
import com.example.ticketfast.R
import kotlinx.android.synthetic.main.activity_pay.*
import java.text.SimpleDateFormat
import java.util.*

class PayActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)


        text_value.setText(intent.getStringExtra("price"))

        btn_final.setOnClickListener(View.OnClickListener {
            //Validar os campos
            val cred = CreditCard()
            cred.name = name.text.toString()
            cred.cvv = cvv.text.toString()
            cred.month = month.text.toString()
            cred.parcels = (Integer.parseInt(parcels.text.toString()))
            //Api de Validação e pagamento
            //Se for aprovado o pagamento
            cred.token = "Token"
            //Post cred para a Api do sistema
            //Se não
            cred.error = "Erro"
            Toast.makeText(applicationContext, "Compra Finalizada", Toast.LENGTH_LONG).show()
            SalvarIngresso(
                    intent.getStringExtra("name"),
                    intent.getStringExtra("date"),
                    intent.getStringExtra("local")
            )
        })

    }

    private fun SalvarIngresso(name: String, date: String, local: String) {

        val myDB = openOrCreateDatabase("ingressos.db", MODE_PRIVATE, null)

        myDB.execSQL("CREATE TABLE IF NOT EXISTS ingressos (" +
                "idingresso INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(50)," +
                "date VARCHAR(1000)," +
                "local VARCHAR(30))")


        val row1 = ContentValues()

        row1.put("name", name)
        row1.put("date", date)
        row1.put("local", local)

        myDB.insert("ingressos", null, row1)

        myDB.close()


    }


}
