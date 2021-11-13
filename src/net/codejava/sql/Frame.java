package net.codejava.sql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class Frame extends JFrame {

    JTextField TF1,TF2,TF3,TF4,TF5;

    public Frame(){
        this.setSize(980, 800);

        this.setLayout(new BorderLayout(20, 0));

        Toolkit T = Toolkit.getDefaultToolkit();

        Dimension D = T.getScreenSize();

        int xCord = (D.width / 2) - (this.getWidth() / 2);//location
        int yCord = (D.height / 2) - (this.getHeight() / 2);

        this.setLocation(xCord, yCord);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.start();

        this.setVisible(true);
    }

    public void start()
    {
        JPanel start = new JPanel(null);
        start.setPreferredSize(start.getPreferredSize());
        this.setTitle("Starting");

        JButton SPokemon = new JButton();
        SPokemon.setText("Search for Pokémon");
        SPokemon.setSize(200, 30);
        ListenForPSearch LPS=new ListenForPSearch(this);
        SPokemon.addActionListener(LPS);
        start.add(SPokemon);
        SPokemon.setLocation(350, 330);

        JButton SMove = new JButton();
        SMove.setText("Search for Move");
        SMove.setSize(200, 30);
        SMove.addActionListener(new ListenForMSearch(this));
        start.add(SMove);
        SMove.setLocation(350, 380);

        JButton Event = new JButton();
        Event.setText("Show events");
        Event.setSize(200, 30);
        Event.addActionListener(new ListenForEvent(this));
        start.add(Event);
        Event.setLocation(350, 430);

        JLabel Title= new JLabel();
        Font labelFont = Title.getFont();
        String labelText = Title.getText();
        Title.setText("Pokédex for Pokémon Emerald");
        Title.setSize(Title.getPreferredSize());
        Title.setSize(Title.getWidth(),30);
        int stringWidth = Title.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = Title.getWidth();
        double widthRatio = (double)componentWidth / (double)stringWidth;
        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = Title.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        Title.setFont(new Font(labelFont.getName(), Font.BOLD, fontSizeToUse));
        Title.setSize(Title.getPreferredSize());
        start.add(Title);
        Title.setLocation(250,100);

        this.add(start);
        this.validate();
    }

    public void searchPokemon()
    {
        JPanel sp = new JPanel(null);
        sp.setPreferredSize(sp.getPreferredSize());
        this.setTitle("Search for Pokémon");

        JButton SName = new JButton();
        SName.setText("Search by Name");
        ListenForName LN=new ListenForName(this);
        SName.addActionListener(LN);
        SName.setSize(200, 30);
        sp.add(SName);
        SName.setLocation(350, 330);

        JButton SNumber = new JButton();
        SNumber.setText("Search by Number");
        SNumber.setSize(200, 30);
        ListenForNumber LNr=new ListenForNumber(this);
        SNumber.addActionListener(LNr);
        sp.add(SNumber);
        SNumber.setLocation(350, 380);

        JButton SType = new JButton();
        SType.setText("Search By Type");
        SType.setSize(200, 30);
        ListenForType LT=new ListenForType(this);
        SType.addActionListener(LT);
        sp.add(SType);
        SType.setLocation(350,430);

        JButton Back = new JButton();
        Back.setText("Go Back");
        ListenForBack1 LB=new ListenForBack1(this);
        Back.addActionListener(LB);
        Back.setSize(200, 30);
        sp.add(Back);
        Back.setLocation(350,480);

        this.add(sp);
        this.validate();

    }

    public void PokémonSearch(){
        JPanel psn=new JPanel(null);

        TF1=new JTextField();
        TF1.setSize(200,30);
        psn.add(TF1);
        TF1.setLocation(350,340);

        JButton Search = new JButton();
        Search.setText("Search");
        Search.setSize(200, 30);
        ListenForPNSearch PNS=new ListenForPNSearch(this);
        Search.addActionListener(PNS);
        psn.add(Search);
        Search.setLocation(350,390);

        JButton Back = new JButton();
        Back.setText("Go Back");
        ListenForBack2 LB=new ListenForBack2(this);
        Back.addActionListener(LB);
        Back.setSize(200, 30);
        psn.add(Back);
        Back.setLocation(350,440);

        this.add(psn);
        this.validate();

    }

    public void PokémonNumberSearch(){
        JPanel psnr=new JPanel(null);

        TF1=new JTextField();
        TF1.setSize(200,30);
        psnr.add(TF1);
        TF1.setLocation(350,340);

        JButton Search = new JButton();
        Search.setText("Search");
        Search.setSize(200, 30);
        ListenForPNrSearch PNrS=new ListenForPNrSearch(this);
        Search.addActionListener(PNrS);
        psnr.add(Search);
        Search.setLocation(350,390);

        JButton Back = new JButton();
        Back.setText("Go Back");
        ListenForBack2 LB=new ListenForBack2(this);
        Back.addActionListener(LB);
        Back.setSize(200, 30);
        psnr.add(Back);
        Back.setLocation(350,440);

        this.add(psnr);
        this.validate();

    }

    public void PokémonTypeSearch(){
        JPanel pst=new JPanel(null);

        JLabel Type1=new JLabel("Type 1");
        Type1.setSize(Type1.getPreferredSize());
        pst.add(Type1);
        Type1.setLocation(320,320);

        TF1=new JTextField();
        TF1.setSize(200,30);
        pst.add(TF1);
        TF1.setLocation(240,340);

        JLabel Type2=new JLabel("Type 2");
        Type2.setSize(Type1.getPreferredSize());
        pst.add(Type2);
        Type2.setLocation(540,320);

        TF2=new JTextField();
        TF2.setSize(200,30);
        pst.add(TF2);
        TF2.setLocation(460,340);

        JButton Search = new JButton();
        Search.setText("Search");
        Search.setSize(200, 30);
        Search.addActionListener(new ListenForTSearch(this));
        pst.add(Search);
        Search.setLocation(350,390);

        JButton Back = new JButton();
        Back.setText("Go Back");
        ListenForBack2 LB=new ListenForBack2(this);
        Back.addActionListener(LB);
        Back.setSize(200, 30);
        pst.add(Back);
        Back.setLocation(350,440);

        this.add(pst);
        this.validate();

    }

    public void moveSearch(){
        JPanel sn = new JPanel(null);
        sn.setPreferredSize(sn.getPreferredSize());
        this.setTitle("Search for Move");

        JButton SName = new JButton();
        SName.setText("Search by Name");
        SName.addActionListener(new ListenForMName(this));
        SName.setSize(200, 30);
        sn.add(SName);
        SName.setLocation(350, 330);

        JButton SType = new JButton();
        SType.setText("Search By Type");
        SType.setSize(200, 30);
        SType.addActionListener(new ListenForMType(this));
        sn.add(SType);
        SType.setLocation(350,380);

        JButton Back = new JButton();
        Back.setText("Go Back");
        ListenForBack1 LB=new ListenForBack1(this);
        Back.addActionListener(LB);
        Back.setSize(200, 30);
        sn.add(Back);
        Back.setLocation(350,430);

        this.add(sn);
        this.validate();

    }

    public void moveNameSearch() {
        JPanel psn=new JPanel(null);

        TF1=new JTextField();
        TF1.setSize(200,30);
        psn.add(TF1);
        TF1.setLocation(350,340);

        JButton Search = new JButton();
        Search.setText("Search");
        Search.setSize(200, 30);
        Search.addActionListener(new ListenForMNSearch(this));
        psn.add(Search);
        Search.setLocation(350,390);

        JButton Back = new JButton();
        Back.setText("Go Back");
        ListenForBack3 LB=new ListenForBack3(this);
        Back.addActionListener(LB);
        Back.setSize(200, 30);
        psn.add(Back);
        Back.setLocation(350,440);

        this.add(psn);
        this.validate();
    }

    public void moveTypeSearch() {
        JPanel psn=new JPanel(null);

        TF1=new JTextField();
        TF1.setSize(200,30);
        psn.add(TF1);
        TF1.setLocation(350,340);

        JButton Search = new JButton();
        Search.setText("Search");
        Search.setSize(200, 30);
        Search.addActionListener(new ListenForMTSearch(this));
        psn.add(Search);
        Search.setLocation(350,390);

        JButton Back = new JButton();
        Back.setText("Go Back");
        ListenForBack3 LB=new ListenForBack3(this);
        Back.addActionListener(LB);
        Back.setSize(200, 30);
        psn.add(Back);
        Back.setLocation(350,440);

        this.add(psn);
        this.validate();
    }



    void showPokemonTypes(int t1,int t2,Connection connection)
    {
        try(Statement statement = connection.createStatement()) {
            String sql;
            if(t2==0)
            {
                 sql = "SELECT * from Pokemon.Pokemons\n" +
                         "where Type1="+t1+" OR Type2="+ t1+"\n"+
                 "Order by PId";
            }
            else
            {
                sql="SELECT * from Pokemon.Pokemons\n" +
                        "where (Type1="+t1+"AND Type2="+t2+") OR (Type1="+t2+" AND Type2="+t1+")\n"+
                        "Order by PId";
            }
            ResultSet result=statement.executeQuery(sql);
            if(result.next())
            {
                ArrayList<String> data=new ArrayList<String>();
                data.add(String.valueOf(result.getInt("PId")));
                data.add(result.getString("PName"));
                int type1=result.getInt("Type1")-1;
                data.add(String.valueOf(type1));
                int type2=result.getInt("Type2")-1;
                if(type2!=-1)
                {
                    data.add(String.valueOf(type2));
                }
                else
                {
                    data.add("Nothing");
                }
                while(result.next())
                {
                    data.add(String.valueOf(result.getInt("PId")));
                    data.add(result.getString("PName"));
                    type1=result.getInt("Type1")-1;
                    data.add(String.valueOf(type1));
                    type2=result.getInt("Type2")-1;
                    if(type2!=-1)
                    {
                        data.add(String.valueOf(type2));
                    }
                    else
                    {
                        data.add("Nothing");
                    }
                }
                JPanel TSearch=new JPanel(null);

                PokemonTypeSearch Ptest=new PokemonTypeSearch();
                Ptest.createTable(data,this);
                Ptest.setPreferredSize(new Dimension(320,data.size()*30/4));
                JScrollPane S=new JScrollPane(Ptest);
                S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                S.setPreferredSize(new Dimension(420,300));
                S.setSize(S.getPreferredSize());
                TSearch.add(S);
                JButton back=new JButton();
                back.setText("Back");
                back.setSize(back.getPreferredSize());
                back.addActionListener(new ListenForBack2(this));
                TSearch.add(back);
                back.setLocation(0,310);

                this.add(TSearch);

            }
            else
            {
                JPanel notFound=new JPanel(null);
                JLabel nothing=new JLabel("No pokemon has this type combination");
                nothing.setSize(nothing.getPreferredSize());
                notFound.add(nothing);
                nothing.setLocation(0,0);
                JButton back=new JButton();
                back.setText("Back");
                back.addActionListener(new ListenForBack2(this));
                notFound.add(back);
                back.setSize(back.getPreferredSize());
                back.setLocation(0,20);
                notFound.setSize(notFound.getPreferredSize());
                this.add(notFound);
            }
            this.validate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void showPokemon(String s,Connection connection){

        this.setTitle(s);
        try(Statement statement = connection.createStatement()){
            String sql= "Select * from Pokemon.Pokemons " +
                    "where PName LIKE '"+s+"'";

            try(ResultSet result = statement.executeQuery(sql)){
                if(result.next()) {

                    JPanel pokemonPanel = new JPanel(null);
                    pokemonPanel.setSize(pokemonPanel.getPreferredSize());

                    JLabel Title= new JLabel();
                    Font labelFont = Title.getFont();
                    String labelText = Title.getText();
                    Title.setText(String.valueOf("#"+result.getInt("Pid"))+" "+result.getString("PName"));
                    Title.setSize(Title.getPreferredSize());
                    Title.setSize(Title.getWidth(),30);
                    int stringWidth = Title.getFontMetrics(labelFont).stringWidth(labelText);
                    int componentWidth = Title.getWidth();
                    double widthRatio = (double)componentWidth / (double)stringWidth;
                    int newFontSize = (int)(labelFont.getSize() * widthRatio);
                    int componentHeight = Title.getHeight();
                    int fontSizeToUse = Math.min(newFontSize, componentHeight);
                    Title.setFont(new Font(labelFont.getName(), Font.BOLD, fontSizeToUse));
                    Title.setSize(Title.getPreferredSize());
                    pokemonPanel.add(Title);

                    ArrayList<String> StatsTable=new ArrayList<String>();
                    StatsTable.add("HP");
                    StatsTable.add(String.valueOf(result.getInt("HP")));
                    StatsTable.add("Atk");
                    StatsTable.add(String.valueOf(result.getInt("Atk")));
                    StatsTable.add("Def");
                    StatsTable.add(String.valueOf(result.getInt("Def")));
                    StatsTable.add("SpAtk");
                    StatsTable.add(String.valueOf(result.getInt("SpAtk")));
                    StatsTable.add("SpDef");
                    StatsTable.add(String.valueOf(result.getInt("SpDef")));
                    StatsTable.add("Spd");
                    StatsTable.add(String.valueOf(result.getInt("Spd")));
                    StatsTable.add("Total");
                    int sum=result.getInt("HP")+result.getInt("Atk")+result.getInt("Def")+result.getInt("SpAtk")+result.getInt("SpDef")+result.getInt("Spd");
                    StatsTable.add(String.valueOf(sum));
                    Tabledraw Stats=new Tabledraw();
                    Stats.createTable(StatsTable,2,0,this);
                    Stats.setPreferredSize(new Dimension(160,200));
                    Stats.setSize(Stats.getPreferredSize());
                    JScrollPane Scroll=new JScrollPane(Stats);
                    Scroll.setSize(163,210);
                    Scroll.setLocation(300,50);
                    pokemonPanel.add(Scroll);

                    JLabel Pokemon=new JLabel();
                    ImageIcon PImg;
                    int pid=result.getInt("PId");
                    if(pid<10) {
                        PImg = new ImageIcon(new ImageIcon("Spr_3e_00"+pid+".png").getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
                    }
                    else
                    {
                        if (pid<100) {
                            PImg = new ImageIcon(new ImageIcon("Spr_3e_0"+pid+".png").getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
                        }
                        else {
                            PImg = new ImageIcon(new ImageIcon("Spr_3e_"+pid+".png").getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
                        }
                    }
                    Pokemon.setIcon(PImg);
                    Pokemon.setPreferredSize(new Dimension(128,128));
                    Pokemon.setSize(Pokemon.getPreferredSize());
                    pokemonPanel.add(Pokemon);
                    Pokemon.setLocation(30,Title.getHeight()+40);

                    int T1=result.getInt("Type1");
                    String T2=String.valueOf(result.getInt("Type2"));

                    sql="SELECT TName from Pokemon.Types\n"+
                            "Where Tid="+T1;
                    ResultSet t1=statement.executeQuery(sql);
                    JLabel Type1=new JLabel();
                    t1.next();
                    ImageIcon img1=new ImageIcon(new ImageIcon(t1.getString("TName").toLowerCase()+".gif").getImage().getScaledInstance(40, 20, Image.SCALE_DEFAULT));
                    Type1.setIcon(img1);
                    Type1.setPreferredSize(new Dimension(50, 30));
                    Type1.setSize(Type1.getPreferredSize());
                    pokemonPanel.add(Type1);
                    Type1.setLocation(50,250);

                    if(T2!=null)
                    {
                        sql="SELECT TName from Pokemon.Types\n"+
                                "Where Tid="+T2;
                        ResultSet t2=statement.executeQuery(sql);
                        JLabel Type2=new JLabel();
                        if(t2.next()) {
                            ImageIcon img2 = new ImageIcon(new ImageIcon(t2.getString("TName").toLowerCase() + ".gif").getImage().getScaledInstance(40, 20, Image.SCALE_DEFAULT));
                            Type2.setIcon(img2);
                            Type2.setPreferredSize(new Dimension(50, 30));
                            Type2.setSize(Type2.getPreferredSize());
                            pokemonPanel.add(Type2);
                            Type2.setLocation(100, 250);
                        }
                    }

                    sql="SELECT AName,Description,OverworldEffect from Pokemon.Abilities\n" +
                            "join Pokemon.Pokemons P on Abilities.AId = P.PAbility1\n" +
                            "where P.PName like '"+s+"'";
                    int a2y=0;
                    ResultSet ability1=statement.executeQuery(sql);
                    if(ability1.next())
                    {
                        JLabel A1=new JLabel("Ability1: ");
                        A1.setSize(A1.getPreferredSize());
                        pokemonPanel.add(A1);
                        A1.setLocation(475,50);

                        JLabel AName1=new JLabel(ability1.getString("AName"));
                        AName1.setSize(AName1.getPreferredSize());
                        pokemonPanel.add(AName1);
                        AName1.setLocation(475+A1.getWidth(),50);

                        JLabel AEffect1=new JLabel(ability1.getString("Description"));
                        AEffect1.setSize(AEffect1.getPreferredSize());
                        pokemonPanel.add(AEffect1);
                        AEffect1.setLocation(475,50+A1.getHeight());

                        if(475+AEffect1.getWidth()>pokemonPanel.getPreferredSize().width)
                        {
                            pokemonPanel.setPreferredSize(new Dimension(475+AEffect1.getWidth(),pokemonPanel.getHeight()));
                        }

                        a2y=AEffect1.getHeight()+A1.getHeight()+50;

                        String OE=ability1.getString("OverworldEffect");
                        if(OE!=null)
                        {
                            JLabel AOE1=new JLabel(OE);
                            AOE1.setSize(AOE1.getPreferredSize());
                            pokemonPanel.add(AOE1);
                            AOE1.setLocation(475,a2y);

                            if(475+AOE1.getWidth()>pokemonPanel.getPreferredSize().width)
                            {
                                pokemonPanel.setPreferredSize(new Dimension(475+AOE1.getWidth(),pokemonPanel.getHeight()));
                            }

                            a2y+=AOE1.getHeight();
                        }
                    }

                    sql="SELECT AName,Description,OverworldEffect from Pokemon.Abilities\n" +
                            "join Pokemon.Pokemons P on Abilities.AId = P.PAbility2\n" +
                            "where P.PName like '"+s+"'";
                    ResultSet ability2=statement.executeQuery(sql);
                    if(ability2.next())
                    {
                        a2y+=10;

                        JLabel A2=new JLabel("Ability2: ");
                        A2.setSize(A2.getPreferredSize());
                        pokemonPanel.add(A2);
                        A2.setLocation(475,a2y);

                        JLabel AName2=new JLabel(ability2.getString("AName"));
                        AName2.setSize(AName2.getPreferredSize());
                        pokemonPanel.add(AName2);
                        AName2.setLocation(475+A2.getWidth(),a2y);

                        JLabel AEffect2=new JLabel(ability2.getString("Description"));
                        AEffect2.setSize(AEffect2.getPreferredSize());
                        pokemonPanel.add(AEffect2);
                        AEffect2.setLocation(475,a2y+A2.getHeight());

                        if(475+AEffect2.getWidth()>pokemonPanel.getPreferredSize().width)
                        {
                            pokemonPanel.setPreferredSize(new Dimension(475+AEffect2.getWidth(),pokemonPanel.getHeight()));
                        }

                        String OE=ability2.getString("OverworldEffect");
                        if(OE!=null)
                        {
                            JLabel AOE2=new JLabel(OE);
                            AOE2.setSize(AOE2.getPreferredSize());
                            pokemonPanel.add(AOE2);
                            AOE2.setLocation(475,a2y+A2.getHeight()+AEffect2.getHeight());

                            if(475+AOE2.getWidth()>pokemonPanel.getPreferredSize().width)
                            {
                                pokemonPanel.setPreferredSize(new Dimension(475+AOE2.getWidth(),pokemonPanel.getHeight()));
                            }
                        }
                    }


                    sql="Select TName,[W/S].Multyplier from Pokemon.Types\n" +
                            "JOIN Pokemon.[Weak/Strong] [W/S] on Types.Tid = [W/S].Type1\n" +
                            "where [W/S].Type2="+T1;
                    ArrayList <String> Types=new ArrayList<String>();
                    ArrayList <Double> val=new ArrayList<Double>();
                    ResultSet set1=statement.executeQuery(sql);
                    while (set1.next())
                    {
                        Types.add(set1.getString("TName"));
                        val.add(set1.getDouble("Multyplier"));
                    }

                    if(T2!=null) {
                        sql = "Select TName,[W/S].Multyplier from Pokemon.Types\n" +
                                "JOIN Pokemon.[Weak/Strong] [W/S] on Types.Tid = [W/S].Type1\n" +
                                "where [W/S].Type2=" + T2;
                        ResultSet set2 = statement.executeQuery(sql);
                        if (set2.next()) {
                            int i = 0;
                            val.set(i,val.get(i)*set2.getDouble("Multyplier"));
                            i++;
                            while (set2.next()) {
                                val.set(i,val.get(i)*set2.getDouble("Multyplier"));
                                i++;
                            }
                        }
                    }

                    TypeDraw TTable=new TypeDraw();
                    TTable.createTable(Types,val);
                    TTable.setPreferredSize(new Dimension(850,60));
                    JScrollPane ST=new JScrollPane(TTable);
                    ST.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    ST.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                    ST.setPreferredSize(new Dimension(850,60));
                    ST.setSize(ST.getPreferredSize());
                    pokemonPanel.add(ST);
                    ST.setLocation(0,290);

                    int y=380;
                    int x=0;
                    int si=1;

                    sql="SELECT Pokemon1 from Pokemon.Evolutions\n" +
                            "where Pokemon2="+pid;
                    int[][] evo=new int [6][4];
                    int start=0;

                    ResultSet backevo=statement.executeQuery(sql);
                    if(backevo.next())
                    {
                        start++;
                        int be1=backevo.getInt("Pokemon1");
                        sql="SELECT Pokemon1 from Pokemon.Evolutions\n" +
                                "where Pokemon2="+be1;
                        backevo=statement.executeQuery(sql);
                        if(backevo.next())
                        {
                            start++;
                            evo[0][start-2]=backevo.getInt("Pokemon1");
                        }
                        evo[0][start-1]=be1;
                    }
                    evo[0][start]=pid;

                    sql="SELECT Pokemon2 from Pokemon.Evolutions\n" +
                            "where Pokemon1="+pid;
                    int end=start;
                    int nobranches=0;
                    int split=0;

                    ResultSet forwardevo=statement.executeQuery(sql);
                    while(forwardevo.next())
                    {
                        evo[nobranches][end+1]=forwardevo.getInt("Pokemon2");
                        if(nobranches!=0 && split==0)
                        {
                            split=end;
                        }
                        nobranches++;
                    }
                    if(nobranches!=0)
                    {
                        end++;
                        if(nobranches==1)
                        {
                            sql="SELECT Pokemon2 from Pokemon.Evolutions\n" +
                                    "where Pokemon1="+evo[0][end];
                            forwardevo=statement.executeQuery(sql);
                            int nobranches2=0;
                            while(forwardevo.next())
                            {
                                evo[nobranches2][end+1]=forwardevo.getInt("Pokemon2");
                                if(nobranches!=0 && split==0)
                                {
                                    split=end;
                                }
                                nobranches2++;
                            }
                            if(nobranches2!=0)
                            {
                                end++;
                            }
                            if(nobranches2>nobranches)
                            {
                                nobranches=nobranches2;
                            }
                        }
                        else
                        {
                            int ok=0;
                            for(int i=0;i<nobranches;i++)
                            {
                                sql="SELECT Pokemon2 from Pokemon.Evolutions\n" +
                                        "where Pokemon1="+evo[i][end];
                                forwardevo=statement.executeQuery(sql);
                                if(forwardevo.next())
                                {
                                    evo[i][end+1]=forwardevo.getInt("Pokemon2");
                                    ok=1;
                                }
                            }
                            if(ok==1)
                            {
                                end++;
                            }
                        }
                    }
                    int startx;
                    for(int i=0;i<nobranches || i==0;i++)
                    {
                        startx=50;
                        for(int j=0;j<=end;j++)
                        {
                            int evoid;
                            if(j<=split)
                            {
                                evoid=evo[0][j];
                            }
                            else
                            {
                                evoid=evo[i][j];
                            }
                            if(j!=0)
                            {
                                JLabel arrow=new JLabel("--------------------------------------------------------------->");
                                arrow.setSize(arrow.getPreferredSize());
                                pokemonPanel.add(arrow);
                                arrow.setLocation(startx,y-25);


                                if(j<=split+1) {
                                    sql = "SELECT Method,ELevel,Item,Special_Cond from Pokemon.Evolutions\n" +
                                            "where Pokemon2=" + evoid+" AND Pokemon1="+evo[0][j-1];
                                }
                                else {
                                    sql = "SELECT Method,ELevel,Item,Special_Cond from Pokemon.Evolutions\n" +
                                            "where Pokemon2=" + evoid+" AND Pokemon1="+evo[i][j-1];
                                }

                                ResultSet evoifo=statement.executeQuery(sql);
                                if(evoifo.next()) {
                                    JLabel evoinformation=new JLabel();
                                    String evom = evoifo.getString("Method");
                                    String moreinfo;
                                    String specialinfo=evoifo.getString("Special_Cond");
                                    if(evom.equals("Level"))
                                    {
                                        moreinfo=String.valueOf(evoifo.getInt("ELevel"));
                                        if(moreinfo!=null)
                                        {
                                            evoinformation.setText("LV "+moreinfo);
                                            if(specialinfo!=null)
                                            {
                                                evoinformation.setText("LV "+moreinfo+", "+specialinfo);
                                            }
                                        }
                                        else
                                        {
                                            evoinformation.setText("LV up with "+specialinfo);
                                        }
                                    }
                                    if(evom.equals("Friendship"))
                                    {
                                        if(specialinfo!=null)
                                        {
                                            evoinformation.setText("Lv up with Max Friendship during "+specialinfo);
                                        }
                                        else
                                        {
                                            evoinformation.setText("Lv up with Max Friendship");
                                        }
                                    }
                                    if(evom.equals("Item"))
                                    {
                                        sql="SELECT IName from Pokemon.Items \n"+
                                                "where IId="+evoifo.getInt("Item");
                                        ResultSet item=statement.executeQuery(sql);
                                        if(item.next())
                                        {
                                            evoinformation.setText("Give "+item.getString("IName"));
                                        }
                                    }
                                    if(evom.equals("Trade"))
                                    {
                                        String itemid=String.valueOf(evoifo.getString("Item"));
                                        if(itemid!=null) {
                                            sql = "SELECT IName from Pokemon.Items \n" +
                                                    "where IId=" + evoifo.getInt("Item");
                                            ResultSet item = statement.executeQuery(sql);
                                            if (item.next()) {
                                                evoinformation.setText("Trade holding " + item.getString("IName"));
                                            }
                                        }
                                        else
                                        {
                                            evoinformation.setText("Trade");
                                        }
                                    }
                                    evoinformation.setSize(evoinformation.getPreferredSize());
                                    pokemonPanel.add(evoinformation);
                                    evoinformation.setLocation(startx,y-25+arrow.getHeight());
                                }
                                startx+=arrow.getPreferredSize().width;

                            }
                            JLabel evoL=new JLabel();
                            ImageIcon PEvo;
                            if(evoid<10) {
                                PEvo = new ImageIcon(new ImageIcon("Spr_3e_00"+evoid+".png").getImage().getScaledInstance(65,65, Image.SCALE_DEFAULT));
                            }
                            else
                            {
                                if (evoid<100) {
                                    PEvo = new ImageIcon(new ImageIcon("Spr_3e_0"+evoid+".png").getImage().getScaledInstance(65,65, Image.SCALE_DEFAULT));
                                }
                                else {
                                    PEvo = new ImageIcon(new ImageIcon("Spr_3e_"+evoid+".png").getImage().getScaledInstance(65,65, Image.SCALE_DEFAULT));
                                }
                            }
                            evoL.setIcon(PEvo);
                            evoL.setPreferredSize(new Dimension(65,65));
                            evoL.setSize(Pokemon.getPreferredSize());
                            pokemonPanel.add(evoL);
                            evoL.setLocation(startx,y-65);

                            sql = "Select PName from Pokemon.Pokemons " +
                                    "where PId="+evoid;
                            ResultSet evoifo=statement.executeQuery(sql);
                            evoifo.next();

                            JButton selPokemon=new JButton();
                            selPokemon=new JButton(evoifo.getString("PName"));
                            pokemonPanel.add(selPokemon);
                            selPokemon.setSize(selPokemon.getPreferredSize());
                            selPokemon.setLocation(startx,y+30);
                            selPokemon.addActionListener(new JumpToMon(this));

                            startx+=65;
                        }
                        y+=90;

                    }


                    sql="Select MName,TName,Method,LLevel from Pokemon.LearningMoves\n"+
                    "join Pokemon.Moves M on M.Mid = LearningMoves.MoveLearned\n"+
                    "join Pokemon.Types T on T.Tid = M.MType\n"+
                            "join Pokemon.Pokemons P on P.Pid = LearningMoves.Learner\n" +
                            "where PName LIKE '"+s+"'\n" +
                            "ORDER BY LLevel,Method";
                    try(ResultSet result2 = statement.executeQuery(sql)){
                        String Header1[]={"Move Name","Move Type","Level"};
                        String Header2[]={"Move Name","Move Type"};

                        ArrayList <String> val1= new ArrayList<String>();
                        ArrayList <String> val2= new ArrayList<String>();
                        ArrayList <String> val3= new ArrayList<String>();
                        ArrayList <String> val4= new ArrayList<String>();
                        ArrayList <String> val5= new ArrayList<String>();

                        while (result2.next())
                        {
                            if(result2.getString("Method").equals("Level"))
                            {
                                val1.add(result2.getString("MName"));
                                val1.add(result2.getString("TName"));
                                val1.add(String.valueOf(result2.getInt("LLevel")));
                            }
                            else
                            {
                                if(result2.getString("Method").equals("TM"))
                                {
                                    val2.add(result2.getString("MName"));
                                    val2.add(result2.getString("TName"));
                                }
                                else
                                {
                                    if(result2.getString("Method").equals("Move Tutor")){
                                        val3.add(result2.getString("MName"));
                                        val3.add(result2.getString("TName"));
                                    }
                                    else
                                    {
                                        if(result2.getString("Method").equals("Breeding")){
                                            val4.add(result2.getString("MName"));
                                            val4.add(result2.getString("TName"));
                                        }
                                        else
                                        {
                                            if(result2.getString("Method").equals("Special")){
                                                val5.add(result2.getString("MName"));
                                                val5.add(result2.getString("TName"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(val1.size()!=0) {
                            JLabel label=new JLabel("Moves learned by leveling");
                            label.setSize(label.getPreferredSize());
                            pokemonPanel.add(label);
                            label.setLocation(x+10,y-20);

                            Tabledraw Ptest=new Tabledraw();
                            Ptest.createTable(val1,3,1,this);
                            Ptest.setPreferredSize(new Dimension(315,val1.size()*30/3));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(340,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=400;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            pokemonPanel.add(S);
                            this.validate();
                        }
                        if(val2.size()!=0) {
                            JLabel label=new JLabel("Moves learned by TM");
                            label.setSize(label.getPreferredSize());
                            pokemonPanel.add(label);
                            label.setLocation(x+10,y-20);
                            Tabledraw Ptest=new Tabledraw();
                            Ptest.createTable(val2,2,1,this);
                            Ptest.setPreferredSize(new Dimension(240,val2.size()*30/2));
                            Ptest.setSize(Ptest.getPreferredSize());
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(260,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=400;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            pokemonPanel.add(S);
                            this.validate();
                        }
                        if(val3.size()!=0) {
                            JLabel label=new JLabel("Moves learned from Move Tutor");
                            label.setSize(label.getPreferredSize());
                            pokemonPanel.add(label);
                            label.setLocation(x+10,y-20);
                            Tabledraw Ptest=new Tabledraw();
                            Ptest.createTable(val3,2,1,this);
                            Ptest.setPreferredSize(new Dimension(240,val3.size()*30/2));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(260,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=400;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            pokemonPanel.add(S);
                            this.validate();
                        }
                        if(val4.size()!=0) {
                            JLabel label=new JLabel("Egg Moves");
                            label.setSize(label.getPreferredSize());
                            pokemonPanel.add(label);
                            label.setLocation(x+10,y-20);
                            Tabledraw Ptest=new Tabledraw();
                            Ptest.createTable(val4,2,1,this);
                            Ptest.setPreferredSize(new Dimension(240,val4.size()*30/2));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(260,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=400;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            pokemonPanel.add(S);
                            this.validate();
                        }
                        if(val5.size()!=0) {
                            JLabel label=new JLabel("Moves learned only in other games");
                            label.setSize(label.getPreferredSize());
                            pokemonPanel.add(label);
                            label.setLocation(x+10,y-20);
                            Tabledraw Ptest=new Tabledraw();
                            Ptest.createTable(val5,2,1,this);
                            Ptest.setPreferredSize(new Dimension(240,val5.size()*30/2));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(260,100);
                            S.setLocation(x,y);
                            y += 150;
                            x=0;
                            si=1;
                            Component[] comp = pokemonPanel.getComponents();
                            for (int i = 0;i<comp.length;i++) {
                                if (comp[i] instanceof JButton) {
                                    //add action listener for noves
                                }
                            }
                            pokemonPanel.add(S);
                            this.validate();
                        }
                        if(si==2)
                        {
                            y+=150;
                            x=0;
                        }

                    }
                    sql="Select LName,EMName,EncounterPercentage,Min_Level,Max_Level from Pokemon.Location\n" +
                            "join Pokemon.Encounters E on Location.Lid = E.EcounterLocation\n" +
                            "join Pokemon.EncounterMethod EM on EM.EMId = E.EncounterMethod\n" +
                            "join Pokemon.Pokemons P on P.Pid = E.EcounterPokemon\n" +
                            "where PName like '"+s+"'";
                    ResultSet set3=statement.executeQuery(sql);
                    JLabel Encounters=new JLabel();
                    Encounters.setText("Locations where you can find this Pokémon:");
                    Encounters.setSize(Encounters.getPreferredSize());
                    pokemonPanel.add(Encounters);
                    Encounters.setLocation(0,y);
                    y+=30;

                    if(set3.next())
                    {
                        ArrayList<String> EncountersList=new ArrayList<String>();
                        EncountersList.add(set3.getString("LName"));
                        EncountersList.add(set3.getString("EMName"));
                        EncountersList.add(set3.getInt("EncounterPercentage") +"%");
                        EncountersList.add(String.valueOf(set3.getInt("Min_Level")));
                        EncountersList.add(String.valueOf(set3.getInt("Max_Level")));
                        while(set3.next())
                        {
                            EncountersList.add(set3.getString("LName"));
                            EncountersList.add(set3.getString("EMName"));
                            EncountersList.add(set3.getInt("EncounterPercentage") +"%");
                            EncountersList.add(String.valueOf(set3.getInt("Min_Level")));
                            EncountersList.add(String.valueOf(set3.getInt("Max_Level")));
                        }
                        Tabledraw Ptest=new Tabledraw();
                        Ptest.createTable(EncountersList,5,0,this);
                        Ptest.setPreferredSize(new Dimension(400,EncountersList.size()*30/5));
                        JScrollPane S=new JScrollPane(Ptest);
                        S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                        S.setSize(400,100);
                        S.setLocation(0,y);
                        y+=130;
                        pokemonPanel.add(S);
                    }
                    else
                    {
                        JLabel notFound=new JLabel();
                        notFound.setText("Trade from another game");
                        notFound.setSize(notFound.getPreferredSize());
                        pokemonPanel.add(notFound);
                        notFound.setLocation(0,y-20);
                        int ok=0;
                        for(int i=0;i<nobranches || i==0;i++)
                        {
                            for(int j=0;j<=end;j++)
                            {
                                if(evo[i][j]!=0) {
                                    sql = "Select EncounterMethod from Pokemon.Encounters\n" +
                                            "where EcounterPokemon=" + evo[i][j];
                                    ResultSet checkLoc = statement.executeQuery(sql);
                                    if (checkLoc.next()) {
                                        ok = 1;
                                        if (j > start) {
                                            sql = "Select PName from Pokemon.Pokemons\n" +
                                                    "where Pid=" + evo[i][j];
                                            checkLoc=statement.executeQuery(sql);
                                            checkLoc.next();
                                            notFound.setText("Breed "+checkLoc.getString("PName"));
                                        }
                                        else
                                        {
                                            sql = "Select PName from Pokemon.Pokemons\n" +
                                                    "where Pid=" + evo[i][j];
                                            checkLoc=statement.executeQuery(sql);
                                            checkLoc.next();
                                            notFound.setText("Evolve "+checkLoc.getString("PName"));
                                        }
                                        i=nobranches;
                                        j=end+1;
                                    }
                                }
                            }
                        }

                    }


                    JButton back=new JButton();
                    back.setText("Back");
                    back.addActionListener(new ListenForBack2(this));
                    back.setSize(back.getPreferredSize());
                    pokemonPanel.add(back);
                    back.setLocation(0,y);
                    y+=20;

                    JScrollPane newScroll=new JScrollPane(pokemonPanel);
                    pokemonPanel.setPreferredSize(new Dimension(pokemonPanel.getPreferredSize().width,y));
                    pokemonPanel.setSize(pokemonPanel.getPreferredSize());
                    newScroll.setPreferredSize(this.getSize());
                    newScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    newScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    this.add(newScroll);
                    this.validate();
                }

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showMove(String s,Connection connection)
    {
        this.setTitle(s);
        try(Statement statement=connection.createStatement()) {
            String sql= "Select * from Pokemon.Moves " +
                    "where MName LIKE '"+s+"'";
            try(ResultSet result = statement.executeQuery(sql)) {
                if (result.next()) {
                    JPanel movePanel=new JPanel(null);
                    movePanel.setSize(movePanel.getPreferredSize());

                    JLabel Title= new JLabel();
                    Font labelFont = Title.getFont();
                    String labelText = Title.getText();
                    Title.setText(result.getString("MName"));
                    Title.setSize(Title.getPreferredSize());
                    Title.setSize(Title.getWidth(),30);
                    int stringWidth = Title.getFontMetrics(labelFont).stringWidth(labelText);
                    int componentWidth = Title.getWidth();
                    double widthRatio = (double)componentWidth / (double)stringWidth;
                    int newFontSize = (int)(labelFont.getSize() * widthRatio);
                    int componentHeight = Title.getHeight();
                    int fontSizeToUse = Math.min(newFontSize, componentHeight);
                    Title.setFont(new Font(labelFont.getName(), Font.BOLD, fontSizeToUse));
                    Title.setSize(Title.getPreferredSize());
                    movePanel.add(Title);

                    int mid=result.getInt("MId");
                    int pp=result.getInt("MPP");
                    String acc=String.valueOf(result.getInt("MAccuracy"));
                    String power=String.valueOf(result.getInt("MPower"));
                    String desc=result.getString("MDescription");
                    int T=result.getInt("MType");

                    JLabel Label1=new JLabel("Type: ");
                    Label1.setSize(Label1.getPreferredSize());
                    movePanel.add(Label1);
                    Label1.setLocation(0,50);

                    sql="SELECT TName from Pokemon.Types\n"+
                            "Where Tid="+T;
                    ResultSet t1=statement.executeQuery(sql);
                    JLabel Type1=new JLabel();
                    t1.next();
                    ImageIcon img1=new ImageIcon(new ImageIcon(t1.getString("TName").toLowerCase()+".gif").getImage().getScaledInstance(40, 20, Image.SCALE_DEFAULT));
                    Type1.setIcon(img1);
                    Type1.setPreferredSize(new Dimension(50, 30));
                    Type1.setSize(Type1.getPreferredSize());
                    movePanel.add(Type1);
                    Type1.setLocation(40,45);

                    JLabel Label2=new JLabel("Power points: "+pp);
                    Label2.setSize(Label2.getPreferredSize());
                    movePanel.add(Label2);
                    Label2.setLocation(100,50);

                    JLabel Label3=new JLabel();
                    if(power!=null)
                    {
                        Label3.setText("Base Power: "+power);
                    }
                    else
                    {
                        Label3.setText("Base Power: N/A");
                    }
                    movePanel.add(Label3);
                    Label3.setSize(Label3.getPreferredSize());
                    Label3.setLocation(210,50);

                    JLabel Label4=new JLabel();
                    if(acc!=null)
                    {
                        Label4.setText("Accuracy: "+acc+"%");
                    }
                    else
                    {
                        Label4.setText("Accuracy: N/A");
                    }
                    movePanel.add(Label4);
                    Label4.setSize(Label4.getPreferredSize());
                    Label4.setLocation(320,50);

                   // JLabel Description=new JLabel();
                   // Description.setSize(Description.getPreferredSize());
                   // movePanel.add(Description);
                   // Description.setLocation(0,80);

                    JTextArea textArea = new JTextArea(2, 300);
                    textArea.setText(desc);
                    textArea.setWrapStyleWord(true);
                    textArea.setLineWrap(true);
                    textArea.setOpaque(false);
                    textArea.setEditable(false);
                    textArea.setFocusable(false);
                    textArea.setBackground(UIManager.getColor("Label.background"));
                    textArea.setFont(UIManager.getFont("Label.font"));
                    textArea.setBorder(UIManager.getBorder("Label.border"));
                    textArea.setSize(new Dimension(800,60));
                    movePanel.add(textArea);
                    textArea.setLocation(0,80);

                    int y=150;
                    sql="SELECT Pid,PName,Type1,Type2,Method from Pokemon.Pokemons\n" +
                            "join Pokemon.LearningMoves LM on Pokemons.Pid = LM.Learner\n" +
                            "join Pokemon.Moves M on M.Mid = LM.MoveLearned\n" +
                            "where MName LIKE '"+s+"'\n" +
                            "ORDER BY Method,Pid";
                    try(ResultSet result2 = statement.executeQuery(sql)){

                        ArrayList <String> val1= new ArrayList<String>();
                        ArrayList <String> val2= new ArrayList<String>();
                        ArrayList <String> val3= new ArrayList<String>();
                        ArrayList <String> val4= new ArrayList<String>();
                        ArrayList <String> val5= new ArrayList<String>();

                        while (result2.next())
                        {
                            if(result2.getString("Method").equals("Level"))
                            {
                                val1.add(String.valueOf(result2.getInt("PId")));
                                val1.add(result2.getString("PName"));
                                val1.add(String.valueOf(result2.getInt("Type1")-1));
                                int type2=result2.getInt("Type2")-1;
                                if(type2!=-1)
                                {
                                    val1.add(String.valueOf(type2));
                                }
                                else
                                {
                                    val1.add("Nothing");
                                }
                            }
                            else
                            {
                                if(result2.getString("Method").equals("TM"))
                                {
                                    val2.add(String.valueOf(result2.getInt("PId")));
                                    val2.add(result2.getString("PName"));
                                    val2.add(String.valueOf(result2.getInt("Type1")-1));
                                    int type2=result2.getInt("Type2")-1;
                                    if(type2!=-1)
                                    {
                                        val2.add(String.valueOf(type2));
                                    }
                                    else
                                    {
                                        val2.add("Nothing");
                                    }
                                }
                                else
                                {
                                    if(result2.getString("Method").equals("Move Tutor")){
                                        val3.add(String.valueOf(result2.getInt("PId")));
                                        val3.add(result2.getString("PName"));
                                        val3.add(String.valueOf(result2.getInt("Type1")-1));
                                        int type2=result2.getInt("Type2")-1;
                                        if(type2!=-1)
                                        {
                                            val3.add(String.valueOf(type2));
                                        }
                                        else
                                        {
                                            val3.add("Nothing");
                                        }
                                    }
                                    else
                                    {
                                        if(result2.getString("Method").equals("Breeding")){
                                            val4.add(String.valueOf(result2.getInt("PId")));
                                            val4.add(result2.getString("PName"));
                                            val4.add(String.valueOf(result2.getInt("Type1")-1));
                                            int type2=result2.getInt("Type2")-1;
                                            if(type2!=-1)
                                            {
                                                val4.add(String.valueOf(type2));
                                            }
                                            else
                                            {
                                                val4.add("Nothing");
                                            }
                                        }
                                        else
                                        {
                                            if(result2.getString("Method").equals("Special")){
                                                val5.add(String.valueOf(result2.getInt("PId")));
                                                val5.add(result2.getString("PName"));
                                                val5.add(String.valueOf(result2.getInt("Type1")-1));
                                                int type2=result2.getInt("Type2")-1;
                                                if(type2!=-1)
                                                {
                                                    val5.add(String.valueOf(type2));
                                                }
                                                else
                                                {
                                                    val5.add("Nothing");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        int x=0;
                        int si=1;
                        if(val1.size()!=0) {
                            JLabel label=new JLabel("Pokemon that learn by leveling");
                            label.setSize(label.getPreferredSize());
                            movePanel.add(label);
                            label.setLocation(x+10,y-20);

                            PokemonTypeSearch Ptest=new PokemonTypeSearch();
                            Ptest.createTable(val1,this);
                            Ptest.setPreferredSize(new Dimension(320,val1.size()*30/4));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(420,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=450;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            movePanel.add(S);
                            this.validate();
                        }
                        if(val2.size()!=0) {
                            JLabel label=new JLabel("Pokemon that learn by TM");
                            label.setSize(label.getPreferredSize());
                            movePanel.add(label);
                            label.setLocation(x+10,y-20);

                            PokemonTypeSearch Ptest=new PokemonTypeSearch();
                            Ptest.createTable(val2,this);
                            Ptest.setPreferredSize(new Dimension(320,val2.size()*30/4));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(420,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=450;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            movePanel.add(S);
                            this.validate();
                        }
                        if(val3.size()!=0) {
                            JLabel label=new JLabel("Pokemon that learn from Move Tutor");
                            label.setSize(label.getPreferredSize());
                            movePanel.add(label);
                            label.setLocation(x+10,y-20);

                            PokemonTypeSearch Ptest=new PokemonTypeSearch();
                            Ptest.createTable(val3,this);
                            Ptest.setPreferredSize(new Dimension(320,val3.size()*30/4));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(420,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=450;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            movePanel.add(S);
                            this.validate();
                        }
                        if(val4.size()!=0) {
                            JLabel label=new JLabel("Pokemon that learn from Egg Moves");
                            label.setSize(label.getPreferredSize());
                            movePanel.add(label);
                            label.setLocation(x+10,y-20);

                            PokemonTypeSearch Ptest=new PokemonTypeSearch();
                            Ptest.createTable(val4,this);
                            Ptest.setPreferredSize(new Dimension(320,val4.size()*30/4));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(420,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=450;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            movePanel.add(S);
                            this.validate();
                        }
                        if(val5.size()!=0) {
                            JLabel label=new JLabel("Pokemon that learn in other games");
                            label.setSize(label.getPreferredSize());
                            movePanel.add(label);
                            label.setLocation(x+10,y-20);

                            PokemonTypeSearch Ptest=new PokemonTypeSearch();
                            Ptest.createTable(val5,this);
                            Ptest.setPreferredSize(new Dimension(320,val5.size()*30/4));
                            JScrollPane S=new JScrollPane(Ptest);
                            S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                            S.setSize(420,100);
                            S.setLocation(x,y);
                            if(si==1)
                            {
                                x+=450;
                                si=2;
                            }
                            else {
                                y += 150;
                                si=1;
                                x=0;
                            }
                            movePanel.add(S);
                            this.validate();
                        }
                        if(si==2)
                        {
                            y+=150;
                            x=0;
                        }

                    }

                    JButton back=new JButton();
                    back.setText("Back");
                    back.addActionListener(new ListenForBack3(this));
                    back.setSize(back.getPreferredSize());
                    movePanel.add(back);
                    back.setLocation(0,y);
                    y+=20;

                    this.add(movePanel);
                    this.validate();

                }

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    void showMoveTypes(int t1,Connection connection)
    {
        try(Statement statement = connection.createStatement()) {
            String sql;
            sql = "SELECT * from Pokemon.Moves\n" +
                        "where MType="+t1+
                        "Order by MName";
            ResultSet result=statement.executeQuery(sql);
            if(result.next())
            {
                ArrayList<String> data=new ArrayList<String>();
                data.add(result.getString("MName"));
                while(result.next())
                {
                    data.add(result.getString("MName"));
                }

                JPanel TSearch=new JPanel(null);

                Tabledraw Ptest=new Tabledraw();
                Ptest.createTable(data,1,1,this);
                Ptest.setPreferredSize(new Dimension(320,data.size()*30/4));
                JScrollPane S=new JScrollPane(Ptest);
                S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                S.setPreferredSize(new Dimension(150,300));
                S.setSize(S.getPreferredSize());
                TSearch.add(S);
                JButton back=new JButton();
                back.setText("Back");
                back.setSize(back.getPreferredSize());
                back.addActionListener(new ListenForBack3(this));
                TSearch.add(back);
                back.setLocation(0,310);

                this.add(TSearch);

            }
            else
            {
                JPanel notFound=new JPanel(null);
                JLabel nothing=new JLabel("No pokemon has this type combination");
                nothing.setSize(nothing.getPreferredSize());
                notFound.add(nothing);
                nothing.setLocation(0,0);
                JButton back=new JButton();
                back.setText("Back");
                back.addActionListener(new ListenForBack2(this));
                notFound.add(back);
                back.setSize(back.getPreferredSize());
                back.setLocation(0,20);
                notFound.setSize(notFound.getPreferredSize());
                this.add(notFound);
            }
            this.validate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void showEvents(){
        JPanel eventPanel=new JPanel(null);
        String url= "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
        try(Connection connection = DriverManager.getConnection(url)) {
            try(Statement statement = connection.createStatement()){
                String sql = "SELECT PName,M.MName as Move1,M2.MName as Move2,M3.MName as Move3,M4.MName as Move4 from Pokemon.Events\n" +
                        "join Pokemon.Pokemons P on P.Pid = Events.EPokemon\n" +
                        "join Pokemon.Moves M on M.Mid = Events.EMove1\n" +
                        "Join Pokemon.Moves M2 on M2.Mid = Events.EMove2\n" +
                        "join Pokemon.Moves M3 on M3.Mid = Events.EMove3\n" +
                        "JOIN Pokemon.Moves M4 on M4.Mid = Events.EMove4";
                try(ResultSet result = statement.executeQuery(sql)){
                    if(result.next())
                    {
                        ArrayList<String> eventData=new ArrayList<String>();
                        eventData.add(result.getString("PName"));
                        eventData.add(result.getString("Move1"));
                        eventData.add(result.getString("Move2"));
                        eventData.add(result.getString("Move3"));
                        eventData.add(result.getString("Move4"));

                        while (result.next())
                        {
                            eventData.add(result.getString("PName"));
                            eventData.add(result.getString("Move1"));
                            eventData.add(result.getString("Move2"));
                            eventData.add(result.getString("Move3"));
                            eventData.add(result.getString("Move4"));
                        }

                        EventDraw Ptest=new EventDraw();
                        Ptest.createTable(eventData,this);
                        Ptest.setPreferredSize(new Dimension(800,eventData.size()*30/5));
                        JScrollPane S=new JScrollPane(Ptest);
                        S.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        S.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                        S.setSize(800,500);
                        S.setLocation(90,0);

                        JButton back=new JButton("Go Back");
                        back.addActionListener(new ListenForBack1(this));
                        back.setSize(back.getPreferredSize());
                        eventPanel.add(back);
                        back.setLocation(500,520);

                        JButton add=new JButton("Add event");
                        add.addActionListener(new ListenForAdd(this));
                        add.setSize(add.getPreferredSize());
                        eventPanel.add(add);
                        add.setLocation(300,520);

                        TF1=new JTextField();
                        TF1.setSize(100,30);
                        eventPanel.add(TF1);
                        TF1.setLocation(190,580);

                        TF2=new JTextField();
                        TF2.setSize(100,30);
                        eventPanel.add(TF2);
                        TF2.setLocation(300,580);

                        TF3=new JTextField();
                        TF3.setSize(100,30);
                        eventPanel.add(TF3);
                        TF3.setLocation(410,580);

                        TF4=new JTextField();
                        TF4.setSize(100,30);
                        eventPanel.add(TF4);
                        TF4.setLocation(520,580);

                        TF5=new JTextField();
                        TF5.setSize(100,30);
                        eventPanel.add(TF5);
                        TF5.setLocation(630,580);

                        eventPanel.add(S);
                        this.add(eventPanel);
                        this.validate();

                    }
                }
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }


    private class ListenForPSearch implements ActionListener{
        Frame frame;
        private ListenForPSearch() {

        }
        private ListenForPSearch(Frame x) {
            this.frame=x;
        }
        public void actionPerformed(ActionEvent e){
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.searchPokemon();
        }
    }


    private class ListenForBack1 implements ActionListener {
        //activates when you "Back" button
        Frame frame;

        private ListenForBack1() {
        }

        private ListenForBack1(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.start();

        }
    }

    private class ListenForBack2 implements ActionListener {
        //activates when you "Back" button
        Frame frame;

        private ListenForBack2() {
        }

        private ListenForBack2(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.searchPokemon();

        }
    }

    private class ListenForBack3 implements ActionListener {
        //activates when you "Back" button
        Frame frame;

        private ListenForBack3() {
        }

        private ListenForBack3(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.moveSearch();

        }
    }

    private class ListenForName implements ActionListener{
        Frame frame;

        private ListenForName() {
        }

        private ListenForName(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.PokémonSearch();
        }
    }

    private class ListenForNumber implements ActionListener{
        Frame frame;

        private ListenForNumber() {
        }

        private ListenForNumber(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.PokémonNumberSearch();
        }
    }

    private class ListenForType implements ActionListener{
        Frame frame;

        private ListenForType() {
        }

        private ListenForType(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.PokémonTypeSearch();
        }
    }

    private class ListenForPNSearch implements ActionListener{
        Frame frame;

        private ListenForPNSearch() {
        }

        private ListenForPNSearch(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            JFrame x=new JFrame();
            String url= "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
            try(Connection connection = DriverManager.getConnection(url)) {
                try(Statement statement = connection.createStatement()){
                    String sql = "Select PName from Pokemon.Pokemons " +
                                 "where PName LIKE '"+TF1.getText()+"'";
                    try(ResultSet result = statement.executeQuery(sql)){
                        if(result.next())
                        {
                            frame.getContentPane().removeAll();
                            frame.repaint();
                            frame.showPokemon(TF1.getText(),connection);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(x, "Pokemon Not Found");
                        }
                    }
                }
            } catch (SQLException er) {
                System.err.println(1);
            }
        }
    }

    private class ListenForPNrSearch implements ActionListener{
        Frame frame;

        private ListenForPNrSearch() {
        }

        private ListenForPNrSearch(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            JFrame x=new JFrame();
            String url= "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
            try(Connection connection = DriverManager.getConnection(url)) {
                try(Statement statement = connection.createStatement()){
                    String sql = "Select PName from Pokemon.Pokemons " +
                            "where PId="+Integer.parseInt(TF1.getText());
                    try(ResultSet result = statement.executeQuery(sql)){
                        if(result.next())
                        {
                            frame.getContentPane().removeAll();
                            frame.repaint();
                            frame.showPokemon(result.getString("PName"),connection);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(x, "Pokemon Not Found");
                        }
                    }
                }
            } catch (SQLException er) {
                System.err.println(1);
            }
        }
    }

    private class ListenForTSearch implements ActionListener{
        Frame frame;

        private ListenForTSearch() {
        }

        private ListenForTSearch(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            JFrame x = new JFrame();
            String t1=TF1.getText();
            String t2=TF2.getText();
            if(t1.equals(""))
            {
                JOptionPane.showMessageDialog(x,"Type 1 can't be empty.");
            }
            else {
                if (t1.equals("Normal") || t1.equals("Fighting") || t1.equals("Flying") || t1.equals("Poison") || t1.equals("Ground") || t1.equals("Rock") || t1.equals("Bug") || t1.equals("Ghost") || t1.equals("Steel") || t1.equals("Fire") || t1.equals("Water") || t1.equals("Electric") || t1.equals("Psychic") || t1.equals("Ice") || t1.equals("Dragon") || t1.equals("Dark") || t1.equals("Grass")) {
                    String url = "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
                    try (Connection connection = DriverManager.getConnection(url)) {
                        try (Statement statement = connection.createStatement()) {
                            String sql = "Select Tid from Pokemon.Types " +
                                    "where TName LIKE '" + t1+"'";
                            try (ResultSet result = statement.executeQuery(sql)) {
                                if (result.next()) {
                                    int t1id=result.getInt("Tid");
                                    if(!t2.equals(""))
                                    {
                                        if(t2.equals("Normal") || t2.equals("Fighting") || t2.equals("Flying") || t2.equals("Poison") || t2.equals("Ground") || t2.equals("Rock") || t2.equals("Bug") || t2.equals("Ghost") || t2.equals("Steel") || t2.equals("Fire") || t2.equals("Water") || t2.equals("Electric") || t2.equals("Psychic") || t2.equals("Ice") || t2.equals("Dragon") || t2.equals("Dark") || t2.equals("Grass")) {
                                            sql = "Select Tid from Pokemon.Types " +
                                                    "where TName LIKE '" + t2+"'";
                                            ResultSet result2 = statement.executeQuery(sql);
                                            result2.next();
                                            int t2id = result2.getInt("Tid");
                                            frame.getContentPane().removeAll();
                                            frame.repaint();
                                            frame.showPokemonTypes(t1id,t2id,connection);
                                        }
                                        else
                                        {

                                            JOptionPane.showMessageDialog(x,"Type 2 is invalid");
                                        }
                                    }
                                    else
                                    {
                                        frame.getContentPane().removeAll();
                                        frame.repaint();
                                        frame.showPokemonTypes(t1id,0,connection);
                                    }
                                }
                            }
                        }
                    } catch (SQLException er) {
                        er.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(x,"Type 1 is invalid");
                }
            }
        }
    }

    private class ListenForMSearch implements ActionListener{
        Frame frame;
        private ListenForMSearch() {

        }
        private ListenForMSearch(Frame x) {
            this.frame=x;
        }
        public void actionPerformed(ActionEvent e){
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.moveSearch();
        }
    }

    private class ListenForMName implements ActionListener{
        Frame frame;

        private ListenForMName() {
        }

        private ListenForMName(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.moveNameSearch();
        }
    }

    private class ListenForMType implements ActionListener{
        Frame frame;

        private ListenForMType() {
        }

        private ListenForMType(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.moveTypeSearch();
        }
    }

    private class ListenForEvent implements ActionListener{
        Frame frame;

        private ListenForEvent() {
        }

        private ListenForEvent(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.showEvents();
        }
    }

    private class ListenForMNSearch implements ActionListener{
        Frame frame;

        private ListenForMNSearch() {
        }

        private ListenForMNSearch(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            JFrame x=new JFrame();
            String url= "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
            try(Connection connection = DriverManager.getConnection(url)) {
                try(Statement statement = connection.createStatement()){
                    String sql = "Select MName from Pokemon.Moves " +
                            "where MName LIKE '"+TF1.getText()+"'";
                    try(ResultSet result = statement.executeQuery(sql)){
                        if(result.next())
                        {
                            frame.getContentPane().removeAll();
                            frame.repaint();
                            frame.showMove(TF1.getText(),connection);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(x, "Move Not Found");
                        }
                    }
                }
            } catch (SQLException er) {
                System.err.println(1);
            }
        }
    }

    private class ListenForMTSearch implements ActionListener{
        Frame frame;

        private ListenForMTSearch() {
        }

        private ListenForMTSearch(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            JFrame x=new JFrame();
            String t1=TF1.getText();
            if(t1.equals(""))
            {
                JOptionPane.showMessageDialog(x,"Type 1 can't be empty.");
            }
            else {
                if (t1.equals("Normal") || t1.equals("Fighting") || t1.equals("Flying") || t1.equals("Poison") || t1.equals("Ground") || t1.equals("Rock") || t1.equals("Bug") || t1.equals("Ghost") || t1.equals("Steel") || t1.equals("Fire") || t1.equals("Water") || t1.equals("Electric") || t1.equals("Psychic") || t1.equals("Ice") || t1.equals("Dragon") || t1.equals("Dark") || t1.equals("Grass") || t1.equals("Curse") || t1.equals("None")) {
                    String url = "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
                    try (Connection connection = DriverManager.getConnection(url)) {
                        try (Statement statement = connection.createStatement()) {
                            String sql = "Select Tid from Pokemon.Types " +
                                    "where TName LIKE '" + t1+"'";
                            try (ResultSet result = statement.executeQuery(sql)) {
                                if (result.next()) {
                                        int t1id=result.getInt("Tid");
                                        frame.getContentPane().removeAll();
                                        frame.repaint();
                                        frame.showMoveTypes(t1id,connection);
                                }
                            }
                        }
                    } catch (SQLException er) {
                        er.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(x,"Type 1 is invalid");
                }
            }
        }
    }

    private class ListenForAdd implements ActionListener{
        Frame frame;

        private ListenForAdd() {
        }

        private ListenForAdd(Frame x) {
            this.frame = x;
        }

        public void actionPerformed(ActionEvent e) {
            JFrame x=new JFrame();
            int p,m1 = 0,m2=0,m3=0,m4=0;
            String url= "jdbc:sqlserver://localhost;databaseName=Master;integratedSecurity=true;";
            try(Connection connection = DriverManager.getConnection(url)) {
                try(Statement statement = connection.createStatement()){
                    String sql = "Select PId from Pokemon.Pokemons " +
                            "where PName LIKE '"+TF1.getText()+"'";
                    try(ResultSet result = statement.executeQuery(sql)){
                        if(result.next())
                        {
                            p=result.getInt("Pid");
                            if(TF1.getText().equals(""))
                            {
                                JOptionPane.showMessageDialog(x, "First move can't be empty");
                            }
                            else
                            {
                                int ok=1;
                                sql = "Select MId from Pokemon.Moves " +
                                        "where MName LIKE '"+TF2.getText()+"'";
                               ResultSet result2 = statement.executeQuery(sql);
                                if(result2.next())
                                {
                                    m1=result2.getInt("MId");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(x, "Move 1 Not Found");
                                    ok=0;
                                }
                                if(TF3.getText().equals(""))
                                {
                                    m2=296;
                                }
                                else
                                {
                                    sql = "Select MId from Pokemon.Moves " +
                                            "where MName LIKE '"+TF3.getText()+"'";
                                    result2 = statement.executeQuery(sql);
                                    if(result2.next())
                                    {
                                        m2=result2.getInt("MId");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(x, "Move 2 Not Found");
                                        ok=0;
                                    }

                                }
                                if(TF4.getText().equals(""))
                                {
                                    m3=296;
                                }
                                else
                                {
                                    sql = "Select MId from Pokemon.Moves " +
                                            "where MName LIKE '"+TF4.getText()+"'";
                                    result2 = statement.executeQuery(sql);
                                    if(result2.next())
                                    {
                                        m3=result2.getInt("MId");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(x, "Move 3 Not Found");
                                        ok=0;
                                    }

                                }
                                if(TF5.getText().equals(""))
                                {
                                    m4=296;
                                }
                                else
                                {
                                    sql = "Select MId from Pokemon.Moves " +
                                            "where MName LIKE '"+TF5.getText()+"'";
                                    result2 = statement.executeQuery(sql);
                                    if(result2.next())
                                    {
                                        m4=result2.getInt("MId");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(x, "Move 4 Not Found");
                                        ok=0;
                                    }

                                }
                                if(ok==1)
                                {
                                    sql="insert into Pokemon.Events (EPokemon, EMove1, EMove2, EMove3, EMove4) \n" +
                                            "VALUES ("+p+","+m1+","+m2+","+m3+","+m4+")";
                                    statement.executeUpdate(sql);

                                    sql="SELECT * from Pokemon.LearningMoves\n" +
                                            "where Learner="+p+" and MoveLearned="+m1;
                                    result2=statement.executeQuery(sql);
                                    if(!result2.next())
                                    {
                                        sql="INSERT into Pokemon.LearningMoves(Learner, MoveLearned, Method)\n" +
                                                "VALUES ("+p+","+m1+",'Special')";
                                        statement.executeUpdate(sql);
                                    }

                                    if(m2!=296)
                                    {
                                        sql="SELECT * from Pokemon.LearningMoves\n" +
                                                "where Learner="+p+" and MoveLearned="+m2;
                                        result2=statement.executeQuery(sql);
                                        if(!result2.next())
                                        {
                                            sql="INSERT into Pokemon.LearningMoves(Learner, MoveLearned, Method)\n" +
                                                    "VALUES ("+p+","+m2+",'Special')";
                                            statement.executeUpdate(sql);
                                        }
                                    }

                                    if(m3!=296)
                                    {
                                        sql="SELECT * from Pokemon.LearningMoves\n" +
                                                "where Learner="+p+" and MoveLearned="+m3;
                                        result2=statement.executeQuery(sql);
                                        if(!result2.next())
                                        {
                                            sql="INSERT into Pokemon.LearningMoves(Learner, MoveLearned, Method)\n" +
                                                    "VALUES ("+p+","+m3+",'Special')";
                                            statement.executeUpdate(sql);
                                        }
                                    }

                                    if(m4!=296)
                                    {
                                        sql="SELECT * from Pokemon.LearningMoves\n" +
                                                "where Learner="+p+" and MoveLearned="+m4;
                                        result2=statement.executeQuery(sql);
                                        if(!result2.next())
                                        {
                                            sql="INSERT into Pokemon.LearningMoves(Learner, MoveLearned, Method)\n" +
                                                    "VALUES ("+p+","+m4+",'Special')";
                                            statement.executeUpdate(sql);
                                        }
                                    }
                                    connection.close();
                                    frame.getContentPane().removeAll();
                                    frame.repaint();
                                    frame.showEvents();
                                }
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(x, "Pokemon Not Found");
                        }
                    }
                }
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }
    }

}
