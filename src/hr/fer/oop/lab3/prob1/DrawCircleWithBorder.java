package hr.fer.oop.lab3.prob1;

public class DrawCircleWithBorder {

    public static void main(String[] args) {
        int[][] testCircle = {{10, 10, 3}, {50, 50, 15}, {100, 100, 25}};

        for (int[] test : testCircle) {
            BorderedPicture p = new BorderedPicture(test[0], test[1]);
            Circle c = new Circle(test[2]);

            c.drawOnPicture(p);
            p.renderImageToStream(System.out);
        }
    }
}
