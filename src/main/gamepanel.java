package main;

import javax.swing.*;
import java.awt.*;

public class gamepanel extends JPanel {

    //screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scaledTileSize = 5;

    final int tileSize = originalTileSize * scaledTileSize; // scaled tile size
    final int maxTilesColumns = 9;
    final int maxTilesRows = 16;
    final int screenWidth = tileSize * maxTilesRows;
    final int screenHeight = tileSize * maxTilesColumns;



    public gamepanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // drawing from this panel done in an offscreen painting buffer (better rendering performance)
    }

}
