package com.example.moavaz.project17;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Context context;
    private EditText editusername, editpassword;
    private Button login;

    public LoginFragment(Context context) {
        this.context = context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_login, container, false);
        editusername = (EditText) v.findViewById(R.id.editusername);
        editpassword = (EditText) v.findViewById(R.id.editpassword);

        login = (Button) v.findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editusername.getText().toString().equals("admin") && editpassword.getText().toString().equals("12")) {
                    StudentNetworkListView studentNetworkListView = new StudentNetworkListView((Activity) context);
                    studentNetworkListView.execute();
                } else
                    Toast.makeText(context, "Not Valid", Toast.LENGTH_LONG).show();
            }
        });


        return v;
    }

}
