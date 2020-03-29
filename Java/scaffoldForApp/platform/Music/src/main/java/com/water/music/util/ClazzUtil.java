package com.water.music.util;

import java.io.File;
import java.util.*;

public final
class ClazzUtil {

    class ClazzPath {
        private Class clazz;
        private String clazzName;

        ClazzPath(Object obj){
            this(obj.getClass());
        }
        ClazzPath(Class clazz){
            this.clazz = clazz;
            this.clazzName = clazz.getName();
        }

        /**
         * 获取classes目录的路径，例如${home}/WEB-INF/classes/
         * @return
         */
        public String getClassesPath(){
            return clazz.getClassLoader().getResource("").getPath();
        }

        /**
         * 类的类目录，例如${home}/WEB-INF/classes/com/s
         * @param obj
         * @return
         */
        public String getClazzPath(Object obj){
            return clazz.getResource("").getPath();
        }

        /**
         * 获取包名，例如com.s
         * @return
         */
        public String getPackageName(){
            return clazzName.substring(0,clazzName.lastIndexOf("."));
        }

        /**
         * 获取包路径 例如com/s
         * @return
         */
        public String getPackagePath(){
            return getPackageName().replace(".", String.valueOf(File.separatorChar));
        }

        /**
         * 获取类名，例如ClazzUtil
         * @return
         */
        public String getName(){
            return clazzName.substring(clazzName.lastIndexOf(".") + 1);
        }

        /**
         * 获取全类名，例如com.util.ClazzUtil
         * @return
         */
        public String getFullName(){
            return clazzName;
        }

        /**
         * 获取类源码对应的文件，例如new File("com/util/ClazzUtil.java");
         * @return
         */
        public File getClassSourceFile(){
            /*String fileDir =
            String fileName = getPackagePath() + File.separatorChar + getName() + ".java";*/
            return null;
        }
    }
    /**
     * 获取实例对应类的包名
     * @param obj
     * @return
     */
    public static String getClazzPackageName(Object obj){
        String name = obj.getClass().getName();
        String packageName = name.substring(0,name.lastIndexOf("."));
        return packageName;
    }

    /**
     *  获取实例对应的类名，不包含包名前缀
     * @param obj
     * @return
     */
    public static String getClassNameWithoutPackageName(Object obj){
        String name = obj.getClass().getName();
        String packageName = name.substring(name.lastIndexOf(".")+1);
        return packageName;
    }
    /**
     * get all class in the package
     * @param packageName
     * @return
     */
    public static List<String> getAllClassOfPackage(String packageName){


        return  /*Arrays.asList(file.list())*/ null;
    }

    /**
     * convert package to path
     * @param packageName
     * @return
     */
    public static String convertPath(String packageName){
        return packageName.replace(".", String.valueOf(File.separatorChar));
    }

    /**
     * get package file
     * @param obj
     * @return
     */
    public static String getClazzPackageFile(Object obj){



        return  null;
    }

    /**
     *  获取实例对应类所在的绝对目录文件对象
     * @param obj
     * @return
     */
    public static File getCurrentClassDirFile(Object obj){
        if(obj == null){
            return null;
        }
        File file = new File(obj.getClass().getResource("").getFile());
        return file;
    }

    /**
     *  获取目录下所有类的类名
     * @param dir
     * @return
     */
    public static List<String> getDirClazzes(File dir){
        List<String> fNames = new ArrayList<>();
        if(dir.isDirectory()){
           File[] classFile = dir.listFiles();
           for(File f: classFile){
               String fName = f.getName();
               fName = fName.substring(0,fName.lastIndexOf("."));
               fNames.add(fName);
           }
       }
       return fNames;
    }


    /**
     *  获取实例对应类所在包的所有类的类名和类全名的映射
     * @param obj
     * @return
     */
    public static Map<String,String> getAllBrotherNameClassMap(Object obj){
        if(obj == null){
            return null;
        }
        Map<String,String> mapping = new HashMap<>();
        String myPackage = getClazzPackageName(obj);
        String myName = getClassNameWithoutPackageName(obj);
        File myDir = getCurrentClassDirFile(obj);
        List<String> myBrother = getDirClazzes(myDir);
        for(String s : myBrother){
            if(s.equals(myName)){
                continue;
            }
            mapping.put(s,myPackage+"."+s);
        }
        return mapping;
    }

}
