package com.cloudtravel.cloudtravelwebservice.mapper;

import com.cloudtravel.cloudtravelwebservice.model.MomentComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MomentCommentMapper {
    @Delete({
        "delete from moment_comment",
        "where moment_comment_id = #{momentCommentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer momentCommentId);

    @Insert({
        "insert into moment_comment (moment_comment_id, moment_id, ",
        "commenter_id, create_time, ",
        "content)",
        "values (#{momentCommentId,jdbcType=INTEGER}, #{momentId,jdbcType=INTEGER}, ",
        "#{commenterId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(MomentComment record);

    int insertSelective(MomentComment record);

    @Select({
        "select",
        "moment_comment_id, moment_id, commenter_id, create_time, content",
        "from moment_comment",
        "where moment_comment_id = #{momentCommentId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    MomentComment selectByPrimaryKey(Integer momentCommentId);

    int updateByPrimaryKeySelective(MomentComment record);

    @Update({
        "update moment_comment",
        "set moment_id = #{momentId,jdbcType=INTEGER},",
          "commenter_id = #{commenterId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where moment_comment_id = #{momentCommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(MomentComment record);

    @Update({
        "update moment_comment",
        "set moment_id = #{momentId,jdbcType=INTEGER},",
          "commenter_id = #{commenterId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where moment_comment_id = #{momentCommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MomentComment record);
}