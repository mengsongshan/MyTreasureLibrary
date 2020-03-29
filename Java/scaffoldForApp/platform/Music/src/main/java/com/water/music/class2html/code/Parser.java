package com.water.music.class2html.code;

import com.water.music.class2html.code.visitor.Visitor;
import com.water.music.class2html.code.visitor.impl.CommentVisitor;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public
class Parser {
    private InputStreamReader reader ;
    Cursor cursor;
    public Parser(InputStream source){
        this.reader = new InputStreamReader(source);
        cursor = new Cursor(reader);
    }

    public Parser(InputStream source,String charset){
        try {
            this.reader = new InputStreamReader(source,charset);
            cursor = new Cursor(reader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void parser(){
           char c ;
           Visitor visitor = null;
       /*
       * 注释，包，导入类，类，方法，字段，代码块，
       * 字段分析策略：
       *     1、逐个字符读取，一次流过滤出所有的组件
       *     2、读入内存多次处理
       *
       * */

           for(;cursor.isEof();){
               c = cursor.next();
               if(c == Constanst.COMMENT_LINE){
                   c = cursor.next();
                   if(c == Constanst.COMMENT_MUTIL){
                       visitor = new CommentVisitor();
                   }
               }
               visitor.doVisitor(cursor);
           }
    }

}
