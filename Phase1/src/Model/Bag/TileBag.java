package Model.Bag;

import Model.Tiles.Tile;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class TileBag {
    private Tile[] tiles;
    private int TilesLeft;

    /**
     * <b>Constructor</b> Constructs a new tile bag and that can fit a specific number of tiles
     * <b>Postcondition:</b> A new tile bag with a specific number of tiles has been constructed
     *
     * @param  numberOfPlayers
     */
    public TileBag(int numberOfPlayers){
        if(numberOfPlayers == 1){
            setTilesLeft(131);
            tiles = new Tile[131];
        }
        else{
            setTilesLeft(127);
            tiles = new Tile[127];
        }
        initializeBag();
        shuffleTiles();
    }

    /**
     * <b>Transformer</b> Initialises the tile bag and fills it with the tiles
     * <b>Postcondition:</b> The tile bag ohas been initialised and has been filled with tiles
     *
     */
    public void initializeBag(){

    }

    /**
     * <b>Transformer</b> Shuffles the tiles in the bag
     * <b>Postcondition:</b> The tiles in the bag have been shuffled
     *
     */
    public void shuffleTiles(){

    }

    /**
     * <b>Transformer</b> Draws a tile from the bag
     * <b>Postcondition:</b>The tile has been drawn
     *
     */
    public void DrawTile(){

    }

    /**
     * <b>Transformer</b> Updates the tiles left in the bag
     * <b>Postcondition:</b>The tiles that are left in the bag have been updated
     *
     * @return int tilesLeft
     */
    public void setTilesLeft(int tilesLeft) {
        TilesLeft = tilesLeft;
    }

    /**
     * <b>Accessor:</b> Returns the number of the tiles that are left in the bag
     * <b>Postcondition:</b> The number of the tiles that are left in the bag has been returned
     * @return int TilesLeft
     */
    public int getTilesLeft(){
        return this.TilesLeft;
    }
}
