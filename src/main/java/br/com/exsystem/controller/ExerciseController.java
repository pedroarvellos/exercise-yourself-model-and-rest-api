package br.com.exsystem.controller;

import br.com.exsystem.criteria.ExerciseCriteria;
import br.com.exsystem.model.service.ExerciseService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exercise")
public class ExerciseController {
    
    ExerciseService es = new ExerciseService();
    
    //Read a particular exercise according to his passed ID.
    @GetMapping (value = "/{exerciseID}")
    public ResponseEntity readById(@PathVariable Long exerciseID) throws Exception {
        try {
            return ResponseEntity.ok(es.readById(exerciseID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
