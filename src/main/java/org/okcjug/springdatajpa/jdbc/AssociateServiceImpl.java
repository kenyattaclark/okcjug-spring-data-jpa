package org.okcjug.springdatajpa.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.okcjug.springdatajpa.common.AssociateService;
import org.okcjug.springdatajpa.domain.Associate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AssociateServiceImpl extends JdbcDaoSupport implements AssociateService {

    @Override
    public Associate findById(final Long id) {
        final String sql = "select id, first_name, last_name from Associate where id = ?";
        final Connection connection = getConnection();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Associate associate = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            // Make a decision. Get first or get last? Return null or empty?
            if (resultSet.next()) {
                associate = new Associate();
                associate.setId(resultSet.getLong("id"));
                associate.setFirstName(resultSet.getString("first_name"));
                associate.setLastName(resultSet.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // Unrecoverable!!!
            }
        }

        return associate;
    }

    @Override
    public Associate save(final Associate associate) {
        final String insertSql = "insert into Associate(first_name, last_name) values (?, ?)";
        final String updateSql = "update Associate set first_name = ?, last_name = ? where id = ?";
        Connection connection = getConnection();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try {
            if (associate.getId() != null) {
                statement = connection.prepareStatement(updateSql);
                statement.setString(1, associate.getFirstName());
                statement.setString(2, associate.getLastName());
                statement.setLong(3, associate.getId());
            } else {
                statement = connection.prepareStatement(insertSql);
                statement.setString(1, associate.getFirstName());
                statement.setString(2, associate.getLastName());
            }

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // Unrecoverable!!!
            }
        }

        return associate;
    }

    @Override
    public List<Associate> findAll() {
        final String sql = "select id, first_name, last_name from Associate";
        Connection connection = getConnection();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        List<Associate> associates = new ArrayList<Associate>();

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Associate associate = new Associate();
                associate.setId(resultSet.getLong("id"));
                associate.setFirstName(resultSet.getString("first_name"));
                associate.setLastName(resultSet.getString("last_name"));
                associates.add(associate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // Unrecoverable!!!
            }
        }

        return associates;
    }

    @Override
    public List<Associate> findAll(int page, int pageSize) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Associate> findByLastName(String lastName, int page, int pageSize) {
        // TODO Auto-generated method stub
        return null;
    }
}