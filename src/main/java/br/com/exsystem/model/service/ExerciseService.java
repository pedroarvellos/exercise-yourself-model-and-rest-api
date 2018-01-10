package br.com.exsystem.model.service;

import br.com.exsystem.model.ConnectionManager;
import br.com.exsystem.model.base.service.BaseExerciseService;
import br.com.exsystem.model.dao.ExerciseDAO;
import br.com.exsystem.model.entity.BodyPart;
import br.com.exsystem.model.entity.Exercise;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ExerciseService implements BaseExerciseService{

    ExerciseDAO dao = new ExerciseDAO();
    
    @Override
    public void create(Exercise entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            dao.create(conn, entity);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Exercise readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Exercise entity = null;
        try {
            entity = dao.readById(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.close();
        }
        return entity;
    }

    @Override
    public List<Exercise> readByCriteria(Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Exercise> entityList = null;
        try {
            entityList = dao.readByCriteria(conn, criteria, limit, offset);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.close();
        }
        return entityList;
    }

    @Override
    public Exercise update(Exercise entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            dao.update(conn, entity);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return entity;
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            dao.delete(conn, id);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Long countByCriteria(Map<Long, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Long count = null;
        try {
            count = dao.countByCriteria(conn, criteria);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        return count;
    }

    @Override
    public Map<String, String> validate(Map<String, Object> fields) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
