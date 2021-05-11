package com.example.server.components;

import com.example.server.api.QuizAPI;
import com.example.server.models.MultipleChoiceQuestion;
import com.example.server.models.MultipleChoiceQuestionPayload;
import com.example.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// I've commented this out now because I only wanted to run this once to save 50 questions to the database.

//@Component
//public class DataLoader implements ApplicationRunner {
//    @Autowired
//    QuestionRepository questionRepository;
//
//    @Autowired
//    QuizAPI quizAPI;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        //Fetches the questions from the API and saves them as a list of MultipleChoiceQuestionPayload
//        List<MultipleChoiceQuestionPayload> questionsFromAPI = quizAPI.getQuestions();
//
//        //Maps the list of MultipleChoiceQuestionPayload objects to a list of MultipleChoiceQuestion objects and saves them all to the database
//        List<MultipleChoiceQuestion> savedQuestions = questionsFromAPI.stream()
//                .map(question -> new MultipleChoiceQuestion(question.getCategory(), question.getType(), question.getDifficulty(), question.getQuestion(), question.getCorrectAnswer(), question.getIncorrectAnswers()))
//                .collect(Collectors.toList());
//
//        questionRepository.saveAll(savedQuestions);
//    }
//}
