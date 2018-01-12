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
@RequestMapping(value = "/bodypart")
public class BodyPartController {
    
    ExerciseService es = new ExerciseService();
    
    //Read all exercises from a defined part of the body.
    @GetMapping (value = "/{bodyPartID}")
    public ResponseEntity readByCriteria(@PathVariable Long bodyPartID) throws Exception {
        try {
            Map<Long, Object> criteria = new HashMap<>();
            criteria.put(ExerciseCriteria.BODY_PART_ID, bodyPartID);
            
            return ResponseEntity.ok(es.readByCriteria(criteria, null, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
