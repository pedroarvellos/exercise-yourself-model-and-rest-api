package br.com.exsystem.controller;

import br.com.exsystem.model.entity.Exercise;
import br.com.exsystem.model.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
            Exercise exercise = es.readById(exerciseID);
            return ResponseEntity.ok(exercise);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @PostMapping
    public ResponseEntity create(@RequestBody Exercise entity) {
        try {
            
            es.create(entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity update (@RequestBody Exercise entity) {
        try {
            
            es.update(entity);
            return ResponseEntity.ok("Exercise Updated!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @DeleteMapping (value = "/{id}")
    public ResponseEntity delete (@PathVariable Long id) {
        try {
            
            es.delete(id);
            return ResponseEntity.ok("Exercise deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
