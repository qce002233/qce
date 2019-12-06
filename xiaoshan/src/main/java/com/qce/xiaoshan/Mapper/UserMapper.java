package com.qce.xiaoshan.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import com.qce.xiaoshan.Root;
import com.qce.xiaoshan.User;
@Mapper
public interface UserMapper {
	// 查询
	@Select("select * from student where name = #{name}")
	List<User> findByName(@Param("name") String name);
	
	@Select("select * from student where id = #{id}")
	User findByid(@Param("id") Integer id);

	// 添加
	@Insert("insert into student(ID,NAME,AGE) values(#{id},#{name},#{age})")
	int insert(@Param("id") Integer id,@Param("name") String name, @Param("age") Integer age);
    //刷新
	@Select("select * from student")
	List<User> flash();
	
	@Insert("insert into root(ACCOUNTNUMBER,PASSWORD) values(#{accountnumber},#{password})")
	int insertroot(@Param("accountnumber") String accountnumber,@Param("password") String password); 
	@Select("select*from root")
	List<Root>rootmap();
    
}