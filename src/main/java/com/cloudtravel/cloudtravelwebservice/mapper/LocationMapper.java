package com.cloudtravel.cloudtravelwebservice.mapper;

import com.cloudtravel.cloudtravelwebservice.model.Location;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LocationMapper {
    @Delete({
        "delete from location",
        "where location_id = #{locationId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer locationId);

    @Insert({
        "insert into location (location_id, name, ",
        "address, level, ",
        "open_time, latitude, ",
        "longitude, description)",
        "values (#{locationId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{level,jdbcType=TINYINT}, ",
        "#{openTime,jdbcType=VARCHAR}, #{latitude,jdbcType=DOUBLE}, ",
        "#{longitude,jdbcType=DOUBLE}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(Location record);

    int insertSelective(Location record);

    @Select({
        "select",
        "location_id, name, address, level, open_time, latitude, longitude, description",
        "from location",
        "where location_id = #{locationId,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    Location selectByPrimaryKey(Integer locationId);

    int updateByPrimaryKeySelective(Location record);

    @Update({
        "update location",
        "set name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=TINYINT},",
          "open_time = #{openTime,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=DOUBLE},",
          "longitude = #{longitude,jdbcType=DOUBLE},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where location_id = #{locationId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Location record);

    @Update({
        "update location",
        "set name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=TINYINT},",
          "open_time = #{openTime,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=DOUBLE},",
          "longitude = #{longitude,jdbcType=DOUBLE}",
        "where location_id = #{locationId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Location record);
}