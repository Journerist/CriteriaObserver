package org.journerist.CriteriaObserver.interactor;

import org.journerist.CriteriaObserver.Properties;
import org.journerist.CriteriaObserver.ui.Table;
import org.junit.Assert;
import org.junit.Test;

public class FocusManagerTest {
    @Test
    public void shouldSetTablesFocusAttribute() throws Exception {
        Table table = new Table();
        FocusManager focusManager = new FocusManager(table);
        focusManager.update();
        Assert.assertEquals(table.get(Properties.FOCUSED), true);

    }
}
