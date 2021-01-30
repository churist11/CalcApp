package jp.techacademy.shoutarou.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        divide.setOnClickListener(this)
        multiple.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (editText1.text.isEmpty() || editText2.text.isEmpty()) {

            Snackbar.make(v!!, "数字を入力してください", Snackbar.LENGTH_LONG)
                .setAction("わかりました"){
                    Log.d("kotlin_debug", "Snackbarをタップした")
                }.show()
            return
        }

        val num1 = editText1.text.toString().toDouble()
        val num2 = editText2.text.toString().toDouble()

        var result: Double = 0.0

        when (v?.id) {
            R.id.plus -> {
                result = this.getCalcResult(num1, num2, "+")
                Log.d("kotlin_debug",
                    "plus result: ${result}")
            }
            R.id.minus -> {
                result = this.getCalcResult(num1, num2, "-")
                Log.d("kotlin_debug",
                    "minus result: ${result}")
            }
            R.id.divide -> {
                result = this.getCalcResult(num1, num2, "/")
                Log.d("kotlin_debug",
                    "divide result: ${result}")
            }
            R.id.multiple -> {
                result = this.getCalcResult(num1, num2, "*")
                Log.d("kotlin_debug",
                    "multiple result: ${result}")
            }
        }

        val intent = Intent(this, Main2Activity::class.java)

        intent.putExtra("result", result)

        startActivity(intent)

    }

    private fun getCalcResult(firstNum: Double, secondNum: Double, method: String): Double {

        val result: Double =

        when (method) {
            "+" -> firstNum + secondNum
            "-" -> firstNum - secondNum
            "/" -> firstNum / secondNum
            "*" -> firstNum * secondNum
            else -> 0.0
        }

        return result
    }
}
