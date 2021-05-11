package com.example.server;

import com.example.server.api.QuizAPI;
import com.example.server.models.MultipleChoiceQuestion;
import com.example.server.repositories.QuestionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	QuizAPI quizAPI;

	@Autowired
	QuestionRepository questionRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void canCallAPI() throws JsonProcessingException {
		quizAPI.getQuestions();

	}

	@Test
	public void canSaveQuestionToDB() {
		ArrayList<String> incorrectAnswers = new ArrayList<>();
		MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion("geography", "multiple choice", "easy", "What is the capital of France?", "Paris", incorrectAnswers);
		incorrectAnswers.add("London");
		incorrectAnswers.add("Berlin");
		incorrectAnswers.add("Rome");

		questionRepository.save(multipleChoiceQuestion);
	}

}
