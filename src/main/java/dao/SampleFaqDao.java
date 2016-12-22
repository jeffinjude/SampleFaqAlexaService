package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.Dbconnector;

public class SampleFaqDao {
	Connection conn = null;
	PreparedStatement sqlStmt = null;
	
	
	public String getFaqAnswer(String questionIntent)
	{
		String faqAnswer = "";
        try{
            Connection connection = Dbconnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT question_id, question_intent, question, answer FROM faq_answers where question_intent = ?");
            statement.setString(1, questionIntent);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
	            if (resultSet.getString("answer").equals("") || resultSet.getString("answer").equals(null)){
	            	faqAnswer =  "Couldn't find the answer";
	            }
	            else {
	            	faqAnswer =  resultSet.getString("answer");
	            }
            }
        }
        catch(Exception e)
        {
        	faqAnswer = "Couldn't fetch the answer from database";
        	e.printStackTrace();
        }
        
        return faqAnswer;
	}
	
	
}
