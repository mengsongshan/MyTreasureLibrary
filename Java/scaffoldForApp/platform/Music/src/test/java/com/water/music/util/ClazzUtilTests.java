package com.water.music.util;

import org.junit.Test;

import java.io.File;
import java.util.List;

public
class ClazzUtilTests {

    @Test
    public void getAllClassOfPackageTest(){

        List<String> clazzes = ClazzUtil.getAllClassOfPackage(ClazzUtil.getClazzPackageName(this));
        for(String s : clazzes){
            System.out.println(s);
        }
    }

    @Test
    public void convertPathTest(){
        System.out.println(ClazzUtil.convertPath(ClazzUtil.getClazzPackageName(this)));
    }

    @Test
    public void getClazzPackageFileTest(){
        ClazzUtil.getClazzPackageFile(this);
    }

    @Test
    public void getCurrentClassFileTest(){

    }

    @Test
    public void getDirClazzesTest(){
        File f = ClazzUtil.getCurrentClassDirFile(this);
        ClazzUtil.getDirClazzes(f);
    }

    @Test
    public void getClassNameWithoutPackageNameTest(){
        System.out.println(ClazzUtil.getClassNameWithoutPackageName(this));
    }
}
