package net.codejava.sql;


import java.awt.*;
import javax.swing.JComponent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class Tabledraw extends JComponent {

    private class Table {
        ArrayList<String> s;
        int noCol;
        int c;
        Frame f;

        public Table() {
            s = null;
            noCol = 0;
            c = 0;
            f=null;
        }


        public Table(ArrayList<String> s, int noCol, int c,Frame f) {
            this.s = s;
            this.noCol = noCol;
            this.c = c;
            this.f=f;
        }
    }

    public Table table = new Table();

    public void createTable(ArrayList<String> s, int noCol, int c,Frame f) {
        table = new Table(s, noCol, c,f);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.BLACK);
        int y = 0;
        for (int i = 0; i < table.s.size(); i += table.noCol) {
            int x = 0;
            for (int j = 0; j < table.noCol; j++) {
                if (j == 0 && table.c == 1) {
                    JButton button = new JButton();
                    button.setText(table.s.get(i + j));
                    button.setPreferredSize(new Dimension(150, 20));
                    button.setSize(button.getPreferredSize());
                    button.setBorderPainted(false);
                    button.addActionListener(new JumpToMove(table.f));
                    this.add(button);
                    button.setLocation(x, y + 5);
                    x += 160;
                    g.drawLine(x, y, x, y + 30);
                } else {
                    JLabel Label = new JLabel();
                    if (j != 1 || table.c==0) {
                        if (table.s.get(i + j).equals("1") && table.c==1) {
                            Label.setText("-");
                        } else {
                            Label.setText(table.s.get(i + j));
                        }
                        if(table.s.get(i+j).equals("0%"))
                        {
                            Label.setText("Only One");
                        }
                        Font f = Label.getFont();
                        Label.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
                        Label.setSize(80, 30);

                    }
                    else
                    {
                        ImageIcon img=new ImageIcon(new ImageIcon(table.s.get(i+j).toLowerCase()+".gif").getImage().getScaledInstance(60, 20, Image.SCALE_DEFAULT));
                                //new ImageIcon(table.s.get(i+j).toLowerCase()+".gif");
                        Label.setIcon(img);
                        Label.setSize(80, 30);
                    }
                    this.add(Label);
                    Label.setLocation(x + 5, y);
                    x += 80;
                    g.drawLine(x, y, x, y + 30);
                }
            }
            y += 30;
            g.drawLine(0, y, x, y);
        }
    }
}
