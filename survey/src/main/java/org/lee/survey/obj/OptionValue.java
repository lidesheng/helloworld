package org.lee.survey.obj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaio on 2016/6/30.
 */
public class OptionValue {

    private static List<OptionValue> defaultValues = createDefaultValues();

    private String name;

    private String value;

    public OptionValue(String nameAndCode) {
        this(nameAndCode, nameAndCode);
    }

    public OptionValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static List<OptionValue> getDefaultValues() {
        return  defaultValues;
    }

    private static List<OptionValue> createDefaultValues() {
        List<OptionValue> values = new ArrayList<OptionValue>();
        for (int i = 10; i >= 1; i--) {
            values.add(new OptionValue(String.valueOf(i)));
        }
        return values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
