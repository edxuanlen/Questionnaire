//package com.run.serviceimpl;
//
//
//import com.run.mapper.BaseMapper;
//import com.run.service.BaseServiceClient;
//import com.run.annotation.Column;
//import com.run.annotation.Id;
//import com.run.annotation.Table;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author edxuanlen
// */
//@Service(value = "baseServie")
//public class BaseServiceClientImpl implements BaseServiceClient {
//    private static final Logger log = LoggerFactory.getLogger(BaseServiceClientImpl.class);
//
//    @Autowired
//    private BaseMapper baseMapper;
//
//    private Map<String, Object> transformObj(Object t) {
//        //获取表名
//        if (null == t.getClass().getAnnotation(Table.class)) {
//            throw new RuntimeException("Error Input Object! Error @Table Annotation.");
//        }
//        Map<String, Object> re = new HashMap<String, Object>();
//        re.put("TABLE_NAME", t.getClass().getAnnotation(Table.class).value());
//
//        Method[] m = t.getClass().getMethods();
//        if (null == m || m.length <= 0) {
//            throw new RuntimeException("Error Input Object! No Method.");
//        }
//
//        List k = new ArrayList();//存放列名
//        List v = new ArrayList();//存放列值
//        for (Method i : m) {
//            //获取列名和值
//            try {
//                if (null != i.getAnnotation(Column.class)) {
//                    k.add(i.getAnnotation(Column.class).value());
//                    v.add(i.invoke(t, null));
//                    continue;
//                }
//                //获取主键
//                if (null != i.getAnnotation(Id.class)) {
//                    re.put("KEY_ID", i.getAnnotation(Id.class).value());
//                    re.put("KEY_VALUE", i.invoke(t, null));
//                }
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
//            } catch (InvocationTargetException e) {
//                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
//            }
//        }
//        re.put("COLUMNS", k);
//        re.put("VALUES", v);
//        if (k.size() != v.size()) {
//            throw new RuntimeException("Error Input Object! Internal Error.");
//        }
//        return re;
//    }
//
//    @Override
//    public int insert(Object obj) {
//        Map<String, Object> params = transformObj(obj);
//        log.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
//        return baseMapper.insert(params);
//    }
//
//    @Override
//    public HashMap queryById(long id) {
//        return null;
//    }
//
//    @Override
//    public int update(Object object) {
//        return 0;
//    }
//
//    @Override
//    public int delete(Object object) {
//        return 0;
//    }
//}