package com.water.music.logadapter.model;



public abstract
class AbstractLogger implements Logger{
    TargetLogger target;

    AbstractLogger(TargetLogger logger){
        this.target =  logger;
    }





}
