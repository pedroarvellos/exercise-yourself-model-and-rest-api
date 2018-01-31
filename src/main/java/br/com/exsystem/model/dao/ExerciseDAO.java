package br.com.exsystem.model.dao;

import br.com.exsystem.criteria.ExerciseCriteria;
import br.com.exsystem.model.base.BaseDAO;
import br.com.exsystem.model.entity.BodyPart;
import br.com.exsystem.model.entity.Exercise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
        ps.setString(++i, entity.getPhoto());
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
                + "VALUES (?, ?) RETURNING exercise_fk;";

        PreparedStatement ps = conn.prepareStatement(query);

        if (entity.getBodyPartList() != null && !entity.getBodyPartList().isEmpty()) {
            for (BodyPart bodyPart : entity.getBodyPartList()) {

                int i = 0;
                ps.setLong(++i, bodyPart.getId());
                ps.setLong(++i, entity.getId());

                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    entity.setId(rs.getLong("exercise_fk"));
                }
            }

            ps.close();
        } else {
            throw new Exception("Body Part not mentioned!");
        }

    }

    @Override
    public Exercise readById(Connection conn, Long id) throws Exception {
        String query = "SELECT exercise_id, exercise_name, exercise_description, exercise_photo, exercise_instructions, body_part_id, body_part_name, body_part_photo FROM exercise LEFT JOIN body_part_exercise ON exercise.exercise_id = body_part_exercise.exercise_fk LEFT JOIN body_part ON body_part.body_part_id = body_part_exercise.body_part_fk WHERE exercise_id = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        Exercise entity = null;
        if (rs.next()) {
            entity = new Exercise();
            entity.setId(rs.getLong("exercise_id"));
            entity.setName(rs.getString("exercise_name"));
            entity.setDescription(rs.getString("exercise_description"));
            entity.setInstructions(rs.getString("exercise_instructions"));
            entity.setPhoto(rs.getString("exercise_photo"));

            BodyPart bodyEntityFirst = new BodyPart();

            bodyEntityFirst.setId(rs.getLong("body_part_id"));
            bodyEntityFirst.setName(rs.getString("body_part_name"));
            bodyEntityFirst.setPhoto(rs.getString("body_part_photo"));

            entity.getBodyPartList().add(bodyEntityFirst);

            while (rs.next()) {
                BodyPart bodyEntityNext = new BodyPart();

                bodyEntityNext.setId(rs.getLong("body_part_id"));
                bodyEntityNext.setName(rs.getString("body_part_name"));
                bodyEntityNext.setPhoto(rs.getString("body_part_photo"));

                entity.getBodyPartList().add(bodyEntityNext);
            }
        }

        rs.close();
        ps.close();

        return entity;
    }

    @Override
    public List<Exercise> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        String query = "SELECT exercise_id, exercise_name, exercise_description, exercise_photo, exercise_instructions, body_part_id, body_part_name, body_part_photo FROM exercise LEFT JOIN body_part_exercise ON exercise.exercise_id = body_part_exercise.exercise_fk LEFT JOIN body_part ON body_part.body_part_id = body_part_exercise.body_part_fk WHERE 1=1 ";
            
        query += this.applyCriteria(criteria);
        query += " ORDER BY exercise_id";
        
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        List <Exercise> exerciseList = new ArrayList<>();
        Exercise entity = null;
        Boolean key = rs.next();
        while (key) {
            
            entity = new Exercise();
            entity.setId(rs.getLong("exercise_id"));
            entity.setName(rs.getString("exercise_name"));
            entity.setDescription(rs.getString("exercise_description"));
            entity.setInstructions(rs.getString("exercise_instructions"));
            entity.setPhoto(rs.getString("exercise_photo"));
            
            exerciseList.add(entity);

            do {
                BodyPart bodyEntity = new BodyPart();

                bodyEntity.setId(rs.getLong("body_part_id"));
                bodyEntity.setName(rs.getString("body_part_name"));
                bodyEntity.setPhoto(rs.getString("body_part_photo"));

                entity.getBodyPartList().add(bodyEntity);

                key = rs.next();
                
                if(!key) {
                  break;  
                } 
            } while(rs.getLong("exercise_id") == entity.getId());
        }

        rs.close();
        ps.close();
        
        return exerciseList;
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        Long count = null;
        String query = "SELECT count(*) count FROM exercise WHERE 1=1 ";
        query += applyCriteria(criteria);

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        if (rs.next()) {
            count = rs.getLong("count");
        }

        rs.close();
        s.close();

        return count;
    }

    @Override
    public void update(Connection conn, Exercise entity) throws Exception {
        String query = "DELETE FROM exercise WHERE exercise_id = ?;";

        PreparedStatement ps = conn.prepareStatement(query);

        int i = 0;
        ps.setLong(++i, entity.getId());
        
        ps.execute();
        ps.close();
        
        this.create(conn, entity);
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        String query = "DELETE FROM exercise WHERE exercise_id = ?;";

        PreparedStatement ps = conn.prepareStatement(query);

        int i = 0;
        ps.setLong(++i, id);

        ps.execute();
        ps.close();
    }

    @Override
    public String applyCriteria(Map<Long, Object> criteria) throws Exception {
        String query = "";
        
        Long bodyPartValue = (Long) criteria.get(ExerciseCriteria.BODY_PART_ID);
        if(bodyPartValue != null){
            query += " AND body_part_id = " + bodyPartValue;
        }
        
        return query;
    }
}
