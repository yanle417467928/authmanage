package com.yanle.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ajax返回类型，树形结构
 *
 * @author yanle
 * @ create 2017-03-01 15:45
 **/
public class Tree implements Serializable{

    private static final long serialVersionUID = -1609177454933385368L;

    private Long id;
    private String text;
    private String state = "open";//open,closed
    private Boolean checked = false;
    private Object attributes;
    private List<Tree> children;
    private String iconCls;
    private Long pid;

    private String openMode;//ajax,iframe,


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getOpenMode() {
        return openMode;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", checked=" + checked +
                ", attributes=" + attributes +
                ", children=" + children +
                ", iconCls='" + iconCls + '\'' +
                ", pid=" + pid +
                ", openMode='" + openMode + '\'' +
                '}';
    }
}
