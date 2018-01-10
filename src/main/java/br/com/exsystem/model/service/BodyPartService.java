package br.com.exsystem.model.service;

import br.com.exsystem.model.ConnectionManager;
import br.com.exsystem.model.base.service.BaseBodyPartService;
import br.com.exsystem.model.dao.BodyPartDAO;
import br.com.exsystem.model.entity.BodyPart;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class BodyPartService implements BaseBodyPartService {

    BodyPartDAO dao = new BodyPartDAO();

    @Override
    public void create(BodyPart entity) throws Exception {
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
    public BodyPart readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        BodyPart entity = null;
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
    public List<BodyPart> readByCriteria(Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<BodyPart> entityList = null;
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
    public BodyPart update(BodyPart entity) throws Exception {
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
