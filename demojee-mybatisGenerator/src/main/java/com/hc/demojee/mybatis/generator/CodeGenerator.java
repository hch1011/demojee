package com.hc.demojee.mybatis.generator;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 代码生成类
 * 
 * @author 黄诚<cheng.huang@linkedcare.cn>
 *
 * 2017年9月7日 下午9:11:59
 *
 */
public class CodeGenerator {
    // 属性文件和配置文件
    private String DefaultPropertyFileName = "com/hc/demojee/mybatis/generator/generatorConfig.properties";
    private String DefaultConfigFileName = "com/hc/demojee/mybatis/generator/generatorConfig.xml";
    
    private ClassLoader classloader;
    private Properties properties;
    private List<String> warnings;
    private boolean overwriteJavaClass = true;
    
    private int count = 0;
    private List<String> tables = new ArrayList<String>();
   
    public static CodeGenerator buildGenerator() throws Exception{
        return new CodeGenerator(null,null);
    }
    
    public static CodeGenerator buildGenerator(String propertyFile, String configFileName) throws Exception{
        return new CodeGenerator(propertyFile,configFileName);
    }
    
    /**
     * 
     * @param propertyFile
     * @param configFileName
     * @throws Exception
     */
    public CodeGenerator(String propertyFile, String configFileName)  throws Exception{
        if (propertyFile != null) {
            DefaultPropertyFileName = propertyFile;
        }
        if (configFileName != null) {
            DefaultConfigFileName = configFileName;
        }
        classloader = Thread.currentThread().getContextClassLoader();
        properties = PropertiesLoaderUtils.loadAllProperties(DefaultPropertyFileName, classloader);
        warnings = new ArrayList<String>();
    }
    
    /**
     * 生成代码
     */
    public CodeGenerator gen() throws Exception {
        count++;
        checkNotNull(properties.getProperty("tableName"), "表名不能空");
        checkNotNull(properties.getProperty("table.primaryKey"), "主键名不能空");
        checkNotNull(properties.getProperty("domainObjectName"), "实体类名不能空");
        checkNotNull(properties.getProperty("mapperName"), "Mapper接口名不能空");

        InputStream configInput = classloader.getResourceAsStream(DefaultConfigFileName);
        ConfigurationParser configurationParser = new ConfigurationParser(properties, warnings);
        Configuration config = configurationParser.parseConfiguration(configInput);

        DefaultShellCallback callback = new DefaultShellCallback(overwriteJavaClass);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        
        tables.add(properties.getProperty("tableName"));
        System.out.println("------------------");
        System.out.println("表名：\t"+properties.getProperty("tableName"));
        System.out.print("生成文件：");
        if(overwriteJavaClass){
            System.out.println("\t"+properties.getProperty("model.package") + "." +properties.getProperty("domainObjectName"));
            System.out.println("\t"+properties.getProperty("mapper.package") + "." + properties.getProperty("mapperName"));
        }
        System.out.println("\t"+properties.getProperty("mapper.xml.package") + "." + properties.getProperty("mapperName")+".xml");

        properties.remove("tableName");
        properties.remove("domainObjectName");
        properties.remove("mapperName");
        return this;
    }
    
    public CodeGenerator report() throws Exception {
        System.out.println("------------------");
        System.out.println("总共处理了"+count+"张表：");
        for (String item : tables) {
            System.out.println("\t"+item);
        }
        return this;
    }
    /**
     * 当domain或Mapper存在时，是否覆盖已有的java文件
     * 
     * @param overwrite  true:直接覆盖源文件；false:生成带序号的新文件
     * 
     * @return
     */
    public CodeGenerator setOverwriteJavaClass(boolean overwrite){
        overwriteJavaClass = overwrite;
        return this;
    }
    /**
     * 设置表名和主键名
     * @param tableName
     * @return
     */
    public CodeGenerator setNameForTable(String tableName, String primaryKey){
        if(tableName != null){
            properties.put("tableName",         tableName);
        }
        if(primaryKey != null){
            properties.put("table.primaryKey",  primaryKey);
        }
        return this;
    }
    /**
     * 指定Model实体名和对应的接口名；可以附带包名，两个放在一起是为了防止遗漏
     * @param javaModelName
     * @param javaMapperName
     * @return
     */
    public CodeGenerator setNameForJavaClass(String javaModelName, String javaMapperName){
        //javaModelName
        int lastIndex = javaModelName.lastIndexOf(".");
        if(lastIndex > 0){
            properties.put("model.package",     javaModelName.substring(0,lastIndex));
            properties.put("domainObjectName",  javaModelName.substring(lastIndex+1));
        }else{
            properties.put("domainObjectName",  javaModelName);
        }
        //javaMapperName
        lastIndex = javaMapperName.lastIndexOf(".");
        if(lastIndex > 0){
            properties.put("mapper.package",     javaMapperName.substring(0,lastIndex));
            properties.put("mapperName",  javaMapperName.substring(lastIndex+1));
        }else{
            properties.put("mapperName",  javaMapperName);
            
        }
        return this;
    }

    /**
     * 指定Mapper接口名.可以附带包名
     * 
     * @param javaMapperName
     * @return
     */
    public CodeGenerator setNameForJavaMapper(String javaMapperName){
        int lastIndex = javaMapperName.lastIndexOf(".");
        if(lastIndex > 0){
            properties.put("mapper.package",     javaMapperName.substring(0,lastIndex-1));
            properties.put("mapperName",  javaMapperName.substring(lastIndex));
        }else{
            properties.put("mapperName",  javaMapperName);
            
        }
        return this;
    }
    /**
     * 设置生成的Model.java包名，如：cn.linkedcare.libra.entity
     * 也可以在设置javaDomainName时一起指定
     * @param modelPackage
     * @return
     */
    public CodeGenerator setPackageForJavaModel(String javaModelPackage){
        properties.put("model.package",  javaModelPackage);
        return this;
    }
    /**
     * 设置生成的Mapper.java或Dao.java包名，如：cn.linkedcare.libra.mapper
     * 也可以在设置JavaMapperName时一起指定
     * @param mapperPackage
     * @return
     */
    public CodeGenerator setPackageForJavaMapper(String javaMapperPackage){
        properties.put("mapper.package",  javaMapperPackage);
        return this;
    }
    /**
     * 设置生成的XML文件包名， 默认mappers
     * @param mapperXmlPackage 
     * @return
     */
    public CodeGenerator setPackageForXmlMapper(String mapperXmlPackage){
        properties.put("mapper.xml.package",  mapperXmlPackage);
        return this;
    }

    /**
     * 设置源码生成路径
     * 
     * @param javaBasePath      默认：src/test/java
     * @return
     */
    public CodeGenerator setBasePathForJava(String javaBasePath){
        properties.put("java.basePath", "src/main/java");
        return this;
    }
    /**
     * 设置源码生成路径
     * 
     * @param xmlBasePath       默认：src/test/resources
     * @return
     */
    public CodeGenerator setBasePathForXml(String xmlBasePath){
        properties.put("xml.basePath",  "src/main/resources");
        return this;
    }
    
    public void checkNotNull(String obj, String msg) throws Exception{
        if(obj == null || obj.trim().length() == 0){
            throw new Exception(msg);
        }
    }
}
