package org.example;

import javax.swing.*;
import java.awt.*;

public class SnakeWindow extends JDialog {

    SnakeGame snake;
    SnakeWindow(){
        setTitle("Snake Game");
        setModal(true);
        setBounds(600, 200, 700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        snake = new SnakeGame(this);
        add(snake);
    }

    public SnakeGame getSnake() {
        return snake;
    }

    public void setSnake(SnakeGame snake) {
        this.snake = snake;
    }
}
