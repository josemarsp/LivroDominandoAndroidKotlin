package br.com.josef.listsimpleskotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnSave.setOnClickListener {
            val name = editName.text.toString()
            val age = editAge.text.toString().toInt()
            val people = People(name, age)

            val intent =  Intent()
            intent.putExtra(EXTRA_PERSON, people)
            setResult(RESULT_OK, intent)
            finish();
        }

    }

    companion object{
        val EXTRA_PERSON = "people"
    }
}
