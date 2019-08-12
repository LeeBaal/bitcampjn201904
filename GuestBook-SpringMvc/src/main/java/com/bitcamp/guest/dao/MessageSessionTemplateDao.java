package com.bitcamp.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.JdbcUtil;

@Repository("sessionTemplateDao")
public class MessageSessionTemplateDao{ // 이름 안정하면 : messageDao 
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String nameSpace = "com.bitcamp.guest.mapper.mybatis.guestMapper";
	
	public int insert(Message message) {
		
		return template.update(nameSpace+".insertMessage",message);
	}
	
	
	public int selectCount() {
		  
		  return template.selectOne(nameSpace+".selectCount");
	}
		  
	
	 public List<Message> selectList(Map<String, Object>params){
		  
		 return template.selectList(nameSpace+".selectList", params);
		 
		 }
	
	 
	 public Message select(int messageId) {
	  
		 return template.selectOne(nameSpace+".select", messageId);
		 
	 }
	 
	
	 public int deleteMessage(int messageId){
		 
		 return template.update(nameSpace+".deleteMessage", messageId);
		 
		 }
	
	
	
	
	
	
	
}