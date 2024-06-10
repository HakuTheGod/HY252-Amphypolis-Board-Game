package Model.Board;

import Model.Bag.TileBag;
import Model.Players.Player;
import Model.Tiles.*;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class Board{
    private LandslideTile[] LandArea;
    private AmphoraTile[] AmphoraArea;
    private StatueTile[] StatueArea;
    private VaseTile[] VaseArea;
    private SkeletonTile[] SkeletonArea;
    private TileBag Bag;

    /**
     * <b>Constructor</b> Constructs a new board and sets it's areas
     * <b>Postcondition:</b> A new board with different areas has been constructed
     *
     */
    public Board(){
        Start();
    }

    /**
     * <b>Transformer</b>Sets the areas of the board
     * <b>Postcondition:</b>The areas of the board have been set
     *
     */
    public void Start(){
       setLandArea(new LandslideTile[24]);
        setAmphoraArea(new AmphoraTile[30]);
        setVaseArea(new VaseTile[27]);
        setStatueArea(new StatueTile[24]);
        setSkeletonArea(new SkeletonTile[30]);
    }

    /**
     * <b>Transformer</b>Sets the amphora area
     * <b>Postcondition:</b>The amphora area has been set
     * @param amphoraArea
     */
    public void setAmphoraArea(AmphoraTile[] amphoraArea) {
        AmphoraArea = amphoraArea;
    }

    /**
     * <b>Accessor:</b> Returns the amphora area
     * <b>Postcondition:</b> The amphora area has been returned
     * @return AmphoraTile[] AmphoraArea
     */
    public AmphoraTile[] getAmphoraArea() {
        return AmphoraArea;
    }

    /**
     * <b>Transformer</b>Sets the land area
     * <b>Postcondition:</b>The land area has been set
     * @param landArea
     */
    public void setLandArea(LandslideTile[] landArea) {
        LandArea = landArea;
    }

    /**
     * <b>Accessor:</b> Returns the land area
     * <b>Postcondition:</b> The land area has been returned
     * @return LandTile[] LandArea
     */
    public LandslideTile[] getLandArea() {
        return LandArea;
    }

    /**
     * <b>Transformer</b>Sets the vase area
     * <b>Postcondition:</b>The vase area has been set
     * @param vaseArea
     */
    public void setVaseArea(VaseTile[] vaseArea) {
        VaseArea = vaseArea;
    }

    /**
     * <b>Accessor:</b> Returns the vase area
     * <b>Postcondition:</b> The vase area has been returned
     * @return VaseTile[] VaseArea
     */
    public VaseTile[] getVaseArea() {
        return VaseArea;
    }

    /**
     * <b>Transformer</b>Sets the statue area
     * <b>Postcondition:</b>The statue area has been set
     * @param statueArea
     */
    public void setStatueArea(StatueTile[] statueArea) {
        StatueArea = statueArea;
    }

    /**
     * <b>Accessor:</b> Returns the statue area
     * <b>Postcondition:</b> The statue area has been returned
     * @return StatueTile[] StatueArea
     */
    public StatueTile[] getStatueArea() {
        return StatueArea;
    }

    /**
     * <b>Transformer</b>Sets the skeleton area
     * <b>Postcondition:</b>The skeleton area has been set
     * @param skeletonArea
     */
    public void setSkeletonArea(SkeletonTile[] skeletonArea) {
        SkeletonArea = skeletonArea;
    }

    /**
     * <b>Accessor:</b> Returns the skeleton area
     * <b>Postcondition:</b> The skeleton area has been returned
     * @return SkeletonTile[] SkeletonArea
     */
    public SkeletonTile[] getSkeletonArea() {
        return SkeletonArea;
    }

    /**
     * <b>Transformer</b>Sets the tile bag
     * <b>Postcondition:</b>The tile bag has been set
     * @param bag
     */
    public void setBag(TileBag bag) {
        Bag = bag;
    }

    /**
     * <b>Accessor:</b> Returns the tile bag
     * <b>Postcondition:</b> The tile bag has been returned
     * @return TileBag Bag
     */
    public TileBag getBag() {
        return Bag;
    }

    /**
     * <b>Transformer</b>Removes a specific tile from an area
     * <b>Postcondition:</b>The tile has been removed from the area
     * @param Area
     */
    public void removeTile(String Area){

    }

    /**
     * <b>Transformer</b>Removes all tiles from an area
     * <b>Postcondition:</b>All the tiles have been removed from the area
     * @param Area
     */
    public void removeAllTilesArea(String Area){

    }

    /**
     * <b>Transformer</b>inserts a specific tile on an area
     * <b>Postcondition:</b>The tile has been inserted to the area
     * @param tile
     * @param Area
     */
    public void insertTiles(int tile, String Area){

    }
}
