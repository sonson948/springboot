package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	@Select("select * from User")
	public List<User> findALL();
	
	@Select("select * from user where id=#{id}")
	User getById(int id);
	
	@Insert("insert into user (username,pass) value(#{username},#{pass})")
	public int insert(User User);
	
	@Update("update user set username=#{username}, pass=#{pass} where id=#{id}")
	void update(User user);
	
	@Delete("delete from user where id=#{id}")
	void delete(int id);
}		
