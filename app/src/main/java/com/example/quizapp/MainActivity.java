package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  Button btnScience = findViewById(R.id.btnScience);
  Button btnHistory = findViewById(R.id.btnHistory);
  Button btnSports = findViewById(R.id.btnSports);

  View.OnClickListener listener = v -> {
   String category = "";
   if (v.getId() == R.id.btnScience) category = "Science";
   else if (v.getId() == R.id.btnHistory) category = "History";
   else if (v.getId() == R.id.btnSports) category = "Sports";

   Intent intent = new Intent(MainActivity.this, QuizActivity.class);
   intent.putExtra("CATEGORY", category);
   startActivity(intent);
  };

  btnScience.setOnClickListener(listener);
  btnHistory.setOnClickListener(listener);
  btnSports.setOnClickListener(listener);
 }
}
