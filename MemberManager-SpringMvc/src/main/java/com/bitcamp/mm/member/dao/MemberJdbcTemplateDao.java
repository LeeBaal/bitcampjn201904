package com.bitcamp.mm.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.mm.jdbc.JdbcUtil;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

@Repository("TemplateDao")
public class MemberJdbcTemplateDao {

	@Autowired
	JdbcTemplate template;
	
	public MemberInfo selectMemberById(String uId) {
		
		String sql = "select * from member1 where uid=?";
		List<MemberInfo> list = template.query(sql,
				new Object[] {uId}, 
				new MemberInfoRowMapper());
		
		
		
		return list.isEmpty()?null:list.get(0);
		
	}

	public MemberInfo selectMemberById2(String uId) {

		String sql = "select * from member1 where uid=?";
		
		MemberInfo memberInfo = null;
		try {
		memberInfo =template.queryForObject(sql, new Object[] { uId }, new MemberInfoRowMapper());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberInfo;

	}
	
	
	public int insertMember(MemberInfo memberInfo) {
		
		String sql = "insert into member1 (uId, uName, uPw, uPhoto) values (?,?,?,?) ";
		
		return template.update(
				sql, 
				memberInfo.getuId(),
				memberInfo.getuName(),
				memberInfo.getuPw(),
				memberInfo.getuPhoto());
		
	}
	
	public List<MemberInfo> selectList(int index, int count) {
		String sql = "select * from member1 limit ?, ?";
		
		return template.query(sql, new MemberInfoRowMapper(),index, count);
		
	}
	
	public int selectTotalCount(SearchParam searchParam) {
		
		String sql = "select count(*) from member1";

		if (searchParam != null) {
			sql = "select count(*) from member1 where ";
			if (searchParam.getStype().equals("both")) {
				sql += " uid like \'%" + searchParam.getKeyword() + "%\' or uname  like \'%" + searchParam.getKeyword()	+ "%\' ";
			}
			if (searchParam.getStype().equals("id")) {
				sql += " uid  like \'%" + searchParam.getKeyword() + "%\' ";
			}
			if (searchParam.getStype().equals("name")) {
				sql += " uname  like \'%" + searchParam.getKeyword() + "%\' ";
			}
			
		}
		return template.queryForObject(sql, Integer.class);
		
	}
	
	
	public List<MemberInfo> selectListByBoth(int index, int count, SearchParam searchParam) {
		String sql = "select * from member1 where uid like ? or uname like ? limit ?,?";
		
		return template.query(sql, 
				new MemberInfoRowMapper(),
				"%" + searchParam.getKeyword() + "%",
				"%" + searchParam.getKeyword() + "%",
				index,
				count);
				
	}
	
	public List<MemberInfo> selectListById(int index, int count, SearchParam searchParam) {
		
		String sql = "select * from member1 where uid like ? limit ?,?";
		
		return template.query(sql, 
				new MemberInfoRowMapper(),
				"%"+searchParam.getKeyword()+"%",
				index,
				count
				);
		
	}
	
	public List<MemberInfo> selectListByName(int index, int count, SearchParam searchParam) {
		String sql = "select * from member1 where uname like ? limit ?,?";
		
		return template.query(sql,
				new MemberInfoRowMapper(),
				"%" + searchParam.getKeyword() + "%",
				index,
				count);
		
	}
	
	
	public MemberInfo selectMemberByIdx(int id) {
		
		String sql = "select * from member1 where idx=?";
		MemberInfo memberInfo = null;
		
		try {
			
		
		memberInfo = template.queryForObject(sql, 
				new MemberInfoRowMapper(), id);
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return memberInfo;
	}
	
	public int memberUpdate(MemberInfo memberInfo) {
		
		String sql = "update member1 set uname=?, upw=?, uphoto=? where idx=?";
		
		return template.update(sql,
				memberInfo.getuName(),
				memberInfo.getuPw(),
				memberInfo.getuPhoto(),
				memberInfo.getIdx());
	}
	
	public int memberDelete(int id) {
		
		String sql = "delete from member1 where idx=?";
		
		return template.update(sql,
				id
				);
		
	}
	
	
	
	
	
}
