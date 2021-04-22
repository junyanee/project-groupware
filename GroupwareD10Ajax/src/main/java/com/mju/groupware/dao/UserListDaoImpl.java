package com.mju.groupware.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mju.groupware.dto.UserList;

@Service
@Repository
public class UserListDaoImpl implements UserListDao {

	@Autowired
	private SqlSession sqlSession;

	// userList를 호출하기 위한 dao
	@Override
	public List<UserList> list() throws Exception {
		List<UserList> output = this.sqlSession.selectList("GetUserList");
		return output;
	}

	// 휴먼계정 List 호출
	@Override
	public List<UserList> DormantList() {
		List<UserList> output = this.sqlSession.selectList("SelectDormantList");
		return output;
	}

	// 탈퇴계정 List 호출
	@Override
	public List<UserList> WithdrawalList() {
		List<UserList> output = this.sqlSession.selectList("SelectWithdrawalList");
		return output;
	}
}
