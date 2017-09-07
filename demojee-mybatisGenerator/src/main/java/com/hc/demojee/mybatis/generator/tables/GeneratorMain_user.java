package com.hc.demojee.mybatis.generator.tables;

import com.hc.demojee.mybatis.generator.CodeGenerator;

/**
 * 
 * @author 黄诚<cheng.huang@linkedcare.cn>
 *
 * 2017年9月7日 下午9:05:10
 *
 */
public class GeneratorMain_user {
    static CodeGenerator generator = null;
    public static void main(String[] args) throws Exception {
        generator = CodeGenerator.buildGenerator()
                .setNameForTable("users", "user_id").setNameForJavaClass("UserEntity", "UserMapper").gen()
                .setNameForTable("user_profiles", "user_id").setNameForJavaClass("UserProfileEntity", "UserProfileMapper").gen()
                .report();
    }
}
