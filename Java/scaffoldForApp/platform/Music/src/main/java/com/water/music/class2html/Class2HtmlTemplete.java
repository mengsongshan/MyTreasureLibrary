package com.water.music.class2html;

import com.water.music.concurrent.task.Task;

import java.io.*;
import java.util.List;

public class Class2HtmlTemplete implements Task {
    private static String HEADER = "<html><head>${fileName}</head><body>";
    private static String TAIL = "</body></html>";
    private static String LINE_H ="<p>";
    private static String LINE_T ="</p>";
    private String fileName;
    private List<String> content;

    public Class2HtmlTemplete(List<String> content,String fileName){
        this.content =content;
        this.fileName = fileName;
    }

    private String build(){
        PrintStream fos = null;
        try {
            fos = new PrintStream(new FileOutputStream(new File(fileName)),true);
            fos.println(HEADER);
            for(String b :content ){
                fos.println(LINE_H + b + LINE_T);
            }
            fos.println(TAIL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fos.close();
        }
        return HEADER + content + TAIL;
    }

    @Override
    public void run() {

        build();
    }
}
