package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTemplateDao;
import com.bitcamp.mm.member.dao.MemberSessionDao;
import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

@Service("listService")
public class MemberListService implements MemberService {
	
	// 자동 메퍼를 이용해서 생성할 dao 
	private MemberSessionDao dao;
	
	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;
	
	
	final int MEMBER_CNT_List = 3;
	
	
	
	
	public ListViewData getListData(int currentPageNumber, SearchParam searchParam) {
		dao = template.getMapper(MemberSessionDao.class);
		ListViewData listData = new ListViewData();
		
	
			
			// 현재 페이지 번호
			listData.setCurrentPageNumber(currentPageNumber);
			// 전체 게시물의 개수
			int totalCnt = dao.selectTotalCount(searchParam);
			
			int totalpageCnt = 0;
			// 전체 페이지 개수
			if(totalCnt>0) {
				totalpageCnt = totalCnt/MEMBER_CNT_List;
				if(totalCnt%MEMBER_CNT_List>0) {
					totalpageCnt++;
				}
				
			}
			
			listData.setPageTotalCount(totalpageCnt);
			
			// 구간 검색을 위한 index
			// 1 -> 0 , 2 -> 3, 3 -> 6 , 4 -> 9
			int index = (currentPageNumber-1)*MEMBER_CNT_List;
			// 회원 정보 리스트
			List<MemberInfo> memberList = null;
			
			
			


		//	// 1. 검색 조건이 없는경우 selectList -> 전체 회원의 리스트
		//	if(searchParam == null) {
		//		memberList = dao.selectList(index, MEMBER_CNT_List);
		//		// 2. id 로 검색 : where like uid '%?%'
		//	} else if(searchParam.getStype().equals("both")) {
		//		memberList = dao.selectListByBoth(index, MEMBER_CNT_List, searchParam);
		//		// 3. name 로 검색 : where like uname '%?%'
		//	} else if(searchParam.getStype().equals("id")) {
		//		memberList = dao.selectListById(index, MEMBER_CNT_List, searchParam);
		//		// 4. id 또는 name 로 검색 : where like uid '%?%' or like uname '%?%'
		//	} else if(searchParam.getStype().equals("name")) {
		//		memberList = dao.selectListByName(index, MEMBER_CNT_List, searchParam);
		//	}
			
			

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("search", searchParam);
			params.put("index", index);
			params.put("count", MEMBER_CNT_List);
			
			memberList = dao.selectList(params);
			System.out.println("사이즈 : : : : " + totalCnt);
			System.out.println("리스트 사이즈 : : : : " + memberList.size());
			
			listData.setMemberList(memberList);
			for(MemberInfo m : memberList) {
				System.out.println(m);
			}
			
			// 1 -> 9-0 =9, 2 -> 9-3=6
			int no = totalCnt - index;
			listData.setNo(no);
			
			listData.setTotalCount(totalCnt);
			

		
		return listData;
		
	}
	
	
	public List<MemberInfo> getAllList(){
		
		
		dao = template.getMapper(MemberSessionDao.class);
		
		List<MemberInfo> list = dao.selectAllList();
		
		return list;
		
	}
	
}