package Model.Tiles;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class SkeletonTile extends FindingTile {
    private String Color;
    private String Type;

    /**
     * <b>Constructor</b> Constructs a new Skeleton tile with color and type.
     * <b>Postcondtion</b> A new Skeleton tile with color and type has been constructed
     * @param Color
     * @param Type
     */
    SkeletonTile(String Color, String Type){
        super(Color,Type);
    }
}
