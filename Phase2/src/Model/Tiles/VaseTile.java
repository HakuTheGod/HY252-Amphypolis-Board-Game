package Model.Tiles;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class VaseTile extends FindingTile {
    private String Color;
    private String Type;

    /**
     * <b>Constructor</b> Constructs a new Vase tile with color and type.
     * <b>Postcondtion</b> A new Vase tile with color and type has been constructed
     * @param Color
     * @param Type
     */
    public VaseTile(String Color, String Type){
        super(Color,Type);
    }

}
