package com.example.employeelistviewjh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.List;


public class MemberViewAdapter extends ArrayAdapter<Employee> {

    public MemberViewAdapter(Context context, List employees) {
        super(context, 0, employees);
    }

    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item_member, parent, false);
        }
        Employee employee = getItem(position);

        TextView tv = view.findViewById(R.id.tv_name);
        tv.setText(employee.toString());

        return view;
    }
}


