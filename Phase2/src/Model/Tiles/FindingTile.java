package Model.Tiles;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class FindingTile implements Tile {
    protected String Color;
    protected String Type;

    /**
     * <b>Constructor</b> Constructs a new tile with color and type. The type can't be 'Landslide'
     * <b>Postcondtion</b> A new tile with color and type has been constructed
     * @param Color
     * @param Type
     */
    FindingTile(String Color, String Type){
        setColor(Color);
        setType(Type);
    }

    /**
     * <b>Transformer</b> Sets the color of the tile
     * <b>postcondition:</b> The color of the tile has been set
     * @param Color
     */
    public void setColor(String Color){
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
    public void setType(String Type){
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
