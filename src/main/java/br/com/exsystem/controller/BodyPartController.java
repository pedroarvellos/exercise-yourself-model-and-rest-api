package br.com.exsystem.controller;

import br.com.exsystem.criteria.ExerciseCriteria;
import br.com.exsystem.model.entity.BodyPart;
import br.com.exsystem.model.entity.Exercise;
import br.com.exsystem.model.service.BodyPartService;
import br.com.exsystem.model.service.ExerciseService;
import java.util.HashMap;
import java.util.List;
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
    
    //Read all exercises from a defined part of the body.
    @GetMapping (value = "/{bodyPartID}")
    public ResponseEntity readExercisesFromBodyPartByCriteria(@PathVariable Long bodyPartID) throws Exception {
        ExerciseService es = new ExerciseService();
        
        try {
            Map<Long, Object> criteria = new HashMap<>();
            criteria.put(ExerciseCriteria.BODY_PART_ID, bodyPartID);
            
            List<Exercise> entityList = es.readByCriteria(criteria, null, null);
            
            return ResponseEntity.ok(entityList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    //Read all body parts from a defined part of the body.
    @GetMapping 
    public ResponseEntity readBodyPartByCriteria() throws Exception {
        BodyPartService bps = new BodyPartService();
        
        try {
            Map<Long, Object> criteria = new HashMap<>();
            
            List<BodyPart> entityList = bps.readByCriteria(criteria, null, null);
            
            return ResponseEntity.ok(entityList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
