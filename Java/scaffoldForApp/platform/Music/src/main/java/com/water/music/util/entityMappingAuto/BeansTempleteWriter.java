package com.water.music.util.entityMappingAuto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public
class BeansTempleteWriter implements TempleteWriter {

    private String beanCfgName;
    private File beanCfg = null;
    PrintStream ps = null;

    public BeansTempleteWriter(String beanCfgName){
            this.beanCfgName = beanCfgName;
    }

    @Override
    public
    void openWriter() {
        beanCfg = new File(beanCfgName);
        try {
            ps = new PrintStream(beanCfg,"UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Override
    public
    void closeWriter() {
        if(ps != null){
            ps.close();
        }
    }

    @Override
    public
    void write(String str) {
        ps.println(str);
    }
}
