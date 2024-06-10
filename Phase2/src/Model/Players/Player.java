package Model.Players;

import Model.Characters.*;
import Model.Characters.Character;
import Model.Tiles.Tile;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class Player {
    private String Name;
    private Tile[] tiles = new Tile[111];
    private Tile[] hand = new Tile[4];
    private String area;
    private int TotalPoints;
    private int turnPoints;
    private int turnValue;
    private String Color;
    private int TileNum;
    private int handSize;
    private int sphinxNum;
    private int CaryatidNum;
    private int timeToPlay;
    private int isWinner;
    private Character[] PlayerCharacters;

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
        setCharacters();
        setCharacters();
        setTileNumber(0);
        setHandSize(0);
        setSphinxNum(0);
        setCaryatidNum(0);
        timeToPlay = 0;
        setTotalPoints(0);
        setTurnPoints(0);
        setIsWinner(0);
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
    public void Add(Tile tile){
        int i = 0;
        while(tiles[i] != null){
            i++;
        }
        tiles[i] = tile;
    }

    /**
     * <b>Transformer</b>Adds the four drawn tiles to the player's hand
     * <b>Postcondition:</b>The four drawn tiles have been added to the player's hand
     *
     * @param tile
     */
    public void AddToHand(Tile tile){
        if(hand[0] == null){
            hand[0] = tile;
        }
        else if(hand[1] == null){
            hand[1] = tile;
        }
        else if(hand[2] == null){
            hand[2] = tile;
        }
        else{
            hand[3] = tile;
        }
    }

    /**
     * <b>Transformer</b>Sets the hand size of the player
     * <b>Postcondition:</b>The hand size of teh player have been set
     *
     * @param handSize
     */
    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    /**
     * <b>Transformer</b>Sets the number of tiles the player has
     * <b>Postcondition:</b>The number of tiles the player has has been set
     *
     * @param num
     */
    public void setTileNumber(int num){
        this.TileNum = num;
    }

    /**
     * <b>Accessor:</b> Returns the number of tiles the player has
     * <b>Postcondition:</b> The number of tiles the player has has been returned
     * @return int TileNum
     */
    public int getTileNumber(){
        return this.TileNum;
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
     * <b>Transformer</b> Calculates the final points of the player
     * <b>Postcondition:</b> The final points of the player have been calculated
     */
    public void calculatePoints(){
        setTotalPoints(getTotalPoints() + getTurnPoints());
    }

    /**
     * <b>Transformer</b>Sets the points of the player
     * <b>Postcondition:</b>The points of the player have been set
     *
     * @param turnPoints
     */
    public void setTurnPoints(int turnPoints) {
        this.turnPoints = turnPoints;
    }

    /**
     * <b>Transformer</b>Calculates the points of the player
     * <b>Postcondition:</b>The points of the player have been calculated
     *
     */
    public void findTurnPoints(){
        int i = 0;
        int counter = 0;
        int col = 0;
        int ind = 0;
        String color = "clear";
        Tile[] temp = new Tile[30];
        Tile[] skelUp = new Tile[10];
        Tile[] skelDown = new Tile[10];
        Tile[] skelMinUp = new Tile[5];
        Tile[] skelMinDown = new Tile[5];
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        while (this.tiles[i] != null){
            if(this.tiles[i].getType() == "Mosaic Tile"){
                counter++;
                if(this.tiles[i].getColor() == color || color == "clear"){
                    color = this.tiles[i].getColor();
                    col = 1;
                }
                else{
                    col = 0;
                }
                if(counter%4 == 0){
                    if(col == 1){
                        setTurnPoints(turnPoints + 4);
                    }
                    else{
                        setTurnPoints(turnPoints + 2);
                    }
                }
            }
            else if(this.tiles[i].getType() == "Amphora"){
                temp[ind] = this.tiles[i];
            }
            else if(this.tiles[i].getType() == "Caryatid Tile"){
                setCaryatidNum(CaryatidNum + 1);
            }
            else if(this.tiles[i].getType() == "Sphinx Tile"){
                setSphinxNum(sphinxNum + 1);
            }
            else if(this.tiles[i].getType() == "Upper Body"){
                skelUp[one] = this.tiles[i];
                one++;
            }
            else if(this.tiles[i].getType() == "Lower Body"){
                skelDown[two] = this.tiles[i];
                two++;
            }
            else if(this.tiles[i].getType() == "Upper Small Body"){
                skelMinUp[three] = this.tiles[i];
                three++;
            }
            else{
                skelMinDown[four] = this.tiles[i];
                four++;
            }
            i++;
        }
        counter = 0;
        Tile tp;
        int b;
        while (temp[counter] != null){
            tp = temp[counter];
            b = counter;
            if(temp[counter+1] != null && (temp[counter + 1].getColor() == temp[counter].getColor())){
                while(temp[b] != null){
                    if(temp[counter].getColor() != temp[b].getColor()){
                        temp[counter] = temp[b];
                        temp[b] = tp;
                    }
                    b++;
                }
            }
            counter++;
        }
        counter = 0;
        int k = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        Tile[] Blue = new Tile[5];
        Tile[] Brown = new Tile[5];
        Tile[] Red = new Tile[5];
        Tile[] Green = new Tile[5];
        Tile[] Yellow = new Tile[5];
        Tile[] Purple = new Tile[5];
        while(temp[counter] != null) {
            if (temp[counter].getColor() == "Blue") {
                Blue[c1] = temp[counter];
                c1++;
            } else if (temp[counter].getColor() == "Brown") {
                Brown[c2] = temp[counter];
                c2++;
            } else if (temp[counter].getColor() == "Red") {
                Red[c3] = temp[counter];
                c3++;
            } else if (temp[counter].getColor() == "Green") {
                Green[c4] = temp[counter];
                c4++;
            } else if (temp[counter].getColor() == "Yellow") {
                Yellow[c5] = temp[counter];
                c5++;
            } else if (temp[counter].getColor() == "Purple") {
                Purple[c6] = temp[counter];
            }
            k++;
            counter++;
        }
        int cols = 0;
        if(k >= 3){
            cols = 6;
        }
        while(cols >= 2) {
            if (Blue[0] == null) {
                cols--;
            } else if (Brown[0] == null) {
                cols--;
            } else if (Red[0] == null) {
                cols--;
            } else if (Green[0] == null) {
                cols--;
            } else if (Yellow[0] == null) {
                cols--;
            } else if (Purple[0] == null) {
                cols--;
            } else {
                if (cols == 6) {
                    this.setTurnPoints(turnPoints + 6);
                    Blue[c1] = null;
                    Brown[c2] = null;
                    Red[c3] = null;
                    Green[c4] = null;
                    Yellow[c5] = null;
                    Purple[c6] = null;
                    c1--;
                    c2--;
                    c3--;
                    c4--;
                    c5--;
                    c6--;
                } else if (cols == 5) {
                    this.setTurnPoints(turnPoints + 4);
                    if (Blue[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Red[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Green[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c3--;
                        c4--;
                        c5--;
                    }
                } else if (cols == 4) {
                    this.setTurnPoints(turnPoints + 2);
                    if (Blue[0] == null && Brown[0] == null) {
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c3--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Red[0] == null) {
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Green[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Yellow[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Blue[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c2--;
                        c3--;
                        c4--;
                        c5--;
                    } else if (Brown[0] == null && Red[0] == null) {
                        Blue[c1] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null && Green[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Brown[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c3--;
                        c4--;
                        c5--;
                    } else if (Red[0] == null && Green[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c5--;
                        c6--;
                    } else if (Red[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c4--;
                        c6--;
                    } else if (Red[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c4--;
                        c5--;
                    } else if (Green[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c3--;
                        c6--;
                    } else if (Green[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c3--;
                        c5--;
                    } else if (Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        c1--;
                        c2--;
                        c3--;
                        c4--;
                    }
                } else if (cols == 3) {
                    setTurnPoints(turnPoints + 1);
                    if (Blue[0] == null && Brown[0] == null && Red[0] == null) {
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Brown[0] == null && Green[0] == null) {
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Brown[0] == null && Yellow[0] == null) {
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Blue[0] == null && Brown[0] == null && Purple[0] == null) {
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c3--;
                        c4--;
                        c5--;
                    } else if (Blue[0] == null && Red[0] == null && Green[0] == null) {
                        Brown[c2] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Red[0] == null && Yellow[0] == null) {
                        Brown[c2] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c2--;
                        c4--;
                        c6--;
                    } else if (Blue[0] == null && Red[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c2--;
                        c4--;
                        c5--;
                    } else if (Blue[0] == null && Green[0] == null && Yellow[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c6--;
                    } else if (Blue[0] == null && Green[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        c2--;
                        c3--;
                        c5--;
                    } else if (Blue[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        c2--;
                        c3--;
                        c4--;
                    } else if (Brown[0] == null && Red[0] == null && Green[0] == null) {
                        Blue[c1] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null && Red[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c4--;
                        c6--;
                    } else if (Brown[0] == null && Red[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c4--;
                        c5--;
                    } else if (Brown[0] == null && Green[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c6--;
                    } else if (Brown[0] == null && Green[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        c1--;
                        c3--;
                        c5--;
                    } else if (Brown[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        c1--;
                        c3--;
                        c4--;
                    } else if (Red[0] == null && Green[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c6--;
                    } else if (Red[0] == null && Green[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c5--;
                    } else if (Red[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        c1--;
                        c2--;
                        c4--;
                    } else if (Green[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        c1--;
                        c2--;
                        c3--;
                    }
                }
            }
        }
        int adSkel = 0;
        int ChSkel = 0;
        int FamSkel = 0;
        counter = 0;
        while(skelUp[counter] != null && skelDown[counter] != null){
            adSkel++;
            counter++;
        }
        counter = 0;
        while(skelMinUp[counter] != null && skelMinDown[counter] != null){
            ChSkel++;
            counter++;
        }
        if(adSkel == 1 && ChSkel == 0){
            setTurnPoints(turnPoints + 1);
        }
        else if(adSkel == 0 && ChSkel == 1){
            setTurnPoints(turnPoints + 1);
        }
        else if(adSkel == 1 && ChSkel == 1){
            setTurnPoints(turnPoints + 2);
        }
        else if(adSkel == 1 && ChSkel == 2){
            setTurnPoints(turnPoints + 3);
        }
        else if(adSkel/2 == ChSkel){
            FamSkel = ChSkel;
        }
        else if(adSkel/2 > ChSkel){
            FamSkel = ChSkel;
            setTurnPoints(turnPoints + (adSkel-FamSkel));
        }
        else{
            FamSkel = adSkel/2;
            setTurnPoints(turnPoints + (ChSkel - FamSkel));
        }
        if(FamSkel != 0){
            setTurnPoints(turnPoints + (6 * FamSkel));
        }
        else {
            setTurnPoints(turnPoints);
        }
    }

    /**
     * <b>Accessor</b> Returns the points the player gathered in this turn
     * <b>Postcondition:</b> the points the player gathered in this turn have been returned
     * @return int turnPoints
     */
    public int getTurnPoints(){
        findTurnPoints();
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
     */
    public void setCharacters(){
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

    /**
     * <b>Transformer</b>Sets the number of the Sphinx tiles the player has
     * <b>Postcondition:</b>The number of the Sphinx tiles the player has is set.
     * @param sphinxNum
     */
    public void setSphinxNum(int sphinxNum) {
        this.sphinxNum = sphinxNum;
    }

    /**
     * <b>Accessor:</b> Returns the number of the Sphinx tiles the player has
     * <b>Postcondition:</b> The number of the Sphinx tiles the player has has been returned
     * @return int sphinxNum
     */
    public int getSphinxNum() {
        return sphinxNum;
    }

    /**
     * <b>Transformer</b>Sets the number of the Caryatid tiles the player has
     * <b>Postcondition:</b>The number of the Caryatid tiles the player has is set.
     * @param caryatidNum
     */
    public void setCaryatidNum(int caryatidNum) {
        CaryatidNum = caryatidNum;
    }

    /**
     * <b>Accessor:</b> Returns the number of the Caryatid tiles the player has
     * <b>Postcondition:</b> The number of the Caryatid tiles the player has has been returned
     * @return int CaryatidNum
     */
    public int getCaryatidNum() {
        return CaryatidNum;
    }

    /**
     * <b>Accessor:</b> Returns the hand of the player
     * <b>Postcondition:</b> The hand of the player has been returned
     * @return tile[] hand
     */
    public Tile[] getHand() {
        return hand;
    }

    /**
     * <b>Transformer</b>Removes all tiles from the player's hand
     * <b>Postcondition:</b>All the tiles have been removed form the player's hand
     */
    public void setHandEmpty() {
        hand[0] = null;
        hand[1] = null;
        hand[2] = null;
        hand[3] = null;
    }


    /**
     * <b>Accessor:</b> Returns the tiles that the player owns
     * <b>Postcondition:</b> The tiles that the player owns have been returned
     * @return Tile[] tiles
     */
    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * <b>Transformer</b>Sets the value to 1 if it's the player's turn to play, 0 otherwise
     * <b>Postcondition:</b>The value has been set to 1 if it's the player's turn to play, 0 otherwise
     * @param timeToPlay
     */
    public void setTimeToPlay(int timeToPlay) {
        this.timeToPlay = timeToPlay;
    }

    /**
     * <b>Accessor:</b> Returns 1 if it's the player's turn to play, 0 otherwise
     * <b>Postcondition:</b> the value of 1 has been returned if it's the player's turn to play, 0 otherwise
     * @return int timeToPlay
     */
    public int getTimeToPlay() {
        return timeToPlay;
    }

    /**
     * <b>Transformer</b>Sets the value to 1 if the player has won, 0 otherwise
     * <b>Postcondition:</b>The value has been set to 1 if the player has won, 0 otherwise
     * @param isWinner
     */
    public void setIsWinner(int isWinner) {
        this.isWinner = isWinner;
    }

    /**
     * <b>Accessor:</b> Returns 1 if ithe player has won, 0 otherwise
     * <b>Postcondition:</b> the value of 1 has been returned if the player has won, 0 otherwise
     * @return int timeToPlay
     */
    public int getIsWinner() {
        return isWinner;
    }
}

