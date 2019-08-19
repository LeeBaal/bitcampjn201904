package com.bitcamp.mm.member.dao;

import java.util.List;
import java.util.Map;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

public interface MemberSessionDao {
	// 회원 가입
	public int insertMember(MemberInfo memberInfo);
	
	public MemberInfo selectMemberById(String userId);
	public MemberInfo selectMemberById2(String userId);
	public MemberInfo selectMemberByIdx(int id);
	public int memberUpdate(MemberInfo memberInfo);
	public int memberDelete(int id);
	
	
	// 이전 dao에서는 검색 처리를 위한 여러개의 메서드가 필요.	
	// 게시물의 개수 : 동적 쿼리로 검색의 결과 까지 처리
	public int selectTotalCount(SearchParam searchParam);
	// 게시물의 LIST :  동적 쿼리로 검색의 결과 까지 처리
	//public List<MemberInfo> selectList(int index, int count);
	public List<MemberInfo> selectList(Map<String, Object> params);

	// 회원의 전체 리스트
	public List<MemberInfo> selectAllList();
	
	
	
	
	
}
