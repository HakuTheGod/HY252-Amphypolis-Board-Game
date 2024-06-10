package Model.Tiles;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class CaryatidTile extends StatueTile{
    private String Color;
    private String Type;

    /**
     * <b>Constructor</b> Constructs a new Caryatid tile with color and type.
     * <b>Postcondtion</b> A new Caryatid tile with color and type has been constructed
     * @param Color
     * @param Type
     */
    CaryatidTile(String Color, String Type){
        super(Color,Type);
    }
}
