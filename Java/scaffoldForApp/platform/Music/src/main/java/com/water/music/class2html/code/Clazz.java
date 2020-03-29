package com.water.music.class2html.code;


public
class Clazz {
    private Cursor cursor;

    Clazz(Cursor cursor){
        this.cursor = cursor;
    }

    public boolean isPackage(Cursor cursor){
        if(cursor.next() == 'p'){
            cursor.mark();
            if(new String(cursor.nextN(6)) == "package"){
                   cursor.readFromMark();
            }
        }
        return false;
    }

    public boolean isImport(Cursor cursor){
        return false;
    }

    public boolean isClass(Cursor cursor){
        return false;
    }

    public boolean isMethod(Cursor cursor){
        return false;
    }

    public boolean isField(Cursor cursor){
        return false;
    }

    public boolean isBlockCode(Cursor cursor){
        return false;
    }

    public boolean isInnerClass(Cursor cursor){
        return false;
    }
}
