package org.journerist.CriteriaObserver.interactor;

import org.journerist.CriteriaObserver.Accessibility;
import org.journerist.CriteriaObserver.Properties;
import org.journerist.CriteriaObserver.criteria.CriteriaObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messenger implements CriteriaObserver {

    Boolean isActive = null;

    public void updateConjunctionResult(boolean fulfilled) {
        if(fulfilled) {
            isActive = true;
        } else {
            isActive = false;
        }
    }

    public Map<Properties, Object> getConjunctionProperties() {
        HashMap<Properties, Object> notifierCriterias = new HashMap<Properties, Object>();
        notifierCriterias.put(Properties.FOCUSED, true);
        notifierCriterias.put(Properties.ACCESSIBILITY, Accessibility.FULL);
        return notifierCriterias;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
