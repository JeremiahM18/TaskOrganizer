package com.example.taskorganizer;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class TaskFragment extends Fragment {

    private TaskViewModel tm;

    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tm = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        EditText etTask = view.findViewById(R.id.etTask);
        EditText etName = view.findViewById(R.id.etName);
        Button btnAdd = view.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tas = etTask.getText().toString().trim();
                String nam = etName.getText().toString().trim();

                if (TextUtils.isEmpty(tas)) {
                    etTask.setError("Enter a task");
                    etTask.requestFocus();
                    return;
                }

                String combined = nam.isEmpty() ? tas : (tas + "-" + nam);
                tm.addTask(combined);

                etTask.setText("");
                etName.setText("");
                hideKeyboard(etTask);
            }
        });
    }

    private void hideKeyboard(View anyView){
        Context ctx = anyView.getContext();
        InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null){
            imm.hideSoftInputFromWindow(anyView.getWindowToken(), 0);
        }
    }
}
