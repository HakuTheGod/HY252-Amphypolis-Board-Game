package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Controller.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */

public class GraphicUI extends JFrame {
    private Image image,image2;
    private JButton PlayButton,ExitButton,saveButton;
    private JButton[] Buttons;
    private JButton bag;
    private JButton endTurn;
    private JDesktopPane LandArea;
    private JDesktopPane AmphoraArea;
    private JDesktopPane StatueArea;
    private JDesktopPane VaseArea;
    private JDesktopPane SkeletonArea;
    private JDesktopPane CardArea;
    private JDesktopPane table;
    private JPanel jpanel;
    private JTextField textField1, textField2;
    private URL imageURL;
    private ClassLoader cldr;

    /**
     * <b>constructor</b>: Creates a new Window and initializes some buttons and panels <br />
     * <b>postconditions</b>: Creates a new Window and initializes some buttons and panels
     * starting a new game.
     */
    public GraphicUI() {

    }

    /**
     * <b>transformer(mutative)</b>:initializes some buttons and labels <br />
     * <p><b>Postcondition:</b> Some buttons and labels have been initialised</p>
     *
     */
    public void initComponents(){

    }

    /**
     * <b>transformer(mutative)</b>:sets some buttons and labels for a new game<br />
     * <p><b>Postcondition:</b> Some buttons and labels have been set for a new game</p>
     *
     */

    public void initButtons(){

    }

    /* a class which is used for doing some action after play button has been pushed */
    public class PlayListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the Play button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the Play button has been pushed</p>
         *
         */

        public void actionPerformed(ActionEvent e) 	{

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

        }

    }
    /* a class which is used for doing some action after the Bag(draw) button has been pushed */
    public class BagListener implements ActionListener{
        /**
         * <b>transformer(mutative)</b>:doing some action after the Bag button has been pushed<br />
         * <p><b>Postcondition:</b> doing some action after the Bag button has been pushed</p>
         *
         */
        @Override
        public void actionPerformed(ActionEvent e) 	{

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

        }
    }




}
