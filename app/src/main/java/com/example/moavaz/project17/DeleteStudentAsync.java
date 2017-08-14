package com.example.moavaz.project17;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Moavaz on 8/14/2017.
 */

public class DeleteStudentAsync extends AsyncTask<Void, Void, String> {

    String jsonresult;
    private Activity context;
    private int id;

    public DeleteStudentAsync(Activity context, int id) {
        this.context = context;
        this.id = id;
    }


    @Override
    protected String doInBackground(Void... params) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://192.168.43.79/projectapi.dev/api/posts/" + id)
                .delete()
                .build();

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
            Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            StudentNetworkListView networkCallForListView = new StudentNetworkListView(context);
            networkCallForListView.execute();
        } else
            Toast.makeText(context, "Not Deleted", Toast.LENGTH_SHORT).show();
    }
}
