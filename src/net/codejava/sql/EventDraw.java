package net.codejava.sql;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class EventDraw extends JComponent {
    private class TableE {
        ArrayList<String> Data;
        Frame f;
        public TableE() {
            Data = null;
            f=null;
        }

        public TableE(ArrayList<String> Data,Frame F) {
            this.Data = Data;
            f=F;
        }
    }

    public EventDraw.TableE table = new EventDraw.TableE();

    public void createTable(ArrayList<String> s,Frame f) {
        table = new EventDraw.TableE(s,f);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 0;
        for (int i = 0; i < table.Data.size(); i += 5) {
            int x = 0;
            for (int j = 0; j < 5; j++) {
                JButton button = new JButton();

                if(!table.Data.get(i+j).equals("Struggle")) {

                    if(j==0)
                    {
                        button.setText(table.Data.get(i+j));
                        button.setPreferredSize(new Dimension(150, 20));
                        button.addActionListener(new JumpToMon(table.f));
                        button.setSize(button.getPreferredSize());
                        button.setBorderPainted(false);
                        this.add(button);
                        button.setLocation(x, y + 5);
                    }
                    else
                    {
                        button.setText(table.Data.get(i+j));
                        button.setPreferredSize(new Dimension(150, 20));
                        button.addActionListener(new JumpToMove(table.f));
                        button.setSize(button.getPreferredSize());
                        button.setBorderPainted(false);
                        this.add(button);
                        button.setLocation(x, y + 5);

                    }

                }
                    x += 160;
                    g.drawLine(x, y, x, y + 30);
            }
            y += 30;
            g.drawLine(0, y, x, y);
        }
    }

}
