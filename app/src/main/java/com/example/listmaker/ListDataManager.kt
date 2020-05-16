package com.example.listmaker

import android.content.Context
import androidx.preference.PreferenceManager

class ListDataManager(private val context: Context) {

    fun saveTask(list: TaskList){
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPref.putStringSet(list.name, list.tasks.toHashSet())
        sharedPref.apply()
    }

    fun readList(): ArrayList<TaskList> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val contents = sharedPreferences.all
        val taskList = ArrayList<TaskList>()

        for (task in contents){
            val taskItem = ArrayList(task.value as HashSet<String>)
            val list = TaskList(task.key, taskItem)
            taskList.add(list)
        }

        return taskList


    }

}