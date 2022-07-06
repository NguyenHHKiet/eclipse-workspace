/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service;

import com.dht.englishappv2.JdbcTemplateUtils;
import com.dht.pojo.Choice;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author admin
 */
public class ChoiceService {
    public List<Choice> getChoices(String questionId) {
        JdbcTemplate t = JdbcTemplateUtils.getT();
        return t.query("select * from choice where question_id=?", (rs, num) -> {
            Choice c = new Choice(rs.getString("id"), rs.getString("content"), rs.getBoolean("is_correct"), rs.getString("question_id"));
            return c;
        }, questionId);
    }
}
