package main;

import javax.swing.*;
import java.awt.*;

public class gamepanel extends JPanel {

    //screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scaledTileSize = 4;

    final int tileSize = originalTileSize * scaledTileSize; // scaled tile size (64px)
    final int maxTilesColumns = 14;
    final int maxTilesRows = 23;
    final int screenWidth = tileSize * maxTilesRows; // 1472px
    final int screenHeight = tileSize * maxTilesColumns; // 896px
    // idk why i thought 23:14 ratio screen would be optimal but yes

    public gamepanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // drawing from this panel done in an offscreen painting buffer (better rendering performance)
    }

}
