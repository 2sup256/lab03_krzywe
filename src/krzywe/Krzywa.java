package krzywe;

import java.util.ArrayList;

public class Krzywa {

    // Dokladnosc
    public static final double dokladnosc = 0.0001;
    // Ilosc punktów kontrolnych
    public int n = 3;

    // Punkty
    public int[] x = new int[n+1];
    public int[] y = new int[n+1];

    public Krzywa() {
        // Poczatkowe punkty
        x[0] = 162; y[0] = 254;
        x[1] = 527; y[1] = 440;
        x[2] = 361; y[2] = 59;
        x[3] = 538; y[3] = 277;

        Main.krzywe.add(this);
    }

    public Krzywa(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        x[0] = x1;
        x[1] = x2;
        x[2] = x3;
        x[3] = x4;
        y[0] = y1;
        y[1] = y2;
        y[2] = y3;
        y[3] = y4;

        Main.krzywe.add(this);
    }

}
