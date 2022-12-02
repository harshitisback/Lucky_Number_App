package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView wlc, lucky_num;
    Button btn_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        findids();
        Intent i = getIntent();
        // data for userName
        String name = i.getStringExtra("name");
        Toast.makeText(this, "Welcome "+name, Toast.LENGTH_SHORT).show();
        int generatedNum = generateRandNum();
        lucky_num.setText(""+generatedNum);

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(name, generatedNum);
            }
        });





    }



    private int generateRandNum() {
        Random random = new Random();
        int upper_limit = 1000;

        return random.nextInt(1000);
    }

    private void findids() {
        lucky_num = findViewById(R.id.luckynumbertext);
        wlc = findViewById(R.id.textview2);
        btn_share = findViewById(R.id.share_number);
    }

    public void shareData(String userName, int num) {
        // Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, userName);
        i.putExtra(Intent.EXTRA_TEXT,"Lucky Number Hello guys here is my Lucky Number is: "+ String.valueOf(num));

        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}