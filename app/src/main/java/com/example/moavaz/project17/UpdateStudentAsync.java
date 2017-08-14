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

public class UpdateStudentAsync extends AsyncTask<Void, Void, String> {

    private Activity context;
    private String fname, lname, mail, ph, img, stuid;
    private String jsonresult;
    private int id;

    public UpdateStudentAsync(Activity context, String fname, String lname, String mail, String stuid, String img,
                              String ph, int id) {
        this.context = context;
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
        this.ph = ph;
        this.img = img;
        this.stuid = stuid;
        this.id = id;
    }

    @Override
    protected String doInBackground(Void... params) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("firstname", fname)
                .add("lastnmae", lname)
                .add("email", mail)
                .add("studentid", stuid)
                .add("image", img)
                .add("contactno", ph)
                .build();

        Request request = new Request.Builder().url("http:// 192.168.15.5/projectapi.dev/api/posts/" + id)
                .put(requestBody).build();

        try {
            Response response = client.newCall(request).execute();
            jsonresult = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonresult;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            Toast.makeText(context, "Updated Successfully" + s, Toast.LENGTH_SHORT).show();
            StudentNetworkListView studentNetworkListView = new StudentNetworkListView(context);
            studentNetworkListView.execute();
        } else
            Toast.makeText(context, "Not Updated", Toast.LENGTH_SHORT).show();
    }
}
