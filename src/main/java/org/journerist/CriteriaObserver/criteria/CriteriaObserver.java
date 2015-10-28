package org.journerist.CriteriaObserver.criteria;

import org.journerist.CriteriaObserver.Properties;

import java.util.Map;

public interface CriteriaObserver {

    void updateConjunctionResult(boolean fulfilled);
    Map<Properties, Object> getConjunctionProperties();
}
