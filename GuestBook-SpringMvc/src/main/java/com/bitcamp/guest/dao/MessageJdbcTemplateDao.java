package com.bitcamp.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.JdbcUtil;

@Repository("jdbcTemplateDao")
public class MessageJdbcTemplateDao { // 이름 안정하면 : messageDao 
	
	@Autowired
	JdbcTemplate template;
	
	
	public int insert (Message message) {
		
		String sql = "INSERT INTO GUESTBOOK_MESSAGE "
				+ " (MESSAGE_ID, GUEST_NAME, PASSWORD, MESSAGE) "
				+ " values (GM_MID_SEQ.nextval,?,?,?)";
		
		return template.update(sql,
				message.getGuestName(),
				message.getPassword(),
				message.getMessage()
				);
		
		
	}
	
	
	public Message select(int messageId) {
		
		String sql = "select * from guestbook_message where message_id=?";
		
		return template.queryForObject(sql, new MessageRowMapper(), messageId);
	}

	
	

	
	public int selectCount() {
		
		return template.queryForObject(
				"select count(*) from guestbook_message", 
				Integer.class);
	}
	
	public List<Message> selectList(int firstRow, int endRow){
		
		String sql = "select message_id, guest_name, password, message from ( "
				+ " select rownum rnum, message_id, guest_name, password, message from ( "
				+ " select * from guestbook_message m order by m.message_id desc "
				+ " ) where rownum <= ? " 
				+ " ) where rnum >= ?";
		
		return template.query(
				sql,
				new MessageRowMapper(),
				endRow,
				firstRow
				);
		
	}
		
	

	
	
	
	public int deleteMessage(int messageId) throws SQLException {
		
		
		String sql = "delete from guestbook_message where message_id=?";
		
		return template.update(sql, messageId);
		
	}
	
	
	
	
	
	
	
	
	
	
}