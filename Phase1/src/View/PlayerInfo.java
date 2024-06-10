package View;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class PlayerInfo extends JFrame {
    private String Color;
    private String Name;
    URL imageUrl;
    ClassLoader cldr = this.getClass().getClassLoader();

    /**
     * <b>constructor</b>: Creates a new Player Info Window  <br />
     * <b>Postcondition:</b>: A new Player Info Window has been created
     * starting a new Player Info window
     */
    public PlayerInfo(){
        new JFrame("Player Menu");
        this.initButtons();
        this.getContentPane().setLayout(new GridLayout(0,3));
        this.addButtons();
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setActionListeners();
        this.addNewWindowListener();
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
    public void initButtons(){
        JButton Black= new JButton("Black");
        JButton Red = new JButton("Red");
        JButton Blue = new JButton("Blue");
        JButton Green = new JButton("Green");
    }

    /**
     * <b>Transformer(mutative)</b>:Adds some buttons to the frame <br />
     * <p><b>Postcondition:</b> Some buttons have been added to the frame </p>
     *
     */
    public void addButtons(){

    }

    /**
     * <b>Transformer</b> Sets the button's action listeners
     * <b>Postcondition:</b> The button's action listeners have been set
     *
     */
    public void setActionListeners(){

    }

    /**
     * <b>Transformer</b> Adds window listener to the player info window
     * <b>Postcondition</b> A window listener has been added to the player info window
     *
     */
    public void addNewWindowListener(){

    }
}
