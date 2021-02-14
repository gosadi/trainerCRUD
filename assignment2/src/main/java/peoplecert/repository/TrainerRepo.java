/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplecert.repository;

import peoplecert.entity.Trainer;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alkinoos
 */
@Repository
public class TrainerRepo extends HibernateUtil<Trainer> implements CrudRepo<Trainer>{

    @Override
    public Trainer save(Trainer s) {
        return super.save(s);
    }

    @Override
    public void delete(int id) {
        super.delete(Trainer.class, id);
    }

    @Override
    public Trainer findById(int id) {
        return super.find(Trainer.class, id);
    }

    @Override
    public List<Trainer> findAll() {
        return super.findAll("Trainer.findAll");
    }
    
}
