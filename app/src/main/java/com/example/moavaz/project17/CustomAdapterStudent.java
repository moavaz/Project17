package com.example.moavaz.project17;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Moavaz on 8/14/2017.
 */

public class CustomAdapterStudent extends ArrayAdapter<Student> {

    private static LayoutInflater inflater;
    Activity activity;
    Context context;
    List<Student> students;

    public CustomAdapterStudent(Context context, List<Student> students) {
        super(context, 0, students);
        this.students = students;
        activity = (Activity) context;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student student = getItem(position);

        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.custom_list, parent, false);
        holder.firstname = (TextView) rowView.findViewById(R.id.fname);
        holder.lastname = (TextView) rowView.findViewById(R.id.lname);
        holder.id = (TextView) rowView.findViewById(R.id.id);

        holder.firstname.setText(students.get(position).getFname());
        holder.lastname.setText(students.get(position).getLname());
        holder.id.setText(students.get(position).getId());

        return rowView;
    }

    public class Holder {
        TextView firstname;
        TextView lastname;
        TextView id;

    }
}
