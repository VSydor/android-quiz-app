package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

 private TextView tvFinalScore, tvPerformance, tvCorrectAnswers;
 private Button btnRetry, btnHome;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_result);

  tvFinalScore = findViewById(R.id.tvFinalScore);
  tvPerformance = findViewById(R.id.tvPerformance);
  tvCorrectAnswers = findViewById(R.id.tvCorrectAnswers); // NEW
  btnRetry = findViewById(R.id.btnRetry);
  btnHome = findViewById(R.id.btnHome);

  int score = getIntent().getIntExtra("SCORE", 0);
  int total = getIntent().getIntExtra("TOTAL", 0);

  tvFinalScore.setText("Your Score: " + score + " / " + total);
  tvCorrectAnswers.setText("Correct Answers: " + score + " out of " + total); // NEW

  double percent = (score * 100.0) / total;
  String performance;

  if (percent == 100) performance = "Perfect! 🏆";
  else if (percent >= 80) performance = "Great job! 🎉";
  else if (percent >= 50) performance = "Not bad, keep learning!";
  else performance = "Try again! 💪";

  tvPerformance.setText(performance);

  btnRetry.setOnClickListener(v -> {
   // Restart same quiz
   finish();
  });

  btnHome.setOnClickListener(v -> {
   Intent intent = new Intent(ResultActivity.this, MainActivity.class);
   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
   startActivity(intent);
   finish();
  });
 }
}
