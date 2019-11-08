package hr.fer.oop.lab3.prob1;

public class DrawTriangleWithBorder {

    public static void main(String[] args) {
        int[][] testTriangle = {{10, 10, 5}, {50, 50, 25}, {100, 100, 50}};

        for (int[] test : testTriangle) {
            BorderedPicture p = new BorderedPicture(test[0], test[1]);
            EquilateralTriangle t = new EquilateralTriangle(test[2]);

            t.drawOnPicture(p);
            p.renderImageToStream(System.out);
        }
    }
}
