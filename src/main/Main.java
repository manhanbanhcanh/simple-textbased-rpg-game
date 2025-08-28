package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Create a main game window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Simple Text-Based RPG");

        // Add a game panel
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // fits a window to GamePanel’s preferred size

        // Center window on screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Start the game loop
        gamePanel.startGameThread();
    }
}
