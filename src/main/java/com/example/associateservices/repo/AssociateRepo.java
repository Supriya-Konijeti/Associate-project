package com.example.associateservices.repo;

import com.example.associateservices.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociateRepo extends JpaRepository<Associate,Integer> {

    @Query(value="select * from associate a where a.firstName like %:keyword% or e.lastNamelike %:keyword% or e.email like %:keyword% or e.skills like %:keyword% e.mobileNo like %:keyword%", nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);
  /* @Query
    public List<Associate> findByEmail(String email);*/
}
