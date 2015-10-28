package org.journerist.CriteriaObserver;

import java.util.HashMap;
import java.util.Map;

public class ClassProperties {

    Map<String, Object> properties = new HashMap<String, Object>();

    public void set(Properties key, Object value) {
        properties.put(key.name(), value);
    }

    //TODO:  type safty?
    public Object get(Properties key) {
        return properties.get(key.name());
    }

}
