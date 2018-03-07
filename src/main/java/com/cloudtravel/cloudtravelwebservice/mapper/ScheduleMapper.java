package com.cloudtravel.cloudtravelwebservice.mapper;

import com.cloudtravel.cloudtravelwebservice.model.Schedule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ScheduleMapper {
    @Delete({
        "delete from schedule",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scheduleId);

    @Insert({
        "insert into schedule (schedule_id, user_id, ",
        "date, priority, ",
        "location_id, location_name, ",
        "remark)",
        "values (#{scheduleId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{date,jdbcType=TIMESTAMP}, #{priority,jdbcType=INTEGER}, ",
        "#{locationId,jdbcType=INTEGER}, #{locationName,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=LONGVARCHAR})"
    })
    int insert(Schedule record);

    int insertSelective(Schedule record);

    @Select({
        "select",
        "schedule_id, user_id, date, priority, location_id, location_name, remark",
        "from schedule",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    Schedule selectByPrimaryKey(Integer scheduleId);

    int updateByPrimaryKeySelective(Schedule record);

    @Update({
        "update schedule",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "priority = #{priority,jdbcType=INTEGER},",
          "location_id = #{locationId,jdbcType=INTEGER},",
          "location_name = #{locationName,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=LONGVARCHAR}",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Schedule record);

    @Update({
        "update schedule",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "priority = #{priority,jdbcType=INTEGER},",
          "location_id = #{locationId,jdbcType=INTEGER},",
          "location_name = #{locationName,jdbcType=VARCHAR}",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Schedule record);
}