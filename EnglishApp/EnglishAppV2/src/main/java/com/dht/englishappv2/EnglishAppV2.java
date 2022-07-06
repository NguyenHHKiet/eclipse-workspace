/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dht.englishappv2;


import com.dht.pojo.Choice;
import com.dht.pojo.Question;
import com.dht.service.ChoiceService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author admin
 */
public class EnglishAppV2 {

    public static void main(String[] args) throws SQLException {
        JdbcTemplate t = JdbcTemplateUtils.getT();
        List<Question> questions = t.query("SELECT * FROM question WHERE content like concat('%', ?, '%')", (rs, rowNum) -> {
            Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
            
            return q;
        }, "is");
        
        Scanner s = new Scanner(System.in);
        
        ChoiceService cs = new ChoiceService();
        questions.forEach(q -> {
            System.out.println(q.getContent());
            List<Choice> choices = cs.getChoices(q.getId());
            
            int count = 1;
            for (Choice c: choices)
                System.out.printf("%d. %s\n", count++, c.getContent());
            
            System.out.print("Phuong an cua ban: ");
            int chon = s.nextInt();
            
            if (choices.get(chon-1).isCorrect() == true)
                System.out.println("CHINH XAC!!!");
            else
                System.out.println("SAI ROI!!!");
        });
    }
}
