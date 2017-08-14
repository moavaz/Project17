package com.example.moavaz.project17;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentListFragment extends Fragment {

    private Activity context;
    private List<Student> students;
    private Button addstudent;
    private ListView listviewstudent;

    public StudentListFragment(Activity context, List<Student> students) {

        this.students = students;
        this.context = context;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_student_list, container, false);

        listviewstudent = (ListView) v.findViewById(R.id.listviewstudent);
        addstudent = (Button) v.findViewById(R.id.btnaddstudent);

        CustomAdapterStudent customAdapterStudent = new CustomAdapterStudent(context, students);
        listviewstudent.setAdapter(customAdapterStudent);

        listviewstudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(context, StudentViewActivity.class);

                intent.putExtra("id", students.get(position).getId());
                intent.putExtra("fname", students.get(position).getFname());
                intent.putExtra("lname", students.get(position).getLname());
                intent.putExtra("mail", students.get(position).getMail());
                intent.putExtra("ph", students.get(position).getPh());
                intent.putExtra("stuid", students.get(position).getStuid());
                startActivity(intent);

            }
        });


        listviewstudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                //  Toast.makeText(context,"LONG CLICK PRESS",Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("What do you want ??")
                        .setCancelable(false)
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                UpdateStudentFragment updateStudentFragment = new UpdateStudentFragment(context,
                                        students.get(position).getFname(),
                                        students.get(position).getLname(),
                                        students.get(position).getMail(),
                                        students.get(position).getStuid(),
                                        students.get(position).getImg(),
                                        students.get(position).getPh(),
                                        students.get(position).getId());

                                FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.fragnentcontainer, updateStudentFragment).commit();
                                // Toast.makeText(context,"U Call",Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        DeleteStudentAsync deleteStudentAsync = new DeleteStudentAsync(context,
                                students.get(position).getId());
                        deleteStudentAsync.execute();

                    }
                }).setCancelable(true);
                AlertDialog alert = builder.create();
                alert.setTitle("Done");
                alert.show();
                return true;
            }
        });


        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }

}
