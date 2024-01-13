package com.example.employeelistviewjh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MemberActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        Button back = findViewById(R.id.fab_back);

        listView = findViewById(R.id.lv_member);

        MemberAdapter adapter = new MemberAdapter(this, EmployeeDataManager.employees);
        listView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}