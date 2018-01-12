package br.com.exsystem;

import br.com.exsystem.model.entity.BodyPart;
import br.com.exsystem.model.entity.Exercise;
import br.com.exsystem.model.service.ExerciseService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationExerciseDAOTests {
//
//    ExerciseService es = new ExerciseService();
//
//    @Test
//    public void testCallStack() {
//        Exercise entityExercise = new Exercise();
//        entityExercise.setName("Corrida");
//        entityExercise.setDescription("Loren Ipsilum Loren Ipsilum Loren Ipsilum Loren Ipsilum");
//        entityExercise.setInstructions("Loren Ipsilum Loren Ipsilum Loren Ipsilum Loren Ipsilum");
//        entityExercise.setPhoto(null);
//
//        BodyPart entityBodyFirst = new BodyPart();
//        entityBodyFirst.setId(4L);
//        entityBodyFirst.setName("Coxas");
//        entityBodyFirst.setPhoto(null);
//
//        BodyPart entityBodySecond = new BodyPart();
//        entityBodySecond.setId(5L);
//        entityBodySecond.setName("Panturrilhas");
//        entityBodySecond.setPhoto(null);
//
//        entityExercise.getBodyPartList().add(entityBodyFirst);
//        entityExercise.getBodyPartList().add(entityBodySecond);
//
//        this.testCreate(entityExercise);
//        this.testReadById(entityExercise);
//        this.testReadByCriteria();
//        this.testCountByCriteria();
//
//        entityExercise.setName("Natação");
//        entityExercise.setDescription("Loren Ipsilum Loren Ipsilum Loren Ipsilum Loren Ipsilum");
//        entityExercise.setInstructions("Loren Ipsilum Loren Ipsilum Loren Ipsilum Loren Ipsilum");
//        entityExercise.setPhoto(null);
//
//        entityBodyFirst.setId(4L);
//        entityBodyFirst.setName("Coxas");
//        entityBodyFirst.setPhoto(null);
//
//        entityBodySecond.setId(5L);
//        entityBodySecond.setName("Panturrilhas");
//        entityBodySecond.setPhoto(null);
//
//        entityExercise.getBodyPartList().add(entityBodyFirst);
//        entityExercise.getBodyPartList().add(entityBodySecond);
//
//        this.testUpdate(entityExercise);
//        this.testDelete(entityExercise.getId());
//    }
//
//    
//    public void testCreate(Exercise entityExercise) {
//
//        try {
//            es.create(entityExercise);
//            Assert.assertTrue(entityExercise.getId() != null);
//        } catch (Exception e) {
//
//        }
//    }
//
//    
//    public void testReadById(Exercise entityExercise) {
//
//        try {
//            Exercise entity = es.readById(entityExercise.getId());
//
//            Assert.assertEquals(entityExercise.getId(), entity.getId());
//            Assert.assertEquals(entityExercise.getName(), entity.getName());
//            Assert.assertEquals(entityExercise.getDescription(), entity.getDescription());
//            Assert.assertEquals(entityExercise.getInstructions(), entity.getInstructions());
//            Assert.assertEquals(entityExercise.getBodyPartList().size(), entity.getBodyPartList().size());
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    
//    public void testReadByCriteria() {
//        
//        try {
//            List entityList = es.readByCriteria(null, Long.MIN_VALUE, Long.MIN_VALUE);
//            Assert.assertTrue(entityList.size() > 0);
//        } catch (Exception e) {
//
//        }
//    }
//
//    
//    public void testCountByCriteria() {
//
//        try {
//            Long count = es.countByCriteria(null);
//            Assert.assertEquals(Long.valueOf(1), count);
//        } catch (Exception e) {
//
//        }
//    }
//    
//    
//    public void testUpdate(Exercise entityExercise) {
//
//        Exercise entityExerciseUpdated = null;
//        try {
//            es.update(entityExercise);
//            
//            entityExerciseUpdated = this.readById(entityExercise.getId());
//            
//            Assert.assertEquals(entityExercise.getId(), entityExerciseUpdated.getId());
//            Assert.assertEquals(entityExercise.getName(), entityExerciseUpdated.getName());
//            Assert.assertEquals(entityExercise.getDescription(), entityExerciseUpdated.getDescription());
//            Assert.assertEquals(entityExercise.getInstructions(), entityExerciseUpdated.getInstructions());
//            Assert.assertEquals(entityExercise.getBodyPartList().size(), entityExerciseUpdated.getBodyPartList().size());
//        } catch (Exception e) {
//
//        }
//    }
//
//    
//    public void testDelete(Long id) {
//
//        Exercise entity = null;
//        try {
//            es.delete(id);
//            entity = this.readById(id);
//            
//            Assert.assertNull(entity);
//        } catch (Exception e) {
//
//        }
//    }
//
//    public Exercise readById(Long id) {
//
//        Exercise entity = null;
//        try {
//            entity = es.readById(id);
//        } catch (Exception e) {
//
//        }
//
//        return entity;
//    }

}
