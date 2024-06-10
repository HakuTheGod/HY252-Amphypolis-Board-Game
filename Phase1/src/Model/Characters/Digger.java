package Model.Characters;

import Model.Players.Player;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class Digger implements Character{
    final String Character;
    private String player;
    private boolean Used;
    private String color;

    /**
     * <b>Constructor</b> Constructs a new Digger card with character name, a player that belongs to, a state and a color
     * <b>Postcondition:</b> A new Digger card with name,player,color and state has been constructed
     * @param player
     * @param color
     */
    public Digger(Player player, String color){
        this.Character = "Digger";
        setPlayer(player.getName());
        setUsed(false);
        setColor(color);
    }
    /**
     * <b>Accessor</b> Returns the character card's name
     * <b>Postcondition:</b> The character card's number has been returned
     * @return String character
     */
    public String getCharacter(){
        return this.Character;
    }

    /**
     * <b>Transformer</b> Assigns each card to a player
     * <b>Postcondition:</b> Each card has been assigned to a player
     * @param player
     */
    public void setPlayer(String player){
        this.player = player;
    }

    /**
     * <b>Accessor</b> Returns the player this card has been assigned to
     * <b>Postcondition:</b> The player's name has been returned
     * @return String player
     */
    public String getPlayer(){
        return this.player;
    }

    /**
     * <b>Transformer</b> Sets the card's state to used or not used
     * <b>Postcondition:</b> The card's state has been set
     * @param used
     */
    public void setUsed(boolean used){
        this.Used = used;
    }

    /**
     * <b>Observer</b> Returns if the card has been used or not
     * <b>Postcondition:</b> The state of the card has been returned
     * @return boolean Used
     */
    public boolean getUsed(){
        return this.Used;
    }

    /**
     * <b>Transformer</b> Sets the card's color
     * <b>Postcondition:</b> The card's color has been set
     * @param color
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * <b>Accessor</b> Returns the card's color
     * <b>Postcondition:</b> The card's color has been returned
     * @return
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * <b>Transformer</b> Uses the card according to it's use. Takes the last area the player used as a parameter.
     * <b>Postcondition:</b> The card's has been used
     * @param area
     */
    public void use(String area){

    }
}
