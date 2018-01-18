package com.opensourceteam.mybatis.crud;

import com.opensourceteam.modules.business.test.dao.TTestMapper;
import com.opensourceteam.modules.business.test.po.TTest;
import com.opensourceteam.modules.common.mybatis.mapper.MybatisHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 开发人:刘文
 * 日期:  2018/1/17.
 * 功能描述:
 */
public class TestCRUDMybatis {

    Logger logger = LoggerFactory.getLogger(TestCRUDMybatis.class) ;
    SqlSession session = null;
    TTestMapper tTestMapper = null;
    @Before
    public void before(){
         session = MybatisHelper.getSqlSession();
         tTestMapper = session.getMapper(TTestMapper.class);

    }
    @After
    public void after(){
        session.commit();
        session.close();
    }

    /**
     * 插入一条数据
     */
    @Test
    public void insert(){
        TTest test = new TTest();
        String value = "10" ;
        test.setName("test_" + value);
        test.setRemark("中文remark_" + value);
        tTestMapper.insert(test);
    }

    /**
     * 更新一条数据(根据主键更新)
     */
    @Test
    public void update(){
        TTest test = new TTest();
        String value = "2" ;
        test.setId(2);
        test.setName("test_" + value);
        test.setRemark("中文remark_" + value);
        tTestMapper.updateByPrimaryKey(test);
    }

    /**
     * 删除一条数据(根据主键)
     */
    @Test
    public void deleteByPrimaryKey(){
        tTestMapper.deleteByPrimaryKey(3);
    }

    /**
     * 删除一条数据(根据对象的主键值值)
     */
    @Test
    public void delete(){
        TTest test = new TTest();
        test.setId(4);
        tTestMapper.delete(test);
    }

    @Test
    public void selectAll(){
        List<TTest> list = tTestMapper.selectAll();
        for(TTest po : list){
            logger.debug("po:{}",po);
        }
    }
}
