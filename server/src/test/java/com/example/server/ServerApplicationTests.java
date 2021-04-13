package com.example.server;

import com.example.server.api.QuizAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	QuizAPI quizAPI;


	@Test
	void contextLoads() {
	}

	@Test
	public void canCallAPI() throws IOException {
		quizAPI.getQuestions();

	}

}
