package com.example.moavaz.project17;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentFragment extends Fragment {


    private Activity context;
    private TextView textView;
    private EditText fname, lname, mail, stuid, imag, ph;
    private Button btnsave;

    public AddStudentFragment(Activity context, String s, String toString, String string, String s1, String toString1, String string1) {
        // Required empty public constructor
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_add_student, container, false);

        textView = (TextView) v.findViewById(R.id.textstudent);
        fname = (EditText) v.findViewById(R.id.editfname);
        lname = (EditText) v.findViewById(R.id.editlname);
        imag = (EditText) v.findViewById(R.id.editimg);
        ph = (EditText) v.findViewById(R.id.editcontactno);
        stuid = (EditText) v.findViewById(R.id.editstuid);
        mail = (EditText) v.findViewById(R.id.editemail);
        btnsave = (Button) v.findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddStudentAsync addStudentAsync = new AddStudentAsync(context, fname.getText().toString(),
                        lname.getText().toString(), mail.getText().toString(), stuid.getText().toString(),
                        imag.getText().toString(), ph.getText().toString());

                addStudentAsync.execute();

            }
        });
        return v;
    }

}
