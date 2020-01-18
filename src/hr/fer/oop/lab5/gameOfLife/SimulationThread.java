package hr.fer.oop.lab5.gameOfLife;

public class SimulationThread extends Thread {
    private boolean stopping = false;
    private Board board;

    public SimulationThread(Board board){
        this.board = board;
    }

    @Override
    public void run () {
        while (!stopping){
            board.playOneIteration();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void setStopping(){ stopping = true; }
}
