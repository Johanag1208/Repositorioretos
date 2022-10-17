package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return  adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return  adminRepository.getAdmin(id);
    }

    public Admin save(Admin ad) {
        if (ad.getIdAdmin() == null) {
            return  adminRepository.save(ad);
        } else {
            Optional <Admin> adaux= adminRepository.getAdmin(ad.getIdAdmin());
            if(adaux.isEmpty()){
                return  adminRepository.save(ad);
            }else{
                return ad;
            }
        }
    }


}

