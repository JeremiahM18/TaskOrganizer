package com.example.taskorganizer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class TaskViewModel extends ViewModel {

    private MutableLiveData<LinkedList<String>> task;

    public TaskViewModel(){
        task = new MutableLiveData<>();
//        LinkedList<String> l = new LinkedList<>();
//        task.setValue(l);
    }
    public MutableLiveData<LinkedList<String>> getTask(){
        return  task;
    }

    public void addTask(String ask){
        LinkedList<String> currentList = task.getValue();
        if(currentList != null && task != null){
            currentList.add(ask);
            task.setValue(currentList);
        }
    }
}
