package View;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Controller.Controller;
import Model.Players.GraveRobber;

import java.io.*;
import java.net.URL;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */

public class GraphicUI extends JFrame {
    private Controller game;
    private JButton PlayButton,ExitButton,saveButton, continueButton, Start, Cont, Exit;
    private JButton[] Buttons;
    private JButton[] Cards;
    private JLabel[] us = new JLabel[4];
    private JButton bag;
    private JButton endTurn;
    private JLayeredPane Playing_field;
    private JLabel Background;
    private JLabel table;
    private JLabel MosaicGreen;
    private JLabel MosaicRed;
    private JLabel MosaicYellow;
    private JLabel StatCaryatid;
    private JLabel StatSphinx;
    private JLabel AmphoraBlue;
    private JLabel AmphoraBrown;
    private JLabel AmphoraRed;
    private JLabel AmphoraGreen;
    private JLabel AmphoraYellow;
    private JLabel AmphoraPurple;
    private JLabel UpperBody;
    private JLabel LowerBody;
    private JLabel UpperSmallBody;
    private JLabel LowerSmallBody;
    private JLabel textField1, textField2;
    private JLabel MGT,MRT,MYT,CT,ST,ABT,ABrT,ART,AGT,AYT,APT,UBT,LBT,UsBT,LsBT;
    private URL imageURL;
    private ClassLoader cldr;
    private final GraphicUI ui;
    private int size;
    private int MosaicX;
    private int MosaicY;
    private int StatueX;
    private int StatueY;
    private int AmphoraX;
    private int AmphoraY;
    private int SkeletonX;
    private int SkeletonY;
    private int LandslideX;
    private int LandslideY;
    private int tilesTaken;
    private JButton[] tilesInBoard;
    private int in;
    private int card;
    private String area;
    private String Character;
    private String[] areas;
    private int S;
    private int M;
    private int A;
    private int Skel;
    private int done;
    private int Nturn;
    private int[] P1tiles;
    private int[] P2tiles;
    private int[] P3tiles;
    private int[] P4tiles;
    private Clip Mg;
    private AudioInputStream bgm;
    private Clip ng;

    /**
     * <b>constructor</b>: Creates a new Window and initializes some buttons and panels <br />
     * <b>postconditions</b>: Creates a new Window and initializes some buttons and panels
     * starting a new game.
     */
    public GraphicUI() {
        setMosaicX(0);
        setMosaicY(0);
        setStatueX(0);
        setStatueY(0);
        setAmphoraX(0);
        setAmphoraY(0);
        setSkeletonX(0);
        setSkeletonY(0);
        setLandslideX(0);
        setLandslideY(0);
        setTilesTaken(0);
        MosaicGreen = new JLabel();
        MosaicRed = new JLabel();
        MosaicYellow = new JLabel();
        StatCaryatid = new JLabel();
        StatSphinx = new JLabel();
        AmphoraBlue = new JLabel();
        AmphoraBrown = new JLabel();
        AmphoraRed = new JLabel();
        AmphoraGreen = new JLabel();
        AmphoraYellow = new JLabel();
        AmphoraPurple = new JLabel();
        UpperBody = new JLabel();
        LowerBody = new JLabel();
        UpperSmallBody = new JLabel();
        LowerSmallBody = new JLabel();
        MGT = new JLabel();
        MRT = new JLabel();
        MYT = new JLabel();
        CT = new JLabel();
        ST = new JLabel();
        ABT = new JLabel();
        ABrT = new JLabel();
        ART = new JLabel();
        AGT = new JLabel();
        AYT = new JLabel();
        APT = new JLabel();
        UBT = new JLabel();
        LBT = new JLabel();
        UsBT = new JLabel();
        LsBT = new JLabel();
        ui = this;
        Playing_field = new JLayeredPane();
        table = new JLabel();
        PlayButton = new JButton("Play Game");
        ExitButton = new JButton("Exit Game");
        saveButton = new JButton("Save Game");
        continueButton = new JButton("Continue Game");
        bag = new JButton("Draw");
        Cards = new  JButton[4];
        endTurn = new JButton("End Turn");
        textField1 = new JLabel();
        textField2 = new JLabel("Use Character");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cldr = this.getClass().getClassLoader();
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setResizable(false);
        this.setTitle("Amphipolis");
        PlayButton.addActionListener(new PlayListener());
        continueButton.addActionListener( new ContinueListener());
        ExitButton. addActionListener(new ExitListener());
        this.pack();
        this.setSize(900,768);
        this.setLocationRelativeTo(null);
        this.setLayeredPane(Playing_field);
        card = 0;
        areas = new String[4];
        M = 0;
        S = 0;
        A = 0;
        Skel = 0;
        done = 0;
        Nturn = 0;
        P1tiles = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        P2tiles = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        P3tiles = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        P4tiles = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Start = new JButton("Play Game");
        Start.addActionListener(new PlayListener());
        Cont = new JButton("Continue Game");
        Cont.addActionListener(new ContinueListener());
        Exit = new JButton("Exit Game");
        Exit.addActionListener(new ExitListener());
        Background = new JLabel();
        initComponents();
        this.setVisible(true);
    }

    /**
     * <b>transformer(mutative)</b>:initializes the starting screen <br />
     * <p><b>Postcondition:</b> The starting screen has been initialised</p>
     *
     */
    public void initComponents(){
        Playing_field.setBounds(0,0,900,768);
        Playing_field.setLayout(null);
        Background.setBounds(0,0,900,768);
        imageURL = cldr.getResource("images_2020/Cover.png");
        Background.setIcon(new ImageIcon(imageURL));
        Background.setVisible(true);
        Playing_field.setLayer(Background, 0);
        Playing_field.add(Background);
        Start.setOpaque(true);
        Start.setBounds(270, 600, 350, 75);
        Playing_field.setLayer(Start, 1);
        Playing_field.add(Start);
        Cont.setOpaque(true);
        Cont.setBounds(0, 600, 150, 150);
        Playing_field.setLayer(Cont, 1);
        Playing_field.add(Cont);
        Exit.setOpaque(true);
        Exit.setBounds(745, 600, 150, 150);
        Playing_field.setLayer(Exit, 1);
        Playing_field.add(Exit);
        InputStream music;
        try{
            music = new FileInputStream(new File("Dessert.wav"));
            InputStream bufferedIn = new BufferedInputStream(music);
            bgm = AudioSystem.getAudioInputStream(bufferedIn);
            Mg = AudioSystem.getClip();
            Mg.open(bgm);
            Mg.start();
            Mg.loop(Mg.LOOP_CONTINUOUSLY);

        }
        catch(LineUnavailableException | UnsupportedAudioFileException | IOException e){
            e.printStackTrace();
        }
        Graphics g1 = this.getGraphics();
        this.paintComponents(g1);
        this.repaint();

    }

