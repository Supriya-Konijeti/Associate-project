package com.example.associateservices;

import com.example.associateservices.model.Associate;

import com.example.associateservices.model.Skills;
import com.example.associateservices.repo.AssociateRepo;

import com.example.associateservices.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AssociateServicesApplication implements CommandLineRunner {
    private AssociateRepo associateRepo;
    private SkillRepo skillRepository;
@Autowired
    public AssociateServicesApplication(AssociateRepo associateRepo, SkillRepo skillRepository) {
        this.associateRepo = associateRepo;
        this.skillRepository = skillRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AssociateServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Skills javascript = new Skills(1, "Javascript");
        Skills java = new Skills(2, "Java");
        Skills cpp = new Skills(3, "C++");
        Skills python = new Skills(4, "Python");

        skillRepository.save(javascript);
        skillRepository.save(java);
        skillRepository.save(cpp);
        skillRepository.save(python);
        associateRepo.save(new Associate(1,"Supriya1","Konijeti1","Supriya1@email.com","9999999991",Arrays.asList(new Skills[]{java})));
        associateRepo.save(new Associate(2,"Supriya2","Konijeti2","Supriya2@email.com","9999999992",Arrays.asList(new Skills[]{javascript})));
        associateRepo.save(new Associate(3,"Supriya3","Konijeti3","Supriya3@email.com","9999999993",Arrays.asList(new Skills[]{cpp})));
        associateRepo.save(new Associate(4,"Supriya4","Konijeti4","Supriya4@email.com","9999999994",Arrays.asList(new Skills[]{python})));
 }
}
