package com.hc.demojee.mybatis.generator;

/**
 * 你可以直接修改使用，也可以copy一份新的类修改后再使用
 * 
 * 代码生成入口
 * 0 默认配置在属性文件中，main方法中可以覆盖设置一些属性(表名,对象名),不用改动配置文件
 * 1 工具生成的代码尽量不要去修改，没意义，给后续更新维护带来麻烦; 工具做不到的例外；
 * 2 Dao.xml(Map.xml)文件中可以添加自己的方法节点，重新生成时会保留；也可以新建自己的Dao.xml(Map.xml)文件,添加自己的代码，参考(CouponItemEntityMapperEx.xml)
 * 3 overwriteJavaClass=true时，java文件会被重新生成，自己添加的逻辑会丢失；overwriteJavaClass=false时，会生成带序号的新java文件；
 *   建议是用true，这样可以保持代码最新状态，利用版本控制工具与历史代码合并；
 * 4 可以级联重复设置表名，java文件名，多次生成
 * 
 * @author 黄诚<cheng.huang@linkedcare.cn>
 *
 * 2017年7月13日 上午09:19:15
 *
 */
public class GeneratorMain {
    public static void main(String[] args) throws Exception {
        CodeGenerator generator = null;

        generator = CodeGenerator.buildGenerator()
                .setNameForTable("coupon_item", "id")
                .setNameForJavaClass("cn.linkedcare.libra.entity.CoupomItemEntity","cn.linkedcare.libra.dao.CoupomItemDao").gen()
                .setNameForTable("coupon_define", "id").setNameForJavaClass("CouponDefineEntity", "CouponDefineDao").gen()
                .setNameForTable("xx", "xx_id").setNameForJavaClass("XxxEntity", "XxxMapper").gen();
        generator.report();
    }
    
    
    
    /**
     * 完整参数，多表示例
     * 所有的后面的
     * 
     * @throws Exception
     */
    public void test1() throws Exception {
        CodeGenerator generator;
        generator = CodeGenerator.buildGenerator().setOverwriteJavaClass(true)
                .setBasePathForJava("src/test/java").setBasePathForXml("src/test/resources")
                //NameForJavaClass设置了完整的包路径时这里可以忽略
                .setPackageForXmlMapper("cn.linkedcare.mappers")
                .setPackageForJavaModel("cn.linkedcare.libra.entity").setPackageForJavaMapper("cn.linkedcare.libra.dao")
                //设置表名，生成文件名，生成
                .setNameForTable("coupon_item", "id")
                .setNameForJavaClass("cn.linkedcare.libra.entity.CoupomItemEntity","cn.linkedcare.libra.dao.CoupomItemDao").gen()
                //多表生成多次设置
                .setNameForTable("coupon_define1", "id").setNameForJavaClass("CouponDefineEntity1", "CouponDefineDao1").gen()
                .setNameForTable("coupon_define2", "id").setNameForJavaClass("CouponDefineEntity2", "CouponDefineDao2").gen()
                .setNameForTable("coupon_define3", "id").setNameForJavaClass("CouponDefineEntity3", "CouponDefineDao3").gen()
                .setNameForTable("coupon_define4", "id").setNameForJavaClass("CouponDefineEntity4", "CouponDefineDao4").gen()
                //生成报告
                .report();

                // 继续使用
                generator.setNameForTable("coupon_define", "id").setNameForJavaClass("CouponDefineEntity", "CouponDefineDao").gen()
                .setNameForTable("coupon_define", "id").setNameForJavaClass("CouponDefineEntity", "CouponDefineDao").gen()
                .report();
    }
}
