package org.journerist.CriteriaObserver.criteria;


import org.journerist.CriteriaObserver.Accessibility;
import org.journerist.CriteriaObserver.ClassProperties;
import org.journerist.CriteriaObserver.Properties;

import java.util.*;

public class CriteriaHolder {
    ClassProperties properties = new ClassProperties();
    Map<CriteriaObserver, Map<Properties, Object>> observers = new HashMap<CriteriaObserver, Map<Properties, Object>>();


    public CriteriaHolder() {
        //defaults
        set(Properties.ACCESSIBILITY, Accessibility.NO_ACCESS);
        set(Properties.ACTIVE_USER, "visitor");
        set(Properties.FOCUSED, false);
    }

    public void set(Properties prop, Object value) {
        properties.set(prop, value);
        notifyObserver();
    }

    private void notifyObserver() {
        Set<CriteriaObserver> criteriaObservers = observers.keySet();
        for(CriteriaObserver observer : criteriaObservers) {
            //if all properties are fulfilled  then the observer gets called with true otherwise false
            observer.updateConjunctionResult(calculateCriteriaConjunctionResult(observers.get(observer)));
        }
    }

    private boolean calculateCriteriaConjunctionResult(Map<Properties, Object> propertiesOfInterest) {
        boolean conjunctionResult = true;

        Set<Properties> properties = propertiesOfInterest.keySet();
        for(Properties poi : properties) {
            Object criteriaHolderProperty = this.properties.get(poi);
            Object observerProperty = propertiesOfInterest.get(poi);

            //this is the result of loosing type safety
            conjunctionResult = conjunctionResult && criteriaHolderProperty.equals(observerProperty);
        }
        return conjunctionResult;
    }

    public Object get(Properties focused) {
        return properties.get(focused);
    }

    public void register(CriteriaObserver obs) {
        observers.put(obs, obs.getConjunctionProperties());
    }
}
