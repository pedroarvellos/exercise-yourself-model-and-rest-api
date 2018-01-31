package br.com.exsystem.model.dao;

import br.com.exsystem.model.base.BaseDAO;
import br.com.exsystem.model.entity.BodyPart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BodyPartDAO implements BaseDAO<BodyPart> {

    @Override
    public void create(Connection conn, BodyPart entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BodyPart readById(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BodyPart> readByCriteria(Connection conn, Map<Long, Object> criteria, Long limit, Long offset) throws Exception {
        String query = "SELECT * FROM body_part WHERE 1=1 ";

        query += this.applyCriteria(criteria);

        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        List<BodyPart> bodyPartList = new ArrayList<>();
        BodyPart bodyPart = null;
        while (rs.next()) {

            bodyPart = new BodyPart();
            bodyPart.setId(rs.getLong("body_part_id"));
            bodyPart.setName(rs.getString("body_part_name"));
            bodyPart.setPhoto(rs.getString("body_part_photo"));

            bodyPartList.add(bodyPart);
        }

        rs.close();
        ps.close();

        return bodyPartList;
    }

    @Override
    public Long countByCriteria(Connection conn, Map<Long, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Connection conn, BodyPart entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection conn, Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String applyCriteria(Map<Long, Object> criteria) throws Exception {
        return "";
    }
}
