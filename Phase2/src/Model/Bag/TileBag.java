package Model.Bag;

import Model.Tiles.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class TileBag {
    private Tile[] tiles;
    private int TilesLeft;
    private int players;
    private List<Tile> tileList;

    /**
     * <b>Constructor</b> Constructs a new tile bag and that can fit a specific number of tiles
     * <b>Postcondition:</b> A new tile bag with a specific number of tiles has been constructed
     *
     * @param  numberOfPlayers
     */
    public TileBag(int numberOfPlayers){
        if(numberOfPlayers == 1){
            this.players = 1;
            setTilesLeft(131);
            tiles = new Tile[131];
        }
        else{
            this.players = 4;
            setTilesLeft(135);
            tiles = new Tile[135];
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
        for(int i = 0; i < 27; i++){
            if(i < 9){
                this.tiles[i] = new AmphoraTile("Green", "Mosaic Tile");
            }
            else if(i >= 9 && i < 18){
                this.tiles[i] = new AmphoraTile("Red", "Mosaic Tile");
            }
            else{
                this.tiles[i] = new AmphoraTile("Yellow", "Mosaic Tile");
            }
        }
        for(int i = 27; i < 51; i++){
            if(i < 39){
                this.tiles[i] = new StatueTile("Clear", "Caryatid Tile");
            }
            else{
                this.tiles[i] = new StatueTile("Clear", "Sphinx Tile");
            }
        }
        if(this.players == 1){
            for(int i = 51; i < 71; i++){
                this.tiles[i] = new LandslideTile("Landslide Tile");
            }
            for(int i = 71; i < 101; i++){
                if(i < 81){
                    this.tiles[i] = new SkeletonTile("Clear", "Upper Body");
                }
                else if(i >= 81 && i < 91){
                    this.tiles[i] = new SkeletonTile("Clear", "Lower Body");
                }
                else if(i >= 91 && i < 96){
                    this.tiles[i] = new SkeletonTile("Clear", "Upper Small Body");
                }
                else{
                    this.tiles[i] = new SkeletonTile("Clear", "Lower Small Body");
                }
            }
            for(int i = 101; i < 131; i++){
                if(i < 106){
                    this.tiles[i] = new VaseTile("Blue", "Amphora");
                }
                else if(i >= 106 && i < 111){
                    this.tiles[i] = new VaseTile("Brown", "Amphora");
                }
                else if(i >= 111 && i < 116){
                    this.tiles[i] = new VaseTile("Red", "Amphora");
                }
                else if(i >= 116 && i < 121){
                    this.tiles[i] = new VaseTile("Green", "Amphora");
                }
                else if(i >= 121 && i < 126){
                    this.tiles[i] = new VaseTile("Yellow", "Amphora");
                }
                else{
                    this.tiles[i] = new VaseTile("Purple", "Amphora");
                }
            }
        }
        else{
            for(int i = 51; i < 75; i++){
                this.tiles[i] = new LandslideTile("Landslide Tile");
            }
            for(int i = 74; i < 105; i++){
                if(i < 84){
                    this.tiles[i] = new SkeletonTile("Clear", "Upper Body");
                }
                else if(i >= 84 && i < 94){
                    this.tiles[i] = new SkeletonTile("Clear", "Lower Body");
                }
                else if(i >= 94 && i < 99){
                    this.tiles[i] = new SkeletonTile("Clear", "Upper Small Body");
                }
                else{
                    this.tiles[i] = new SkeletonTile("Clear", "Lower Small Body");
                }
            }
            for(int i = 105; i < 135; i++){
                if(i < 110){
                    this.tiles[i] = new VaseTile("Blue", "Amphora");
                }
                else if(i >= 110 && i < 115){
                    this.tiles[i] = new VaseTile("Brown", "Amphora");
                }
                else if(i >= 115 && i < 120){
                    this.tiles[i] = new VaseTile("Red", "Amphora");
                }
                else if(i >= 120 && i < 125){
                    this.tiles[i] = new VaseTile("Green", "Amphora");
                }
                else if(i >= 125 && i < 130){
                    this.tiles[i] = new VaseTile("Yellow", "Amphora");
                }
                else{
                    this.tiles[i] = new VaseTile("Purple", "Amphora");
                }
            }
        }
    }

    /**
     * <b>Transformer</b> Shuffles the tiles in the bag
     * <b>Postcondition:</b> The tiles in the bag have been shuffled
     *
     */
    public void shuffleTiles(){
        tileList = Arrays.asList(tiles);
        Collections.shuffle(tileList);
        tileList.toArray(tiles);
    }

    /**
     * <b>Transformer</b> Draws a tile from the bag
     * <b>Postcondition:</b>The tile has been drawn
     *
     */
    public void DrawTile(){
        tiles[getTilesLeft()-1] = null;
    }

    /**
     * <b>Transformer</b> Updates the tiles left in the bag
     * <b>Postcondition:</b>The tiles that are left in the bag have been updated
     *
     * @param  tilesLeft
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

    /**
     * <b>Transformer</b> Removes a number of landslide tiled from the bag
     * <b>Postcondition:</b>A number of landslide tiles has been removed from the bag
     *
     * @param num
     */
    public void delLandslide(int num){
        int found = 0;
        for(int i = 0; i < num; i++){
            while(tiles[found] != null){
                if(tiles[found].getType() == "Landslide Tile"){
                    Tile temp = tiles[found];
                    tiles[found] = tiles[getTilesLeft()-1];
                    tiles[getTilesLeft()-1] = temp;
                    tiles[getTilesLeft()-1] = null;
                    setTilesLeft(getTilesLeft() - 1);
                    break;
                }
                found++;
            }
            found = 0;
        }
    }

    /**
     * <b>Accessor:</b> Draws a tile from the bag
     * <b>Postcondition:</b> A tile has been drawn from the bag
     * @return Tile drawn
     */
    public Tile getDrawnTile(){
        Tile drawn = tiles[getTilesLeft()-1];
        DrawTile();
        setTilesLeft(getTilesLeft()-1);
        return drawn;
    }

    /**
     * <b>Accessor:</b> Returns the tiles in the bag
     * <b>Postcondition:</b> The tiles in the bag have been returned
     * @return Tile[] tiles
     */
    public Tile[] getTiles() {
        return tiles;
    }
}
