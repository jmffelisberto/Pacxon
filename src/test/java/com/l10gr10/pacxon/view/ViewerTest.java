package com.l10gr10.pacxon.view;

import com.l10gr10.pacxon.gui.GUI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ViewerTest {

    @Test
    public void testConstructorAndGetModel() {
        // Create a sample model
        String sampleModel = "Sample Model";

        // Create a viewer with the sample model
        Viewer<String> viewer = new Viewer<String>(sampleModel) {
            @Override
            protected void drawElements(GUI gui) {

                // Do nothing for the purpose of this test
            }
        };

        // Test whether the constructor correctly sets the model
        assertEquals(sampleModel, viewer.getModel());
    }

    // You can add more tests based on your specific requirements
}
