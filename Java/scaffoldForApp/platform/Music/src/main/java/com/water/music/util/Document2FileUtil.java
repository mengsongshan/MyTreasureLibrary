package com.water.music.util;

import org.w3c.dom.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Document对象生成XML文件
 XML文件常见的格式，第一行是版本、编码设置
 第二行是Document Type ，Document Type在DOM中的定义，是只读属性
 以下就是元素和注释，元素中包含属性，元素具有子元素，元素内容可以是子元素、纯文本Node、实体等。
 一般情况下，系统自动构建工具只生成简单的XML结构。
 */
public
class Document2FileUtil {

    public void bulidDocument(Element root,List<Element> elements){
        Document document = createDocument();

        document.appendChild(root);
    }

    Document createDocument(){
        Document document = DomUtil.getDocument();
        document.setXmlVersion("1.0");
        return document;
    }

    public Element createElement(Document doc, String tag, Map<String,String> attrs){
           return this.createElement(doc,tag,attrs,null);
    }

    public Element createElement(Document doc, String tag){
        return this.createElement(doc,tag,null,null);
    }

    public Element createElement(Document doc, String tag, Map<String,String> attrs, List<Element> child){
        if (doc == null || tag == null){
            return null;
        }

        Element element = doc.createElement(tag);
        if(attrs != null && attrs.size() > 0){
            for(String key : attrs.keySet()){
                element.setAttribute(key,attrs.get(key));
            }
        }

        if (child != null && child.size() > 0){
            for (Element e : child){
                element.appendChild(e);
            }
        }

        return element;
    }

    public void writerDocument(Document doc, String fileName){
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer tra;
        FileOutputStream fileOutputStream = null;
        try {
            tra = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            fileOutputStream = new FileOutputStream( new File(fileName));
            StreamResult sr = new StreamResult(fileOutputStream);

            tra.transform(domSource,sr);
        } catch (TransformerConfigurationException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (TransformerException e) {
            System.out.println(e);
        }finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }

    }

    public static
    void main(String[] args) {
        Document2FileUtil d2 = new Document2FileUtil();
        Map<String, String> attrs = new HashMap<>();
        attrs.put("xmlns","http://www.springframework.org/schema/beans");
        attrs.put("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        attrs.put("xmlns:context","http://www.springframework.org/schema/context");
        Document document = d2.createDocument();
        Element element = d2.createElement(document,"beans",attrs,null);
        document.appendChild(element);
        d2.writerDocument(document,"code2xml.xml");
    }
}
