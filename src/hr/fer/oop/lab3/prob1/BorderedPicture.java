package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;

public class BorderedPicture extends Picture {

    public BorderedPicture(int width, int height) {
        super(width + 2, height + 2);
        addBorder();
    }

    public void addBorder() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (i == 0 || j == 0 || i == this.getHeight() - 1 || j == this.getWidth() - 1) {
                    turnPixelOn(i, j);
                }
            }
        }
    }


}
