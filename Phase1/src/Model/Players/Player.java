package Model.Players;

import Model.Characters.*;
import Model.Characters.Character;
import Model.Tiles.FindingTile;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class Player {
    private String Name;
    private FindingTile[] tiles = new FindingTile[111];
    private String area;
    private int TotalPoints;
    private int turnPoints;
    private int turnValue;
    private String Color;
    private Character[] PlayerCharacters;
    private boolean turnToPlay;

    /**
     * <b>Constructor</b> Constructs a new player with color,name and value assigned from it's parameters
     * <b>Postcondition:</b> A new player with color,name and value has been constructed
     * @param Color
     * @param Name
     * @param value
     */
    public Player(String Color,String Name,int value){
        setName(Name);
        setColor(Color);
        setTurnValue(value);
        setPlayerCharacters(new Character[4]);
        setCharacters(this.getColor());
        setCharacters(this.getColor());
    }

    /**
     * <b>Transformer</b>Sets the name of player
     * <b>Postcondition:</b>The name of player has been set
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * <b>Accessor:</b> Returns the player's name
     * <b>Postcondition:</b> The player's name has been returned
     * @return String Name
     */
    public String getName() {
        return this.Name;
    }

    /**
     * <b>Transformer</b> Adds a new tile on this player's tiles
     * <b>Postcondition:</b> A new tile has been added from the board to this player's tiles
     * @param tile
     */
    public void Add(FindingTile tile){
        int i = 0;
        while(tiles[i] != null){
            i++;
        }
        tiles[i] = tile;
    }

    /**
     * <b>Transformer</b> Sets the last area from which the player took a tile
     * <b>Postcondition:</b> The last area form which the player took a tile has been set
     * @param area
     */
    public void setLastArea(String area){
        this.area = area;
    }

    /**
     * <b>Accessor</b> Returns the last area from which the player took a tile
     * <b>Postcondition:</b> The last area form which the player took a tile has been returned
     * @return String area
     */
    public String getLastArea(){
        return this.area;
    }

    /**
     * <b>Transformer</b> Calculates the points the player gathered in this turn
     * <b>Postcondition:</b> The points that the player gathered in this turn have been calculated
     * @param points
     */
    public void calculatePoints(int points){

    }

    /**
     * <b>Accessor</b> Returns the points the player gathered in this turn
     * <b>Postcondition:</b> the points the player gathered in this turn have been returned
     * @return int turnPoints
     */
    public int getTurnPoints(){
        return this.turnPoints;
    }

    /**
     * <b>Transformer</b> Calculates the points the player gathered in the game
     * <b>Postcondition:</b> The points that the player gathered in this turn have been calculated
     * @param totalPoints
     */
    public void setTotalPoints(int totalPoints) {
        TotalPoints = totalPoints;
    }

    /**
     * <b>Accessor</b> Returns the points the player gathered in this game
     * <b>Postcondition:</b> The points that the player gathered in this turn have been calculated
     * @return int TotalPoints
     */
    public int getTotalPoints(){
        return this.TotalPoints;
    }

    /**
     * <b>Transformer</b> Sets the value of the player's turn
     * <b>Postcondition:</b> The value of the player's turn has been set
     * @param turnValue
     */
    public void setTurnValue(int turnValue) {
        this.turnValue = turnValue;
    }

    /**
     * <b>Accessor</b> Returns the value of the player's turn
     * <b>Postcondition:</b> The value of the player's turn has been returned
     * @return int turnValue
     */
    public int getTurnValue() {
        return turnValue;
    }

    /**
     * <b>Transformer</b> Sets the color of the player
     * <b>postcondition:</b> The color of the player has been set
     * @param color
     */
    public void setColor(String color) {
        Color = color;
    }

    /**
     * <b>Accessor</b> Returns the color of the player
     * <b>postcondition:</b> The color of the player has been returned
     * @return String Color
     */
    public String getColor() {
        return Color;
    }

    /**
     * <b>Transformer</b> Finds if this is the turn for this player to play
     * <b>postcondition:</b> The answer of weather it's the player's turn to play has been found
     * @param turnToPlay
     */
    public void setTurnToPlay(boolean turnToPlay) {
        this.turnToPlay = turnToPlay;
    }

    /**
     * <b>Observer</b> Returns if this is the turn for this player to play
     * <b>postcondition:</b> Weather it's the player's turn to play has been returned
     * @return boolean turnToPlay
     */
    public boolean isTurnToPlay() {
        return turnToPlay;
    }

    /**
     * <b>Transformer</b> Sets the character cards of this player
     * <b>postcondition:</b> The character cards of this player has been set
     * @param playerCharacters
     */
    public void setPlayerCharacters(Character[] playerCharacters) {
        this.PlayerCharacters = playerCharacters;
    }

    /**
     * <b>Transformer</b> Adds the character cards to the player
     * <b>postcondition:</b> The character cards has been added to the player
     * @param Color
     */
    public void setCharacters(String Color){
        this.PlayerCharacters[0] = new Professor(this, this.getColor());
        this.PlayerCharacters[1] = new Assistant(this, this.getColor());
        this.PlayerCharacters[2] = new Archeologist(this, this.getColor());
        this.PlayerCharacters[3] = new Digger(this, this.getColor());
    }

    /**
     * <b>Accessor</b> Returns a specific card of the player
     * <b>postcondition:</b> The specific card of the player has been returned
     * @param CharName
     * @return Card PlayerCharacters[index]
     */
    public Character getCharacter(String CharName){
        switch(CharName){
            case "Professor":
                return this.PlayerCharacters[0];
            case "Assistant":
                return this.PlayerCharacters[1];
            case "Archeologist":
                return this.PlayerCharacters[2];
            case "Digger":
                return this.PlayerCharacters[3];
            default:
                throw new IllegalArgumentException();
        }
    }
}
