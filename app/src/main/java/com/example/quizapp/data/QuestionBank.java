package com.example.quizapp;

import com.example.quizapp.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank {

 public static List<Question> getQuestions(String category) {
  switch (category) {
   case "Science":
    return getScienceQuestions();
   case "History":
    return getHistoryQuestions();
   case "Sports":
    return getSportsQuestions();
   default:
    return new ArrayList<>();
  }
 }

 private static List<Question> getScienceQuestions() {
  List<Question> list = new ArrayList<>();
  list.add(new Question("What planet is known as the Red Planet?",
          List.of("Earth", "Mars", "Jupiter", "Venus"), 1));
  list.add(new Question("What gas do plants absorb from the atmosphere?",
          List.of("Oxygen", "Carbon Dioxide", "Nitrogen", "Helium"), 1));
  list.add(new Question("What is the chemical symbol for water?",
          List.of("H2O", "O2", "CO2", "NaCl"), 0));
  list.add(new Question("How many bones are in the adult human body?",
          List.of("206", "208", "201", "212"), 0));
  list.add(new Question("What is the powerhouse of the cell?",
          List.of("Nucleus", "Mitochondria", "Ribosome", "Cytoplasm"), 1));
  list.add(new Question("What is the largest organ in the human body?",
          List.of("Heart", "Liver", "Skin", "Lungs"), 2));
  list.add(new Question("Which vitamin is produced when a person is exposed to sunlight?",
          List.of("Vitamin A", "Vitamin D", "Vitamin C", "Vitamin K"), 1));
  list.add(new Question("What is the speed of light?",
          List.of("3×10^8 m/s", "3×10^6 m/s", "3×10^4 m/s", "3×10^2 m/s"), 0));
  list.add(new Question("Which part of the plant conducts photosynthesis?",
          List.of("Root", "Stem", "Leaf", "Flower"), 2));
  list.add(new Question("What planet is closest to the Sun?",
          List.of("Venus", "Mercury", "Earth", "Mars"), 1));
  Collections.shuffle(list);
  return list;
 }

 // Similarly update History and Sports questions
 private static List<Question> getHistoryQuestions() {
  List<Question> list = new ArrayList<>();
  list.add(new Question("Who was the first President of the United States?",
          List.of("Abraham Lincoln", "George Washington", "John Adams", "Thomas Jefferson"), 1));
  list.add(new Question("In which year did World War II end?",
          List.of("1945", "1939", "1942", "1950"), 0));
  list.add(new Question("The Great Wall of China was built to protect against whom?",
          List.of("Japanese", "Mongols", "Russians", "Indians"), 1));
  list.add(new Question("Who discovered America?",
          List.of("Marco Polo", "Christopher Columbus", "James Cook", "Vasco da Gama"), 1));
  list.add(new Question("In which country did the Renaissance begin?",
          List.of("France", "Italy", "Germany", "England"), 1));
  list.add(new Question("Who was known as the Maid of Orléans?",
          List.of("Joan of Arc", "Cleopatra", "Queen Victoria", "Marie Antoinette"), 0));
  list.add(new Question("Which empire built Machu Picchu?",
          List.of("Aztec", "Inca", "Maya", "Roman"), 1));
  list.add(new Question("Who wrote the Declaration of Independence?",
          List.of("Thomas Jefferson", "George Washington", "John Adams", "Benjamin Franklin"), 0));
  list.add(new Question("What was the name of the ship on which the Pilgrims traveled to America?",
          List.of("Mayflower", "Santa Maria", "Titanic", "Endeavour"), 0));
  list.add(new Question("Who was the first man to step on the moon?",
          List.of("Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "Michael Collins"), 1));
  Collections.shuffle(list);
  return list;
 }

 private static List<Question> getSportsQuestions() {
  List<Question> list = new ArrayList<>();
  list.add(new Question("How many players are there in a soccer team?",
          List.of("9", "10", "11", "12"), 2));
  list.add(new Question("In which sport is the term 'love' used?",
          List.of("Tennis", "Cricket", "Golf", "Basketball"), 0));
  list.add(new Question("Which country hosted the 2016 Summer Olympics?",
          List.of("China", "Brazil", "UK", "Russia"), 1));
  list.add(new Question("How many rings are there in the Olympic logo?",
          List.of("4", "5", "6", "7"), 1));
  list.add(new Question("Who holds the record for most goals in football history?",
          List.of("Cristiano Ronaldo", "Pelé", "Lionel Messi", "Maradona"), 0));
  list.add(new Question("Which sport uses a puck?",
          List.of("Baseball", "Ice Hockey", "Cricket", "Golf"), 1));
  list.add(new Question("In basketball, how many points is a free throw worth?",
          List.of("1", "2", "3", "4"), 0));
  list.add(new Question("What is the national sport of Japan?",
          List.of("Karate", "Sumo Wrestling", "Judo", "Baseball"), 1));
  list.add(new Question("In cricket, how many runs is a boundary worth?",
          List.of("4", "5", "6", "3"), 0));
  list.add(new Question("Which country won the 2018 FIFA World Cup?",
          List.of("Brazil", "Germany", "France", "Argentina"), 2));
  Collections.shuffle(list);
  return list;
 }
}
