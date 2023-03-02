package pl.edu.pjwstk.Data.description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionService {
    @Autowired
    private DescriptionRepository repo;

    public List<Description> listAll(){
        return (List<Description>) repo.findAll();
    }

    public Description findById(int id){
        return repo.findById(id).get();
    }
}
