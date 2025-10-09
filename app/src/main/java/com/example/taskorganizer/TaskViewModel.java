package com.example.taskorganizer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class TaskViewModel extends ViewModel {

    private final MutableLiveData<LinkedList<String>> task;

    public TaskViewModel(){
        task = new MutableLiveData<>();
//        LinkedList<String> l = new LinkedList<>();
//        task.setValue(l);
    }
    public MutableLiveData<LinkedList<String>> getTask(){
        return  task;
    }

    public void addTask(String item){
        if(item == null) return;
        LinkedList<String> currentList = task.getValue();
        if(currentList == null) {
            currentList = new LinkedList<>();
            currentList.add(item);
            task.setValue(currentList);
        }
    }
}
