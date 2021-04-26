package com.example.library.studentlibrary.Services;

import com.example.library.studentlibrary.Model.Card;
import com.example.library.studentlibrary.Model.CardStatus;
import com.example.library.studentlibrary.Model.Student;
import com.example.library.studentlibrary.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;

@Entity
class CardService {

    @Autowired
    private
    CardRepository cardRepository;

    Card createAndReturn(Student student) {
        Card card = new Card();
        card.setStudent(student);
        student.setCard(card);

        cardRepository.save(card);
        return card;

    }

    void deactivateCard(int student_id){
        cardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }

}
