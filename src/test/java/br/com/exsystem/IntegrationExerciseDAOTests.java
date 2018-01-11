package br.com.exsystem;

import br.com.exsystem.model.ConnectionManager;
import br.com.exsystem.model.dao.ExerciseDAO;
import br.com.exsystem.model.entity.BodyPart;
import br.com.exsystem.model.entity.Exercise;
import br.com.exsystem.model.service.ExerciseService;
import java.sql.Connection;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationExerciseDAOTests {

    ExerciseDAO ed = new ExerciseDAO();
    ExerciseService es = new ExerciseService();

//    @Test
//    public void testCreate() {
//
//        try {
//            Exercise entityExercise = new Exercise();
//            entityExercise.setName("Corrida");
//            entityExercise.setDescription("Loren Ipsilum Loren Ipsilum Loren Ipsilum Loren Ipsilum");
//            entityExercise.setInstructions("Loren Ipsilum Loren Ipsilum Loren Ipsilum Loren Ipsilum");
//            entityExercise.setPhoto(null);
//
//            BodyPart entityBodyFirst = new BodyPart();
//            entityBodyFirst.setId(4L);
//            entityBodyFirst.setName("Coxas");
//            entityBodyFirst.setPhoto(null);
//            
//            BodyPart entityBodySecond = new BodyPart();
//            entityBodySecond.setId(5L);
//            entityBodySecond.setName("Panturrilhas");
//            entityBodySecond.setPhoto(null);
//
//            entityExercise.getBodyPartList().add(entityBodyFirst);
//            entityExercise.getBodyPartList().add(entityBodySecond);
//
//            es.create(entityExercise);
//        } catch (Exception e) {
//            Assert.assertFalse(true);
//        }
//    }
//
//    @Test
//    public void testReadById() {
//
//        try {
//            Connection conn = ConnectionManager.getInstance().getConnection();
//            Exercise entity = ed.readById(conn, 24L);
//        } catch (Exception e) {
//
//        }
//    }
    
    @Test
    public void testReadByCriteria() {

        try {
            Connection conn = ConnectionManager.getInstance().getConnection();
            List entityList = ed.readByCriteria(conn, null, Long.MIN_VALUE, Long.MIN_VALUE);

        } catch (Exception e) {

        }
    }

}
