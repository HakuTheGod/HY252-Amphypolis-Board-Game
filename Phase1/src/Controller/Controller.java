package Controller;
import Model.Bag.TileBag;
import Model.Board.*;
import Model.Players.Player;
import View.PlayerInfo;
import View.PlayerMenu;

/**
 * Controller is the master of the game and controls all
 * of the operations executed
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class Controller {
    private int PlayerNumber;
    private Board b;
    private PlayerMenu p;
    private PlayerInfo I;
    private Player[] players;
    private String Winner;
    private boolean gameOver;
    private boolean not_Started;
    private int j = 0;

    /**
     * <b>constructor</b>: Constructs a new Controller and sets the game as
     * eligible to start .<br />
     * <b>postcondition</b>: constructs a new Controller,with either 1 or 4 ne players,new
     * instances of Tile Class , Characters Class and Bag Class and initialize
     * some int or boolean variables.So,is responsible for creating a new game and
     * initializing it.
     */

    public Controller(){
        p = new PlayerMenu();
        setPlayerNumber(p.getPlayers());
        setPlayerNumber(PlayerNumber);
        b = new Board();
        setPlayers(PlayerNumber);
        if(getPlayerNumber() == 1){
            I = new PlayerInfo();
            addPlayer(I.getColor(),I.getName());
            b.insertTiles(8, "LandArea");
        }
        else{
            while(j < 4){
                I = new PlayerInfo();
                addPlayer(I.getColor(), I.getName());
                j++;
            }
        }
        setGameOver(false);
        initializeTurn();
    }

    /**
     * <b>Transformer</b>Sets the number of players
     * <b>Postcondition:</b>The number of players has been set
     * @param playerNumber
     */
    public void setPlayerNumber(int playerNumber) {
        this.PlayerNumber = playerNumber;
    }

    /**
     * <b>Accessor</b> Returns the player number
     * <b>Postcondition:</b> The player number has been returned
     * @return int playerNumber
     */
    public int getPlayerNumber() {
        return this.PlayerNumber;
    }

    /**
     * <b>Transformer</b> Initialises the first turn of the game to a random number between 1-4
     * <b>Postcondition:</b> The first turn has been initialised and assigned to the player with the
     * found number
     */
    public void initializeTurn(){

    }

    /**
     * <b>Transformer</b> Assigns the next turn to the next player and updates it's turn value to the current turn
     * <b>Postcondition:</b> The turn has switched and the new turn is assigned to the next player
     * @param player
     * @param turnValue
     */
    public void NewTurn(Player player,int turnValue){

    }

    /**
     * <b>Transformer</b> Ends the current turn
     * <b>Postcondition:</b> The current turn has ended
     * @param player
     */
    public void turnEnd(Player player){

    }

    /**
     * <b>Transformer</b> Sets the game to have ended
     * <b>Postcondition:</b> The game has ended
     * @param gameOver
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * <b>Observer</b> Returns if the game is finished or still active
     * <b>Postcondition:</b> The status of the game has been returned
     * @return boolean gameOver
     */
    public boolean getGameOver(){
        return this.gameOver;
    }

    /**
     * <b>Transformer</b> Adds a player to the game and assigns it's properties value
     * <b>Postcondition:</b> A player with the indicated properties has been added to the game
     * @param Color
     * @param Name
     */
    public void addPlayer(String Color, String Name){

    }

    /**
     * <b>Accessor</b> Returns a specific player
     * <b>Postcondition:</b> A specific player has been returned
     * @param PlayerNumber
     * @return Player players[PlayerNumber]
     */
    public Player getPlayer(int PlayerNumber){
        if(this.players[PlayerNumber] != null){
            return this.players[PlayerNumber];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * <b>Transformer</b> Sets the players
     * <b>Postcondition:</b> the players have been set
     * @param Players
     */
    public void setPlayers(int Players) {
        if(Players == 1){
            this.players = new Player[1];
        }
        else{
            this.players = new Player[4];
        }
    }

    /**
     * <b>Transformer</b> Assigns whether the game has started
     * <b>Postcondition:</b> The game has either started or not yet
     * @param not_Started
     */
    public void setNot_Started(boolean not_Started) {
        this.not_Started = not_Started;
    }

    /**
     * <b>Observer</b> Returns if the game has started
     * <b>Postcondition:</b> Returns if the game has started
     *
     * @return
     */
    public boolean isNot_Started() {
        return not_Started;
    }

    /**
     * <b>Accessor</b> Returns the points that the player gathered on this turn
     * <b>Postcondition:</b> The points of the player have been returned
     * @param player
     * @return int TurnPoints
     */
    public int getPlayerTurnPoints(Player player){
        return player.getTurnPoints();
    }
    /**
     * <b>Accessor</b> Returns the total points that the player gathered during the game
     * <b>Postcondition:</b> The total points of the player have been returned
     * @param player
     * @return int TotalPoints
     */
    public int getPlayerTotalPoints(Player player){
        return player.getTotalPoints();
    }

    /**
     * <b>Transformer</b> Gives the player it's starting tiles
     * <b>Postcondition:</b> The starting tiles have been given to the player
     * @param player
     * @param bag
     */
    public void getStartingTiles(Player player, TileBag bag){

    }

    /**
     * <b>Transformer</b> Executes the player's turn
     * <b>Postcondition:</b> The player has played for his turn
     * @param player
     */
    public void PlayTurn(Player player){

    }

    /**
     * <b>Transformer</b> Sets the winner of the game
     * <b>Postcondition:</b> The winner of the game has been set
     * @param player
     */
    public void SetWinner(Player player){
        this.Winner = player.getName();
    }

    /**
     * <b>Transformer</b> Calculates the winner of the game
     * <b>Postcondition:</b> The winner of the game has been found
     */
    public void findWinner(){

    }

    /**
     * <b>Accessor</b> Returns the winner of the game
     * <b>Postcondition:</b> The winner of the game has been returned
     * @return String Winner
     */
    public String getWinner(){
        return this.Winner;
    }

}
