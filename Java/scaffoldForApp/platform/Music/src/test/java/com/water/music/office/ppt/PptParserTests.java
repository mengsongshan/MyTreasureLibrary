package com.water.music.office.ppt;

import org.junit.Test;

public
class PptParserTests {
    private static String EASIER_PPT_TEMPLETE_PATH = "D:\\360极速浏览器下载\\公司内部用模板.ppt";
    PptParser pptParser = new PptParser();
    @Test
    public  void operateMasterTest(){
        pptParser.operateMaster(EASIER_PPT_TEMPLETE_PATH);

    }

    @Test
    public void operateSlideTest(){
        pptParser.operateSlide(EASIER_PPT_TEMPLETE_PATH);
    }

    @Test
    public void changeBackgroundTest(){
        EASIER_PPT_TEMPLETE_PATH = "c:\\train\\Dubbo.ppt";
        pptParser.changeBackground(EASIER_PPT_TEMPLETE_PATH);
    }
}
