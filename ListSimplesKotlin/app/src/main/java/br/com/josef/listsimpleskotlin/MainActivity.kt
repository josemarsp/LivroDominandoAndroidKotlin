package br.com.josef.listsimpleskotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val people: MutableList<People> by lazy { mutableListOf<People>() }
    private var adapter: ArrayAdapter<People>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAdd.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivityForResult(intent, REQUEST_INSERT)
        }

        listPeople.setOnItemClickListener { _, _, position, _ ->
            showShortToast(people[position].name+" foi clicado!")
        }


        adapter = ArrayAdapter<People>(this, android.R.layout.simple_list_item_1, people)
        listPeople.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_INSERT && resultCode == RESULT_OK) {
            val person = data?.getSerializableExtra(DetailActivity.EXTRA_PERSON) as? People
            if(person != null) {
                people.add(person)
                //ordenar a lista
                people.sortBy { it.name }

                //filtrando apenas nomes maiores de 21 > no log
                val f = people.filter {it.age > 21}
                f.forEach{ Log.d("LOGY", "${it.name} ${it.age}")}

                adapter?.notifyDataSetChanged()

            }
        }
    }

    companion object {
        val REQUEST_INSERT = 0
    }


}
