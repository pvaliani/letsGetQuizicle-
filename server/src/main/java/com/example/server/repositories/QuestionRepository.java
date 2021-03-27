package com.example.server.repositories;

import com.example.server.models.MultipleChoiceQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository <MultipleChoiceQuestion, String> {
}
