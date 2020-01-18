package hr.fer.oop.lab5.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class BoardFrame extends JFrame {
    private static final int BOARD_HEIGHT = 30;
    public static final int  BOARD_WIDTH = 30;

    private JButton btnPlay, btnStop, btnTick;
    private JToggleButton buttons[][];
    private Board board;
    private SimulationThread simulationThread;

    public BoardFrame(){
        JPanel buttonPanel = new JPanel();

        btnPlay = new JButton("POKRENI");
        buttonPanel.add(btnPlay);
        btnPlay.addActionListener((e) -> {
            simulationThread = new SimulationThread(board);
            btnPlay.setEnabled(false);
            btnStop.setEnabled(true);
            btnTick.setEnabled(false);
            simulationThread.start();
        });

        btnStop = new JButton("ZAUSTAVI");
        btnStop.setEnabled(false);
        buttonPanel.add(btnStop);
        btnStop.addActionListener((e) -> {
            simulationThread.setStopping();
            btnPlay.setEnabled(true);
            btnStop.setEnabled(false);
            btnTick.setEnabled(true);
        });

        btnTick = new JButton("Jedna iteracija");
        buttonPanel.add(btnTick);
        btnTick.addActionListener((e) -> {
            board.playOneIteration();
        });

        add(buttonPanel, BorderLayout.NORTH);

        initializeButtonAndBoard();
    }

    private void initializeButtonAndBoard () {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        buttons = new JToggleButton[BOARD_WIDTH][BOARD_HEIGHT];
        JPanel boardPanel = new JPanel();
        add(boardPanel, BorderLayout.CENTER);
        boardPanel.setLayout(new GridLayout(BOARD_WIDTH,BOARD_HEIGHT, 1, 1));

        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                JToggleButton toggleButton = new JToggleButton();
                toggleButton.setPreferredSize(new Dimension(20,20));
                buttons[x][y] = toggleButton;
                Point point = new Point(x, y);
                toggleButton.addActionListener((e) -> {
                    if(((JToggleButton)e.getSource()).isSelected()) {
                        board.setCell((int)point.getX(), (int)point.getY(), true);
                    } else {
                        board.setCell((int)point.getX(), (int)point.getY(), false);
                    }
                });
                    boardPanel.add(toggleButton);
            }
        }

        board.addListener((b) -> {
            boolean cells[][] = new boolean[BOARD_WIDTH][BOARD_HEIGHT];
            for (int y = 0; y < BOARD_HEIGHT; y++) {
                for (int x = 0; x < BOARD_WIDTH; x++) {
                    cells[x][y] = b.isCellAlive(x, y);
                }
            }

            SwingUtilities.invokeLater(() -> {
                for (int y = 0; y < BOARD_HEIGHT; y++) {
                    for (int x = 0; x < BOARD_WIDTH; x++) {
                        buttons[x][y].setSelected(cells[x][y]);
                    }
                }
            });
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoardFrame frame = new BoardFrame();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

}
