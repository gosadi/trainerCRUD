/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplecert.service;

import peoplecert.entity.Trainer;
import peoplecert.repository.TrainerRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alkinoos
 */
@Transactional
@Service
public class TrainerService {

    @Autowired
    TrainerRepo trainerRepo;

    public List<Trainer> getTrainers() {
        List<Trainer> trainers = trainerRepo.findAll();
        return trainers;
    }

    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepo.save(trainer);
    }

    public void deleteTrainer(int id) {
        trainerRepo.delete(Trainer.class, id);
    }

    public Trainer getTrainerById(int id) {
        return trainerRepo.findById(id);
    }

   
}
