package com.water.music.util.entityMappingAuto;

import com.water.music.util.DomUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;
import java.util.Map;

public
class BeanXmlTemplete implements Templete{

    final String BEANS = "beans";
    final String BEAN = "bean";
    final String XML = "xml";
    final String XMLNS = "xmlns";
    final String XMLNS_XSI = "xmlns:xsi";
    final String XSI_SCHEMALOCATION = "xsi:schemaLocation";

    private String buildInstruct(){
        String fileInstruct = SymbolConst.prefix + SymbolConst.questionMark + XML + SymbolConst.space + keyValueStr("version","1.0") + SymbolConst.space
                + keyValueStr("encoding","UTF-8")+SymbolConst.questionMark+SymbolConst.suffix;
        return fileInstruct;
    }

    private String buildBeansPrefix(){
        String beansPrefix = SymbolConst.prefix + BEANS +SymbolConst.space+ keyValueStr(XMLNS,"http://www.springframework.org/schema/beans") + SymbolConst.space
                + keyValueStr(XMLNS_XSI,"http://www.w3.org/2001/XMLSchema-instance") + SymbolConst.space +
                keyValueStr(XSI_SCHEMALOCATION,"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd")+
                SymbolConst.suffix;
        return beansPrefix;
    }


    @Override
    public
    void buildHeader(TempleteWriter writer) {
        writer.write(buildInstruct());
        writer.write(buildBeansPrefix());
    }

    @Override
    public
    void buildBody(TempleteWriter writer,Map<String,String> content) {
        for (String s : content.keySet()){
            writer.write(simpleBean(s,content.get(s)));
        }
    }

    @Override
    public
    void buildBottom(TempleteWriter writer) {
        String beansSuffix =  SymbolConst.prefix + SymbolConst.backSlash + BEANS + SymbolConst.suffix;
        writer.write(beansSuffix);
    }


    private String keyValueStr(String key, String value){
        return key + SymbolConst.equalMark +SymbolConst.quotationMark + value + SymbolConst.quotationMark;
    }

    private String simpleBean(String id, String clazz){
        String beanPrefix = SymbolConst.tab + SymbolConst.prefix + BEAN + SymbolConst.space + keyValueStr("id",id) + SymbolConst.space
                + keyValueStr("class",clazz) + SymbolConst.suffix;
        String beanSuffix = SymbolConst.prefix + SymbolConst.backSlash + BEAN + SymbolConst.suffix;
       return  beanPrefix + beanSuffix;
    }

    public void generateBeans(Map<String,String> beans, String fileName){
        TempleteWriter tw = new BeansTempleteWriter(fileName);
        tw.openWriter();
        buildHeader(tw);
        buildBody(tw,beans);
        buildBottom(tw);
        tw.closeWriter();
    }

}

interface SymbolConst{
    String prefix = "<";
    String suffix = ">";
    String questionMark = "?";
    String equalMark = "=";
    String quotationMark = "\"";
    String space = " ";
    String backSlash = "/";
    String tab = "    ";
}