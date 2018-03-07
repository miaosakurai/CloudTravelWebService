package com.cloudtravel.cloudtravelwebservice.mapper;

import com.cloudtravel.cloudtravelwebservice.model.Moment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MomentMapper {
    @Delete({
        "delete from moment",
        "where moment_id = #{momentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer momentId);

    @Insert({
        "insert into moment (moment_id, user_id, ",
        "create_time, status, ",
        "content, photo)",
        "values (#{momentId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR}, #{photo,jdbcType=LONGVARCHAR})"
    })
    int insert(Moment record);

    int insertSelective(Moment record);

    @Select({
        "select",
        "moment_id, user_id, create_time, status, content, photo",
        "from moment",
        "where moment_id = #{momentId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Moment selectByPrimaryKey(Integer momentId);

    int updateByPrimaryKeySelective(Moment record);

    @Update({
        "update moment",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR},",
          "photo = #{photo,jdbcType=LONGVARCHAR}",
        "where moment_id = #{momentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Moment record);

}