package com.example.quizapp;
import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.*; import androidx.appcompat.app.AppCompatActivity; import com.example.quizapp.data.QuestionBank; import com.example.quizapp.model.Question; import java.util.List;
public class MainActivity extends AppCompatActivity {
 private TextView tvQuestion; private RadioGroup rgOptions; private Button btnNext; private List<Question> questions; private int currentIndex = 0; private int score = 0;
 @Override protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
 tvQuestion = findViewById(R.id.tvQuestion); rgOptions = findViewById(R.id.rgOptions); btnNext = findViewById(R.id.btnNext);
 questions = QuestionBank.getQuestions(); showQuestion();
 btnNext.setOnClickListener(v -> { int selectedId = rgOptions.getCheckedRadioButtonId(); if (selectedId != -1) {
 View radio = findViewById(selectedId); int answerIndex = rgOptions.indexOfChild(radio);
 Question q = questions.get(currentIndex); if (answerIndex == q.getCorrectIndex()) score++;
 currentIndex++; if (currentIndex < questions.size()) { rgOptions.clearCheck(); showQuestion(); }
 else { Intent i = new Intent(MainActivity.this, ResultActivity.class); i.putExtra("score", score); i.putExtra("total", questions.size()); startActivity(i); finish(); }
 }});
 }
 private void showQuestion() { Question q = questions.get(currentIndex); tvQuestion.setText((currentIndex + 1) + ". " + q.getQuestion()); for (int i = 0; i < 4; i++) { ((RadioButton) rgOptions.getChildAt(i)).setText(q.getOptions()[i]); } }
}
