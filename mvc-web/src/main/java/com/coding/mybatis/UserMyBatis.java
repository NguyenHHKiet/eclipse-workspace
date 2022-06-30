package com.coding.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.coding.entity.BlogUser;

@Mapper
public interface UserMyBatis {

	@Select("select * from blog_user")
	public List<BlogUser> findAll();
	
	@Select("select * from blog_user where id = #{id}")
	public BlogUser findId(int id);
	
	@Insert("insert into blog_user (name, email) values (#{name}, #{email})")
	public int insert(BlogUser arg);
	
	@Update("update blog_user set name=#{name}, email=#{email} where id=#{id}")
	public int update(BlogUser arg);
	
	@Delete("delete from blog_user where id=#{id}")
	public int delete(int id);
}
