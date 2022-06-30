package com.coding.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.coding.entity.BlogUser;

public interface UserMapper {
	@Select("select * from blog_user")
	public List<BlogUser> findAllUser();
	
	@Select("select * from blog_user where id = #{id}")
	public BlogUser findIdUser(int id);
	
	@Insert("insert into blog_user (name, email) values (#{name}, #{email})")
	public int insertUser(BlogUser arg);
	
	@Update("update blog_user set name=#{name}, email=#{email} where id=#{id}")
	public int updateUser(BlogUser arg);
	
	@Delete("delete from blog_user where id=#{id}")
	public int deleteUser(int id);
}
