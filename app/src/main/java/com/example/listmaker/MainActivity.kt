package com.example.listmaker

import android.os.Bundle
import android.text.InputType
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val adapterList = TodoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        with(listRecyclerview){
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapterList
        }



        fab.setOnClickListener {
//            val adapterTodo = listRecyclerview.adapter as TodoListAdapter
//            adapterTodo.addNewItem()
            showCreateDialog()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateDialog(){
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)
        val myDialog = AlertDialog.Builder(this)
        val todoListEditText = EditText(this)

        todoListEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS

        with(myDialog){
            setTitle(dialogTitle)
            setView(todoListEditText)

            setPositiveButton(positiveButtonTitle){
                dialog, _ ->
                val adapter = listRecyclerview.adapter as TodoListAdapter
                adapter.addNewItem(todoListEditText.text.toString())
                    dialog.dismiss()
            }

            create().show()
        }

    }
}
