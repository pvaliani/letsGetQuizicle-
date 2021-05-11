package com.example.server.controllers;

import com.example.server.api.QuizAPI;
import com.example.server.models.MultipleChoiceQuestion;
import com.example.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping (value = "api/quiz")
    public ResponseEntity<List<MultipleChoiceQuestion>> getAllQuestions() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping (value = "api/quiz/random")
    public ResponseEntity<List<MultipleChoiceQuestion>> getRandomQuiz() {
        // Gets all 50 questions in the database
        List<MultipleChoiceQuestion> dbQuestions = questionRepository.findAll();

        //Shuffles the questions
        Collections.shuffle(dbQuestions);

        //Creating a new array for the random quiz questions
        List<MultipleChoiceQuestion> generatedQuiz = new ArrayList<>();

        //Initialises the index value to 0
        int i = 0;

        //Adds the first 10 questions from the shuffled database questions to the generated quiz list.
        while (generatedQuiz.size() < 10) {
            MultipleChoiceQuestion questionToAdd = dbQuestions.get(i);
            generatedQuiz.add(questionToAdd);
            i ++;
        }

        return new ResponseEntity<>(generatedQuiz, HttpStatus.OK);
    }
}