    /**
     * <b>transformer(mutative)</b>:initializes the main screen <br />
     * <p><b>Postcondition:</b> The main screen has been initialised</p>
     *
     */
    public void initButtons(){
        table.setBounds(0 ,0, 800, 800);
        imageURL = cldr.getResource("images_2020/backgroundRes.png");
        table.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(table, 0);
        Playing_field.add(table);
        PlayButton.setBounds(0, 603, 150, 35);
        PlayButton.setOpaque(true);
        Playing_field.setLayer(PlayButton, 0);
        Playing_field.add(PlayButton);
        saveButton.setBounds(0, 637, 150, 35);
        saveButton.setOpaque(true);
        saveButton.addActionListener(new SaveListener());
        Playing_field.setLayer(saveButton, 0);
        Playing_field.add(saveButton);
        continueButton.setBounds(0, 670, 150, 35);
        continueButton.setOpaque(true);
        Playing_field.setLayer(continueButton, 0);
        Playing_field.add(continueButton);
        ExitButton.setBounds(0, 704, 150, 35);
        ExitButton.setOpaque(true);
        Playing_field.setLayer(ExitButton, 0);
        Playing_field.add(ExitButton);
        bag.setBounds(610, 440, 280, 80);
        bag.setOpaque(true);
        Playing_field.setLayer(bag, 0);
        Playing_field.add(bag);
        endTurn.setBounds(610, 520, 280, 80);
        endTurn.setOpaque(true);
        Playing_field.setLayer(endTurn, 0);
        Playing_field.add(endTurn);
        for(int i = 0; i < 4; i++){
            Cards[i] = new JButton();
        }
        Cards[0].setBounds(630, 100, 98, 160);
        Cards[0].setOpaque(true);
        imageURL = cldr.getResource("images_2020/archaeologistScaled.png");
        Cards[0].setIcon(new ImageIcon(imageURL));
        Cards[0].addActionListener(new CardListener());
        Cards[0].setName("Archeologist");
        Playing_field.setLayer(Cards[0], 0);
        Playing_field.add(Cards[0]);
        Cards[1].setBounds(630, 270, 98, 160);
        Cards[1].setOpaque(true);
        imageURL = cldr.getResource("images_2020/diggerScaled.png");
        Cards[1].setIcon(new ImageIcon(imageURL));
        Cards[1].addActionListener(new CardListener());
        Cards[1].setName("Digger");
        Playing_field.setLayer(Cards[1], 0);
        Playing_field.add(Cards[1]);
        Cards[2].setBounds(770, 100, 98, 160);
        Cards[2].setOpaque(true);
        imageURL = cldr.getResource("images_2020/assistantScaled.png");
        Cards[2].setIcon(new ImageIcon(imageURL));
        Cards[2].addActionListener(new CardListener());
        Cards[2].setName("Assistant");
        Playing_field.setLayer(Cards[2], 0);
        Playing_field.add(Cards[2]);
        Cards[3].setBounds(770, 270, 98, 160);
        Cards[3].setOpaque(true);
        imageURL = cldr.getResource("images_2020/professorScaled.png");
        Cards[3].setIcon(new ImageIcon(imageURL));
        Cards[3].addActionListener(new CardListener());
        Cards[3].setName("Professor");
        Playing_field.setLayer(Cards[3], 0);
        Playing_field.add(Cards[3]);
        textField2.setFont(new Font("Serif", Font.PLAIN, 22));
        textField2.setPreferredSize(new Dimension(35, 50));
        textField2.setBounds(685, 40, 130,50);
        Playing_field.setLayer(textField2, 0);
        Playing_field.add(textField2);
        MosaicGreen.setOpaque(true);
        MosaicGreen.setBounds(498, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/mosaic_greenN.png");
        MosaicGreen.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(MosaicGreen, 0);
        Playing_field.add(MosaicGreen);
        MosaicRed.setOpaque(true);
        MosaicRed.setBounds(568, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/mosaic_redN.png");
        MosaicRed.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(MosaicRed, 0);
        Playing_field.add(MosaicRed);
        MosaicYellow.setOpaque(true);
        MosaicYellow.setBounds(638, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/mosaic_yellowN.png");
        MosaicYellow.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(MosaicYellow, 0);
        Playing_field.add(MosaicYellow);
        StatCaryatid.setOpaque(true);
        StatCaryatid.setBounds(498, 673, 70, 70);
        imageURL = cldr.getResource("images_2020/caryatidN.png");
        StatCaryatid.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(StatCaryatid, 0);
        Playing_field.add(StatCaryatid);
        StatSphinx.setOpaque(true);
        StatSphinx.setBounds(568, 673, 70, 70);
        imageURL = cldr.getResource("images_2020/sphinxN.png");
        StatSphinx.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(StatSphinx, 0);
        Playing_field.add(StatSphinx);
        AmphoraBlue.setOpaque(true);
        AmphoraBlue.setBounds(148, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/amphora_blueN.png");
        AmphoraBlue.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(AmphoraBlue, 0);
        Playing_field.add(AmphoraBlue);
        AmphoraBrown.setOpaque(true);
        AmphoraBrown.setBounds(218, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/amphora_brownN.png");
        AmphoraBrown.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(AmphoraBrown, 0);
        Playing_field.add(AmphoraBrown);
        AmphoraRed.setOpaque(true);
        AmphoraRed.setBounds(288, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/amphora_redN.png");
        AmphoraRed.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(AmphoraRed, 0);
        Playing_field.add(AmphoraRed);
        AmphoraGreen.setOpaque(true);
        AmphoraGreen.setBounds(148, 673, 70, 70);
        imageURL = cldr.getResource("images_2020/amphora_greenN.png");
        AmphoraGreen.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(AmphoraGreen, 0);
        Playing_field.add(AmphoraGreen);
        AmphoraYellow.setOpaque(true);
        AmphoraYellow.setBounds(218, 673, 70, 70);
        imageURL = cldr.getResource("images_2020/amphora_yellowN.png");
        AmphoraYellow.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(AmphoraYellow, 0);
        Playing_field.add(AmphoraYellow);
        AmphoraPurple.setOpaque(true);
        AmphoraPurple.setBounds(288, 673, 70, 70);
        imageURL = cldr.getResource("images_2020/amphora_purpleN.png");
        AmphoraPurple.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(AmphoraPurple, 0);
        Playing_field.add(AmphoraPurple);
        UpperBody.setOpaque(true);
        UpperBody.setBounds(358, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/skeleton_big_topN.png");
        UpperBody.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(UpperBody, 0);
        Playing_field.add(UpperBody);
        LowerBody.setOpaque(true);
        LowerBody.setBounds(358, 673, 70, 70);
        imageURL = cldr.getResource("images_2020/skeleton_big_bottomN.png");
        LowerBody.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(LowerBody, 0);
        Playing_field.add(LowerBody);
        UpperSmallBody.setOpaque(true);
        UpperSmallBody.setBounds(428, 603, 70, 70);
        imageURL = cldr.getResource("images_2020/skeleton_small_topN.png");
        UpperSmallBody.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(UpperSmallBody, 0);
        Playing_field.add(UpperSmallBody);
        LowerSmallBody.setOpaque(true);
        LowerSmallBody.setBounds(428, 673, 70, 70);
        imageURL = cldr.getResource("images_2020/skeleton_small_bottomN.png");
        LowerSmallBody.setIcon(new ImageIcon(imageURL));
        Playing_field.setLayer(LowerSmallBody, 0);
        Playing_field.add(LowerSmallBody);
        MGT.setOpaque(true);
        MGT.setFont(new Font("Serif", Font.PLAIN, 22));
        MGT.setBackground(new Color(255,255,255,110));
        MGT.setPreferredSize(new Dimension(30, 30));
        MGT.setBounds(540, 603, 30,30);
        changeText(MGT, "00");
        Playing_field.setLayer(MGT, 2);
        Playing_field.add(MGT);
        MRT.setOpaque(true);
        MRT.setFont(new Font("Serif", Font.PLAIN, 22));
        MRT.setBackground(new Color(255,255,255,110));
        MRT.setPreferredSize(new Dimension(30, 30));
        MRT.setBounds(610, 603, 30,30);
        changeText(MRT, "00");
        Playing_field.setLayer(MRT, 2);
        Playing_field.add(MRT);
        MYT.setOpaque(true);
        MYT.setFont(new Font("Serif", Font.PLAIN, 22));
        MYT.setBackground(new Color(255,255,255,110));
        MYT.setPreferredSize(new Dimension(30, 30));
        MYT.setBounds(680, 603, 30,30);
        changeText(MYT, "00");
        Playing_field.setLayer(MYT, 2);
        Playing_field.add(MYT);
        CT.setOpaque(true);
        CT.setFont(new Font("Serif", Font.PLAIN, 22));
        CT.setBackground(new Color(255,255,255,110));
        CT.setPreferredSize(new Dimension(30, 30));
        CT.setBounds(540, 673, 30,30);
        changeText(CT, "00");
        Playing_field.setLayer(CT, 2);
        Playing_field.add(CT);
        ST.setOpaque(true);
        ST.setFont(new Font("Serif", Font.PLAIN, 22));
        ST.setBackground(new Color(255,255,255,110));
        ST.setPreferredSize(new Dimension(30, 30));
        ST.setBounds(610, 673, 30,30);
        changeText(ST, "00");
        Playing_field.setLayer(ST, 2);
        Playing_field.add(ST);
        UsBT.setOpaque(true);
        UsBT.setFont(new Font("Serif", Font.PLAIN, 22));
        UsBT.setBackground(new Color(255,255,255,110));
        UsBT.setPreferredSize(new Dimension(30, 30));
        UsBT.setBounds(469, 603, 30,30);
        changeText(UsBT, "00");
        Playing_field.setLayer(UsBT, 2);
        Playing_field.add(UsBT);
        LsBT.setOpaque(true);
        LsBT.setFont(new Font("Serif", Font.PLAIN, 22));
        LsBT.setBackground(new Color(255,255,255,110));
        LsBT.setPreferredSize(new Dimension(30, 30));
        LsBT.setBounds(469, 673, 30,30);
        changeText(LsBT, "00");
        Playing_field.setLayer(LsBT, 2);
        Playing_field.add(LsBT);
        UBT.setOpaque(true);
        UBT.setFont(new Font("Serif", Font.PLAIN, 22));
        UBT.setBackground(new Color(255,255,255,110));
        UBT.setPreferredSize(new Dimension(30, 30));
        UBT.setBounds(399, 603, 30,30);
        changeText(UBT, "00");
        Playing_field.setLayer(UBT, 2);
        Playing_field.add(UBT);
        LBT.setOpaque(true);
        LBT.setFont(new Font("Serif", Font.PLAIN, 22));
        LBT.setBackground(new Color(255,255,255,110));
        LBT.setPreferredSize(new Dimension(30, 30));
        LBT.setBounds(399, 673, 30,30);
        changeText(LBT, "00");
        Playing_field.setLayer(LBT, 2);
        Playing_field.add(LBT);
        ART.setOpaque(true);
        ART.setFont(new Font("Serif", Font.PLAIN, 22));
        ART.setBackground(new Color(255,255,255,110));
        ART.setPreferredSize(new Dimension(30, 30));
        ART.setBounds(329, 603, 30,30);
        changeText(ART, "00");
        Playing_field.setLayer(ART, 2);
        Playing_field.add(ART);
        APT.setOpaque(true);
        APT.setFont(new Font("Serif", Font.PLAIN, 22));
        APT.setBackground(new Color(255,255,255,110));
        APT.setPreferredSize(new Dimension(30, 30));
        APT.setBounds(329, 673, 30,30);
        changeText(APT, "00");
        Playing_field.setLayer(APT, 2);
        Playing_field.add(APT);
        ABrT.setOpaque(true);
        ABrT.setFont(new Font("Serif", Font.PLAIN, 22));
        ABrT.setBackground(new Color(255,255,255,110));
        ABrT.setPreferredSize(new Dimension(30, 30));
        ABrT.setBounds(259, 603, 30,30);
        changeText(ABrT, "00");
        Playing_field.setLayer(ABrT, 2);
        Playing_field.add(ABrT);
        AYT.setOpaque(true);
        AYT.setFont(new Font("Serif", Font.PLAIN, 22));
        AYT.setBackground(new Color(255,255,255,110));
        AYT.setPreferredSize(new Dimension(30, 30));
        AYT.setBounds(259, 673, 30,30);
        changeText(AYT, "00");
        Playing_field.setLayer(AYT, 2);
        Playing_field.add(AYT);
        ABT.setOpaque(true);
        ABT.setFont(new Font("Serif", Font.PLAIN, 22));
        ABT.setBackground(new Color(255,255,255,110));
        ABT.setPreferredSize(new Dimension(30, 30));
        ABT.setBounds(189, 603, 30,30);
        changeText(ABT, "00");
        Playing_field.setLayer(ABT, 2);
        Playing_field.add(ABT);
        AGT.setOpaque(true);
        AGT.setFont(new Font("Serif", Font.PLAIN, 22));
        AGT.setBackground(new Color(255,255,255,110));
        AGT.setPreferredSize(new Dimension(30, 30));
        AGT.setBounds(189, 673, 30,30);
        changeText(AGT, "00");
        Playing_field.setLayer(AGT, 2);
        Playing_field.add(AGT);
        for(int i = 0; i < 4; i++){
            us[i] = new JLabel();
        }
        us[0].setBounds(630, 100, 98, 160);
        us[0].setBackground(new Color(200, 200, 200, 100));
        Playing_field.setLayer(us[0], 2);
        Playing_field.add(us[0]);
        us[1].setBounds(630, 270, 98, 160);
        us[1].setBackground(new Color(200, 200, 200, 100));
        Playing_field.setLayer(us[1], 2);
        Playing_field.add(us[1]);
        us[2].setBounds(770, 100, 98, 160);
        us[2].setBackground(new Color(200, 200, 200, 100));
        Playing_field.setLayer(us[2], 2);
        Playing_field.add(us[2]);
        us[3].setBounds(770, 270, 98, 160);
        us[3].setBackground(new Color(200, 200, 200, 100));
        Playing_field.setLayer(us[3], 2);
        Playing_field.add(us[3]);
        Playing_field.repaint();
    }

    /* a class which is used for doing some action after play button has been pushed */
    public class PlayListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the Play button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the Play button has been pushed</p>
         *
         */

        public void actionPerformed(ActionEvent e) 	{

            int opt = JOptionPane.showConfirmDialog(ui, "Are you sure you want to start a new game?", "New Game", JOptionPane.YES_NO_OPTION);

            if(opt == JOptionPane.NO_OPTION){
                return;
            }
            else{
                Start.setVisible(false);
                Cont.setVisible(false);
                Exit.setVisible(false);
                Background.setVisible(false);
                String Color1 = null;
                String Color2 = null;
                String Color3 = null;
                String Color4 = null;
                String Name1 = null;
                String Name2 = null;
                String Name3 = null;
                String Name4 = null;
                PlayerMenu p = new PlayerMenu();


                if(p.getPlayers() == 1){
                    PlayerInfo k = new PlayerInfo(0, null, null, null);
                    Color1 = k.getColor();
                    String result = (String)JOptionPane.showInputDialog(
                            ui,
                            "Enter the name of the player:",
                            "Name Select",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            ""
                    );
                    if(result != null && result.length() > 0){
                        Name1 = result;
                    }else {
                        Name1 = "Player 1";
                    }
                }
                else {
                    for(int i = 0; i < 4; i++){
                        if(i == 0){
                            PlayerInfo k = new PlayerInfo(i, null, null, null);
                            Color1 = k.getColor();
                            String result = (String)JOptionPane.showInputDialog(
                                    ui,
                                    "Enter the name of the player:",
                                    "Name Select",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    ""
                            );
                            if(result != null && result.length() > 0){
                                Name1 = result;
                            }else {
                                Name1 = "Player" + (i+1);
                            }
                        }
                        else if(i == 1){
                            PlayerInfo k = new PlayerInfo(i, Color1, "null", "null");
                            Color2 = k.getColor();
                            String result = (String)JOptionPane.showInputDialog(
                                    ui,
                                    "Enter the name of the player:",
                                    "Name Select",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    ""
                            );
                            if(result != null && result.length() > 0){
                                Name2 = result;
                            }else {
                                Name2 = "Player" + (i+1);
                            }
                        }
                        else if(i == 2){
                            PlayerInfo k = new PlayerInfo(i, Color1, Color2, null);
                            Color3 = k.getColor();
                            String result = (String)JOptionPane.showInputDialog(
                                    ui,
                                    "Enter the name of the player:",
                                    "Name Select",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    ""
                            );
                            if(result != null && result.length() > 0){
                                Name3 = result;
                            }else {
                                Name3 = "Player" + (i+1);
                            }
                        }
                        else{
                            PlayerInfo k = new PlayerInfo(i, Color1, Color2, Color3);
                            Color4 = k.getColor();
                            String result = (String)JOptionPane.showInputDialog(
                                    ui,
                                    "Enter the name of the player:",
                                    "Name Select",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    null,
                                    ""
                            );
                            if(result != null && result.length() > 0){
                                Name4 = result;
                            }else {
                                Name4 = "Player" + (i+1);
                            }
                        }
                    }
                }
                game = new Controller(p.getPlayers(), Color1, Color2, Color3, Color4, Name1, Name2, Name3, Name4);
                if(game.getPlayerNumber() == 1){
                    Buttons = new JButton[131];
                    tilesInBoard = new JButton[131];
                    size = 131;
                    for(int i = 0; i < 131; i++){
                        Buttons[i] = new JButton();
                    }

                }
                else{
                    Buttons = new JButton[135];
                    tilesInBoard = new JButton[135];
                    size = 135;
                    for(int i = 0; i < 135; i++){
                        Buttons[i] = new JButton();
                    }
                }
                initButtons();
                if(game.getPlayerNumber() == 1){
                    game.setR();
                    textField1.setFont(new Font("Serif", Font.PLAIN, 22));
                    textField1.setPreferredSize(new Dimension(35, 50));
                    textField1.setBounds(713, -10, 130,50);
                    textField1.setText(game.getPlayer(0).getName());
                    Playing_field.setLayer(textField1, 0);
                    Playing_field.add(textField1);
                    bag.addActionListener(new BagListener());
                    endTurn.addActionListener(new EndTurnListener());
                    game.setNot_Started(false);
                    int b = 0;
                    while(b < 8){
                        if(size == 131){
                            setLandslideX(214);
                            setLandslideY(262);
                            Buttons[0].setBounds(getLandslideX(), getLandslideY(), 44, 44);
                            setLandslideX(getLandslideX() + 44);
                            Buttons[0].setOpaque(true);
                            imageURL = cldr.getResource("images_2020/landslideScaled.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Playing_field.setLayer(Buttons[0], 1);
                            Playing_field.add(Buttons[0]);
                            tilesInBoard[0] = Buttons[0];
                            tilesInBoard[0].setName("Landslide");
                            Buttons[0] = Buttons[size-1];
                            Buttons[size-1] = null;
                            size = size-1;
                            b++;
                            Playing_field.repaint();
                        }
                        else{
                            int i = 0;
                            Buttons[0].setBounds(getLandslideX(), getLandslideY(), 44, 44);
                            Buttons[0].setOpaque(true);
                            imageURL = cldr.getResource("images_2020/landslideScaled.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Playing_field.setLayer(Buttons[0], 2);
                            Playing_field.add(Buttons[0]);
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                            tilesInBoard[i].setName("Landslide");
                            Buttons[0] = Buttons[size-1];
                            Buttons[size-1] = null;
                            size = size-1;
                            b++;
                            Playing_field.repaint();
                            if(getLandslideX() == 346){
                                setLandslideY(getLandslideY() + 44);
                                setLandslideX(214);
                            }
                            else{
                                setLandslideX(getLandslideX() + 44);
                            }
                        }

                    }
                }
                if(game.getPlayerNumber() == 4) {
                    for (in = 0; in < 4; in++) {
                        if (game.getPlayer(in).getTurnValue() == 1) {
                            break;
                        }
                    }
                    textField1.setFont(new Font("Serif", Font.PLAIN, 22));
                    textField1.setPreferredSize(new Dimension(35, 50));
                    textField1.setBounds(713, -10, 130,50);
                    textField1.setText(game.getPlayer(in).getName());
                    Playing_field.setLayer(textField1, 0);
                    Playing_field.add(textField1);
                    bag.addActionListener(new BagListener());
                    endTurn.addActionListener(new EndTurnListener());
                    game.setNot_Started(false);
                }
            }
        }
    }
    /* a class which is used for doing some action after a End Turn button has been pushed */
    public class EndTurnListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the End Turn button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the End Turn button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{
            if(Nturn == 0){
                return;
            }
            if(game.getPlayerNumber() == 1){
                done = 0;
                game.getPlayer(0).setHandEmpty();
                setTilesTaken(0);
                if(game.getPlayer(0).getCharacter("Archeologist").getUsed() == false){
                    us[0].setOpaque(false);
                }
                else{
                    us[0].setOpaque(true);
                    us[0].setVisible(true);
                }
                if(game.getPlayer(0).getCharacter("Digger").getUsed() == false){
                    us[1].setOpaque(false);
                }
                else{
                    us[1].setOpaque(true);
                    us[1].setVisible(true);
                }
                if(game.getPlayer(getIn()).getCharacter("Assistant").getUsed() == false){
                    us[2].setOpaque(false);
                }
                else{
                    us[2].setOpaque(true);
                    us[2].setVisible(true);
                }
                if(game.getPlayer(getIn()).getCharacter("Professor").getUsed() == false){
                    us[3].setOpaque(false);
                }
                else{
                    us[3].setOpaque(true);
                    us[3].setVisible(true);
                }
                textField1.setText("Grave Robber");
                game.getR().getTiles(game.getB());
                int p = 0;
                while(tilesInBoard[p] != null){
                    if(tilesInBoard[p].getName() != "Landslide" && tilesInBoard[p].isVisible() == true){
                        tilesInBoard[p].setVisible(false);
                    }
                    p++;
                }
                JOptionPane.showMessageDialog(ui, "The Grave robber moved..", "Think Carefully",JOptionPane.PLAIN_MESSAGE);
                textField1.setText(game.getPlayer(0).getName());
                Nturn = 0;
            }
            else{
                done = 0;
                game.getPlayer(getIn()).setHandEmpty();
                game.turnEnd(game.getPlayer(getIn()));
                if(in >= 3){
                    setIn(0);
                }
                else{
                    setIn(getIn()+1);
                }
                setTilesTaken(0);
                textField1.setText(game.getPlayer(getIn()).getName());
                Nturn = 0;
                if(game.getPlayer(getIn()).getCharacter("Archeologist").getUsed() == false){
                    us[0].setOpaque(false);
                }
                else{
                    us[0].setOpaque(true);
                    us[0].setVisible(true);
                }
                if(game.getPlayer(getIn()).getCharacter("Digger").getUsed() == false){
                    us[1].setOpaque(false);
                }
                else{
                    us[1].setOpaque(true);
                    us[1].setVisible(true);
                }
                if(game.getPlayer(getIn()).getCharacter("Assistant").getUsed() == false){
                    us[2].setOpaque(false);
                }
                else{
                    us[2].setOpaque(true);
                    us[2].setVisible(true);
                }
                if(game.getPlayer(getIn()).getCharacter("Professor").getUsed() == false){
                    us[3].setOpaque(false);
                }
                else{
                    us[3].setOpaque(true);
                    us[3].setVisible(true);
                }
                if(in == 0){
                    P4tiles[0] = Integer.parseInt(MGT.getText());
                    P4tiles[1] = Integer.parseInt(MRT.getText());
                    P4tiles[2] = Integer.parseInt(MYT.getText());
                    P4tiles[3] = Integer.parseInt(CT.getText());
                    P4tiles[4] = Integer.parseInt(ST.getText());
                    P4tiles[5] = Integer.parseInt(ABT.getText());
                    P4tiles[6] = Integer.parseInt(ABrT.getText());
                    P4tiles[7] = Integer.parseInt(ART.getText());
                    P4tiles[8] = Integer.parseInt(AGT.getText());
                    P4tiles[9] = Integer.parseInt(AYT.getText());
                    P4tiles[10] = Integer.parseInt(APT.getText());
                    P4tiles[11] = Integer.parseInt(UBT.getText());
                    P4tiles[12] = Integer.parseInt(LBT.getText());
                    P4tiles[13] = Integer.parseInt(UsBT.getText());
                    P4tiles[14] = Integer.parseInt(LsBT.getText());

                    if(P1tiles[0] < 10) {
                        changeText(MGT, "0" + String.valueOf(P1tiles[0]));
                    }
                    else{
                        changeText(MGT, String.valueOf(P1tiles[0]));
                    }
                    if(P1tiles[1] < 10){
                        changeText(MRT, "0" + String.valueOf(P1tiles[1]));
                    }
                    else{
                        changeText(MRT, String.valueOf(P1tiles[1]));
                    }
                    if(P1tiles[2] < 10){
                        changeText(MYT, "0" + String.valueOf(P1tiles[2]));
                    }
                    else{
                        changeText(MYT, String.valueOf(P1tiles[2]));
                    }
                    if(P1tiles[3] < 10){
                        changeText(CT, "0" + String.valueOf(P1tiles[3]));
                    }
                    else{
                        changeText(CT, String.valueOf(P1tiles[3]));
                    }
                    if(P1tiles[4] < 10){
                        changeText(ST, "0" + String.valueOf(P1tiles[4]));
                    }
                    else{
                        changeText(ST, String.valueOf(P1tiles[4]));
                    }
                    if(P1tiles[5] < 10){
                        changeText(ABT, "0" + String.valueOf(P1tiles[5]));
                    }
                    else{
                        changeText(ABT, String.valueOf(P1tiles[5]));
                    }
                    if(P1tiles[6] < 10){
                        changeText(ABrT, "0" + String.valueOf(P1tiles[6]));
                    }
                    else{
                        changeText(ABrT, String.valueOf(P1tiles[6]));
                    }
                    if(P1tiles[7] < 10){
                        changeText(ART, "0" + String.valueOf(P1tiles[7]));
                    }
                    else{
                        changeText(ART, String.valueOf(P1tiles[7]));
                    }
                    if(P1tiles[8] < 10){
                        changeText(AGT, "0" + String.valueOf(P1tiles[8]));
                    }
                    else{
                        changeText(AGT, String.valueOf(P1tiles[8]));
                    }
                    if(P1tiles[9] < 10){
                        changeText(AYT, "0" + String.valueOf(P1tiles[9]));
                    }
                    else{
                        changeText(AYT, String.valueOf(P1tiles[9]));
                    }
                    if(P1tiles[10] < 10){
                        changeText(APT, "0" + String.valueOf(P1tiles[10]));
                    }
                    else{
                        changeText(APT, String.valueOf(P1tiles[10]));
                    }
                    if(P1tiles[11] < 10){
                        changeText(UBT, "0" + String.valueOf(P1tiles[11]));
                    }
                    else{
                        changeText(UBT, String.valueOf(P1tiles[11]));
                    }
                    if(P1tiles[12] < 10){
                        changeText(LBT, "0" + String.valueOf(P1tiles[12]));
                    }
                    else{
                        changeText(LBT, String.valueOf(P1tiles[12]));
                    }
                    if(P1tiles[13] < 10){
                        changeText(UsBT, "0" + String.valueOf(P1tiles[13]));
                    }
                    else{
                        changeText(UsBT, String.valueOf(P1tiles[13]));
                    }
                    if(P1tiles[14] < 10){
                        changeText(LsBT, "0" + String.valueOf(P1tiles[14]));
                    }
                    else{
                        changeText(LsBT, String.valueOf(P1tiles[14]));
                    }
                }
                else if(in == 1){
                    P1tiles[0] = Integer.parseInt(MGT.getText());
                    P1tiles[1] = Integer.parseInt(MRT.getText());
                    P1tiles[2] = Integer.parseInt(MYT.getText());
                    P1tiles[3] = Integer.parseInt(CT.getText());
                    P1tiles[4] = Integer.parseInt(ST.getText());
                    P1tiles[5] = Integer.parseInt(ABT.getText());
                    P1tiles[6] = Integer.parseInt(ABrT.getText());
                    P1tiles[7] = Integer.parseInt(ART.getText());
                    P1tiles[8] = Integer.parseInt(AGT.getText());
                    P1tiles[9] = Integer.parseInt(AYT.getText());
                    P1tiles[10] = Integer.parseInt(APT.getText());
                    P1tiles[11] = Integer.parseInt(UBT.getText());
                    P1tiles[12] = Integer.parseInt(LBT.getText());
                    P1tiles[13] = Integer.parseInt(UsBT.getText());
                    P1tiles[14] = Integer.parseInt(LsBT.getText());

                    if(P2tiles[0] < 10) {
                        changeText(MGT, "0" + String.valueOf(P2tiles[0]));
                    }
                    else{
                        changeText(MGT, String.valueOf(P2tiles[0]));
                    }
                    if(P2tiles[1] < 10){
                        changeText(MRT, "0" + String.valueOf(P2tiles[1]));
                    }
                    else{
                        changeText(MRT, String.valueOf(P2tiles[1]));
                    }
                    if(P2tiles[2] < 10){
                        changeText(MYT, "0" + String.valueOf(P2tiles[2]));
                    }
                    else{
                        changeText(MYT, String.valueOf(P2tiles[2]));
                    }
                    if(P2tiles[3] < 10){
                        changeText(CT, "0" + String.valueOf(P2tiles[3]));
                    }
                    else{
                        changeText(CT, String.valueOf(P2tiles[3]));
                    }
                    if(P2tiles[4] < 10){
                        changeText(ST, "0" + String.valueOf(P2tiles[4]));
                    }
                    else{
                        changeText(ST, String.valueOf(P2tiles[4]));
                    }
                    if(P2tiles[5] < 10){
                        changeText(ABT, "0" + String.valueOf(P2tiles[5]));
                    }
                    else{
                        changeText(ABT, String.valueOf(P2tiles[5]));
                    }
                    if(P2tiles[6] < 10){
                        changeText(ABrT, "0" + String.valueOf(P2tiles[6]));
                    }
                    else{
                        changeText(ABrT, String.valueOf(P2tiles[6]));
                    }
                    if(P2tiles[7] < 10){
                        changeText(ART, "0" + String.valueOf(P2tiles[7]));
                    }
                    else{
                        changeText(ART, String.valueOf(P2tiles[7]));
                    }
                    if(P2tiles[8] < 10){
                        changeText(AGT, "0" + String.valueOf(P2tiles[8]));
                    }
                    else{
                        changeText(AGT, String.valueOf(P2tiles[8]));
                    }
                    if(P2tiles[9] < 10){
                        changeText(AYT, "0" + String.valueOf(P2tiles[9]));
                    }
                    else{
                        changeText(AYT, String.valueOf(P2tiles[9]));
                    }
                    if(P2tiles[10] < 10){
                        changeText(APT, "0" + String.valueOf(P2tiles[10]));
                    }
                    else{
                        changeText(APT, String.valueOf(P2tiles[10]));
                    }
                    if(P2tiles[11] < 10){
                        changeText(UBT, "0" + String.valueOf(P2tiles[11]));
                    }
                    else{
                        changeText(UBT, String.valueOf(P2tiles[11]));
                    }
                    if(P2tiles[12] < 10){
                        changeText(LBT, "0" + String.valueOf(P2tiles[12]));
                    }
                    else{
                        changeText(LBT, String.valueOf(P2tiles[12]));
                    }
                    if(P2tiles[13] < 10){
                        changeText(UsBT, "0" + String.valueOf(P2tiles[13]));
                    }
                    else{
                        changeText(UsBT, String.valueOf(P2tiles[13]));
                    }
                    if(P2tiles[14] < 10){
                        changeText(LsBT, "0" + String.valueOf(P2tiles[14]));
                    }
                    else{
                        changeText(LsBT, String.valueOf(P2tiles[14]));
                    }
                }
                else if(in == 2){
                    P2tiles[0] = Integer.parseInt(MGT.getText());
                    P2tiles[1] = Integer.parseInt(MRT.getText());
                    P2tiles[2] = Integer.parseInt(MYT.getText());
                    P2tiles[3] = Integer.parseInt(CT.getText());
                    P2tiles[4] = Integer.parseInt(ST.getText());
                    P2tiles[5] = Integer.parseInt(ABT.getText());
                    P2tiles[6] = Integer.parseInt(ABrT.getText());
                    P2tiles[7] = Integer.parseInt(ART.getText());
                    P2tiles[8] = Integer.parseInt(AGT.getText());
                    P2tiles[9] = Integer.parseInt(AYT.getText());
                    P2tiles[10] = Integer.parseInt(APT.getText());
                    P2tiles[11] = Integer.parseInt(UBT.getText());
                    P2tiles[12] = Integer.parseInt(LBT.getText());
                    P2tiles[13] = Integer.parseInt(UsBT.getText());
                    P2tiles[14] = Integer.parseInt(LsBT.getText());

                    if(P3tiles[0] < 10) {
                        changeText(MGT, "0" + String.valueOf(P3tiles[0]));
                    }
                    else{
                        changeText(MGT, String.valueOf(P3tiles[0]));
                    }
                    if(P3tiles[1] < 10){
                        changeText(MRT, "0" + String.valueOf(P3tiles[1]));
                    }
                    else{
                        changeText(MRT, String.valueOf(P3tiles[1]));
                    }
                    if(P3tiles[2] < 10){
                        changeText(MYT, "0" + String.valueOf(P3tiles[2]));
                    }
                    else{
                        changeText(MYT, String.valueOf(P3tiles[2]));
                    }
                    if(P3tiles[3] < 10){
                        changeText(CT, "0" + String.valueOf(P3tiles[3]));
                    }
                    else{
                        changeText(CT, String.valueOf(P3tiles[3]));
                    }
                    if(P3tiles[4] < 10){
                        changeText(ST, "0" + String.valueOf(P3tiles[4]));
                    }
                    else{
                        changeText(ST, String.valueOf(P3tiles[4]));
                    }
                    if(P3tiles[5] < 10){
                        changeText(ABT, "0" + String.valueOf(P3tiles[5]));
                    }
                    else{
                        changeText(ABT, String.valueOf(P3tiles[5]));
                    }
                    if(P3tiles[6] < 10){
                        changeText(ABrT, "0" + String.valueOf(P3tiles[6]));
                    }
                    else{
                        changeText(ABrT, String.valueOf(P3tiles[6]));
                    }
                    if(P3tiles[7] < 10){
                        changeText(ART, "0" + String.valueOf(P3tiles[7]));
                    }
                    else{
                        changeText(ART, String.valueOf(P3tiles[7]));
                    }
                    if(P3tiles[8] < 10){
                        changeText(AGT, "0" + String.valueOf(P3tiles[8]));
                    }
                    else{
                        changeText(AGT, String.valueOf(P3tiles[8]));
                    }
                    if(P3tiles[9] < 10){
                        changeText(AYT, "0" + String.valueOf(P3tiles[9]));
                    }
                    else{
                        changeText(AYT, String.valueOf(P3tiles[9]));
                    }
                    if(P3tiles[10] < 10){
                        changeText(APT, "0" + String.valueOf(P3tiles[10]));
                    }
                    else{
                        changeText(APT, String.valueOf(P3tiles[10]));
                    }
                    if(P3tiles[11] < 10){
                        changeText(UBT, "0" + String.valueOf(P3tiles[11]));
                    }
                    else{
                        changeText(UBT, String.valueOf(P3tiles[11]));
                    }
                    if(P3tiles[12] < 10){
                        changeText(LBT, "0" + String.valueOf(P3tiles[12]));
                    }
                    else{
                        changeText(LBT, String.valueOf(P3tiles[12]));
                    }
                    if(P3tiles[13] < 10){
                        changeText(UsBT, "0" + String.valueOf(P3tiles[13]));
                    }
                    else{
                        changeText(UsBT, String.valueOf(P3tiles[13]));
                    }
                    if(P3tiles[14] < 10){
                        changeText(LsBT, "0" + String.valueOf(P3tiles[14]));
                    }
                    else{
                        changeText(LsBT, String.valueOf(P3tiles[14]));
                    }
                }
                else{
                    P3tiles[0] = Integer.parseInt(MGT.getText());
                    P3tiles[1] = Integer.parseInt(MRT.getText());
                    P3tiles[2] = Integer.parseInt(MYT.getText());
                    P3tiles[3] = Integer.parseInt(CT.getText());
                    P3tiles[4] = Integer.parseInt(ST.getText());
                    P3tiles[5] = Integer.parseInt(ABT.getText());
                    P3tiles[6] = Integer.parseInt(ABrT.getText());
                    P3tiles[7] = Integer.parseInt(ART.getText());
                    P3tiles[8] = Integer.parseInt(AGT.getText());
                    P3tiles[9] = Integer.parseInt(AYT.getText());
                    P3tiles[10] = Integer.parseInt(APT.getText());
                    P3tiles[11] = Integer.parseInt(UBT.getText());
                    P3tiles[12] = Integer.parseInt(LBT.getText());
                    P3tiles[13] = Integer.parseInt(UsBT.getText());
                    P3tiles[14] = Integer.parseInt(LsBT.getText());

                    if(P4tiles[0] < 10) {
                        changeText(MGT, "0" + String.valueOf(P4tiles[0]));
                    }
                    else{
                        changeText(MGT, String.valueOf(P4tiles[0]));
                    }
                    if(P4tiles[1] < 10){
                        changeText(MRT, "0" + String.valueOf(P4tiles[1]));
                    }
                    else{
                        changeText(MRT, String.valueOf(P4tiles[1]));
                    }
                    if(P4tiles[2] < 10){
                        changeText(MYT, "0" + String.valueOf(P4tiles[2]));
                    }
                    else{
                        changeText(MYT, String.valueOf(P4tiles[2]));
                    }
                    if(P4tiles[3] < 10){
                        changeText(CT, "0" + String.valueOf(P4tiles[3]));
                    }
                    else{
                        changeText(CT, String.valueOf(P4tiles[3]));
                    }
                    if(P4tiles[4] < 10){
                        changeText(ST, "0" + String.valueOf(P4tiles[4]));
                    }
                    else{
                        changeText(ST, String.valueOf(P4tiles[4]));
                    }
                    if(P4tiles[5] < 10){
                        changeText(ABT, "0" + String.valueOf(P4tiles[5]));
                    }
                    else{
                        changeText(ABT, String.valueOf(P4tiles[5]));
                    }
                    if(P4tiles[6] < 10){
                        changeText(ABrT, "0" + String.valueOf(P4tiles[6]));
                    }
                    else{
                        changeText(ABrT, String.valueOf(P4tiles[6]));
                    }
                    if(P4tiles[7] < 10){
                        changeText(ART, "0" + String.valueOf(P4tiles[7]));
                    }
                    else{
                        changeText(ART, String.valueOf(P4tiles[7]));
                    }
                    if(P4tiles[8] < 10){
                        changeText(AGT, "0" + String.valueOf(P4tiles[8]));
                    }
                    else{
                        changeText(AGT, String.valueOf(P4tiles[8]));
                    }
                    if(P4tiles[9] < 10){
                        changeText(AYT, "0" + String.valueOf(P4tiles[9]));
                    }
                    else{
                        changeText(AYT, String.valueOf(P4tiles[9]));
                    }
                    if(P4tiles[10] < 10){
                        changeText(APT, "0" + String.valueOf(P4tiles[10]));
                    }
                    else{
                        changeText(APT, String.valueOf(P4tiles[10]));
                    }
                    if(P4tiles[11] < 10){
                        changeText(UBT, "0" + String.valueOf(P4tiles[11]));
                    }
                    else{
                        changeText(UBT, String.valueOf(P4tiles[11]));
                    }
                    if(P4tiles[12] < 10){
                        changeText(LBT, "0" + String.valueOf(P4tiles[12]));
                    }
                    else{
                        changeText(LBT, String.valueOf(P4tiles[12]));
                    }
                    if(P4tiles[13] < 10){
                        changeText(UsBT, "0" + String.valueOf(P4tiles[13]));
                    }
                    else{
                        changeText(UsBT, String.valueOf(P4tiles[13]));
                    }
                    if(P4tiles[14] < 10){
                        changeText(LsBT, "0" + String.valueOf(P4tiles[14]));
                    }
                    else{
                        changeText(LsBT, String.valueOf(P4tiles[14]));
                    }
                }
            }

            Playing_field.repaint();

        }

    }
    /* a class which is used for doing some action after the Bag(draw) button has been pushed */
    public class BagListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the Draw button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the Draw button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{
            if(game.getPlayerNumber() == 4 && Nturn == 0){
                if(game.getPlayer(in).getTimeToPlay() == 0){
                    return;
                }
                game.PlayTurn(game.getPlayer(in));
                int k = 0;
                if(getMosaicX() == 0){
                    setMosaicX(16);
                }
                if(getMosaicY() == 0){
                    setMosaicY(15);
                }
                if(getStatueX() == 0){
                    setStatueX(409);
                }
                if(getStatueY() == 0){
                    setStatueY(15);
                }
                if(getAmphoraX() == 0){
                    setAmphoraX(16);
                }
                if(getAmphoraY() == 0){
                    setAmphoraY(407);
                }
                if(getSkeletonX() == 0){
                    setSkeletonX(409);
                }
                if(getSkeletonY() == 0){
                    setSkeletonY(408);
                }
                if(getLandslideX() == 0){
                    setLandslideX(214);
                }
                if(getLandslideY() == 0){
                    setLandslideY(262);
                }
                while(k<4){
                    String l = game.getPlayer(in).getHand()[k].getType();
                    if(l == "Mosaic Tile"){
                        String c = game.getPlayer(in).getHand()[k].getColor();
                        Buttons[0].setBounds(getMosaicX(), getMosaicY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getMosaicY() >= 147 && getMosaicX() >= 148){
                            setMosaicY(15);
                            setMosaicX(16);
                        }
                        else if(getMosaicX() == 148){
                            setMosaicY(getMosaicY() + 44);
                            setMosaicX(16);
                        }
                        else{
                            setMosaicX(getMosaicX() + 44);
                        }
                        if(c == "Green"){
                            imageURL = cldr.getResource("images_2020/mosaic_greenS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Mosaic Green");
                        }
                        else if(c == "Red"){
                            imageURL = cldr.getResource("images_2020/mosaic_redS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Mosaic Red");
                        }
                        else{
                            imageURL = cldr.getResource("images_2020/mosaic_yellowS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Mosaic Yellow");
                        }
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Caryatid Tile"){
                        Buttons[0].setBounds(getStatueX(), getStatueY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getStatueY() >= 147 && getStatueX() >= 541){
                            setStatueX(409);
                            setStatueY(15);
                        }
                        else if(getStatueX() == 541){
                            setStatueY(getStatueY() + 44);
                            setStatueX(409);
                        }
                        else{
                            setStatueX(getStatueX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/caryatidS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Caryatid");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Sphinx Tile"){
                        Buttons[0].setBounds(getStatueX(), getStatueY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getStatueY() >= 147 && getStatueX() >= 541){
                            setStatueX(409);
                            setStatueY(15);
                        }
                        else if(getStatueX() == 541){
                            setStatueY(getStatueY() + 44);
                            setStatueX(409);
                        }
                        else{
                            setStatueX(getStatueX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/sphinxS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Sphinx");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Amphora"){
                        String c = game.getPlayer(in).getHand()[k].getColor();
                        Buttons[0].setBounds(getAmphoraX(), getAmphoraY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getAmphoraY() >= 539 && getAmphoraX() >= 148){
                            setAmphoraX(16);
                            setAmphoraY(407);
                        }
                        else if(getAmphoraX() == 148){
                            setAmphoraY(getAmphoraY() + 44);
                            setAmphoraX(16);
                        }
                        else{
                            setAmphoraX(getAmphoraX() + 44);
                        }
                        if(c == "Blue"){
                            imageURL = cldr.getResource("images_2020/amphora_blueS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Blue");
                        }
                        else if(c == "Brown"){
                            imageURL = cldr.getResource("images_2020/amphora_brownS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Brown");
                        }
                        else if(c == "Red"){
                            imageURL = cldr.getResource("images_2020/amphora_redS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Red");
                        }
                        else if(c == "Green"){
                            imageURL = cldr.getResource("images_2020/amphora_greenS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Green");
                        }
                        else if(c == "Yellow"){
                            imageURL = cldr.getResource("images_2020/amphora_yellowS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Yellow");
                        }
                        else{
                            imageURL = cldr.getResource("images_2020/amphora_purpleS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Purple");
                        }

                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Upper Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_big_topS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Upper Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Lower Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_big_bottomS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Lower Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Upper Small Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_small_topS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Upper Small Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Lower Small Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_small_bottomS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Lower Small Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else{
                        Buttons[0].setBounds(getLandslideX(), getLandslideY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                            tilesInBoard[i].setName("Landslide");
                        }
                        if(getLandslideX() == 346){
                            setLandslideY(getLandslideY() + 44);
                            setLandslideX(214);
                        }
                        else{
                            setLandslideX(getLandslideX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/landslideScaled.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Landslide");
                    }
                    Playing_field.setLayer(Buttons[0], 1);
                    Playing_field.add(Buttons[0]);
                    Buttons[0] = Buttons[size-1];
                    Buttons[size-1] = null;
                    size = size-1;
                    Playing_field.repaint();
                    k++;
                }
                Nturn = 1;
                int ik = 0;
                while(ik<24 && game.getB().getLandArea()[ik] != null){
                    ik++;
                }
                if(ik >= 16){
                    int W1,W2,W3,W4;
                    game.setGameOver(true);
                    game.findWinner();
                    JOptionPane.showMessageDialog(ui, game.getPlayer(0).getName() + "'s total points are: " + game.getPlayer(0).getTotalPoints() + "\n" + game.getPlayer(1).getName() + "'s total points are: " + game.getPlayer(1).getTotalPoints() + "\n" + game.getPlayer(2).getName() + "'s total points are: " + game.getPlayer(2).getTotalPoints() + "\n" + game.getPlayer(3).getName() + "'s total points are: " + game.getPlayer(3).getTotalPoints(), "Info", JOptionPane.PLAIN_MESSAGE);
                    if(game.getPlayer(0).getIsWinner() == 1){
                        W1 = 1;
                    }
                    else{
                        W1 = 0;
                    }
                    if(game.getPlayer(1).getIsWinner() == 1){
                        W2 = 1;
                    }
                    else{
                        W2 = 0;
                    }
                    if(game.getPlayer(2).getIsWinner() == 1){
                        W3 = 1;
                    }
                    else{
                        W3 = 0;
                    }
                    if(game.getPlayer(3).getIsWinner() == 1){
                        W4 = 1;
                    }
                    else{
                        W4 = 0;
                    }
                    if(W1 == 1 && W2 == 1 && W3 == 1 && W4 == 1){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(0).getName() + "\n" + game.getPlayer(1).getName() + "\n" + game.getPlayer(2).getName() + "\n" + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 1 && W2 == 1 && W3 == 1 && W4 == 0){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(0).getName() + "\n" + game.getPlayer(1).getName() + "\n" + game.getPlayer(2).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 1 && W2 == 1 && W3 == 0 && W4 == 1){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(0).getName() + "\n" + game.getPlayer(1).getName() + "\n" + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 1 && W2 == 0 && W3 == 1 && W4 == 1){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(0).getName() + "\n" + game.getPlayer(2).getName() + "\n" + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 0 && W2 == 1 && W3 == 1 && W4 == 1){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(1).getName() + "\n" + game.getPlayer(2).getName() + "\n" + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 1 && W2 == 1 && W3 == 0 && W4 == 0){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(0).getName() + "\n" + game.getPlayer(1).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 1 && W2 == 0 && W3 == 1 && W4 == 0){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(0).getName() + "\n" + game.getPlayer(2).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 1 && W2 == 0 && W3 == 0 && W4 == 1){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(0).getName() + "\n" + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 0 && W2 == 1 && W3 == 1 && W4 == 0){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(1).getName() + "\n" + game.getPlayer(2).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 0 && W2 == 1 && W3 == 0 && W4 == 1){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(1).getName() + "\n" + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 0 && W2 == 0 && W3 == 1 && W4 == 1){
                        JOptionPane.showMessageDialog(ui, "The winners of the game are: \n" + game.getPlayer(2).getName() + "\n" + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 1 && W2 == 0 && W3 == 0 && W4 == 0){
                        JOptionPane.showMessageDialog(ui, "The winner of the game is: " + game.getPlayer(0).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 0 && W2 == 1 && W3 == 0 && W4 == 0){
                        JOptionPane.showMessageDialog(ui, "The winner of the game is: " + game.getPlayer(1).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(W1 == 0 && W2 == 0 && W3 == 1 && W4 == 0){
                        JOptionPane.showMessageDialog(ui, "The winner of the game is: " + game.getPlayer(2).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(ui, "The winner of the game is: " + game.getPlayer(3).getName(), "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }

                    System.exit(1);
                }
            }
            else if(game.getPlayerNumber() == 1 && Nturn == 0){
                game.PlayTurn(game.getPlayer(0));
                int k = 0;
                if(getMosaicX() == 0){
                    setMosaicX(16);
                }
                if(getMosaicY() == 0){
                    setMosaicY(15);
                }
                if(getStatueX() == 0){
                    setStatueX(409);
                }
                if(getStatueY() == 0){
                    setStatueY(15);
                }
                if(getAmphoraX() == 0){
                    setAmphoraX(16);
                }
                if(getAmphoraY() == 0){
                    setAmphoraY(407);
                }
                if(getSkeletonX() == 0){
                    setSkeletonX(409);
                }
                if(getSkeletonY() == 0){
                    setSkeletonY(408);
                }
                if(getLandslideX() == 0){
                    setLandslideX(214);
                }
                if(getLandslideY() == 0){
                    setLandslideY(262);
                }
                while(k<4){
                    String l = game.getPlayer(0).getHand()[k].getType();
                    if(l == "Mosaic Tile"){
                        String c = game.getPlayer(in).getHand()[k].getColor();
                        Buttons[0].setBounds(getMosaicX(), getMosaicY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getMosaicY() >= 147 && getMosaicX() >= 148){
                            setMosaicY(15);
                            setMosaicX(16);
                        }
                        else if(getMosaicX() == 148){
                            setMosaicY(getMosaicY() + 44);
                            setMosaicX(16);
                        }
                        else{
                            setMosaicX(getMosaicX() + 44);
                        }
                        if(c == "Green"){
                            imageURL = cldr.getResource("images_2020/mosaic_greenS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Mosaic Green");
                        }
                        else if(c == "Red"){
                            imageURL = cldr.getResource("images_2020/mosaic_redS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Mosaic Red");
                        }
                        else{
                            imageURL = cldr.getResource("images_2020/mosaic_yellowS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Mosaic Yellow");
                        }
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Caryatid Tile"){
                        Buttons[0].setBounds(getStatueX(), getStatueY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getStatueY() >= 147 && getStatueX() >= 541){
                            setStatueX(409);
                            setStatueY(15);
                        }
                        else if(getStatueX() == 541){
                            setStatueY(getStatueY() + 44);
                            setStatueX(409);
                        }
                        else{
                            setStatueX(getStatueX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/caryatidS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Caryatid");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Sphinx Tile"){
                        Buttons[0].setBounds(getStatueX(), getStatueY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getStatueY() >= 147 && getStatueX() >= 541){
                            setStatueX(409);
                            setStatueY(15);
                        }
                        else if(getStatueX() == 541){
                            setStatueY(getStatueY() + 44);
                            setStatueX(409);
                        }
                        else{
                            setStatueX(getStatueX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/sphinxS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Sphinx");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Amphora"){
                        String c = game.getPlayer(in).getHand()[k].getColor();
                        Buttons[0].setBounds(getAmphoraX(), getAmphoraY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getAmphoraY() >= 539 && getAmphoraX() >= 148){
                            setAmphoraX(16);
                            setAmphoraY(407);
                        }
                        else if(getAmphoraX() == 148){
                            setAmphoraY(getAmphoraY() + 44);
                            setAmphoraX(16);
                        }
                        else{
                            setAmphoraX(getAmphoraX() + 44);
                        }
                        if(c == "Blue"){
                            imageURL = cldr.getResource("images_2020/amphora_blueS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Blue");
                        }
                        else if(c == "Brown"){
                            imageURL = cldr.getResource("images_2020/amphora_brownS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Brown");
                        }
                        else if(c == "Red"){
                            imageURL = cldr.getResource("images_2020/amphora_redS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Red");
                        }
                        else if(c == "Green"){
                            imageURL = cldr.getResource("images_2020/amphora_greenS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Green");
                        }
                        else if(c == "Yellow"){
                            imageURL = cldr.getResource("images_2020/amphora_yellowS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Yellow");
                        }
                        else{
                            imageURL = cldr.getResource("images_2020/amphora_purpleS.png");
                            Buttons[0].setIcon(new ImageIcon(imageURL));
                            Buttons[0].setName("Amphora Purple");
                        }

                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Upper Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_big_topS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Upper Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Lower Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_big_bottomS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Lower Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Upper Small Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_small_topS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Upper Small Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else if(l == "Lower Small Body"){
                        Buttons[0].setBounds(getSkeletonX(), getSkeletonY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getSkeletonY() >= 540 && getSkeletonX() >= 541){
                            setSkeletonX(409);
                            setSkeletonY(408);
                        }
                        else if(getSkeletonX() == 541){
                            setSkeletonY(getSkeletonY() + 44);
                            setSkeletonX(409);
                        }
                        else{
                            setSkeletonX(getSkeletonX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/skeleton_small_bottomS.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Lower Small Body");
                        Buttons[0].addActionListener(new TileListener());
                    }
                    else{
                        Buttons[0].setBounds(getLandslideX(), getLandslideY(), 44, 44);
                        if(tilesInBoard[0] == null){
                            tilesInBoard[0] = Buttons[0];
                        }
                        else{
                            int i = 0;
                            while(tilesInBoard[i] != null){
                                i++;
                            }
                            tilesInBoard[i] = Buttons[0];
                        }
                        if(getLandslideX() == 346){
                            setLandslideY(getLandslideY() + 44);
                            setLandslideX(214);
                        }
                        else{
                            setLandslideX(getLandslideX() + 44);
                        }
                        imageURL = cldr.getResource("images_2020/landslideScaled.png");
                        Buttons[0].setIcon(new ImageIcon(imageURL));
                        Buttons[0].setName("Landslide");
                    }
                    Playing_field.setLayer(Buttons[0], 1);
                    Playing_field.add(Buttons[0]);
                    Buttons[0] = Buttons[size-1];
                    Buttons[size-1] = null;
                    size = size-1;
                    Playing_field.repaint();
                    k++;
                }
                Nturn = 1;
                int ik = 0;
                while(ik<24 && game.getB().getLandArea()[ik] != null){
                    ik++;
                }
                if(ik >= 16) {
                    game.setGameOver(true);
                    game.getPlayer(0).findTurnPoints();
                    game.getPlayer(0).calculatePoints();
                    game.getR().areaTotalPoints();
                    if (game.getPlayer(0).getCaryatidNum() > game.getR().getCaryatidNum()) {
                        game.getPlayer(0).setTotalPoints(game.getPlayer(0).getTotalPoints() + 6);
                    } else if (game.getPlayer(0).getCaryatidNum() == game.getR().getCaryatidNum()) {
                        game.getPlayer(0).setTotalPoints(game.getPlayer(0).getTotalPoints() + 3);
                        game.getR().setTotalPoints(game.getR().getTotalPoints() + 3);
                    } else {
                        game.getR().setTotalPoints(game.getR().getTotalPoints() + 6);
                    }
                    if (game.getPlayer(0).getSphinxNum() > game.getR().getSphinxNum()) {
                        game.getPlayer(0).setTotalPoints(game.getPlayer(0).getTotalPoints() + 6);
                    } else if (game.getPlayer(0).getSphinxNum() == game.getR().getSphinxNum()) {
                        game.getPlayer(0).setTotalPoints(game.getPlayer(0).getTotalPoints() + 3);
                        game.getR().setTotalPoints(game.getR().getTotalPoints() + 3);
                    } else {
                        game.getR().setTotalPoints(game.getR().getTotalPoints() + 6);
                    }
                    JOptionPane.showMessageDialog(ui, game.getPlayer(0).getName() + "'s total points are: " + game.getPlayer(0).getTotalPoints() + "\n" + "Grave robber's total points are: " + game.getR().getTotalPoints(), "Info", JOptionPane.PLAIN_MESSAGE);
                    if (game.getPlayer(0).getTotalPoints() > game.getR().getTotalPoints()) {
                        JOptionPane.showMessageDialog(ui, "The winner of the game is: " + game.getPlayer(0).getName(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(ui, "The winner game is: Grave robber", "Too Bad", JOptionPane.PLAIN_MESSAGE);
                    }
                    System.exit(1);
                }
            }
        }
    }
    /* a class which is used for doing some action after the Save button has been pushed */
    public class SaveListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the Save button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the Save button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{

        }
    }
    /* a class which is used for doing some action after the Continue button has been pushed */
    public class ContinueListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the Save button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the Save button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{

        }
    }
    /* a class which is used for doing some action after a card button has been pushed */
    public class CardListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after a Card button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after a Card button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{
            if(Nturn == 0){
                return;
            }
            Object obj = e.getSource();
            if(obj instanceof JButton){
                JButton C = (JButton)obj;
                if(C.getName() == "Archeologist"){
                    if(card == 1){
                        JOptionPane.showMessageDialog(ui, "You are already using a card.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(game.getPlayer(in).getCharacter("Archeologist").getUsed() == true){
                        JOptionPane.showMessageDialog(ui, "You have already used this card", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        setCharacter("Archeologist");
                        card = 1;
                        game.getPlayer(in).getCharacter("Archeologist").setUsed(true);
                        us[0].setOpaque(true);
                        done = 2;
                    }
                }
                else if(C.getName() == "Digger"){
                    if(card == 1){
                        JOptionPane.showMessageDialog(ui, "You are already using a card.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(game.getPlayer(in).getCharacter("Digger").getUsed() == true){
                        JOptionPane.showMessageDialog(ui, "You have already used this card", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        setCharacter("Digger");
                        card = 1;
                        game.getPlayer(in).getCharacter("Digger").setUsed(true);
                        us[1].setOpaque(true);
                        done = 2;
                    }
                }
                else if(C.getName() == "Assistant"){
                    if(card == 1){
                        JOptionPane.showMessageDialog(ui, "You are already using a card.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(game.getPlayer(in).getCharacter("Assistant").getUsed() == true){
                        JOptionPane.showMessageDialog(ui, "You have already used this card", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        setCharacter("Assistant");
                        card = 1;
                        game.getPlayer(in).getCharacter("Assistant").setUsed(true);
                        us[2].setOpaque(true);
                    }
                }
                else{
                    if(card == 1){
                        JOptionPane.showMessageDialog(ui, "You are already using a card.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(game.getPlayer(in).getCharacter("Professor").getUsed() == true){
                        JOptionPane.showMessageDialog(ui, "You have already used this card", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        setCharacter("Professor");
                        card = 1;
                        game.getPlayer(in).getCharacter("Professor").setUsed(true);
                        us[3].setOpaque(true);
                        done = 3;
                    }
                }
            }
            Playing_field.repaint();
        }
    }
    /* a class which is used for doing some action after a Tile button has been pushed */
    public class TileListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after a Tile button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after a Tile button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{
            if(Nturn == 0){
                JOptionPane.showMessageDialog(ui, "You have to draw from the bag first.", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(getTilesTaken() >= 2 && card == 0){
                JOptionPane.showMessageDialog(ui, "You can't take more than 2 tiles each turn!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                int id;
                Object obj = e.getSource();
                if(obj instanceof JButton){
                    JButton m = (JButton)obj;
                    int i = 0;
                    while(tilesInBoard[i].getName() != m.getName()){
                        i++;
                        if(tilesInBoard[i].isVisible() == false){
                            i++;
                        }
                    }
                    if(card == 1 && getCharacter() == "Archeologist"){
                        if((m.getName() == "Mosaic Green" || m.getName() == "Mosaic Red" || m.getName() == "Mosaic Yellow") && getArea() == "Amphora Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else if((m.getName() == "Caryatid" || m.getName() == "Sphinx") && getArea() == "Statue Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else if((m.getName() == "Amphora Blue" || m.getName() == "Amphora Brown" || m.getName() == "Amphora Red" || m.getName() == "Amphora Green" || m.getName() == "Amphora Yellow" || m.getName() == "Amphora Purple") && getArea() == "Vase Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else if((m.getName() == "Upper Body" || m.getName() == "Lower Body" || m.getName() == "Upper Small Body" || m.getName() == "Lower Small Body") && getArea() == "Skeleton Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            if(m.getName() == "Mosaic Green"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getAmphoraArea()[o].getColor() != "Green"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                                game.getB().removeTile("AmphoraArea", o);
                                id = Integer.parseInt(MGT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(MGT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(MGT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Mosaic Red"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getAmphoraArea()[o].getColor() != "Red"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                                game.getB().removeTile("AmphoraArea", o);
                                id = Integer.parseInt(MRT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(MRT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(MRT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Mosaic Yellow"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getAmphoraArea()[o].getColor() != "Yellow"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                                game.getB().removeTile("AmphoraArea", o);
                                id = Integer.parseInt(MYT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(MYT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(MYT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Caryatid"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getStatueArea()[o].getType() != "Caryatid Tile"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                                game.getB().removeTile("StatueArea", o);
                                id = Integer.parseInt(CT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(CT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(CT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Sphinx"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getStatueArea()[o].getType() != "Sphinx Tile"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                                game.getB().removeTile("StatueArea", o);
                                id = Integer.parseInt(ST.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ST, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(ST, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Amphora Blue"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Blue"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(ABT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ABT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(ABT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Amphora Brown"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Brown"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(ABrT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ABrT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(ABrT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Amphora Red"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Red"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(ART.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ART, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(ART, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Amphora Green"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Green"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(AGT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(AGT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(AGT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Amphora Yellow"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Yellow"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(AYT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(AYT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(AYT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Amphora Purple"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Purple"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(APT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(APT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(APT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Upper Body"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Upper Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(UBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(UBT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(UBT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Lower Body"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Lower Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(LBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(LBT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(LBT, String.valueOf(id));
                                }
                                done--;
                            }
                            else if(m.getName() == "Upper Small Body"){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Upper Small Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(UsBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(UsBT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(UsBT, String.valueOf(id));
                                }
                                done--;
                            }
                            else{
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Lower Small Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(LsBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(LsBT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(LsBT, String.valueOf(id));
                                }
                                done--;
                            }
                        }
                    }
                    else if(card == 1 && getCharacter() == "Digger"){
                        if(m.getName() == "Mosaic Green" && getArea() == "Amphora Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getAmphoraArea()[o].getColor() != "Green"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                            game.getB().removeTile("AmphoraArea", o);
                            id = Integer.parseInt(MGT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(MGT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(MGT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Mosaic Red" && getArea() == "Amphora Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getAmphoraArea()[o].getColor() != "Red"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                            game.getB().removeTile("AmphoraArea", o);
                            id = Integer.parseInt(MRT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(MRT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(MRT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Mosaic Yellow" && getArea() == "Amphora Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getAmphoraArea()[o].getColor() != "Yellow"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                            game.getB().removeTile("AmphoraArea", o);
                            id = Integer.parseInt(MYT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(MYT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(MYT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Caryatid" && getArea() == "Statue Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getStatueArea()[o].getType() != "Caryatid Tile"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                            game.getB().removeTile("StatueArea", o);
                            id = Integer.parseInt(CT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(CT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(CT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Sphinx" && getArea() == "Statue Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getStatueArea()[o].getType() != "Sphinx Tile"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                            game.getB().removeTile("StatueArea", o);
                            id = Integer.parseInt(ST.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ST, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(ST, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Amphora Blue" && getArea() == "Vase Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Blue"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(ABT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ABT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(ABT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Amphora Brown" && getArea() == "Vase Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Brown"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(ABrT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ABrT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(ABrT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Amphora Red" && getArea() == "Vase Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Red"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(ART.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ART, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(ART, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Amphora Green" && getArea() == "Vase Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Green"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(AGT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(AGT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(AGT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Amphora Yellow" && getArea() == "Vase Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Yellow"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(AYT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(AYT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(AYT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Amphora Purple" && getArea() == "Vase Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Purple"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(APT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(APT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(APT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Upper Body" && getArea() == "Skeleton Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Upper Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(UBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(UBT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(UBT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Lower Body" && getArea() == "Skeleton Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Lower Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(LBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(LBT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(LBT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Upper Small Body" && getArea() == "Skeleton Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Upper Small Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(UsBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(UsBT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(UsBT, String.valueOf(id));
                            }
                            done--;
                        }
                        else if(m.getName() == "Lower Small Body" && getArea() == "Skeleton Area"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Lower Small Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(LsBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(LsBT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(LsBT, String.valueOf(id));
                            }
                            done--;
                        }
                        else{
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else if(card == 1 && getCharacter() == "Professor"){
                        if((m.getName() == "Mosaic Green" || m.getName() == "Mosaic Red" || m.getName() == "Mosaic Yellow") && getArea() == "Amphora Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else if((m.getName() == "Caryatid" || m.getName() == "Sphinx") && getArea() == "Statue Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else if((m.getName() == "Amphora Blue" || m.getName() == "Amphora Brown" || m.getName() == "Amphora Red" || m.getName() == "Amphora Green" || m.getName() == "Amphora Yellow" || m.getName() == "Amphora Purple") && getArea() == "Vase Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else if((m.getName() == "Upper Body" || m.getName() == "Lower Body" || m.getName() == "Upper Small Body" || m.getName() == "Lower Small Body") && getArea() == "Skeleton Area"){
                            JOptionPane.showMessageDialog(ui, "You can't pick tiles from this area!", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            if(getArea() == "Amphora Area") {
                                areas[0] = "Amphora Area";
                            }
                            else if(getArea() == "Statue Area"){
                                areas[0] = "Statue Area";
                            }
                            else if(getArea() == "Vase Area"){
                                areas[0] = "Vase Area";
                            }
                            else{
                                areas[0] = "Skeleton Area";
                            }
                            int hid = 0;
                            while(hid<4 && areas[hid] != null) {
                                if(areas[hid] == "Amphora Area"){
                                    M = 1;
                                }
                                if (areas[hid] == "Statue Area") {
                                    S = 1;
                                }
                                if (areas[hid] == "Vase Area") {
                                    A = 1;
                                }
                                if (areas[hid] == "Skeleton Area") {
                                    Skel = 1;
                                }
                                hid++;
                            }
                            if(m.getName() == "Mosaic Green" && M == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getAmphoraArea()[o].getColor() != "Green"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                                game.getB().removeTile("AmphoraArea", o);
                                id = Integer.parseInt(MGT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(MGT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(MGT, String.valueOf(id));
                                }
                                areas[hid] = "Amphora Area";
                                done--;
                            }
                            else if(m.getName() == "Mosaic Red" && M == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getAmphoraArea()[o].getColor() != "Red"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                                game.getB().removeTile("AmphoraArea", o);
                                id = Integer.parseInt(MRT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(MRT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(MRT, String.valueOf(id));
                                }
                                areas[hid] = "Amphora Area";
                                done--;
                            }
                            else if(m.getName() == "Mosaic Yellow" && M == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getAmphoraArea()[o].getColor() != "Yellow"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                                game.getB().removeTile("AmphoraArea", o);
                                id = Integer.parseInt(MYT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(MYT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(MYT, String.valueOf(id));
                                }
                                areas[hid] = "Amphora Area";
                                done--;
                            }
                            else if(m.getName() == "Caryatid" && S == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getStatueArea()[o].getType() != "Caryatid Tile"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                                game.getB().removeTile("StatueArea", o);
                                id = Integer.parseInt(CT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(CT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(CT, String.valueOf(id));
                                }
                                areas[hid] = "Statue Area";
                                done--;
                            }
                            else if(m.getName() == "Sphinx" && S == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getStatueArea()[o].getType() != "Sphinx Tile"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                                game.getB().removeTile("StatueArea", o);
                                id = Integer.parseInt(ST.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ST, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(ST, String.valueOf(id));
                                }
                                areas[hid] = "Statue Area";
                                done--;
                            }
                            else if(m.getName() == "Amphora Blue" && A == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Blue"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(ABT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ABT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(ABT, String.valueOf(id));
                                }
                                areas[hid] = "Vase Area";
                                done--;
                            }
                            else if(m.getName() == "Amphora Brown" && A == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Brown"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(ABrT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ABrT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(ABrT, String.valueOf(id));
                                }
                                areas[hid] = "Vase Area";
                                done--;
                            }
                            else if(m.getName() == "Amphora Red" && A == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Red"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(ART.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(ART, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(ART, String.valueOf(id));
                                }
                                areas[hid] = "Vase Area";
                                done--;
                            }
                            else if(m.getName() == "Amphora Green" && A == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Green"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(AGT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(AGT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(AGT, String.valueOf(id));
                                }
                                areas[hid] = "Vase Area";
                                done--;
                            }
                            else if(m.getName() == "Amphora Yellow" && A == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Yellow"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(AYT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(AYT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(AYT, String.valueOf(id));
                                }
                                areas[hid] = "Vase Area";
                                done--;
                            }
                            else if(m.getName() == "Amphora Purple" && A == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getVaseArea()[o].getColor() != "Purple"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                                game.getB().removeTile("VaseArea", o);
                                id = Integer.parseInt(APT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(APT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(APT, String.valueOf(id));
                                }
                                areas[hid] = "Vase Area";
                                done--;
                            }
                            else if(m.getName() == "Upper Body" && Skel == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Upper Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(UBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(UBT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(UBT, String.valueOf(id));
                                }
                                areas[hid] = "Skeleton Area";
                                done--;
                            }
                            else if(m.getName() == "Lower Body" && Skel == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Lower Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(LBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(LBT, "0" + String.valueOf(id));
                                }
                                else{
                                    changeText(LBT, String.valueOf(id));
                                }
                                areas[hid] = "Skeleton Area";
                                done--;
                            }
                            else if(m.getName() == "Upper Small Body" && Skel == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Upper Small Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(UsBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(UsBT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(UsBT, String.valueOf(id));
                                }
                                areas[hid] = "Skeleton Area";
                                done--;
                            }
                            else if(m.getName() == "Lower Body" && Skel == 0){
                                m.setVisible(false);
                                int o = 0;
                                while(game.getB().getSkeletonArea()[o].getType() != "Lower Small Body"){
                                    o++;
                                }
                                game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                                game.getB().removeTile("SkeletonArea", o);
                                id = Integer.parseInt(LsBT.getText());
                                id = id+1;
                                if(id < 10){
                                    changeText(LsBT, "0"+String.valueOf(id));
                                }
                                else{
                                    changeText(LsBT, String.valueOf(id));
                                }
                                areas[hid] = "Skeleton Area";
                                done--;
                            }
                            else{
                                JOptionPane.showMessageDialog(ui, "You can't take this tile!", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                    else{
                        if(m.getName() == "Mosaic Green"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getAmphoraArea()[o].getColor() != "Green"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                            game.getB().removeTile("AmphoraArea", o);
                            id = Integer.parseInt(MGT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(MGT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(MGT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Amphora Area");
                            }
                        }
                        else if(m.getName() == "Mosaic Red"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getAmphoraArea()[o].getColor() != "Red"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                            game.getB().removeTile("AmphoraArea", o);
                            id = Integer.parseInt(MRT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(MRT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(MRT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Amphora Area");
                            }
                        }
                        else if(m.getName() == "Mosaic Yellow"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getAmphoraArea()[o].getColor() != "Yellow"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getAmphoraArea()[o]);
                            game.getB().removeTile("AmphoraArea", o);
                            id = Integer.parseInt(MYT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(MYT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(MYT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Amphora Area");
                            }
                        }
                        else if(m.getName() == "Caryatid"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getStatueArea()[o].getType() != "Caryatid Tile"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                            game.getB().removeTile("StatueArea", o);
                            id = Integer.parseInt(CT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(CT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(CT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Statue Area");
                            }
                        }
                        else if(m.getName() == "Sphinx"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getStatueArea()[o].getType() != "Sphinx Tile"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getStatueArea()[o]);
                            game.getB().removeTile("StatueArea", o);
                            id = Integer.parseInt(ST.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ST, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(ST, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Statue Area");
                            }
                        }
                        else if(m.getName() == "Amphora Blue"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Blue"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(ABT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ABT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(ABT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Vase Area");
                            }
                        }
                        else if(m.getName() == "Amphora Brown"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Brown"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(ABrT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ABrT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(ABrT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Vase Area");
                            }
                        }
                        else if(m.getName() == "Amphora Red"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Red"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(ART.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(ART, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(ART, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Vase Area");
                            }
                        }
                        else if(m.getName() == "Amphora Green"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Green"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(AGT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(AGT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(AGT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Vase Area");
                            }
                        }
                        else if(m.getName() == "Amphora Yellow"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Yellow"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(AYT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(AYT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(AYT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Vase Area");
                            }
                        }
                        else if(m.getName() == "Amphora Purple"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getVaseArea()[o].getColor() != "Purple"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getVaseArea()[o]);
                            game.getB().removeTile("VaseArea", o);
                            id = Integer.parseInt(APT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(APT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(APT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Vase Area");
                            }
                        }
                        else if(m.getName() == "Upper Body"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Upper Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(UBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(UBT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(UBT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Skeleton Area");
                            }
                        }
                        else if(m.getName() == "Lower Body"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Lower Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(LBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(LBT, "0" + String.valueOf(id));
                            }
                            else{
                                changeText(LBT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Skeleton Area");
                            }
                        }
                        else if(m.getName() == "Upper Small Body"){
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Upper Small Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(UsBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(UsBT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(UsBT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Skeleton Area");
                            }
                        }
                        else{
                            m.setVisible(false);
                            int o = 0;
                            while(game.getB().getSkeletonArea()[o].getType() != "Lower Small Body"){
                                o++;
                            }
                            game.getPlayer(in).Add(game.getB().getSkeletonArea()[o]);
                            game.getB().removeTile("SkeletonArea", o);
                            id = Integer.parseInt(LsBT.getText());
                            id = id+1;
                            if(id < 10){
                                changeText(LsBT, "0"+String.valueOf(id));
                            }
                            else{
                                changeText(LsBT, String.valueOf(id));
                            }
                            if(card == 0){
                                setArea("Skeleton Area");
                            }

                        }
                    }
                    if(card == 1 && done == 0 && Nturn == 1){
                        card = 0;
                        Playing_field.repaint();
                    }
                    else if(done != 0 && Nturn == 1){
                        card = 1;
                        Playing_field.repaint();
                    }
                    else if(card == 0 && done == 0 && Nturn == 1){
                        setTilesTaken(getTilesTaken() + 1);
                        Playing_field.repaint();
                    }
                    else{
                        Playing_field.repaint();
                    }
                }
            }
        }
    }
    /* a class which is used for doing some action after the Exit button has been pushed */
    public class ExitListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the Exit button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the Exit button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{
            int h = JOptionPane.showConfirmDialog(ui, "Are you sure you want to exit?", "Warning", JOptionPane.YES_NO_OPTION);
            if(h == JOptionPane.NO_OPTION){
                return;
            }
            else{
                JOptionPane.showMessageDialog(ui, "Bye Bye (^w^)/" , null, JOptionPane.PLAIN_MESSAGE);
                System.exit(1);
            }
        }
    }

    /**
     * <b>Transformer</b>Sets the value of mosaic tile coordinate on the x axis
     * <b>Postcondition:</b>The value of the x axis of the mosaic tile is set.
     * @param mosaicX
     */
    public void setMosaicX(int mosaicX) {
        MosaicX = mosaicX;
    }

    /**
     * <b>Transformer</b>Sets the value of mosaic tile coordinate on the y axis
     * <b>Postcondition:</b>The value of the y axis of the mosaic tile is set.
     * @param mosaicY
     */
    public void setMosaicY(int mosaicY) {
        MosaicY = mosaicY;
    }

    /**
     * <b>Accessor:</b> Returns the x axis of the mosaic tile
     * <b>Postcondition:</b> The x axis of the mosaic tile has been returned
     * @return int MosaicX
     */
    public int getMosaicX() {
        return MosaicX;
    }

    /**
     * <b>Accessor:</b> Returns the y axis of the mosaic tile
     * <b>Postcondition:</b> The y axis of the mosaic tile has been returned
     * @return int MosaicY
     */
    public int getMosaicY() {
        return MosaicY;
    }

    /**
     * <b>Transformer</b>Sets the value of Statue tile coordinate on the x axis
     * <b>Postcondition:</b>The value of the x axis of the Statue tile is set.
     * @param statueX
     */
    public void setStatueX(int statueX) {
        StatueX = statueX;
    }

    /**
     * <b>Transformer</b>Sets the value of Statue tile coordinate on the y axis
     * <b>Postcondition:</b>The value of the y axis of the Statue tile is set.
     * @param statueY
     */
    public void setStatueY(int statueY) {
        StatueY = statueY;
    }

    /**
     * <b>Accessor:</b> Returns the x axis of the Statue tile
     * <b>Postcondition:</b> The x axis of the Statue tile has been returned
     * @return int StatueX
     */
    public int getStatueX() {
        return StatueX;
    }

    /**
     * <b>Accessor:</b> Returns the y axis of the Statue tile
     * <b>Postcondition:</b> The y axis of the Statue tile has been returned
     * @return int StatueY
     */
    public int getStatueY() {
        return StatueY;
    }

    /**
     * <b>Transformer</b>Sets the value of Amphora tile coordinate on the x axis
     * <b>Postcondition:</b>The value of the x axis of the Amphora tile is set.
     * @param amphoraX
     */
    public void setAmphoraX(int amphoraX) {
        AmphoraX = amphoraX;
    }

    /**
     * <b>Transformer</b>Sets the value of Amphora tile coordinate on the y axis
     * <b>Postcondition:</b>The value of the y axis of the Amphora tile is set.
     * @param amphoraY
     */
    public void setAmphoraY(int amphoraY) {
        AmphoraY = amphoraY;
    }

    /**
     * <b>Accessor:</b> Returns the x axis of the Amphora tile
     * <b>Postcondition:</b> The x axis of the Amphora tile has been returned
     * @return int AmphoraX
     */
    public int getAmphoraX() {
        return AmphoraX;
    }

    /**
     * <b>Accessor:</b> Returns the y axis of the Amphora tile
     * <b>Postcondition:</b> The y axis of the Amphora tile has been returned
     * @return int AmphoraY
     */
    public int getAmphoraY() {
        return AmphoraY;
    }

    /**
     * <b>Transformer</b>Sets the value of Skeleton tile coordinate on the x axis
     * <b>Postcondition:</b>The value of the x axis of the Skeleton tile is set.
     * @param skeletonX
     */
    public void setSkeletonX(int skeletonX) {
        SkeletonX = skeletonX;
    }

    /**
     * <b>Transformer</b>Sets the value of Skeleton tile coordinate on the y axis
     * <b>Postcondition:</b>The value of the y axis of the Skeleton tile is set.
     * @param skeletonY
     */
    public void setSkeletonY(int skeletonY) {
        SkeletonY = skeletonY;
    }

    /**
     * <b>Accessor:</b> Returns the x axis of the Skeleton tile
     * <b>Postcondition:</b> The x axis of the Skeleton tile has been returned
     * @return int SkeletonX
     */
    public int getSkeletonX() {
        return SkeletonX;
    }

    /**
     * <b>Accessor:</b> Returns the y axis of the Skeleton tile
     * <b>Postcondition:</b> The y axis of the Skeleton tile has been returned
     * @return int SkeletonY
     */
    public int getSkeletonY() {
        return SkeletonY;
    }

    /**
     * <b>Transformer</b>Sets the value of Landslide tile coordinate on the x axis
     * <b>Postcondition:</b>The value of the x axis of the Landslide tile is set.
     * @param landslideX
     */
    public void setLandslideX(int landslideX) {
        LandslideX = landslideX;
    }

    /**
     * <b>Transformer</b>Sets the value of Landslide tile coordinate on the y axis
     * <b>Postcondition:</b>The value of the y axis of the Landslide tile is set.
     * @param landslideY
     */
    public void setLandslideY(int landslideY) {
        LandslideY = landslideY;
    }

    /**
     * <b>Accessor:</b> Returns the x axis of the Landslide tile
     * <b>Postcondition:</b> The x axis of the Landslide tile has been returned
     * @return int LandslideX
     */
    public int getLandslideX() {
        return LandslideX;
    }

    /**
     * <b>Accessor:</b> Returns the y axis of the Landslide tile
     * <b>Postcondition:</b> The y axis of the Landslide tile has been returned
     * @return int LandslideY
     */
    public int getLandslideY() {
        return LandslideY;
    }

    /**
     * <b>Transformer</b>Sets the number of tiles taken by the player this turn(without using cards)
     * <b>Postcondition:</b>The number of tiles taken by the player this turn is set is set.
     * @param tiles
     */
    public void setTilesTaken(int tiles){
        tilesTaken = tiles;
    }

    /**
     * <b>Accessor:</b> Returns the number of tiles taken by the player this turn
     * <b>Postcondition:</b> The number of tiles taken by the player this turn has been returned
     * @return int tilesTaken
     */
    public int getTilesTaken() {
        return tilesTaken;
    }

    /**
     * <b>Transformer</b>Changes the text on a specific label
     * <b>Postcondition:</b>The text of a specific label has been changed.
     * @param label
     * @param text
     */
    public void changeText(JLabel label, String text){
        label.setText(text);
    }

    /**
     * <b>Transformer</b>Sets the last area that the player took a tile from(not including with cards)
     * <b>Postcondition:</b>The last area that the player took a tile from is set.
     * @param ar
     */
    public void setArea(String ar){
        this.area = ar;
    }

    /**
     * <b>Accessor:</b> Returns the last area that the player took a tile from
     * <b>Postcondition:</b> The last area that the player took a tile from has been returned
     * @return String area
     */
    public String getArea(){
        return area;
    }

    /**
     * <b>Transformer</b>Sets the name of a character
     * <b>Postcondition:</b>The name of a character is set.
     * @param g
     */
    public void setCharacter(String g){
        this.Character = g;
    }

    /**
     * <b>Accessor:</b> Returns the name of a character
     * <b>Postcondition:</b> The name of a character has been returned
     * @return String Character
     */
    public String getCharacter(){
        return Character;
    }

    /**
     * <b>Transformer</b>Sets the number of the playing player
     * <b>Postcondition:</b>The number of the playing player is set.
     * @param n
     */
    public void setIn(int n){
        this.in = n;
    }

    /**
     * <b>Accessor:</b> Returns the number of the playing player
     * <b>Postcondition:</b> The number of the playing player has been returned
     * @return int in
     */
    public int getIn(){
        return in;
    }
}
