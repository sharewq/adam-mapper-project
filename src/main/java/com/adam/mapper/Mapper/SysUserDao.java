package com.adam.mapper.Mapper;

import com.adam.mapper.bean.SysUser;
import com.adam.mapper.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SysUserDao extends MyMapper<SysUser> {

    @Select("select * from user where id = #{id}")
    List<Map<String, String>> findUserById(@Param("id") String id);

    @Select("select * from user")
    List<SysUser> findUserAll();

//    SysUser findUserByIdXml1(String id);

//    SysUser findUserByIdXml2(String id);
}