package com.run.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author edxuanlen
 */
@Mapper
public interface BaseMapper {
    /**
     * 插入数据库
     * @param params data
     * @return insert int
     */
    int insert(Map params);

    /**
     * 更新数据库
     * @param params data
     * @return update id
     */
    int update(Map params);

    /**
     * 删除数据
     * @param params data
     * @return delete id
     */
    int delete(Map params);

    /**
     * 查询
     * @param params data
     * @return query HashMap
     */
    HashMap queryById(Map params);
}