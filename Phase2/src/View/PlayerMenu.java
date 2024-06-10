package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class PlayerMenu extends JFrame{
    private int players;
    private JDialog PlayerSelection;
    private JButton Player1;
    private JButton Player4;

    /**
     * <b>constructor</b>: Creates a new Player Menu Window  <br />
     * <b>Postcondition:</b>: A new Player Menu Window has been created
     * starting a new Player Menu window
     */

    public PlayerMenu(){
        new JFrame("Player Menu");
        PlayerSelection = new JDialog(this, "Choose The Number Of Players", true);
        this.initializeButtons();
        PlayerSelection.setLayout(new GridLayout(0,1));
        addButtons();
        this.pack();
        PlayerSelection.pack();
        this.setLocationRelativeTo(null);
        this.setSize(500,300);
        PlayerSelection.setSize(500, 300);
        PlayerSelection.setLocationRelativeTo(null);
        this.setActionListeners();
        this.PlayerSelection.setVisible(true);
        this.validate();
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
        this.Player1.setBounds(0, 0, 250, 300);
        this.PlayerSelection.add(Player1);
        this.Player4.setBounds(250,0,250, 300);
        this.PlayerSelection.add(Player4);
    }

    /**
     * <b>Transformer</b> Sets the button's action listeners
     * <b>Postcondition:</b> The button's action listeners have been set
     *
     */
    public void setActionListeners(){
        this.Player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayers(1);
                PlayerSelection.setVisible(false);
                setVisible(false);
            }
        });
        this.Player4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayers(4);
                PlayerSelection.setVisible(false);
                setVisible(false);
            }
        });
    }
}
