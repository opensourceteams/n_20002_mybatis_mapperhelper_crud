package com.opensourceteam.mybatis.generate;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import sun.nio.cs.Surrogate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发人:刘文
 * 日期:  2018/1/17.
 * 功能描述: 测试mybatis 自动生成
 */
public class TestMybatisGenerate {

    public static void main(String[] args) throws InterruptedException, SQLException, IOException, InvalidConfigurationException, XMLParserException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                Surrogate.Generator.class.getResourceAsStream("/generator/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("mybatis 自动生成完成");
    }
}
