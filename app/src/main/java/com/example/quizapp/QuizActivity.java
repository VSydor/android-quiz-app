package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.model.Question;

import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion, tvQuestionCounter, tvTimer;
    private Button btnOption1, btnOption2, btnOption3, btnOption4, btnNext;
    private ProgressBar progressBar;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private CountDownTimer countDownTimer;
    private static final long QUESTION_TIME_MS = 60000; // 1 minute
    private long timeLeftInMillis = QUESTION_TIME_MS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.tvQuestion);
        tvQuestionCounter = findViewById(R.id.tvProgress);
        tvTimer = findViewById(R.id.tvTimer);
        progressBar = findViewById(R.id.progressBar);

        btnOption1 = findViewById(R.id.btnOption1);
        btnOption2 = findViewById(R.id.btnOption2);
        btnOption3 = findViewById(R.id.btnOption3);
        btnOption4 = findViewById(R.id.btnOption4);
        btnNext = findViewById(R.id.btnNext);

        // Get selected category
        String category = getIntent().getStringExtra("CATEGORY");
        if (category == null) category = "Science";
        questionList = com.example.quizapp.QuestionBank.getQuestions(category);

        progressBar.setMax(questionList.size());
        showQuestion();

        View.OnClickListener optionClickListener = v -> {
            Button clickedButton = (Button) v;
            int selectedIndex = -1;
            if (clickedButton == btnOption1) selectedIndex = 0;
            else if (clickedButton == btnOption2) selectedIndex = 1;
            else if (clickedButton == btnOption3) selectedIndex = 2;
            else if (clickedButton == btnOption4) selectedIndex = 3;
            checkAnswer(selectedIndex);
        };

        btnOption1.setOnClickListener(optionClickListener);
        btnOption2.setOnClickListener(optionClickListener);
        btnOption3.setOnClickListener(optionClickListener);
        btnOption4.setOnClickListener(optionClickListener);

        btnNext.setOnClickListener(v -> {
            currentQuestionIndex++;
            if (currentQuestionIndex < questionList.size()) {
                resetTimer();
                showQuestion();
            } else {
                finishQuiz();
            }
        });
    }

    private void showQuestion() {
        Question q = questionList.get(currentQuestionIndex);

        tvQuestion.setText(q.getQuestion());

        btnOption1.setText(q.getOptions().get(0));
        btnOption2.setText(q.getOptions().get(1));
        btnOption3.setText(q.getOptions().get(2));
        btnOption4.setText(q.getOptions().get(3));

        tvQuestionCounter.setText(String.format(Locale.getDefault(),
                "Question %d / %d", currentQuestionIndex + 1, questionList.size()));
        progressBar.setProgress(currentQuestionIndex + 1);

        // ✅ Re-enable answer buttons for new question
        btnOption1.setEnabled(true);
        btnOption2.setEnabled(true);
        btnOption3.setEnabled(true);
        btnOption4.setEnabled(true);

        // Disable Next button until user selects an answer
        btnNext.setEnabled(false);

        // Reset timer
        resetTimer();
        startTimer();
    }

    private void checkAnswer(int selectedIndex) {
        Question q = questionList.get(currentQuestionIndex);
        if (selectedIndex == q.getCorrectIndex()) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        btnOption1.setEnabled(false);
        btnOption2.setEnabled(false);
        btnOption3.setEnabled(false);
        btnOption4.setEnabled(false);
        btnNext.setEnabled(true);
        stopTimer();
    }

    private void finishQuiz() {
        stopTimer();
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL", questionList.size());
        startActivity(intent);
        finish();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateTimerText();
                Toast.makeText(QuizActivity.this, "Time’s up!", Toast.LENGTH_SHORT).show();
                btnNext.performClick();
            }
        }.start();
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void resetTimer() {
        stopTimer();
        timeLeftInMillis = QUESTION_TIME_MS;
    }

    private void updateTimerText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        tvTimer.setText("Time left: " + timeFormatted);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }
}
