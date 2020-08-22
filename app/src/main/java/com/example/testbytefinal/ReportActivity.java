package com.example.testbytefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testbytefinal.adapter.ItemAdapter;
import com.example.testbytefinal.model.Acount;
import com.example.testbytefinal.model.ListAcount;
import com.example.testbytefinal.webservice.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReportActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Acount> list;

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;
    ImageView salir;
    Button confirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView usertx;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);
        getSupportActionBar().hide();

        Bundle datos = this.getIntent().getExtras();
        String user = datos.getString("user");

        usertx = (TextView) findViewById(R.id.id_user);
        usertx.setText("Bienvenido "+user);

        salir =(ImageView) findViewById(R.id.salir);
        confirmar = (Button) findViewById(R.id.confirmar);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        setUpView();
        lounchPetition();
    }

    private void lounchPetition() {
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://91f7b927-de7a-401b-8a73-f0fd9b35764d.mock.pstmn.io/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        WebServiceClient client = retrofit.create(WebServiceClient.class);
        Call<ListAcount> call = client.getAcounts();
        call.enqueue(new Callback<ListAcount>() {
            @Override
            public void onResponse(Call<ListAcount> call, Response<ListAcount> response) {
                adapter.setdata(response.body().getStatement());
            }

            @Override
            public void onFailure(Call<ListAcount> call, Throwable t) {
                Log.d("TAG1","ERROR: "+t.getMessage());
            }
        });

    }

    private void setUpView() {
        list = new ArrayList<>();
        adapter = new ItemAdapter(list);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }
}