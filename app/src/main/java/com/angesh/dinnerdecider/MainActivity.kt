package com.angesh.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnClickListener {

    private var defaultFoodsList = arrayOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    private lateinit var newFoodItemTxtEdit: EditText
    private lateinit var foodNameTxtView : TextView

    private val foodArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        val addFood:Button = findViewById(R.id.addFoodBtn)
        newFoodItemTxtEdit = findViewById(R.id.newFoodTxt)
        foodNameTxtView = findViewById(R.id.foodNameTxt)
        val decideBtn:Button = findViewById(R.id.decideBtn)

        //put all the default foods into the array
        foodArray.addAll(defaultFoodsList)
        addFood.setOnClickListener(this)
        decideBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.addFoodBtn -> {
                onAddFoodButtonClicked()
            }
            R.id.decideBtn -> {
                onDecideButtonClicked()
            }
        }
    }

    private fun onAddFoodButtonClicked() {
        if (!newFoodItemTxtEdit.text.isNullOrEmpty()) {
            foodArray.add(newFoodItemTxtEdit.text.toString())
            newFoodItemTxtEdit.text.clear()
        }
    }

    private fun onDecideButtonClicked() {
        val randomArrayIndex = Random.nextInt(0, foodArray.size)
        val itemName = foodArray[randomArrayIndex]
        foodNameTxtView.text = itemName
    }

}