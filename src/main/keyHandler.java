package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    //not being used for now
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // returns the integer associated with the key

        if(key == KeyEvent.VK_W) {
            upPressed = true;
        }
        if(key == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(key == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(key == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(key == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(key == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(key == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
