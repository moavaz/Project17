package com.example.moavaz.project17;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Moavaz on 8/14/2017.
 */

public class AddStudentAsync extends AsyncTask<Void, Void, String> {

    private Activity context;
    private String fname, lname , stuid, img, email, ph;
    private String jsonresult;

    public AddStudentAsync(Activity context, String fname, String lname, String email, String stuid,
                            String img, String ph){
        this.context=context;
        this.fname= fname;
        this.lname= lname;
        this.img= img;
        this.stuid = stuid;
        this.email= email;
        this.ph=ph;

    }
    @Override
    protected String doInBackground(Void... params) {

        OkHttpClient httpClient = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("firstname", fname)
                .add("lastname",lname)
                .add("email",email)
                .add("studentid",stuid)
                .add("image",img)
                .add("contactno",ph)
                .build();

        Request request = new Request.Builder().url("http://192.168.43.79/projectapi.dev/api/posts")
                .post(requestBody).build();

        try {
            Response response = httpClient.newCall(request).execute();
            jsonresult = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonresult;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if(s !=null) {
            Toast.makeText(context, "student Added Successfully", Toast.LENGTH_SHORT).show();
            StudentNetworkListView studentNetworkListView = new StudentNetworkListView(context);
            studentNetworkListView.execute();
        }
        else
            Toast.makeText(context,"not Added Successfully", Toast.LENGTH_SHORT).show();
    }
}
