package net.codejava.sql;


import java.awt.*;
import javax.swing.JComponent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class PokemonTypeSearch extends JComponent {

    private class TablePT {
        ArrayList<String> s;
        Frame f;
        public TablePT() {
            s = null;
            f=null;
        }

        public TablePT(ArrayList<String> s,Frame F) {
            this.s = s;
            f=F;
        }
    }

    public TablePT table = new TablePT();

    public void createTable(ArrayList<String> s,Frame f) {
        table = new TablePT(s,f);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 0;
        for (int i = 0; i < table.s.size(); i += 4) {
            int x = 0;
            for (int j = 0; j < 4; j++) {
                if (j == 1) {
                    JButton button = new JButton();
                    button.setText(table.s.get(i + j));
                    button.setPreferredSize(new Dimension(150, 20));
                    button.addActionListener(new JumpToMon(table.f));
                    button.setSize(button.getPreferredSize());
                    button.setBorderPainted(false);
                    this.add(button);
                    button.setLocation(x, y + 5);
                    x += 160;
                    g.drawLine(x, y, x, y + 30);
                } else {
                    JLabel Label = new JLabel();
                    if (j == 0 ) {
                        Label.setText(table.s.get(i + j));
                        Font f = Label.getFont();
                        Label.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
                        Label.setSize(80, 30);
                    }
                    else
                    {
                        if(!table.s.get(i+j).equals("Nothing")) {
                            String[] type =new String[17];
                            type[0]="normal";
                            type[1]="fighting";
                            type[2]="flying";
                            type[3]="poison";
                            type[4]="ground";
                            type[5]="rock";
                            type[6]="bug";
                            type[7]="ghost";
                            type[8]="steel";
                            type[9]="fire";
                            type[10]="water";
                            type[11]="grass";
                            type[12]="electric";
                            type[13]="psychic";
                            type[14]="ice";
                            type[15]="dragon";
                            type[16]="dark";
                            ImageIcon img = new ImageIcon(new ImageIcon(type[Integer.parseInt(table.s.get(i + j))] + ".gif").getImage().getScaledInstance(60, 20, Image.SCALE_DEFAULT));
                            Label.setIcon(img);
                            Label.setSize(80, 30);
                        }
                        else
                        {
                            Label.setText("");
                            Label.setSize(80, 30);
                        }
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
