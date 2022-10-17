package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Bike;
import co.usa.ciclo3.ciclo3.repository.crud.BikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepository {

    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getAll(){
        return (List<Bike>) bikeCrudRepository.findAll();
    }

    public Optional<Bike> getBike(int id){
        return bikeCrudRepository.findById(id);
    }

    public Bike save(Bike b){
        return bikeCrudRepository.save(b);
    }

}
