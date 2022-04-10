package krzywe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WindowPanel extends JPanel {
//    public static HashMap<Integer, HashMap<Integer, Double>> newtonbuffer = new HashMap<>();

    Krzywa selectedKrzywa = null;
    int selectedPoint = -1;

    public WindowPanel() {


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mX = e.getX();
                int mY = e.getY();

                if (e.getButton() == MouseEvent.BUTTON1) {
                    double bestKrzywa = -1;
                    double dist = 0.0;
                    for (Krzywa kr : Main.krzywe) {
                        for (int i = 0; i <= kr.n; i++) {
                            dist = (mY - kr.y[i]) * (mY - kr.y[i]) + (mX - kr.x[i]) * (mX - kr.x[i]);

                            if (dist < bestKrzywa || bestKrzywa == -1) {
                                bestKrzywa = dist;
                                selectedKrzywa = kr;
                            }
                        }
                    }
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    Krzywa nkr = new Krzywa();

                    nkr.x[0] = mX+10;
                    nkr.x[1] = mX+20;
                    nkr.x[2] = mX+30;
                    nkr.x[3] = mX+40;

                    nkr.y[0] = mY + 10;
                    nkr.y[1] = mY+20;
                    nkr.y[2] = mY+30;
                    nkr.y[3] = mY+40;

                } else if (selectedKrzywa != null) {
                    if (selectedPoint == -1) {
                        double dist = 0;
                        double bestDist = -1;
                        for (int i = 0; i <= selectedKrzywa.n; i++) {
                            dist = (mY - selectedKrzywa.y[i]) * (mY - selectedKrzywa.y[i]) + (mX - selectedKrzywa.x[i]) * (mX - selectedKrzywa.x[i]);

                            if (dist < bestDist || bestDist == -1) {
                                bestDist = dist;
                                selectedPoint = i;
                            }
                        }
                        System.out.println("Selected point: " + selectedPoint);
                    } else {

                        System.out.println("Selected point: " + selectedPoint + " moved.");
                        selectedKrzywa.x[selectedPoint] = mX;
                        selectedKrzywa.y[selectedPoint] = mY;

                        FileWriter data = null;
                        try {
                            data = new FileWriter("data.txt");
                            for (Krzywa kr : Main.krzywe) {
                                data.write("new Krzywa("+kr.x[0]+", "+kr.y[0]+", "+kr.x[1]+", "+kr.y[1]+", "+kr.x[2]+", "+kr.y[2]+", "+kr.x[3]+", "+kr.y[3]+");\n");
                            }
                            data.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }


                        selectedPoint = -1;
                    }
                }

                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);


        long time = System.currentTimeMillis();
        for (Krzywa kr : Main.krzywe) {

            for (int i = 0; i <= kr.n; i++) {
                if (selectedKrzywa == kr) {
                    if (i == selectedPoint) {
                        g2.setColor(Color.YELLOW);
                    } else {
                        g2.setColor(Color.BLUE);
                    }
                } else {
                    g2.setColor(Color.BLACK);
                }
                g2.fillRect(kr.x[i], kr.y[i], 5, 5);
            }


            if (selectedKrzywa != kr) {
                g2.setColor(Color.BLACK);
            } else {
                g2.setColor(Color.GREEN);
            }


            for (double t = 0; t <= 1; t += Krzywa.dokladnosc) {

                double px = 0;
                double py = 0;
                for (int i = 0; i <= kr.n; i++) {
                    px += (newton(kr.n, i) * Math.pow(1 - t, kr.n - i) * Math.pow(t, i) * kr.x[i]);
                    py += (newton(kr.n, i) * Math.pow(1 - t, kr.n - i) * Math.pow(t, i) * kr.y[i]);
                }


                g2.drawLine((int) px, (int) py, (int) px, (int) py);

            }
        }

        System.out.println("Time: "+(System.currentTimeMillis() - time)+" ms");

    }

    public double newton(int nad, int pod) {
        // Nieefektywne przy malej ilosci zmiennych
//        HashMap<Integer, Double> buffer = newtonbuffer.get(nad);
//        if (buffer ==  null) {
//            buffer = new HashMap<>();
//        }
//
//        Double buff = buffer.get(pod);
//        if (buff == null) {
//            buff = (double) silnia(nad) / (silnia(pod) * silnia(nad - pod));
//
//            buffer.put(pod, buff);
//            newtonbuffer.put(nad, buffer);
//        }

        double buff = (double) silnia(nad) / (silnia(pod) * silnia(nad - pod));

        return buff;
    }

    public static int silnia (int n) {
        int iloczyn = 1;
        for (int i=1; i<=n; i++) {
            iloczyn *= i;
        }
        return iloczyn;
    }
}
