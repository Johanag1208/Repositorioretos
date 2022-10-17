package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Bike;
import co.usa.ciclo3.ciclo3.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getBikes(){
        return bikeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable ("id") Integer id){
        return bikeService.getBike(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike b){
        return bikeService.save(b);
    }
}
