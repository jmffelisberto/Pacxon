package com.l10gr10.pacxon.gui;

import com.l10gr10.pacxon.model.Position;

import java.io.IOException;

public interface GUI {
    void close() throws IOException;

    void clear();

    void refresh() throws IOException;

    void drawText(Position position, String text, String color);
}
