package com.example.quizapp.data;
import com.example.quizapp.model.Question;
import java.util.*;
public class QuestionBank {
 public static List<Question> getQuestions() {
 List<Question> list = new ArrayList<>();
 list.add(new Question("What is the capital of France?", new String[]{ "Paris", "Berlin", "Madrid", "Rome" }, 0));
 list.add(new Question("Which language runs on the JVM?", new String[]{ "Kotlin", "Swift", "JavaScript", "Objective-C" }, 0));
 list.add(new Question("What does HTTP stand for?", new String[]{ "HyperText Transfer Protocol", "HighText Transfer Protocol", "Hyper Transfer Text Protocol", "HyperText Transmission Protocol" }, 0));
 list.add(new Question("Which planet is known as the Red Planet?", new String[]{ "Mars", "Venus", "Jupiter", "Saturn" }, 0));
 list.add(new Question("What is 7 × 8?", new String[]{ "54", "56", "48", "62" }, 1));
 return list; }
}
