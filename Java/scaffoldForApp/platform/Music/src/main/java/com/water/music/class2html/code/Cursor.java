package com.water.music.class2html.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 * parser by line , detect specified char in line
 */
public
class Cursor {
    private static
    Logger logger = LoggerFactory.getLogger(Cursor.class);

    private int position;

    private int marker;

    private boolean isEof = false;

    private CharCache cache = new CharCache();

    private Reader source;

    Cursor(Reader source) {
        this.source = source;
        this.position = 0;
        this.marker = 0;
    }

    public
    char[] nextN(int n) {
        char[] contents = new char[n];
        for (int i = 0; i < n; i++) {
            contents[i] = next();
            cache.add(contents[i]);
            position++;
        }
        return contents;
    }

    public
    char next() {
        char c = ' ';
        try {
            int content = source.read();
            if(content == Constanst.EOF){
                isEof = true;
                return c;
            }
            c = (char) content;
            cache.add(c);
            position++;
            return c;
        } catch (IOException e) {
            isEof = true;
            logger.error("fail read file ");
        }
        return c;
    }

    public char[] readFromMark(){
        return cache.read(marker,position-marker);
    }

    public
    boolean isEof() {
        return isEof;
    }


    public
    void mark() {
        marker = position;
    }

    class CharCache{
        char[] cache = new char[1024];
        CharCache(){}
        void add(char c){
            if(position > cache.length){
                cache = Arrays.copyOf(cache,cache.length+1024);
            }
            cache[position] = c;
        }

        char read(int index){
            if( index > -1 && index <= position){
                return cache[index];
            }
            return ' ';
        }

        char[] read(int offset,int length){
            char[] content = new char[length];
            for(int i = offset;i < offset+length;i++){
                content[i]=cache[offset+i];
            }
            return content;
        }
    }
}
