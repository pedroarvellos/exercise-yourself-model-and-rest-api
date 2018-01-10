package br.com.exsystem.model.dao;

import br.com.exsystem.model.base.BaseDAO;
import br.com.exsystem.model.entity.BodyPart;
import br.com.exsystem.model.entity.Exercise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class ExerciseDAO implements BaseDAO<Exercise> {

    @Override
    public void create(Connection conn, Exercise entity) throws Exception {
        String query = "INSERT INTO exercise"
                + "(exercise_name, exercise_description, exercise_photo, exercise_instructions)"
                + "VALUES (?, ?, ?, ?) RETURNING exercise_id;";

        PreparedStatement ps = conn.prepareStatement(query);

        int i = 0;
        ps.setString(++i, entity.getName());
        ps.setString(++i, entity.getDescription());
        ps.setBytes(++i, entity.getPhoto());
        ps.setString(++i, entity.getInstructions());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("exercise_id"));
        }
        
        rs.close();
        ps.close();
        
        this.createBodyPartExercise(conn, entity);
    }

    public void createBodyPartExercise(Connection conn, Exercise entity) throws Exception {
        String query = "INSERT INTO body_part_exercise "
                + "(body_part_fk, exercise_fk) "
                + "VALUES (?, ?);";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        if(entity.getBodyPartList() != null && !entity.getBodyPartList().isEmpty()) {
            for (BodyPart bodyPart : entity.getBodyPartList()) {
               
                int i = 0;
                ps.setLong(++i, bodyPart.getId());
                ps.setLong(++i, entity.getId());
                
                ps.executeQuery();
            }
            
            ps.close();
        } else {
            throw new Exception("Body Part not mentioned!");
        }
        
    }

    @Override
    public Exercise readById(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exercise> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection conn, Exercise entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String applyCriteria(Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
