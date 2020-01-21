package hr.fer.oop.lab5.gameOfLife;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class BoardFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final int BOARD_HEIGHT = 30;
    private static final int BOARD_WIDTH = 30;

    private JButton playButton, stopButton, iterationButton, resetButton, saveButton, loadButton;
    private JToggleButton buttons[][];
    private Board board;
    private SimulationThread thread;

    public BoardFrame () {
        JPanel buttonPanel = new JPanel();

        playButton = new JButton("Pokreni");
        buttonPanel.add(playButton);
        playButton.addActionListener(e -> {
            thread = new SimulationThread(board);
            playButton.setEnabled(false);
            stopButton.setEnabled(true);
            iterationButton.setEnabled(false);
            thread.start();
        });


        stopButton = new JButton("Zaustavi");
        stopButton.setEnabled(false);
        buttonPanel.add(stopButton);
        stopButton.addActionListener(e -> {
            thread.setStopping();
            playButton.setEnabled(true);
            stopButton.setEnabled(false);
            iterationButton.setEnabled(true);
        });


        iterationButton = new JButton("Jedna iteracija");
        buttonPanel.add(iterationButton);
        iterationButton.addActionListener(e -> {
            board.playOneIteration();
        });


        resetButton = new JButton("Resetiraj");
        buttonPanel.add(resetButton);
        resetButton.addActionListener(e -> {
            board.resetBoard();
        });


        saveButton = new JButton("Save");
        buttonPanel.add(saveButton);
        saveButton.addActionListener(e -> {
            JFileChooser save = new JFileChooser();
            int returnVal = save.showSaveDialog(BoardFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = save.getSelectedFile();
                    board.saveBoard(file);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        loadButton = new JButton("Load");
        buttonPanel.add(loadButton);
        loadButton.addActionListener(e -> {
            JFileChooser load = new JFileChooser();
            int returnVal = load.showOpenDialog(BoardFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = load.getSelectedFile();
                    board.loadBoard(file);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        add(buttonPanel , BorderLayout.NORTH);

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
            frame.setVisible(true);
            frame.pack();
        });
    }

}
