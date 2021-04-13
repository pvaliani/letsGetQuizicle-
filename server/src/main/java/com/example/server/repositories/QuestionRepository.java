package com.example.server.repositories;

import com.example.server.models.MultiChoiceQPayload;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository <MultiChoiceQPayload, String> {
}
