package Controller;
import Model.Bag.TileBag;
import Model.Board.*;
import Model.Players.GraveRobber;
import Model.Players.Player;
import Model.Tiles.Tile;

import java.lang.Math;

/**
 * Controller is the master of the game and controls all
 * of the operations executed
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class Controller{
    private int PlayerNumber;
    private Board b;
    private Player[] players;
    private boolean gameOver;
    private boolean not_Started;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private int turn;
    private GraveRobber r;

    /**
     * <b>constructor</b>: Constructs a new Controller and sets the game as
     * eligible to start .<br />
     * <b>postcondition</b>: constructs a new Controller,with either 1 or 4 ne players,new
     * instances of Tile Class , Characters Class and Bag Class and initialize
     * some int or boolean variables.So,is responsible for creating a new game and
     * initializing it.
     */

    public Controller(int playerNumber, String color1, String color2, String color3, String color4, String Name1, String Name2, String Name3, String Name4){
        setPlayerNumber(playerNumber);
        setPlayerNumber(PlayerNumber);
        b = new Board();
        setPlayers(PlayerNumber);
        b.setBag(new TileBag(PlayerNumber));
        b.getBag().initializeBag();
        b.getBag().shuffleTiles();
        if(getPlayerNumber() == 1){
            addPlayer(color1,Name1, 1);
            players[0] = player1;
            for(int o = 0; o < 8; o++){
                b.insertTiles("Landslide Tile", "clear");
            }
            b.getBag().delLandslide(8);
        }
        else{
            addPlayer(color1, Name1, 1);
            players[0] = player1;
            addPlayer(color2, Name2, 2);
            players[1] = player2;
            addPlayer(color3, Name3, 3);
            players[2] = player3;
            addPlayer(color4, Name4, 4);
            players[3] = player4;
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
        if(getPlayerNumber() == 1){
            this.player1.setTurnValue(1);
        }
        else{
            this.turn = (int)((Math.random() * (4 - 1)) + 1);
            if(this.turn == 1){
                this.player1.setTurnValue(1);
                this.player1.setTimeToPlay(1);
                this.player2.setTurnValue(2);
                this.player3.setTurnValue(3);
                this.player4.setTurnValue(4);
            }
            else if(this.turn == 2){
                this.player2.setTurnValue(1);
                this.player2.setTimeToPlay(1);
                this.player3.setTurnValue(2);
                this.player4.setTurnValue(3);
                this.player1.setTurnValue(4);
            }
            else if(this.turn == 3){
                this.player3.setTurnValue(1);
                this.player3.setTimeToPlay(1);
                this.player4.setTurnValue(2);
                this.player1.setTurnValue(3);
                this.player2.setTurnValue(4);
            }
            else{
                this.player4.setTurnValue(1);
                this.player4.setTimeToPlay(1);
                this.player1.setTurnValue(2);
                this.player2.setTurnValue(3);
                this.player3.setTurnValue(4);
            }
        }

    }

    /**
     * <b>Transformer</b> Assigns the next turn to the next player and updates it's turn value to the current turn
     * <b>Postcondition:</b> The turn has switched and the new turn is assigned to the next player
     * @param player
     */
    public void NewTurn(Player player){
        player.setTimeToPlay(1);
    }

    /**
     * <b>Transformer</b> Ends the current turn
     * <b>Postcondition:</b> The current turn has ended
     * @param player
     */
    public void turnEnd(Player player){
        if(player.getTurnValue() == 1){
            player.setTimeToPlay(0);
            NewTurn(getPlayers(2));
        }
        else if(player.getTurnValue() == 2){
            player.setTimeToPlay(0);
            NewTurn(getPlayers(3));
        }
        else if(player.getTurnValue() == 3){
            player.setTimeToPlay(0);
            NewTurn(getPlayers(4));
        }
        else{
            player.setTimeToPlay(0);
            NewTurn(getPlayers(1));
        }
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
    public void addPlayer(String Color, String Name, int i){
         if(i == 1){
             player1 = new Player(Color, Name, 0);
         }
         else if(i == 2){
             player2 = new Player(Color, Name, 0);
         }
         else if(i == 3){
             player3 = new Player(Color,Name,0);
         }
         else{
             player4 = new Player(Color, Name, 0);
         }
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
     * <b>Transformer</b> Gives the player it's starting tiles
     * <b>Postcondition:</b> The starting tiles have been given to the player
     * @param player
     * @param bag
     */
    public void drawTiles(Player player, TileBag bag){
        for(int i = 0; i < 4; i++){
            Tile drawn = bag.getDrawnTile();
            while(drawn == null){
                drawn = bag.getDrawnTile();
            }
            player.AddToHand(drawn);
            b.insertTiles(drawn.getType(), drawn.getColor());
        }
    }

    /**
     * <b>Transformer</b> Executes the player's turn
     * <b>Postcondition:</b> The player has played for his turn
     * @param player
     */
    public void PlayTurn(Player player){
        drawTiles(player, b.getBag());
    }

    /**
     * <b>Transformer</b> Sets the winner of the game
     * <b>Postcondition:</b> The winner of the game has been set
     * @param player
     */
    public void SetWinner(Player player){
        player.setIsWinner(1);
    }

    /**
     * <b>Transformer</b> Calculates the winner of the game
     * <b>Postcondition:</b> The winner of the game has been found
     */
    public void findWinner(){
        player1.findTurnPoints();
        if(player1.getCaryatidNum() > player2.getCaryatidNum() && player1.getCaryatidNum() > player3.getCaryatidNum() && player1.getCaryatidNum() > player4.getCaryatidNum()){
            player1.setTotalPoints(player1.getTotalPoints() + 6);
        }
        else if(player1.getCaryatidNum() < player2.getCaryatidNum() && player1.getCaryatidNum() < player3.getCaryatidNum() && player1.getCaryatidNum() < player4.getCaryatidNum()){
            player1.setTotalPoints(player1.getTotalPoints());
        }
        else{
            player1.setTotalPoints(player1.getTotalPoints() + 3);
        }
        if(player1.getSphinxNum() > player2.getSphinxNum() && player1.getSphinxNum() > player3.getSphinxNum() && player1.getSphinxNum() > player4.getSphinxNum()){
            player1.setTotalPoints(player1.getTotalPoints()+6);
        }
        else if(player1.getSphinxNum() < player2.getSphinxNum() && player1.getSphinxNum() < player3.getSphinxNum() && player1.getSphinxNum() < player4.getSphinxNum()){
            player1.setTotalPoints(player1.getTotalPoints());
        }
        else{
            player1.setTotalPoints(player1.getTotalPoints() + 3);
        }
        player1.calculatePoints();
        player2.findTurnPoints();
        if(player2.getCaryatidNum() > player1.getCaryatidNum() && player2.getCaryatidNum() > player3.getCaryatidNum() && player2.getCaryatidNum() > player4.getCaryatidNum()){
            player2.setTotalPoints(player2.getTotalPoints() + 6);
        }
        else if(player2.getCaryatidNum() < player1.getCaryatidNum() && player2.getCaryatidNum() < player3.getCaryatidNum() && player2.getCaryatidNum() < player4.getCaryatidNum()){
            player2.setTotalPoints(player2.getTotalPoints());
        }
        else{
            player2.setTotalPoints(player2.getTotalPoints() + 3);
        }
        if(player2.getSphinxNum() > player1.getSphinxNum() && player2.getSphinxNum() > player3.getSphinxNum() && player2.getSphinxNum() > player4.getSphinxNum()){
            player2.setTotalPoints(player2.getTotalPoints()+6);
        }
        else if(player2.getSphinxNum() < player1.getSphinxNum() && player2.getSphinxNum() < player3.getSphinxNum() && player2.getSphinxNum() < player4.getSphinxNum()){
            player2.setTotalPoints(player2.getTotalPoints());
        }
        else{
            player2.setTotalPoints(player2.getTotalPoints() + 3);
        }
        player2.calculatePoints();
        player3.findTurnPoints();
        if(player3.getCaryatidNum() > player2.getCaryatidNum() && player3.getCaryatidNum() > player1.getCaryatidNum() && player3.getCaryatidNum() > player4.getCaryatidNum()){
            player3.setTotalPoints(player3.getTotalPoints() + 6);
        }
        else if(player3.getCaryatidNum() < player2.getCaryatidNum() && player3.getCaryatidNum() < player1.getCaryatidNum() && player3.getCaryatidNum() < player4.getCaryatidNum()){
            player3.setTotalPoints(player3.getTotalPoints());
        }
        else{
            player3.setTotalPoints(player3.getTotalPoints() + 3);
        }
        if(player3.getSphinxNum() > player2.getSphinxNum() && player3.getSphinxNum() > player1.getSphinxNum() && player3.getSphinxNum() > player4.getSphinxNum()){
            player3.setTotalPoints(player3.getTotalPoints()+6);
        }
        else if(player3.getSphinxNum() < player2.getSphinxNum() && player3.getSphinxNum() < player1.getSphinxNum() && player3.getSphinxNum() < player4.getSphinxNum()){
            player3.setTotalPoints(player3.getTotalPoints());
        }
        else{
            player3.setTotalPoints(player3.getTotalPoints() + 3);
        }
        player3.calculatePoints();
        player4.findTurnPoints();
        if(player4.getCaryatidNum() > player2.getCaryatidNum() && player4.getCaryatidNum() > player3.getCaryatidNum() && player4.getCaryatidNum() > player1.getCaryatidNum()){
            player4.setTotalPoints(player4.getTotalPoints() + 6);
        }
        else if(player4.getCaryatidNum() < player2.getCaryatidNum() && player4.getCaryatidNum() < player3.getCaryatidNum() && player4.getCaryatidNum() < player1.getCaryatidNum()){
            player4.setTotalPoints(player4.getTotalPoints());
        }
        else{
            player4.setTotalPoints(player4.getTotalPoints() + 3);
        }
        if(player4.getSphinxNum() > player2.getSphinxNum() && player4.getSphinxNum() > player3.getSphinxNum() && player4.getSphinxNum() > player1.getSphinxNum()){
            player4.setTotalPoints(player4.getTotalPoints()+6);
        }
        else if(player4.getSphinxNum() < player2.getSphinxNum() && player4.getSphinxNum() < player3.getSphinxNum() && player4.getSphinxNum() < player1.getSphinxNum()){
            player4.setTotalPoints(player4.getTotalPoints());
        }
        else{
            player4.setTotalPoints(player4.getTotalPoints() + 3);
        }
        player4.calculatePoints();
        if(this.player1.getTotalPoints() == this.player2.getTotalPoints() && this.player1.getTotalPoints() == this.player3.getTotalPoints() && this.player1.getTotalPoints() == this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            SetWinner(player3);
            SetWinner(player4);
        }
        else if(this.player1.getTotalPoints() == this.player2.getTotalPoints() && this.player1.getTotalPoints() == this.player3.getTotalPoints() && this.player1.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            SetWinner(player3);
            player4.setIsWinner(0);
        }
        else if(this.player1.getTotalPoints() == this.player2.getTotalPoints() && this.player1.getTotalPoints() == this.player4.getTotalPoints() && this.player1.getTotalPoints() > this.player3.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            SetWinner(player4);
            player3.setIsWinner(0);
        }
        else if(this.player1.getTotalPoints() == this.player3.getTotalPoints() && this.player1.getTotalPoints() == this.player4.getTotalPoints() && this.player1.getTotalPoints() > this.player2.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player3);
            SetWinner(player4);
            player2.setIsWinner(0);
        }
        else if(this.player2.getTotalPoints() == this.player1.getTotalPoints() && this.player2.getTotalPoints() == this.player3.getTotalPoints() && this.player2.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            SetWinner(player3);
            player4.setIsWinner(0);
        }
        else if(this.player2.getTotalPoints() == this.player1.getTotalPoints() && this.player2.getTotalPoints() == this.player4.getTotalPoints() && this.player2.getTotalPoints() > this.player3.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            SetWinner(player4);
            player3.setIsWinner(0);
        }
        else if(this.player2.getTotalPoints() == this.player3.getTotalPoints() && this.player2.getTotalPoints() == this.player4.getTotalPoints() && this.player2.getTotalPoints() > this.player1.getTotalPoints()){
            SetWinner(player2);
            SetWinner(player3);
            SetWinner(player4);
            player1.setIsWinner(0);
        }
        else if(this.player3.getTotalPoints() == this.player1.getTotalPoints() && this.player3.getTotalPoints() == this.player2.getTotalPoints() && this.player3.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            SetWinner(player3);
            player4.setIsWinner(0);
        }
        else if(this.player3.getTotalPoints() == this.player1.getTotalPoints() && this.player3.getTotalPoints() == this.player4.getTotalPoints() && this.player3.getTotalPoints() > this.player2.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player3);
            SetWinner(player4);
            player2.setIsWinner(0);
        }
        else if(this.player3.getTotalPoints() == this.player4.getTotalPoints() && this.player3.getTotalPoints() == this.player2.getTotalPoints() && this.player3.getTotalPoints() > this.player1.getTotalPoints()){
            SetWinner(player2);
            SetWinner(player3);
            SetWinner(player4);
            player1.setIsWinner(0);
        }
        else if(this.player4.getTotalPoints() == this.player1.getTotalPoints() && this.player4.getTotalPoints() == this.player3.getTotalPoints() && this.player4.getTotalPoints() > this.player2.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player4);
            SetWinner(player3);
            player2.setIsWinner(0);
        }
        else if(this.player4.getTotalPoints() == this.player1.getTotalPoints() && this.player4.getTotalPoints() == this.player2.getTotalPoints() && this.player4.getTotalPoints() > this.player3.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            SetWinner(player4);
            player3.setIsWinner(0);
        }
        else if(this.player4.getTotalPoints() == this.player3.getTotalPoints() && this.player4.getTotalPoints() == this.player2.getTotalPoints() && this.player4.getTotalPoints() > this.player1.getTotalPoints()){
            SetWinner(player2);
            SetWinner(player3);
            SetWinner(player4);
            player1.setIsWinner(0);
        }
        else if(this.player1.getTotalPoints() == this.player2.getTotalPoints() && this.player1.getTotalPoints() > this.player3.getTotalPoints() && this.player1.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            player3.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if(this.player1.getTotalPoints() == this.player3.getTotalPoints() && this.player1.getTotalPoints() > this.player2.getTotalPoints() && this.player1.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player3);
            player2.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if(this.player1.getTotalPoints() == this.player4.getTotalPoints() && this.player1.getTotalPoints() > this.player2.getTotalPoints() && this.player1.getTotalPoints() > this.player3.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player4);
            player2.setIsWinner(0);
            player3.setIsWinner(0);
        }
        else if(this.player2.getTotalPoints() == this.player1.getTotalPoints() && this.player2.getTotalPoints() > this.player3.getTotalPoints() && this.player2.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player2);
            player3.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if(this.player2.getTotalPoints() == this.player3.getTotalPoints() && this.player2.getTotalPoints() > this.player1.getTotalPoints() && this.player2.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player2);
            SetWinner(player3);
            player1.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if(this.player2.getTotalPoints() == this.player4.getTotalPoints() && this.player2.getTotalPoints() > this.player2.getTotalPoints() && this.player2.getTotalPoints() > this.player3.getTotalPoints()){
            SetWinner(player2);
            SetWinner(player4);
            player1.setIsWinner(0);
            player3.setIsWinner(0);
        }
        else if(this.player3.getTotalPoints() == this.player1.getTotalPoints() && this.player3.getTotalPoints() > this.player2.getTotalPoints() && this.player3.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player3);
            player2.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if(this.player3.getTotalPoints() == this.player2.getTotalPoints() && this.player3.getTotalPoints() > this.player1.getTotalPoints() && this.player3.getTotalPoints() > this.player4.getTotalPoints()){
            SetWinner(player2);
            SetWinner(player3);
            player1.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if(this.player3.getTotalPoints() == this.player4.getTotalPoints() && this.player3.getTotalPoints() > this.player2.getTotalPoints() && this.player3.getTotalPoints() > this.player1.getTotalPoints()){
            SetWinner(player3);
            SetWinner(player4);
            player1.setIsWinner(0);
            player2.setIsWinner(0);
        }
        else if(this.player4.getTotalPoints() == this.player1.getTotalPoints() && this.player4.getTotalPoints() > this.player3.getTotalPoints() && this.player4.getTotalPoints() > this.player2.getTotalPoints()){
            SetWinner(player1);
            SetWinner(player4);
            player2.setIsWinner(0);
            player3.setIsWinner(0);
        }
        else if(this.player4.getTotalPoints() == this.player3.getTotalPoints() && this.player4.getTotalPoints() > this.player2.getTotalPoints() && this.player4.getTotalPoints() > this.player1.getTotalPoints()){
            SetWinner(player3);
            SetWinner(player4);
            player1.setIsWinner(0);
            player2.setIsWinner(0);
        }
        else if(this.player4.getTotalPoints() == this.player2.getTotalPoints() && this.player4.getTotalPoints() > this.player3.getTotalPoints() && this.player4.getTotalPoints() > this.player1.getTotalPoints()){
            SetWinner(player2);
            SetWinner(player4);
            player1.setIsWinner(0);
            player3.setIsWinner(0);
        }
        else if((this.player1.getTotalPoints() > this.player2.getTotalPoints()) && (this.player1.getTotalPoints() > this.player3.getTotalPoints()) && (this.player1.getTotalPoints() > this.player4.getTotalPoints())){
            SetWinner(player1);
            player2.setIsWinner(0);
            player3.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if((this.player2.getTotalPoints() > this.player1.getTotalPoints()) && (this.player2.getTotalPoints() > this.player3.getTotalPoints()) && (this.player2.getTotalPoints() > this.player4.getTotalPoints())){
            SetWinner(player2);
            player1.setIsWinner(0);
            player3.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else if((this.player3.getTotalPoints() > this.player2.getTotalPoints()) && (this.player3.getTotalPoints() > this.player1.getTotalPoints()) && (this.player3.getTotalPoints() > this.player4.getTotalPoints())){
            SetWinner(player3);
            player1.setIsWinner(0);
            player2.setIsWinner(0);
            player4.setIsWinner(0);
        }
        else{
            SetWinner(player4);
            player1.setIsWinner(0);
            player2.setIsWinner(0);
            player3.setIsWinner(0);
        }
    }

    /**
     * <b>Accessor:</b> Returns an instance of the board of the game
     * <b>Postcondition:</b> An instance of the board of the game has been returned
     * @return Board b
     */
    public Board getB() {
        return b;
    }

    /**
     * <b>Accessor:</b> Returns the player that it's his turn to play
     * <b>Postcondition:</b> The player that is about to play has been returned
     * @param turn
     * @return Player players[l]
     */
    public Player getPlayers(int turn) {
        int l = 0;
        while(players[l] != null){
            if(players[l].getTurnValue() == turn){
                break;
            }
            l++;
        }
        return players[l];
    }

    /**
     * <b>Transformer</b> Creates a new GraveRobber
     * <b>Postcondition:</b> A new GraveRobber has been created
     */
    public void setR(){
        r = new GraveRobber();
    }

    /**
     * <b>Accessor:</b> Returns the GraveRobber
     * <b>Postcondition:</b> The GraveRobber has been returned
     * @return Board b
     */
    public GraveRobber getR() {
        return r;
    }
}
