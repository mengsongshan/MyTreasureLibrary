package com.water.music.entity.userinfo;

import com.water.music.util.ClazzUtil;
import com.water.music.util.PathUtil;
import com.water.music.util.entityMappingAuto.BeanXmlTemplete;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;

public
class EntityToHbmXmlUtil {

    /**
     * 获取包中的所有实例Bean，生成Bean的配置文件
     */
    private void buildBeanCfgFile(){
      Map<String,String> allBrother = ClazzUtil.getAllBrotherNameClassMap(this);
      BeanXmlTemplete bxt = new BeanXmlTemplete();
      bxt.generateBeans(allBrother,PathUtil.getClassesPath(this)+ File.separatorChar+"beanCfgName.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("beanCfgName.xml");

        String[] beans = ac.getBeanDefinitionNames();
        for(int i = 0 ; i < beans.length ;i++){
            System.out.println(beans[i]);
        }
    }



    public void generate(){

    }

    public static
    void main(String[] args) {
      /*     EntityToHbmXmlUtil ethu = new EntityToHbmXmlUtil();
           ethu.buildBeanCfgFile();*/

        try {
            Field[] fields = Class.forName("com.water.music.entity.userinfo.Picture").getDeclaredFields();
            for (Field f : fields){
                System.out.println(f.getClass().getName()+"\t\t"+f.getName());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
