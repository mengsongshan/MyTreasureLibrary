package com.water.music.util;

import org.codehaus.plexus.util.StringUtils;

import java.io.File;

public final
class PathUtil {

    /**
     * 获取项目根目录
     * @return
     */
    public static String getHome(){
        String home = System.getProperty("user.dir");
        if(StringUtils.isEmpty(home)){
            home = new File("").getAbsolutePath();
        }
        return home;
    }

    /**
     * 获取classes目录
     * @return
     */
    public static String getClassesPath(Object obj){
        return obj.getClass().getClassLoader().getResource("").getPath();
    }

    /**
     * 根据文件名在当前项目中获取文件路径
     * @return
     */
    public static File getPathByNameInHome(String fileName){
        File home = new File(getHome());
        if(home.isDirectory()){
            return new GetFile(home.listFiles(),fileName).getFilePath();
        }
        return null;
    }

   static class GetFile{
        private String fileName;
        private File[] files;
        private File targetFile ;

        GetFile(File[] files, String fileName){
            this.fileName = fileName;
            this.files = files;
        }
        File getFilePath(){
            getFiles(files);
            return targetFile;
        }
        private void getFiles(File[] files){
            for(File f : files){
                if(f.isDirectory()){
                    File[] child = f.listFiles();
                    getFiles(child);
                }else{
                    if(fileName.equals(f.getName())){
                        targetFile = f;
                        break;
                    }
                }
            }
        }
    }


    public static
    void main(String[] args) {
        System.out.println(new File("C:\\desk.xml").getName());
    }
}
