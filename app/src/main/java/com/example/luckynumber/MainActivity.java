package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                // Explicit Intent
                Intent i = new Intent(getApplicationContext(), LuckyNumberActivity.class);
                // passing the name to the second Activity
                i.putExtra("name",name);  // by using putExtra method
                startActivity(i);


            }
        });
    }

    private void findId() {
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

    }
}