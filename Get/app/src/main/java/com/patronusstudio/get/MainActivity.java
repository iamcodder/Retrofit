package com.patronusstudio.get;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApi jsonApi = retrofit.create(JsonApi.class);

        Call<List<Post>> list = jsonApi.getData();

        list.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textView.setText("Error code : " + response.code());
                    return;
                }

                List<Post> list = response.body();

                if (list != null) {
                    for (Post post : list) {
                        String icerik = "";
                        icerik += "Id : " + post.getId() + "\n";
                        icerik += "Kullanıcı Id : " + post.getKullanıcı_id() + "\n";
                        icerik += "Başlık : " + post.getBaslik() + "\n";
                        icerik += "İçerik : " + post.getIcerik() + "\n";

                        textView.append(icerik);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText("Error : " + t.getLocalizedMessage());
            }
        });
    }
}
