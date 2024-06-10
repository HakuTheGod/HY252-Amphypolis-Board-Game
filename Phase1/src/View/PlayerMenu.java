package View;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class PlayerMenu extends JFrame{
    int players;
    JButton Player1;
    JButton Player4;
    URL imageUrl;
    ClassLoader cldr = this.getClass().getClassLoader();

    /**
     * <b>constructor</b>: Creates a new Player Menu Window  <br />
     * <b>Postcondition:</b>: A new Player Menu Window has been created
     * starting a new Player Menu window
     */

    public PlayerMenu(){
        new JFrame("Player Menu");
        this.initializeButtons();
        this.getContentPane().setLayout(new GridLayout(0,3));
        this.addButtons();
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setActionListeners();
        this.addNewWindowListener();
    }

    /**
     * <b>Transformer</b>Sets the number of players
     * <b>Postcondition:</b>The number of players has been set
     * @param value
     */
    public void setPlayers(int value){
        this.players = value;
    }

    /**
     * <b>Accessor:</b> Returns the player number
     * <b>Postcondition:</b> The player number has been returned
     * @return int players
     */
    public int getPlayers() {
        return this.players;
    }

    /**
     * <b>Transformer(mutative)</b>:initializes some buttons and labels <br />
     * <p><b>Postcondition:</b> Some buttons and labels have been initialised</p>
     *
     */
    public void initializeButtons(){
        this.Player1 = new JButton("1 Player");
        this.Player4 = new JButton("4 Players");
    }

    /**
     * <b>Transformer(mutative)</b>:Adds some buttons to the frame <br />
     * <p><b>Postcondition:</b> Some buttons have been added to the frame </p>
     *
     */
    public void addButtons(){
        this.add(Player1);
        this.add(Player4);
    }

    /**
     * <b>Transformer</b> Sets the button's action listeners
     * <b>Postcondition:</b> The button's action listeners have been set
     *
     */
    public void setActionListeners(){

    }

    /**
     * <b>Transformer</b> Adds window listener to the player menu window
     * <b>Postcondition</b> A window listener has been added to the player menu window
     *
     */
    public void addNewWindowListener(){

    }
}
