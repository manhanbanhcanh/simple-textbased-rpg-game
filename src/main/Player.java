package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    // Position & speed
    private int x, y;
    private int speed;

    // Size of the player (rectangle for now)
    private final int width = 40;
    private final int height = 40;

    // Input handler
    private KeyHandler keyHandler;

    // Screen boundaries
    private final int screenWidth;
    private final int screenHeight;

    public Player(KeyHandler keyHandler, int screenWidth, int screenHeight) {
        this.keyHandler = keyHandler;
        this.x = 100; // starting position
        this.y = 100;
        this.speed = 4; // movement speed
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
        }
        if (keyHandler.downPressed) {
            y += speed;
        }
        if (keyHandler.leftPressed) {
            x -= speed;
        }
        if (keyHandler.rightPressed) {
            x += speed;
        }

        // Boundary collision
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x + width > screenWidth) x = screenWidth - width;
        if (y + height > screenHeight) y = screenHeight - height;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, width, height);
    }
}
