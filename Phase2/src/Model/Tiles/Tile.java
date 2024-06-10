package Model.Tiles;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public interface Tile {

     /**
      * <b>Transformer</b> Sets the color of the tile
      * <b>postcondition:</b> The color of the tile has been set
      * @param Color
      */
     void setColor(String Color);

     /**
      * <b>Accessor</b> Returns the color of the tile
      * <b>postcondition:</b> The color of the tile has been returned
      * @return String Color
      */
     String getColor();

     /**
      * <b>Transformer</b> Sets the type of the tile
      * <b>postcondition:</b> The type of the tile has been set
      * @param Type
      */
     void setType(String Type);

     /**
      * <b>Accessor</b> Returns the type of the tile
      * <b>postcondition:</b> The type of the tile has been returned
      * @return String Type
      */
     String getType();

}
