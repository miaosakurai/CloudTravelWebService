package com.cloudtravel.cloudtravelwebservice.mapper;

import com.cloudtravel.cloudtravelwebservice.model.Friend;
import com.cloudtravel.cloudtravelwebservice.model.FriendKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FriendMapper {
    @Delete({
        "delete from friend",
        "where from_user_id = #{fromUserId,jdbcType=INTEGER}",
          "and to_user_id = #{toUserId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(FriendKey key);

    @Insert({
        "insert into friend (from_user_id, to_user_id, ",
        "status)",
        "values (#{fromUserId,jdbcType=INTEGER}, #{toUserId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(Friend record);

    int insertSelective(Friend record);

    @Select({
        "select",
        "from_user_id, to_user_id, status",
        "from friend",
        "where from_user_id = #{fromUserId,jdbcType=INTEGER}",
          "and to_user_id = #{toUserId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Friend selectByPrimaryKey(FriendKey key);

    int updateByPrimaryKeySelective(Friend record);

    @Update({
        "update friend",
        "set status = #{status,jdbcType=INTEGER}",
        "where from_user_id = #{fromUserId,jdbcType=INTEGER}",
          "and to_user_id = #{toUserId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Friend record);
}