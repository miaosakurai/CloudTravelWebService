package com.cloudtravel.cloudtravelwebservice.mapper;

import com.cloudtravel.cloudtravelwebservice.model.SearchHistory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SearchHistoryMapper {
    @Delete({
        "delete from search_history",
        "where search_history_id = #{searchHistoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer searchHistoryId);

    @Insert({
        "insert into search_history (search_history_id, user_id, ",
        "content, create_time)",
        "values (#{searchHistoryId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    @Select({
        "select",
        "search_history_id, user_id, content, create_time",
        "from search_history",
        "where search_history_id = #{searchHistoryId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    SearchHistory selectByPrimaryKey(Integer searchHistoryId);

    int updateByPrimaryKeySelective(SearchHistory record);

    @Update({
        "update search_history",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where search_history_id = #{searchHistoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SearchHistory record);
}