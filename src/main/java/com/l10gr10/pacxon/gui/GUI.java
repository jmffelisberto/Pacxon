package com.l10gr10.pacxon.gui;

import java.io.IOException;

public interface GUI {
    void close() throws IOException;

    void clear();

    void refresh() throws IOException;
}
