package net.codejava.sql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JumpToMon implements ActionListener {
    Frame frame;
    Connection c;

    public JumpToMon() {
    }

    public JumpToMon(Frame x) {
        this.frame = x;
    }

    public void actionPerformed(ActionEvent e) {
        JButton source=(JButton)e.getSource();
        String url= "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
        try(Connection connection = DriverManager.getConnection(url)) {
            try(Statement statement = connection.createStatement()){
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.showPokemon(source.getText(),connection);
            }
        } catch (SQLException er) {
            System.err.println(1);
        }
    }
}