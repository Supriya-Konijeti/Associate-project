package com.example.associateservices.service;


import com.example.associateservices.model.Associate;
import com.example.associateservices.model.Skills;
import com.example.associateservices.repo.AssociateRepo;
import com.example.associateservices.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AssociateServiceImpl implements AssociateService{
    private AssociateRepo associateRepo;
    private SkillRepo skillrepo;
    private Associate associate;
@Autowired
    public AssociateServiceImpl(AssociateRepo associateRepo, SkillRepo skillrepo) {
        this.associateRepo = associateRepo;
    this.skillrepo = skillrepo;
}

    @Override
    public Associate createAssociate(Associate associate) {

    return associateRepo.save(associate);
    }

    @Override
    public Associate addSkills(Skills skills) {
        skillrepo.save(skills);
        associate.add(skills);
        return associate;
    }

    @Override
    public List<Associate> displayAllAssociate() {

    return associateRepo.findAll();
    }

    @Override
    public Associate findById(int id) {

        Associate associate=null;
        Optional<Associate> result=associateRepo.findById(id);
        if(result.isPresent())
        {
            associate=result.get();
        }
        else {

            throw new RuntimeException("Did not find associate id - " + id);
        }

        return associate;
    }

    @Override
    public Skills findSkillsById(int id) {
        return skillrepo.getOne(id);
    }

    @Override
    public List<Associate> findByKeyword(String keyword) {
        return associateRepo.findByKeyword(keyword);
    }

    @Override
    public List<Skills> displaySkills(){
     return skillrepo.findAll();
    }

    /* @Override
    public List<Associate> findAssociateByFirstName(String firstName){
        return associateRepo.findAssociateByFirstName(firstName);
    }*/
    @Override
    public void deleteAllAssociate() {
        associateRepo.deleteAll();
    }
    /*@Override
    public List<Associate> findByEmail(String email){
        return associateRepo.findByEmail(email);
}*/

}
