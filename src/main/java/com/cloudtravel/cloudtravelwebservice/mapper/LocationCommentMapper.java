package com.cloudtravel.cloudtravelwebservice.mapper;

import com.cloudtravel.cloudtravelwebservice.model.LocationComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LocationCommentMapper {
    @Delete({
        "delete from location_comment",
        "where location_comment_id = #{locationCommentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer locationCommentId);

    @Insert({
        "insert into location_comment (location_comment_id, user_id, ",
        "star, create_time, ",
        "content, photo)",
        "values (#{locationCommentId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{star,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR}, #{photo,jdbcType=LONGVARCHAR})"
    })
    int insert(LocationComment record);

    int insertSelective(LocationComment record);

    @Select({
        "select",
        "location_comment_id, user_id, star, create_time, content, photo",
        "from location_comment",
        "where location_comment_id = #{locationCommentId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    LocationComment selectByPrimaryKey(Integer locationCommentId);

    int updateByPrimaryKeySelective(LocationComment record);

    @Update({
        "update location_comment",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "star = #{star,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR},",
          "photo = #{photo,jdbcType=LONGVARCHAR}",
        "where location_comment_id = #{locationCommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(LocationComment record);

}