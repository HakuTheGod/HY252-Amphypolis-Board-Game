package Model.Tiles;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class SphinxTile extends StatueTile{
    private String Color;
    private String Type;

    /**
     * <b>Constructor</b> Constructs a new Sphinx tile with color and type.
     * <b>Postcondtion</b> A new Sphinx tile with color and type has been constructed
     * @param Color
     * @param Type
     */
    SphinxTile(String Color, String Type){
        super(Color,Type);
    }
}
