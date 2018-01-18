### mybatis 通用mapper的使用

- maven 项目
- 测试通用mapper(增、删、改、查、分页)
- 文档 : https://github.com/opensourceteams/n_20002_mybatis_mapperhelper_crud
- 视频地址 :  https://youtu.be/K9j3q_2orJ4
- 视频地址 :  https://www.youtube.com/watch?v=Wfzynet4RMo
- 自动生成启动类


          com.opensourceteam.mybatis.generate.TestMybatisGenerate.main
- 单元测试mapper(增、删、改、查)

    
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
            String value = "1" ;
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

- 主键uuid
- 分页查询(用专门的分页插件)
# end
