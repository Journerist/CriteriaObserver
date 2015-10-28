package org.journerist.CriteriaObserver.interactor;

import org.journerist.CriteriaObserver.Accessibility;
import org.journerist.CriteriaObserver.Properties;
import org.journerist.CriteriaObserver.ui.Table;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessengerTest {

    @Test
    public void setUp() throws Exception {
        Messenger messenger = new Messenger();
        Table table = new Table();
        table.register(messenger);
        table.set(Properties.ACCESSIBILITY, Accessibility.FULL);
        assertEquals(messenger.getIsActive(), false);
    }

    @Test
    public void shouldBeOkWhenEverytingIsFulfilled() throws Exception {
        Messenger messenger = new Messenger();
        Table table = new Table();
        table.register(messenger);
        table.set(Properties.ACCESSIBILITY, Accessibility.FULL);
        table.set(Properties.FOCUSED, true);
        assertEquals(messenger.getIsActive(), true);
    }
}
