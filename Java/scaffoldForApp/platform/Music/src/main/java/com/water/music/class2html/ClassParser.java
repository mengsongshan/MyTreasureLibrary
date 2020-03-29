package com.water.music.class2html;


import java.io.*;
import java.nio.ByteBuffer;
import java.util.stream.Stream;

public class ClassParser {
    private BufferedInputStream source ;
    public ClassParser(InputStream is){
        this.source = new BufferedInputStream(is);
    }

    public void parser(){
        try {
            int fileSize = source.available();
            byte[] content = new byte[fileSize];
            ByteBuffer bb = ByteBuffer.allocate(fileSize);
            source.read(content,0,fileSize);
            bb.put(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
