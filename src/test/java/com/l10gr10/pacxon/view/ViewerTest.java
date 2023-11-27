package com.l10gr10.pacxon.view;

import com.l10gr10.pacxon.gui.GUI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ViewerTest {

    @Test
    public void testConstructorAndGetModel() {
        String sampleModel = "Sample Model";
        Viewer<String> viewer = new Viewer<String>(sampleModel) {
            @Override
            protected void drawElements(GUI gui) {
            }
        };
        assertEquals(sampleModel, viewer.getModel());
    }
}
