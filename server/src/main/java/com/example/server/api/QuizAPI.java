package com.example.server.api;

import com.example.server.models.MultipleChoiceQuestion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// The code for the fetch is set up in here

//Use the component annotation to allow the fetch

@Component
public class QuizAPI {

//   performs a fetch for 50 questions

    public MultipleChoiceQuestion[] getQuestions() throws JsonProcessingException {
        String url = "https://opentdb.com/api.php?amount=50&type=multiple";

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        MultipleChoiceQuestion[] questionsFromAPI = new MultipleChoiceQuestion[0];

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

//      Represents the node we are dealing with - initialised to null
        JsonNode root = null;

//      Exception handling from the fetch

        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JsonNode node = root.get(1);
        JsonNode questionsNode = root.get("results");
//        System.out.println(questionsNode);

        String questionsString = questionsNode.toString();
//        questionsFromAPI = mapper.readValue(questionsString, MultipleChoiceQuestion[].class);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        questionsFromAPI = mapper.readValue(questionsString, MultipleChoiceQuestion[].class);

        System.out.println(questionsFromAPI);
        return questionsFromAPI;
    }

}
