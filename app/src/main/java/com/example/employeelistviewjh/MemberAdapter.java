package com.example.employeelistviewjh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<Employee> {
    ImageButton del;

    ImageButton money;

    ImageButton age;

    public MemberAdapter(Context context, List employees) {
        super(context, 0, employees);
    }


    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_member, parent, false);
        }
        Employee employee = getItem(position);

        TextView tv = view.findViewById(R.id.tv_name);
        tv.setText(employee.toString());

        EditText editMoney = view.findViewById(R.id.edit_salary);
        Button save = view.findViewById(R.id.button_save);

        EditText editAge = view.findViewById(R.id.edit_age);
        Button saveAge = view.findViewById(R.id.button_save_age);


        del = view.findViewById(R.id.delete_button);
        money = view.findViewById(R.id.money_button);
        age = view.findViewById(R.id.age_button);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Employee e = getItem(position);
                    EmployeeDataManager.deleteEmployee(e);
                    remove(e);
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.fillInStackTrace();
                }
            }
        });

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editMoney.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String s = editMoney.getText().toString();
                        if(!s.isEmpty()) {
                            employee.setSalary(s);
                            editMoney.setVisibility(View.INVISIBLE);
                            save.setVisibility(View.INVISIBLE);
                            notifyDataSetChanged();
                        } else {
                            employee.getSalary();
                            editMoney.setVisibility(View.INVISIBLE);
                            save.setVisibility(View.INVISIBLE);
                            notifyDataSetChanged();
                        }
                    }
                });
            }
        });

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAge.setVisibility(View.VISIBLE);
                saveAge.setVisibility(View.VISIBLE);

                saveAge.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = editAge.getText().toString();
                        if(!s.isEmpty()) {
                            employee.setAge(s);
                            editAge.setVisibility(View.INVISIBLE);
                            saveAge.setVisibility(View.INVISIBLE);
                            notifyDataSetChanged();
                        } else {
                            employee.getAge();
                            editAge.setVisibility(View.INVISIBLE);
                            saveAge.setVisibility(View.INVISIBLE);
                            notifyDataSetChanged();

                        }
                    }
                });
            }
        });
        return view;
    }
}
