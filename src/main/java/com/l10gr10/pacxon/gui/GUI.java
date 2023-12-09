package com.l10gr10.pacxon.gui;

import com.l10gr10.pacxon.model.Position;

import java.io.IOException;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT};
    void close() throws IOException;

    void clear();

    void refresh() throws IOException;

    void drawText(Position position, String text, String color);

    GUI.ACTION getNextAction() throws IOException;

    void drawBlock(Position position, String color);

    int getScreenWidth();
}
