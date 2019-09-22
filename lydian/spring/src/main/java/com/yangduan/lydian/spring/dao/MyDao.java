package com.yangduan.lydian.spring.dao;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Repository
public class MyDao {

    public MyDao() {
    }

    private Function<ResultSet, Map<String, Object>> mapper = resultSet -> {
        try {
            if (resultSet.next()) {
                Map<String, Object> result = new HashMap<>();
                ResultSetMetaData metaData = resultSet.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i ++) {
                    result.put(metaData.getColumnName(i), resultSet.getObject(i));
                }
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://172.20.4.165:3306/yunlu_admin", "htyunlu", "123456789");
    }

    public Map<String, Object> getNewsById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from news where newsid = ?");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            return mapper.apply(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(resultSet).close();
                Objects.requireNonNull(statement).close();
                Objects.requireNonNull(connection).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
