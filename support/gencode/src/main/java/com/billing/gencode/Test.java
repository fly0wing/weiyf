package com.billing.gencode;

import cn.org.rapid_framework.generator.GeneratorControl;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.util.GLogger;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhangkai on 2014/8/23.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Properties prop = new Properties();
            InputStream in = Test.class.getResourceAsStream("/generator.properties");
            prop.load(in);

            GLogger.logLevel = GLogger.TRACE;
            GeneratorFacade generatorFacade = new GeneratorFacade();
            generatorFacade.getGenerator().setTemplateRootDirs(StringUtils.split(prop.getProperty("templateRootDirs"), ","));

            String generateAllTableStr = prop.getProperty("generateAllTables");
            boolean generateAllTable = BooleanUtils.toBoolean(generateAllTableStr);
            if (generateAllTable) {
                generatorFacade.generateByAllTable();
            } else {
                generatorFacade.generateByTable(StringUtils.split(prop.getProperty("generateTables"), ","));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
