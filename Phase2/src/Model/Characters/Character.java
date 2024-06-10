package Model.Characters;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public interface Character {
    /**
     * <b>Accessor</b> Returns the character card's name
     * <b>Postcondition:</b> The character card's number has been returned
     * @return String character
     */
    String getCharacter();

    /**
     * <b>Transformer</b> Assigns each card to a player
     * <b>Postcondition:</b> Each card has been assigned to a player
     * @param player
     */
    void setPlayer(String player);

    /**
     * <b>Accessor</b> Returns the player this card has been assigned to
     * <b>Postcondition:</b> The player's name has been returned
     * @return String player
     */
    String getPlayer();

    /**
     * <b>Transformer</b> Sets if the card has been used
     * <b>Postcondition:</b> The card's state has been set
     * @param used
     */
    void setUsed(boolean used);

    /**
     * <b>Observer</b> Returns if the card has been used
     * <b>Postcondition:</b> If the card has been used has been returned
     * @return boolean Used
     */
    boolean getUsed();

    /**
     * <b>Transformer</b> Sets the card's color
     * <b>Postcondition:</b> The card's color has been set
     * @param color
     */
    void setColor(String color);

    /**
     * <b>Accessor</b> Returns the card's color
     * <b>Postcondition:</b> The card's color has been returned
     * @return
     */
    String getColor();
    /**
     * <b>Transformer</b> Uses the card according to it's use. Takes the last area the player used as a parameter.
     * <b>Postcondition:</b> The card's has been used
     * @param area1
     * @param i
     */
    void use(String area1, int i);


}
