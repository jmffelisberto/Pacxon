
package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.model.game.display.Display;
import com.l10gr10.pacxon.view.Viewer;

public class GameState extends State<Display>{

    @Override
    protected Viewer<Display> getViewer() {
        return null;
    }

    public GameState(Display display) {
        super(display);
    }


}
