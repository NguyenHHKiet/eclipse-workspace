/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service;

import com.dht.englishappv2.JdbcUtils;
import com.dht.pojo.Question;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {
    public List<Question> getQuestions(String kw) throws SQLException {
        List<Question> q = new ArrayList<>();
        try (Connection cnn = JdbcUtils.getConn()) {
            CallableStatement stm = cnn.prepareCall("{ CALL getQuestions(?) }");
            stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                q.add(new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id")));
            }
        }
        
        return q;
    }
}
