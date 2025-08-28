package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // ===== SCREEN SETTINGS =====
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int FPS = 60;

    // ===== GAME LOOP =====
    private Thread gameThread;

    // ===== INPUT =====
    private KeyHandler keyHandler = new KeyHandler();

    // ===== PLAYER / GAME OBJECTS =====
    private Player player = new Player(keyHandler, SCREEN_WIDTH, SCREEN_HEIGHT);

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // improves performance
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // fixed fps game loop
        double drawInterval = 1000000000.0 / FPS; // nanoseconds per frame
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            // update (game logic)
            update();

            // draw (render screen)
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1_000_000; // convert to ms

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // todo: update player, enemies, events, etc.
        player.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // todo: draw player, map, enemies, etc.
        g2.setColor(Color.white);
        g2.drawString("Game is running...", 20, 20);

        player.draw(g2);

        g2.dispose();
    }
}
