package com.example.associateservices.conroller;


import com.example.associateservices.model.Associate;
import com.example.associateservices.model.Skills;
import com.example.associateservices.repo.AssociateRepo;
import com.example.associateservices.repo.SkillRepo;
import com.example.associateservices.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AssociateController {
    private AssociateService associateService;
    private AssociateRepo associateRepo;
    private SkillRepo skillRepo;
    private final Environment environment;
@Autowired
    public AssociateController(AssociateService associateService, Environment environment) {
        this.associateService = associateService;
    this.environment = environment;
}
    @GetMapping("/")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("customer service is up at port number: "+environment.getProperty("local.server.port"));
    }
    @PostMapping(path = "/associates")
    public ResponseEntity<Associate> createAssociate(@RequestBody Associate associate)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(associateService.createAssociate(associate));
    }
    @GetMapping(path="/associates")
    public ResponseEntity<List<Associate>> getAllAssociate(){
        return ResponseEntity.ok(associateService.displayAllAssociate());
    }
    @GetMapping(path="/associates/{id}")
    public ResponseEntity<Associate> getAssociateById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(associateService.findById(id));
    }
    @PostMapping("/addskill/{id}")
    public Optional<Associate> addSkills(@PathVariable Integer id,@RequestBody Skills skill)
    {
        Optional a=associateRepo.findById(id);
        if(a==null)
        {
            System.out.println("No such Associate found with given id....");
        }
        else
        {
            associateService.addSkills(skill);
        }
        return a;
    }
    @PutMapping("/associates/{id}")
    public ResponseEntity<Associate> UpdateById(@PathVariable("id") Integer id ,@RequestBody Associate associate) {
        Associate e = associateService.findById(id);
        e.setFirstName(associate.getFirstName());
        e.setLastName(associate.getLastName());
        e.setEmail(associate.getEmail());
        e.setMobileNo(associate.getMobileNo());
        e.setSkills(associate.getSkills());
        final Associate Updated = associateRepo.save(e);
        return ResponseEntity.status(HttpStatus.OK).body(Updated);
    }
   @GetMapping("/list/{keyword}")
    public List<Associate> getAssociates(Model model, String keyword)
    {
        List<Associate> list=associateService.displayAllAssociate();
        if(keyword!=null){
           model.addAttribute("associates", associateService.findByKeyword(keyword));
        }
        else {
            model.addAttribute("associates", list);
        }
       // return "list-associates";
        return list;
    }
    /*@GetMapping(path="/associates/{firstName}")
    public ResponseEntity<List<Associate>> getAssociateByFirstName(@PathVariable("firstName") String firstName){
        return  ResponseEntity.ok(associateService.findAssociateByFirstName(firstName));
    }
    @GetMapping("/associates/{email}")
    public ResponseEntity<List<Associate>> getAssociateByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(associateService.findByEmail(email));
    }*/
    @DeleteMapping(path="/associates")
    public void deleteAll(){
    associateService.deleteAllAssociate();
    }
}
