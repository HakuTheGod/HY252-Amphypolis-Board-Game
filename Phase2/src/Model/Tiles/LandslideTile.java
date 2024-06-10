package Model.Tiles;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class LandslideTile implements Tile {
    private String Color;
    private String Type;

    /**
     * <b>Constructor</b> Constructs a new Landslide tile.
     * <b>Postcondtion</b> A new Landslide tile has been constructed
     * @param Type
     */
    public LandslideTile(String Type){
        setType(Type);
        setColor("clear");
    }
    /**
     * <b>Transformer</b> Sets the color of the tile. The color of Landslide tiles is 'clear'
     * <b>postcondition:</b> The color of the tile has been set
     * @param Color
     */
    public final void setColor(String Color){
        this.Color = Color;
    }

    /**
     * <b>Accessor</b> Returns the color of the tile
     * <b>postcondition:</b> The color of the tile has been returned
     * @return String Color
     */
    public String getColor(){
        return this.Color;
    }

    /**
     * <b>Transformer</b> Sets the type of the tile
     * <b>postcondition:</b> The type of the tile has been set
     * @param Type
     */
    public final void setType(String Type){
        this.Type = Type;
    }

    /**
     * <b>Accessor</b> Returns the type of the tile
     * <b>postcondition:</b> The type of the tile has been returned
     * @return String Type
     */
    public String getType(){
        return this.Type;
    }
}
