package com.example.associateservices.service;


import com.example.associateservices.model.Associate;
import com.example.associateservices.model.Skills;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssociateService {
    public Associate createAssociate(Associate associate);
    //public Associate addSkills(Skills skills);
    public List<Associate> displayAllAssociate();
    public List<Skills> displaySkills();
    public Associate findById(int id);
    public Skills findSkillsById(int id);
    //public Associate updateAssociate(Integer id);
    //public List<Associate> findAssociateByFirstName(String firstName);
    public void deleteAllAssociate();
    @Query(value="select * from associate a where a.firstName like %:keyword% or e.lastNamelike %:keyword% or e.email like %:keyword% or e.skills like %:keyword% e.mobileNo like %:keyword%", nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);
   /*public List<Associate> findByEmail(String email);*/
}
