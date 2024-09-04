package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {

    private final int SIZE = 640;
    private final int DOT_SIZE = 32;
    private final int ALL_DOTS = 400;
    private Image apple;
    private Image dot;
    private int appleX, appleY;
    private int dots;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private Timer timer;
    private static boolean gameOver;
    private boolean leftPressed = false;
    private boolean rightPressed = true;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private final JDialog parent;

    public SnakeGame(JDialog m_parent) {
        parent = m_parent;
        gameOver = false;
        loadImage();
        game();
        addKeyListener(new KeyListener());
        setFocusable(true);
    }

    public void game(){
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 128 - i*DOT_SIZE;
            y[i] = 128;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();
    }

    public void createApple(){
        appleX = new Random().nextInt(20)*DOT_SIZE;
        appleY = new Random().nextInt(20)*DOT_SIZE;
    }

    public void loadImage(){
        ImageIcon imageApple = new ImageIcon("D:\\JavaMiniGames\\apple.png");
        apple = imageApple.getImage();
        ImageIcon imageDot = new ImageIcon("D:\\JavaMiniGames\\dot.png");
        dot = imageDot.getImage();
    }

    public void move(){
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(leftPressed){
            x[0] -= DOT_SIZE;
        }
        if(rightPressed){
            x[0] += DOT_SIZE;
        }
        if(upPressed){
            y[0] -= DOT_SIZE;
        }
        if(downPressed){
            y[0] += DOT_SIZE;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!gameOver){
            g.drawImage(apple, appleX, appleY, this);
            for(int i = 0; i < dots; i++){
                g.drawImage(dot, x[i], y[i], this);
            }
        } else{
            timer.stop();
            new GameOverDialog(dots).setVisible(true);
            if (gameOver){
                parent.dispose();
            }
        }
    }

    public void checkEat(){
        if(x[0] == appleX && y[0] == appleY){
            dots++;
            createApple();
        }
    }

    public void checkCrash(){
        for (int i = dots; i > 0; i--){
            if (i > 4 && x[0] == x[i] && y[0] == y[i]){
                gameOver = true;
            }
        }
        if (x[0] > SIZE){
            gameOver = true;
        }
        if (x[0] < 0){
            gameOver = true;
        }
        if (y[0] > SIZE){
            gameOver = true;
        }
        if (y[0] < 0){
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver){
            checkEat();
            checkCrash();
            move();
        }
        repaint();
    }

    class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !rightPressed) {
                leftPressed = true;
                upPressed = false;
                downPressed = false;
            }
            if (key == KeyEvent.VK_RIGHT && !leftPressed) {
                rightPressed = true;
                upPressed = false;
                downPressed = false;
            }
            if (key == KeyEvent.VK_UP && !downPressed) {
                leftPressed = false;
                upPressed = true;
                rightPressed = false;
            }
            if (key == KeyEvent.VK_DOWN && !upPressed) {
                downPressed = true;
                rightPressed = false;
                leftPressed = false;
            }
        }
    }
}
