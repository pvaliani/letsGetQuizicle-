package com.example.server.api;

import com.example.server.models.MultiChoiceQPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

// The code for the fetch is set up in here

//Use the component annotation to allow the fetch

@Component
public class QuizAPI {

//   performs a fetch for 50 questions

    public JsonNode getQuestions() throws IOException {
        String url = "https://opentdb.com/api.php?amount=50&type=multiple";

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);



//      Represents the node we are dealing with - initialised to null
        JsonNode root = null;

 //     Exception handling from the fetch

        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JsonNode node = root.get(1);

        JsonNode questionsNode = root.get("results");
//
//        ObjectReader reader = mapper.readerFor(new TypeReference<List<MultiChoiceQPayload>>() {
//        });
//
//        List<MultiChoiceQPayload> questionsFromAPI = reader.readValue(questionsNode);
//        System.out.println(questionsFromAPI);
//       mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//       QuestionPayload[] questionsFromAPI = mapper.readValue(questionsNode, QuestionPayload[].class);



        return questionsNode;
    }

}
