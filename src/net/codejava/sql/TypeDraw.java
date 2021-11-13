package net.codejava.sql;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TypeDraw extends JComponent {

    private class TableT {
        ArrayList<String> s;
        ArrayList<Double> d;

        public TableT() {
            s = null;
            d=null;
        }


        public TableT(ArrayList<String> s, ArrayList<Double> d) {
            this.s = s;
            this.d = d;
        }
    }

    public TypeDraw.TableT table = new TypeDraw.TableT();

    public void createTable(ArrayList<String> s, ArrayList<Double> d) {
        table = new TypeDraw.TableT(s, d);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.BLACK);
        int x = 0;
        for (int i = 0; i < 17; i ++) {

            JLabel Label1 = new JLabel();
            ImageIcon img=new ImageIcon(new ImageIcon(table.s.get(i).toLowerCase()+".gif").getImage().getScaledInstance(40, 20, Image.SCALE_DEFAULT));
            Label1.setIcon(img);
            Label1.setPreferredSize(new Dimension(50, 30));
            Label1.setSize(Label1.getPreferredSize());

            JLabel Label2=new JLabel();
            Label2.setText("X"+String.valueOf(table.d.get(i)));
            Font f = Label2.getFont();
            Label2.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
            Label2.setPreferredSize(new Dimension(50, 30));
            Label2.setSize(Label2.getPreferredSize());

            this.add(Label1);
            this.add(Label2);

            Label1.setLocation(x + 5, 0);
            Label2.setLocation(x+5,30);
            x+=50;
            g.drawLine(x, 0, x, 60);
        }
        g.drawLine(0,30,x,30);

    }

}
