package com.water.music.class2html;

import com.water.music.constant.ClassToHtml;
import com.water.music.concurrent.task.Task;
import com.water.music.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleClass2Html implements Task {
    private Logger logger = LoggerFactory.getLogger(SimpleClass2Html.class);

    private String path ;
    private String baseOutPath = ClassToHtml.BASE_OUT_PAHT;
    private String fileName;
    private final String FILE_SUFFIX = ".html";
    private List<String> byteCache = new ArrayList<String>();

    public SimpleClass2Html(String path){
        System.out.println(path);
        if(Strings.isNullOrEmpty(path)){
            return;
        }
        this.path = path;
        fileName = pathConvert(path);
    }

    private String pathConvert(String path){
        return /*baseOutPath + File.pathSeparatorChar +*/ path.substring(0,path.lastIndexOf(".")) + FILE_SUFFIX;
    }

    @Override
    public void run() {
        BufferedReader fis = null;

        try {
            fis = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            String str ;
            do{
                 str = fis.readLine();
                 byteCache.add(str);
            }while(str != null);

            Class2HtmlThreadPool.execute(new Class2HtmlTemplete(byteCache, fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
