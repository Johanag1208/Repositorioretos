package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category ca) {
        if (ca.getId() == null) {
            return categoryRepository.save(ca);
        } else {
            Optional <Category> caaux=categoryRepository.getCategory(ca.getId());
            if(caaux.isEmpty()){
                return categoryRepository.save(ca);
            }else{
                return ca;
            }
        }
    }


}

