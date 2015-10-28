package org.journerist.CriteriaObserver.interactor;

import org.journerist.CriteriaObserver.Properties;
import org.journerist.CriteriaObserver.ui.Table;

public class FocusManager {

    private final Table table;

    public FocusManager(Table table) {
        this.table = table;
    }

    public void update() {
        table.set(Properties.FOCUSED, true);
    }
}
