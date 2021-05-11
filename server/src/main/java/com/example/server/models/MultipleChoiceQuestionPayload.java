package com.example.server.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MultipleChoiceQuestionPayload {

    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correct_answer;
    private ArrayList<String> incorrect_answers;


    public MultipleChoiceQuestionPayload(String category, String type, String difficulty, String question, String correct_answer, ArrayList incorrect_answers){
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    public MultipleChoiceQuestionPayload(){
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String questions) {
        this.question = questions;
    }

    public String getCorrectAnswer() {
        return correct_answer;
    }

    public void setCorrectAnswer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public ArrayList getIncorrectAnswers() {
        return incorrect_answers;
    }

    public void setIncorrectAnswers(ArrayList incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

}
