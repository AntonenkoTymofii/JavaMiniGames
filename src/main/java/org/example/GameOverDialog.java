package org.example;

import javax.swing.*;
import java.awt.*;

public class GameOverDialog extends JDialog {

    private JButton exitButton = new JButton("Exit");
//    private boolean restart = false;
//    private boolean exit = false;

    GameOverDialog(int score) {
        setTitle("Game Over");
        setSize(400, 300);
        setModal(true);
        setLocationRelativeTo(null);
        JLabel scoreLabel = new JLabel("Your core: " + score);
        JPanel buttonPanel = getButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        add(scoreLabel, BorderLayout.CENTER);

    }

    private JPanel getButtonPanel() {
        exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            dispose();
        } );

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(exitButton);
        return buttonPanel;
    }
}
