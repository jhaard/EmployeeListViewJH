package com.example.employeelistviewjh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddEmployee extends AppCompatActivity {
    TextView idText;
    EditText nameInput;
    EditText ageInput;
    EditText salaryInput;
    TextView status;
    int viewID;

    EmployeeDataManager employeeDataManager = new EmployeeDataManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        idText = findViewById(R.id.id_employee);
        nameInput = findViewById(R.id.et_name);
        ageInput = findViewById(R.id.et_age);
        salaryInput = findViewById(R.id.et_salary);
        status = findViewById(R.id.status);

        Button add = findViewById(R.id.fab_add_employee);
        Button back = findViewById(R.id.fab_back);

        //Om id-listan inte är tom, hämta senaste id och visa det som text.
        if(!EmployeeDataManager.idNumbers.isEmpty()) {
            viewID = EmployeeDataManager.getLastID() + 1;

            String s = String.valueOf(viewID);
            String nextAvailableID = "ID: " + s;

            idText.setText(nextAvailableID);
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String age = ageInput.getText().toString();
                String salary = salaryInput.getText().toString();


                // Namn och ålder får inte vara tomt
                if (!name.isEmpty() && !age.isEmpty()) {

                    //Första ID samt uppdatera nästa id.
                    int nextID = 1;
                    for (int j = 0; j <= EmployeeDataManager.idNumbers.size(); j++) {
                        nextID = j + 1;
                    }

                    EmployeeDataManager.idNumbers.add(nextID);

                    // Nästa id ska synas i add employee-xml efter att Employee har skapats.
                    viewID = nextID + 1; //

                    // Visa rätt id i add employees
                    String id = String.valueOf(viewID);
                    String viewIdText = "ID: " + id;
                    idText.setText(viewIdText);

                    // Rätt id ska visas i lista och inte nästa
                    String employeeID = String.valueOf(nextID);
                    employeeDataManager.createEmployee(employeeID, name, age, salary);
                    status.setTextColor(getResources().getColor(R.color.green, null));

                    String granted = name + " with ID: " + nextID + " was added.";

                    status.setText(granted);

                } else {
                    String failed = "Name and age cannot be empty...";
                    status.setText(failed);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}