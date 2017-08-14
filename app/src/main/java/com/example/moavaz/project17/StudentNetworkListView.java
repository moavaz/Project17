package com.example.moavaz.project17;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;

import com.google.gson.reflect.TypeToken;

import org.immutables.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Moavaz on 8/14/2017.
 */

public class StudentNetworkListView extends AsyncTask<Void, Void, String> {

    String jsonresult;
    Activity context;

    public StudentNetworkListView(Activity context) {

        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://projectapi.dev/api/posts")
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

        com.google.gson.Gson gson = new com.google.gson.Gson();

        List<Student> students = gson.fromJson(jsonresult, new TypeToken<ArrayList<Student>>() {
        }.getType());

        FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
        StudentListFragment studentListFragment = new StudentListFragment(context, students);
        fragmentManager.beginTransaction().replace(R.id.fragnentcontainer, studentListFragment).commit();
    }
}
