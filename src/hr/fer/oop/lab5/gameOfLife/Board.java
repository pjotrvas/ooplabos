package hr.fer.oop.lab5.gameOfLife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private int width;
    private int height;

    private boolean cells[][];
    private boolean nextCells[][];
    private List<BoardListener> listeners;

    public Board(int width, int height){
        if (width <= 0) throw new IllegalArgumentException("Width must be greater than 0!");
        if (height <= 0) throw new IllegalArgumentException("Height must be greater than 0!");

        this.width = width;
        this.height = height;
        cells = new boolean[width][height];
        nextCells = new boolean[width][height];
        listeners = new LinkedList <>();
    }

    private int normalizeX(int x) {
        int result = x;
        while(result < 0)
            result += width;

        return result % width;
    }

    private int normalizeY(int y) {
        int result = y;
        while(result < 0)
            result += height;

        return result % height;
    }

    public boolean isCellAlive( int x, int y){
        int normalizedX = normalizeX(x);
        int normalizedY = normalizeY(y);
        return cells[normalizedX][normalizedY];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public void setCell(int x, int y, boolean alive){
        int normalizedX = normalizeX(x);
        int normalizedY = normalizeY(y);
        cells[normalizedX][normalizedY] = alive;
    }


    public int countAliveNeighbors(int x, int y) {
        int result = 0;

        if(isCellAlive(x-1, y-1)) result++;
        if(isCellAlive(x  , y-1)) result++;
        if(isCellAlive(x+1, y-1)) result++;

        if(isCellAlive(x-1, y  )) result++;
        if(isCellAlive(x+1, y  )) result++;

        if(isCellAlive(x-1, y+1)) result++;
        if(isCellAlive(x  , y+1)) result++;
        if(isCellAlive(x+1, y+1)) result++;

        return result;
    }

    public void playOneIteration(){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                nextCells[x][y] = Rule.futureOf(isCellAlive(x, y), countAliveNeighbors(x, y));
            }
        }

        boolean tempCells[][] = nextCells;
        nextCells = cells;
        cells = tempCells;

        listeners.forEach(l -> l.boardChanged(this));
    }


    public void addListener(BoardListener listener) {
        listeners.add(listener);
    }

    public void removeListener(BoardListener listener) {
        listeners.remove(listener);
    }

    public void resetBoard() {
        for (int y=0;y<height;y++) {
            for (int x=0;x<width;x++) {
                nextCells[x][y] = false;
            }
        }
        boolean tempCells[][] = nextCells;
        nextCells = cells;
        cells = tempCells;
        listeners.forEach(listener -> listener.boardChanged(this));
    }

    public void loadBoard(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            String line;
            int y=0;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                String[] parts = line.split(",");
                int x=0;
                for (String part : parts) {
                    if (part.equals("true")) {
                        nextCells[x][y] = true;
                    } else {
                        nextCells[x][y] = false;
                    }
                    x++;
                }

                stringBuffer.append("\n");
                sb.append("\n");
                y++;
            }
            fileReader.close();
            boolean tempCells[][] = nextCells;
            nextCells = cells;
            cells = tempCells;
            listeners.forEach(listener -> listener.boardChanged(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBoard(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (int y=0; y<height; y++) {
                for (int x=0; x<width; x++) {
                    if (isCellAlive(x, y)) {
                        bw.write("true,");
                    } else {
                        bw.write("false,");
                    }
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
