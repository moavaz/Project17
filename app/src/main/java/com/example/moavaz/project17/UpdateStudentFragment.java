package com.example.moavaz.project17;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateStudentFragment extends Fragment {

    private Activity context;
    private Button btnedit;
    private EditText editTextfname, editTextlname, editTextmail, editTextcontact, editTextstuid, editTextimg;
    private String fname, lname, mail, ph, img, stuid;
    private int id;

    public UpdateStudentFragment(Activity context, String fname, String lname, String mail, String stuid, String img,
                                 String ph, int id) {
        this.context = context;
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
        this.ph = ph;
        this.stuid = stuid;
        this.img = img;
        this.id = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_update_student, container, false);

        editTextfname = (EditText) v.findViewById(R.id.editTextfname);
        editTextlname = (EditText) v.findViewById(R.id.editTextlname);
        editTextmail = (EditText) v.findViewById(R.id.editTextemail);
        editTextcontact = (EditText) v.findViewById(R.id.editTextcontact);
        editTextstuid = (EditText) v.findViewById(R.id.editTextstuid);
        editTextimg = (EditText) v.findViewById(R.id.editTextimg);
        btnedit = (Button) v.findViewById(R.id.btnupdate);

        editTextfname.setText(fname);
        editTextlname.setText(lname);
        editTextmail.setText(mail);
        editTextcontact.setText(ph);
        editTextimg.setText(img);
        editTextstuid.setText(stuid);

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStudentAsync updateStudentAsync = new UpdateStudentAsync(context, editTextfname.getText().toString(),
                        editTextlname.getText().toString(), editTextmail.getText().toString(), editTextstuid.getText().toString(),
                        editTextimg.getText().toString(), editTextcontact.getText().toString(), id);
                updateStudentAsync.execute();
            }
        });

        return v;
    }

}
