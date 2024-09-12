package org.example;

import javax.swing.*;
import java.awt.*;

public class SnakeWindow extends JDialog {

    SnakeGame snake;
    SnakeWindow(){
        setTitle("Snake Game");
        setModal(true);
        setBounds(600, 200, 700, 700);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        snake = new SnakeGame(this);
        add(snake);
    }
}
