package com.run.service;


import java.util.HashMap;

/**
 * @author edxuanlen
 */
public interface BaseServiceClient  {

    /**
     * @param object insert obj
     * @return insert id
     */
    public int insert(Object object);

    /**
     * @param id query id
     * @return query result map
     */
    public HashMap queryById(long id);

    /**
     * @param object upadate obj
     * @return update id
     */
    public int update(Object object);

    /**
     * @param object delete obj
     * @return delete id
     */
    public int delete(Object object);
}
