package com.example.server;

import com.example.server.api.QuizAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	QuizAPI quizAPI;


	@Test
	void contextLoads() {
	}

	@Test
	public void canCallAPI() throws JsonProcessingException {
		quizAPI.getQuestions();

	}

}
