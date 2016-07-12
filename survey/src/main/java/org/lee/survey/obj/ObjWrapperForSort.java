package org.lee.survey.obj;

/**
 * Created by lee on 2016/7/8.
 */
public class ObjWrapperForSort {

    private String key;

    private int value;

    public ObjWrapperForSort(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
