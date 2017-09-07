package com.hc.demojee.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 
 * 修改默认注释
 * 参考：http://www.cnblogs.com/mengzw/p/6655001.html
 * @author 黄诚<cheng.huang@linkedcare.cn>
 *
 *
 * 2017年9月7日 下午9:11:46
 *
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean suppressAllComments;

    /**
     * 添加实体类属性注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        // 添加表字段的注释到属性注释中
        field.addJavaDocLine("/**");
        if (introspectedColumn.getRemarks() != null) {
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        }
        // StringBuffer sb = new StringBuffer();
        // sb.append(" * 表字段 : ");
        // sb.append(introspectedTable.getFullyQualifiedTable());
        // sb.append('.');
        // sb.append(introspectedColumn.getActualColumnName());
        // field.addJavaDocLine(sb.toString());
        // field.addJavaDocLine(" * ");
        // addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }

    /**
     * 去掉实体类get方法的注释
     */
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
    }

    /**
     * 去掉实体类set方法的注释
     */
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
    }

    /**
     * 去掉mapper接口的注释
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
    }
}