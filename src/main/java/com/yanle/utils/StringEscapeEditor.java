package com.yanle.utils;

import org.springframework.web.util.HtmlUtils;

import java.beans.PropertyEditorSupport;

/**
 * 防止XSS攻击
 *
 * @author yanle
 * @create 2017-02-17 15:02
 **/
public class StringEscapeEditor extends PropertyEditorSupport {
    public StringEscapeEditor(){

    }

    public String getAsText(){
        Object value = getValue();
        return  value !=null?value.toString():"";
    }

    public void setAsText(String text) throws IllegalArgumentException{
        if (null == text){
            setValue(null);
        }else{
            setValue(HtmlUtils.htmlEscape(text));
        }
    }

}
