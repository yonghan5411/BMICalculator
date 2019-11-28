package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.bmicalculator.R.drawable.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener() {
            val weight: Double = editTextWeight.text.toString().toDouble()
            val height: Double = editTextHeight.text.toString().toDouble()

            val bmi: Double = calBMI(weight, height)

            val status: String

            try {
                if (bmi < 18.5) {
                    imageViewProfile.setImageResource(under)
                    status = "Under"

                } else if (bmi < 24.9) {
                    imageViewProfile.setImageResource(normal)
                    status = "Normal"

                } else {
                    imageViewProfile.setImageResource(over)
                    status = "Over"

                }

                //when{
                //bmi < 18.5 ->{ imageViewProfile.setImageResource(R.drawable.under) status = "Under" )
                //bmi < 24.9 ->{ imageViewProfile.setImageResource(R.drawable.normal) status = "Normal"}
                // else -> { imageViewProfile.setImageResource(R.drawable.over) status = "Over"}}


                bmiResult.text = "BMI: %.2f (%s)".format(bmi, status)
            } catch (ex: Exception) {

               //val toast:Toast = Toast.makeText(applicationContext,"weight or height can't be empty")
                val toast:Toast = Toast.makeText(applicationContext,"weight or height can't be empty", Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER,0,0)

                toast.show()
            }


            buttonReset.setOnClickListener() {
                bmiResult.setText("")
                editTextHeight.setText("")
                editTextWeight.setText("")

                imageViewProfile.setImageResource(empty)
            }
        }
    }


    public fun calBMI(weight:Double, height:Double):Double{

      return weight / Math.pow(height,2.0)



    }
}

