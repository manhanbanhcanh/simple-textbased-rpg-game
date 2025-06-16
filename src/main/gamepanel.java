package main;

import javax.swing.*;
import java.awt.*;

public class gamepanel extends JPanel implements Runnable{

    //screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scaledTileSize = 5;

    final int tileSize = originalTileSize * scaledTileSize; // scaled tile size
    final int maxTilesColumns = 9;
    final int maxTilesRows = 16;
    final int screenWidth = tileSize * maxTilesRows;
    final int screenHeight = tileSize * maxTilesColumns;

    int fps = 90;

    keyHandler keyHandler = new keyHandler();
    Thread gameThread; //automatically call the run() method

    // set player default pos
    int pX = 100;
    int pY = 100;
    int pVel = 2;

    public gamepanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // drawing from this panel done in an offscreen painting buffer (better rendering performance)
        this.addKeyListener(keyHandler);
        this.setFocusable(true); //gamepanel can be focused to receive keyboard input
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 / fps;
        double nextDrawInterval = System.nanoTime() + drawInterval;

        while(gameThread != null) {

            //checking the time
            //long curTime = System.nanoTime();

            //update information
            update();
            //draw the screen with the updated information
            repaint(); // call the paintComponent thing

            //sleep method for limiting the fps
            try{
                double remainingTime = nextDrawInterval - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0) remainingTime = 0;

                Thread.sleep((long) remainingTime);

                nextDrawInterval += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update() {
        if(keyHandler.upPressed) {
            pY -= pVel;
        }
        else if(keyHandler.downPressed) {
            pY += pVel;
        }
        else if(keyHandler.leftPressed) {
            pX -= pVel;
        }
        else if(keyHandler.rightPressed) {
            pX += pVel;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);

        g2d.fillRect(pX, pY, tileSize, tileSize);

        g2d.dispose(); // release system's resources ig?
    }
}
