package krzywe;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Krzywa> krzywe = new ArrayList<>();

    public static void main(String[] args) {
        // Wygenrowane przez program i wklejone na sztywno by nie odczytywac z pliku
        new Krzywa(589, 162, 601, 158, 612, 153, 621, 150);
        new Krzywa(621, 150, 617, 119, 580, 85, 539, 88);
        new Krzywa(435, 142, 462, 106, 489, 89, 540, 88);
        new Krzywa(435, 142, 402, 196, 414, 287, 483, 298);
        new Krzywa(435, 142, 402, 196, 414, 287, 483, 298);
        new Krzywa(483, 297, 552, 316, 628, 303, 624, 210);
        new Krzywa(519, 210, 520, 217, 519, 226, 519, 235);
        new Krzywa(519, 210, 520, 217, 519, 226, 519, 235);
        new Krzywa(519, 237, 562, 238, 579, 238, 591, 237);
        new Krzywa(519, 237, 562, 238, 579, 238, 591, 237);
        new Krzywa(592, 238, 588, 268, 542, 279, 499, 265);
        new Krzywa(592, 238, 588, 268, 542, 279, 499, 265);
        new Krzywa(459, 170, 438, 214, 455, 256, 500, 266);
        new Krzywa(460, 170, 477, 107, 572, 101, 589, 162);
        new Krzywa(289, 162, 301, 158, 312, 153, 321, 150);
        new Krzywa(321, 150, 319, 119, 280, 85, 239, 88);
        new Krzywa(135, 142, 162, 106, 189, 89, 240, 88);
        new Krzywa(135, 142, 102, 196, 114, 287, 183, 298);
        new Krzywa(135, 142, 102, 196, 114, 287, 183, 298);
        new Krzywa(183, 297, 252, 316, 328, 303, 324, 210);
        new Krzywa(219, 210, 220, 217, 219, 226, 219, 235);
        new Krzywa(219, 210, 220, 217, 219, 226, 219, 235);
        new Krzywa(219, 237, 262, 238, 279, 238, 291, 237);
        new Krzywa(219, 237, 262, 238, 279, 238, 291, 237);
        new Krzywa(292, 238, 288, 268, 242, 279, 199, 265);
        new Krzywa(292, 238, 288, 268, 242, 279, 199, 265);
        new Krzywa(159, 170, 138, 214, 155, 256, 200, 266);
        new Krzywa(160, 170, 177, 107, 272, 101, 289, 162);
        new Krzywa(520, 210, 562, 209, 589, 209, 625, 210);
        new Krzywa(219, 210, 263, 208, 286, 210, 325, 209);






        JFrame window = new JFrame();
        window.setTitle("Benzier Inicja??y");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);

        WindowPanel panel = new WindowPanel();
        panel.setSize(window.getWidth(), window.getHeight());

        window.add(panel);
        window.setVisible(true);
    }
}
