package com.example.associateservices.model;

import javax.persistence.*;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String skill;
/*@ManyToOne
@JoinColumn(name="associate_id")
    private Associate associate;*/

    public Skills() {
    }

    public Skills(Integer id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    /*public Associate getAssociate() {
        return associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }*/

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                '}';
    }
}