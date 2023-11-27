package com.l10gr10.pacxon.model.game.display;

import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DisplayBuilder {
    private final List<String> lines;

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public DisplayBuilder() throws IOException {
        URL resource = DisplayBuilder.class.getResource("/board/board.lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    protected int getHeight() {
        return lines.size();
    }

    public Display generateDisplay(){
        Display display = new Display(getWidth(), getHeight(), 0, 0);

        return display;
    }

}