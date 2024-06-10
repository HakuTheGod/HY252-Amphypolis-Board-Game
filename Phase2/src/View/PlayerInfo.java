package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class PlayerInfo extends JFrame{
    private String Color;
    private JDialog PlayerInfo;
    private String Name;
    private JButton Black, Red, Blue, Green;

    /**
     * <b>constructor</b>: Creates a new Player Info Window  <br />
     * <b>Postcondition:</b>: A new Player Info Window has been created
     * starting a new Player Info window
     */
    public PlayerInfo(int num, String last1, String last2, String last3){
            new JFrame("Player Menu");
            this.PlayerInfo = new JDialog(this, "Player Information", true);
            this.initButtons(num, last1, last2, last3);
            this.PlayerInfo.setLayout(new GridLayout(0, 1));
            addButtons(num, last1, last2, last3);
            this.pack();
            PlayerInfo.pack();
            this.setSize(500, 300);
            PlayerInfo.setSize(500,300);
            this.setLocationRelativeTo(null);
            PlayerInfo.setLocationRelativeTo(null);
            this.setActionListeners(num, last1, last2, last3);
            this.PlayerInfo.setVisible(true);
    }


    /**
     * <b>Transformer</b>Sets the color of the player
     * <b>Postcondition:</b>The color of the player has been set
     * @param color
     */
    public void setColor(String color) {
        Color = color;
    }

    /**
     * <b>Accessor:</b> Returns the player's Color
     * <b>Postcondition:</b> The player's Color has been returned
     * @return String Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * <b>Transformer</b>Sets the name of the player
     * <b>Postcondition:</b>The name of the player has been set
     * @param name
     */
    @Override
    public void setName(String name) {
        Name = name;
    }

    /**
     * <b>Accessor:</b> Returns the player's name
     * <b>Postcondition:</b> The player's name has been returned
     * @return String Name
     */
    @Override
    public String getName() {
        return Name;
    }

    /**
     * <b>Transformer(mutative)</b>:initializes some buttons and labels <br />
     * <p><b>Postcondition:</b> Some buttons and labels have been initialised</p>
     *
     */
    public void initButtons(int num, String Last1, String Last2, String Last3){
        if(num == 0){
            this.Black= new JButton("Black");
            this.Red = new JButton("Red");
            this.Blue = new JButton("Blue");
            this.Green = new JButton("Green");
        }
        else if(num == 1){
            if(Last1 == "Black"){
                this.Red = new JButton("Red");
                this.Blue = new JButton("Blue");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Red"){
                this.Black= new JButton("Black");
                this.Blue = new JButton("Blue");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Blue"){
                this.Black= new JButton("Black");
                this.Red = new JButton("Red");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Green"){
                this.Black= new JButton("Black");
                this.Red = new JButton("Red");
                this.Blue = new JButton("Blue");
            }
            else{
                System.out.println("Error: Unknown Color.");
                System.exit(0);
            }
        }
        else if(num == 2){
            if(Last1 == "Black" && Last2 == "Red"){
                this.Blue = new JButton("Blue");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Black" && Last2 == "Blue"){
                this.Red = new JButton("Red");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Black" && Last2 == "Green"){
                this.Red = new JButton("Red");
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Red" && Last2 == "Black"){
                this.Blue = new JButton("Blue");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Red" && Last2 == "Blue"){
                this.Black= new JButton("Black");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Red" && Last2 == "Green"){
                this.Black= new JButton("Black");
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Blue" && Last2 == "Black"){
                this.Red = new JButton("Red");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Blue" && Last2 == "Red"){
                this.Black= new JButton("Black");
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Blue" && Last2 == "Green"){
                this.Black= new JButton("Black");
                this.Red = new JButton("Red");
            }
            else if(Last1 == "Green" && Last2 == "Black"){
                this.Red = new JButton("Red");
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Green" && Last2 == "Red"){
                this.Black= new JButton("Black");
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Green" && Last2 == "Blue"){
                this.Black= new JButton("Black");
                this.Red = new JButton("Red");
            }
            else{
                System.out.println("Error: Unknown Color.");
                System.exit(0);
            }
        }
        else if(num == 3){
            if(Last1 == "Black" && Last2 == "Red" && Last3 == "Blue"){
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Black" && Last2 == "Red" && Last3 == "Green"){
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Black" && Last2 == "Blue" && Last3 == "Red"){
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Black" && Last2 == "Blue" && Last3 == "Green"){
                this.Red = new JButton("Red");
            }
            else if(Last1 == "Black" && Last2 == "Green" && Last3 == "Red"){
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Black" && Last2 == "Green" && Last3 == "Blue"){
                this.Red = new JButton("Red");
            }
            else if(Last1 == "Red" && Last2 == "Black" && Last3 == "Blue"){
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Red" && Last2 == "Black" && Last3 == "Green"){
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Red" && Last2 == "Blue" && Last3 == "Black"){
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Red" && Last2 == "Blue" && Last3 == "Green"){
                this.Black= new JButton("Black");
            }
            else if(Last1 == "Red" && Last2 == "Green" && Last3 == "Black"){
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Red" && Last2 == "Green" && Last3 == "Blue"){
                this.Black= new JButton("Black");
            }
            else if(Last1 == "Blue" && Last2 == "Black" && Last3 == "Red"){
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Blue" && Last2 == "Black" && Last3 == "Green"){
                this.Red = new JButton("Red");
            }
            else if(Last1 == "Blue" && Last2 == "Red" && Last3 == "Black"){
                this.Green = new JButton("Green");
            }
            else if(Last1 == "Blue" && Last2 == "Red" && Last3 == "Green"){
                this.Black= new JButton("Black");
            }
            else if(Last1 == "Blue" && Last2 == "Green" && Last3 == "Black"){
                this.Red = new JButton("Red");
            }
            else if(Last1 == "Blue" && Last2 == "Green" && Last3 == "Red"){
                this.Black= new JButton("Black");
            }
            else if(Last1 == "Green" && Last2 == "Black" && Last3 == "Red"){
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Green" && Last2 == "Black" && Last3 == "Blue"){
                this.Red = new JButton("Red");
            }
            else if(Last1 == "Green" && Last2 == "Red" && Last3 == "Black"){
                this.Blue = new JButton("Blue");
            }
            else if(Last1 == "Green" && Last2 == "Red" && Last3 == "Blue"){
                this.Black= new JButton("Black");
            }
            else if(Last1 == "Green" && Last2 == "Blue" && Last3 == "Black"){
                this.Red = new JButton("Red");
            }
            else if(Last1 == "Green" && Last2 == "Blue" && Last3 == "Red"){
                this.Black= new JButton("Black");
            }
            else{
                System.out.println("Error: Unknown Color.");
                System.exit(0);
            }
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * <b>Transformer(mutative)</b>:Adds some buttons to the frame <br />
     * <p><b>Postcondition:</b> Some buttons have been added to the frame </p>
     *
     */
    public void addButtons(int num, String Last1, String Last2, String Last3){
        if(num == 0){
            this.PlayerInfo.add(Black);
            this.PlayerInfo.add(Red);
            this.PlayerInfo.add(Blue);
            this.PlayerInfo.add(Green);
        }
        else if(num == 1){
            if(Last1 == "Black"){
                this.PlayerInfo.add(Red);
                this.PlayerInfo.add(Blue);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Red"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Blue);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Blue"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Red);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Green"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Red);
                this.PlayerInfo.add(Blue);
            }
            else{
                System.out.println("Error: Unknown Color.");
                System.exit(0);
            }
        }
        else if(num == 2){
            if(Last1 == "Black" && Last2 == "Red"){
                this.PlayerInfo.add(Blue);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Black" && Last2 == "Blue"){
                this.PlayerInfo.add(Red);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Black" && Last2 == "Green"){
                this.PlayerInfo.add(Red);
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Red" && Last2 == "Black"){
                this.PlayerInfo.add(Blue);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Red" && Last2 == "Blue"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Red" && Last2 == "Green"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Blue" && Last2 == "Black"){
                this.PlayerInfo.add(Red);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Blue" && Last2 == "Red"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Blue" && Last2 == "Green"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Red);
            }
            else if(Last1 == "Green" && Last2 == "Black"){
                this.PlayerInfo.add(Red);
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Green" && Last2 == "Red"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Green" && Last2 == "Blue"){
                this.PlayerInfo.add(Black);
                this.PlayerInfo.add(Red);
            }
            else{
                System.out.println("Error: Unknown Color.");
                System.exit(0);
            }
        }
        else if(num == 3){
            if(Last1 == "Black" && Last2 == "Red" && Last3 == "Blue"){
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Black" && Last2 == "Red" && Last3 == "Green"){
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Black" && Last2 == "Blue" && Last3 == "Red"){
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Black" && Last2 == "Blue" && Last3 == "Green"){
                this.PlayerInfo.add(Red);
            }
            else if(Last1 == "Black" && Last2 == "Green" && Last3 == "Red"){
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Black" && Last2 == "Green" && Last3 == "Blue"){
                this.PlayerInfo.add(Red);
            }
            else if(Last1 == "Red" && Last2 == "Black" && Last3 == "Blue"){
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Red" && Last2 == "Black" && Last3 == "Green"){
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Red" && Last2 == "Blue" && Last3 == "Black"){
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Red" && Last2 == "Blue" && Last3 == "Green"){
                this.PlayerInfo.add(Black);
            }
            else if(Last1 == "Red" && Last2 == "Green" && Last3 == "Black"){
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Red" && Last2 == "Green" && Last3 == "Blue"){
                this.PlayerInfo.add(Black);
            }
            else if(Last1 == "Blue" && Last2 == "Black" && Last3 == "Red"){
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Blue" && Last2 == "Black" && Last3 == "Green"){
                this.PlayerInfo.add(Red);
            }
            else if(Last1 == "Blue" && Last2 == "Red" && Last3 == "Black"){
                this.PlayerInfo.add(Green);
            }
            else if(Last1 == "Blue" && Last2 == "Red" && Last3 == "Green"){
                this.PlayerInfo.add(Black);
            }
            else if(Last1 == "Blue" && Last2 == "Green" && Last3 == "Black"){
                this.PlayerInfo.add(Red);
            }
            else if(Last1 == "Blue" && Last2 == "Green" && Last3 == "Red"){
                this.PlayerInfo.add(Black);
            }
            else if(Last1 == "Green" && Last2 == "Black" && Last3 == "Red"){
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Green" && Last2 == "Black" && Last3 == "Blue"){
                this.PlayerInfo.add(Red);
            }
            else if(Last1 == "Green" && Last2 == "Red" && Last3 == "Black"){
                this.PlayerInfo.add(Blue);
            }
            else if(Last1 == "Green" && Last2 == "Red" && Last3 == "Blue"){
                this.PlayerInfo.add(Black);
            }
            else if(Last1 == "Green" && Last2 == "Blue" && Last3 == "Black"){
                this.PlayerInfo.add(Red);
            }
            else if(Last1 == "Green" && Last2 == "Blue" && Last3 == "Red"){
                this.PlayerInfo.add(Black);
            }
            else{
                System.out.println("Error: Unknown Color.");
                System.exit(0);
            }
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * <b>Transformer</b> Sets the button's action listeners
     * <b>Postcondition:</b> The button's action listeners have been set
     *
     */
    public void setActionListeners(int num, String Last1, String Last2, String Last3){
        if(num == 0){
            Black.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setColor("Black");
                    PlayerInfo.setVisible(false);
                }
            });
            Red.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setColor("Red");
                    PlayerInfo.setVisible(false);
                }
            });
            Blue.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setColor("Blue");
                    PlayerInfo.setVisible(false);
                }
            });
            Green.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setColor("Green");
                    PlayerInfo.setVisible(false);
                }
            });
        }
        else if(num == 1){
            if(Last1 == "Black"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else if(num == 2){
            if(Last1 == "Black" && Last2 == "Red"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Black" && Last2 == "Blue"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Black" && Last2 == "Green"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Black"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Blue"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Green"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Black"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Red"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Green"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Black"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Red"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Blue"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else if(num == 3){
            if(Last1 == "Black" && Last2 == "Red" && Last3 == "Blue"){
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Black" && Last2 == "Red" && Last3 == "Green"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Black" && Last2 == "Blue" && Last3 == "Red"){
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Black" && Last2 == "Blue" && Last3 == "Green"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Black" && Last2 == "Green" && Last3 == "Red"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Black" && Last2 == "Green" && Last3 == "Blue"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Black" && Last3 == "Blue"){
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Black" && Last3 == "Green"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Blue" && Last3 == "Black"){
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Blue" && Last3 == "Green"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Green" && Last3 == "Black"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Red" && Last2 == "Green" && Last3 == "Blue"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Black" && Last3 == "Red"){
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Black" && Last3 == "Green"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Red" && Last3 == "Black"){
                Green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Green");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Red" && Last3 == "Green"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Green" && Last3 == "Black"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Blue" && Last2 == "Green" && Last3 == "Red"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Black" && Last3 == "Red"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Black" && Last3 == "Blue"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Red" && Last3 == "Black"){
                Blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Blue");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Red" && Last3 == "Blue"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Blue" && Last3 == "Black"){
                Red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Red");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
            else if(Last1 == "Green" && Last2 == "Blue" && Last3 == "Red"){
                Black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor("Black");
                        PlayerInfo.setVisible(false);
                    }
                });
            }
        }

    }
}
