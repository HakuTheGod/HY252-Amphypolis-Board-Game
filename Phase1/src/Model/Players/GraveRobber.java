package Model.Players;

import Model.Board.Board;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class GraveRobber {
    private String Name;
    private int totalPoints;

    /**
     * <b>Constructor</b> Constructs a new grave robber
     * <b>Postcondition:</b> A new grave robber has been constructed
     *
     */
    GraveRobber(){
        Name = "GraveRobber";
    }

    /**
     * <b>Transformer</b> Removes the tiles form all areas
     * <b>Postcondition:</b> The tiles from all areas have been removed
     *
     * @param board
     * @param Area
     */
    public void getTiles(Board board, String Area){

    }

    /**
     * <b>Transformer</b> Sets the total points of the Grave Robber
     * <b>Postcondition:</b> The total points of the grave robber have been set.
     *
     * @param totalPoints
     */
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    /**
     * <b>Accessor</b> Returns the total points of the GraveRobber
     * <b>Postcondition:</b> The total points of the GraveRobber have been returned.
     * @return int totalPoint
     */
    public int getTotalPoints() {
        return totalPoints;
    }
}
