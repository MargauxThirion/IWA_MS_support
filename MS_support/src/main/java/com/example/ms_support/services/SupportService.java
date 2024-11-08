package com.example.ms_support.services;

import com.example.ms_support.models.SupportQuestion;
import com.example.ms_support.repositories.SupportQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportService {

    private final SupportQuestionRepository repository;

    @Autowired
    public SupportService(SupportQuestionRepository repository) {
        this.repository = repository;
    }

    // Créer une nouvelle question de support
    public SupportQuestion createSupportQuestion(SupportQuestion question) {
        return repository.save(question);
    }

    // Obtenir une question par ID
    public Optional<SupportQuestion> getSupportQuestionById(Integer questionId) {
        return repository.findById(questionId);
    }

    // Obtenir toutes les questions ouvertes
    public List<SupportQuestion> getOpenSupportQuestions() {
        return repository.findByStatus("open");
    }

    // Mettre à jour le statut d'une question (par exemple, de "open" à "closed")
    public SupportQuestion closeSupportQuestion(Integer questionId) {
        Optional<SupportQuestion> question = repository.findById(questionId);
        if (question.isPresent()) {
            SupportQuestion updatedQuestion = question.get();
            updatedQuestion.setStatus("closed");
            return repository.save(updatedQuestion);
        }
        return null; // Gérer l'absence de question dans le controller
    }
}
