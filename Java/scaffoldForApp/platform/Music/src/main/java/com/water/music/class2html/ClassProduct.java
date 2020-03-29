package com.water.music.class2html;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ClassProduct implements Callable<List<File>>
{
    private static Logger logger = LoggerFactory.getLogger(ClassProduct.class);

    public static List<File> datas = new ArrayList<File>(5000);
    public String[] rootPath;
    private boolean isRun = true;

    public ClassProduct(String[] rootPath){
        this.rootPath = rootPath;
    }

    @Override
    public List<File> call() throws Exception {
        while(isRun){
            File[] roots = new File[rootPath.length];
            for(int i= 0;i< rootPath.length;i++){
                roots[i] = new File(rootPath[i]);
            }
            getFiles(roots);
            isRun = false;
        }
            return datas;
    }

    private void getFiles(File[] files){
        for(File f : files){
            if(f.isDirectory()){
                File[] child = f.listFiles();
                getFiles(child);
            }else{
                if(f.getName().indexOf(".java") > 0){
                    logger.debug(f.getPath());
                    datas.add(f);
                }
            }
        }
    }


    public void setRun(boolean run) {
        isRun = run;
    }
}
