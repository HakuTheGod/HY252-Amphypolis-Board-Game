package Model.Players;

import Model.Board.Board;
import Model.Tiles.Tile;

/**
 * @version 1.0
 * @author Nikola Kovatsevits - csd4285
 */
public class GraveRobber {
    private int totalPoints;
    private int caryatidNum;
    private int sphinxNum;
    private Tile[] tiles;
    private int j;

    /**
     * <b>Constructor</b> Constructs a new grave robber
     * <b>Postcondition:</b> A new grave robber has been constructed
     *
     */
    public GraveRobber(){
        setSphinxNum(0);
        setCaryatidNum(0);
        tiles = new Tile[111];
        setTotalPoints(0);
        j = 0;
    }

    /**
     * <b>Transformer</b> Removes the tiles form all areas
     * <b>Postcondition:</b> The tiles from all areas have been removed
     *
     * @param board
     */
    public void getTiles(Board board){
        while(board.getAmphoraArea()[0] != null){
            tiles[j] = board.getAmphoraArea()[0];
            board.removeTile("AmphoraArea", 0);
            j++;
        }
        while(board.getStatueArea()[0] != null){
            tiles[j] = board.getStatueArea()[0];
            board.removeTile("StatueArea",0);
            j++;
        }
        while(board.getVaseArea()[0] != null){
            tiles[j] = board.getVaseArea()[0];
            board.removeTile("VaseArea",0);
            j++;
        }
        while (board.getSkeletonArea()[0] != null){
            tiles[j] = board.getSkeletonArea()[0];
            board.removeTile("SkeletonArea",0);
            j++;
        }
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

    /**
     * <b>Transformer</b>Calculates the points of the GraveRobber
     * <b>Postcondition:</b>The points of the GraveRobber have been calculated
     *
     */
    public void areaTotalPoints(){
        int i = 0;
        int counter = 0;
        int col = 0;
        int ind = 0;
        String color = "clear";
        Tile[] temp = new Tile[30];
        Tile[] skelUp = new Tile[10];
        Tile[] skelDown = new Tile[10];
        Tile[] skelMinUp = new Tile[5];
        Tile[] skelMinDown = new Tile[5];
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        while (this.tiles[i] != null){
            if(this.tiles[i].getType() == "Mosaic Tile"){
                counter++;
                if(this.tiles[i].getColor() == color || color == "clear"){
                    color = this.tiles[i].getColor();
                    col = 1;
                }
                else{
                    col = 0;
                }
                if(counter%4 == 0){
                    if(col == 1){
                        setTotalPoints(totalPoints + 4);
                    }
                    else{
                        setTotalPoints(totalPoints + 2);
                    }
                }
            }
            else if(this.tiles[i].getType() == "Amphora"){
                temp[ind] = this.tiles[i];
            }
            else if(this.tiles[i].getType() == "Caryatid Tile"){
                setCaryatidNum(caryatidNum + 1);
            }
            else if(this.tiles[i].getType() == "Sphinx Tile"){
                setSphinxNum(sphinxNum + 1);
            }
            else if(this.tiles[i].getType() == "Upper Body"){
                skelUp[one] = this.tiles[i];
                one++;
            }
            else if(this.tiles[i].getType() == "Lower Body"){
                skelDown[two] = this.tiles[i];
                two++;
            }
            else if(this.tiles[i].getType() == "Upper Small Body"){
                skelMinUp[three] = this.tiles[i];
                three++;
            }
            else{
                skelMinDown[four] = this.tiles[i];
                four++;
            }
            i++;
        }
        counter = 0;
        Tile tp;
        int b;
        while (temp[counter] != null){
            tp = temp[counter];
            b = counter;
            if(temp[counter+1] != null && (temp[counter + 1].getColor() == temp[counter].getColor())){
                while(temp[b] != null){
                    if(temp[counter].getColor() != temp[b].getColor()){
                        temp[counter] = temp[b];
                        temp[b] = tp;
                    }
                    b++;
                }
            }
            counter++;
        }
        counter = 0;
        int k = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;
        Tile[] Blue = new Tile[5];
        Tile[] Brown = new Tile[5];
        Tile[] Red = new Tile[5];
        Tile[] Green = new Tile[5];
        Tile[] Yellow = new Tile[5];
        Tile[] Purple = new Tile[5];
        while(temp[counter] != null) {
            if (temp[counter].getColor() == "Blue") {
                Blue[c1] = temp[counter];
                c1++;
            } else if (temp[counter].getColor() == "Brown") {
                Brown[c2] = temp[counter];
                c2++;
            } else if (temp[counter].getColor() == "Red") {
                Red[c3] = temp[counter];
                c3++;
            } else if (temp[counter].getColor() == "Green") {
                Green[c4] = temp[counter];
                c4++;
            } else if (temp[counter].getColor() == "Yellow") {
                Yellow[c5] = temp[counter];
                c5++;
            } else if (temp[counter].getColor() == "Purple") {
                Purple[c6] = temp[counter];
            }
            k++;
            counter++;
        }
        int cols = 0;
        if(k >= 3){
            cols = 6;
        }
        while(cols >= 2) {
            if (Blue[0] == null) {
                cols--;
            } else if (Brown[0] == null) {
                cols--;
            } else if (Red[0] == null) {
                cols--;
            } else if (Green[0] == null) {
                cols--;
            } else if (Yellow[0] == null) {
                cols--;
            } else if (Purple[0] == null) {
                cols--;
            } else {
                if (cols == 6) {
                    setTotalPoints(totalPoints + 6);
                    Blue[c1] = null;
                    Brown[c2] = null;
                    Red[c3] = null;
                    Green[c4] = null;
                    Yellow[c5] = null;
                    Purple[c6] = null;
                    c1--;
                    c2--;
                    c3--;
                    c4--;
                    c5--;
                    c6--;
                } else if (cols == 5) {
                   setTotalPoints(totalPoints + 4);
                    if (Blue[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Red[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Green[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c3--;
                        c4--;
                        c5--;
                    }
                } else if (cols == 4) {
                    setTotalPoints(totalPoints + 2);
                    if (Blue[0] == null && Brown[0] == null) {
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c3--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Red[0] == null) {
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Green[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Yellow[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Blue[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c2--;
                        c3--;
                        c4--;
                        c5--;
                    } else if (Brown[0] == null && Red[0] == null) {
                        Blue[c1] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null && Green[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Brown[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c3--;
                        c4--;
                        c5--;
                    } else if (Red[0] == null && Green[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c5--;
                        c6--;
                    } else if (Red[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c4--;
                        c6--;
                    } else if (Red[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c4--;
                        c5--;
                    } else if (Green[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c3--;
                        c6--;
                    } else if (Green[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c3--;
                        c5--;
                    } else if (Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        c1--;
                        c2--;
                        c3--;
                        c4--;
                    }
                } else if (cols == 3) {
                    setTotalPoints(totalPoints + 1);
                    if (Blue[0] == null && Brown[0] == null && Red[0] == null) {
                        Green[c4] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c4--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Brown[0] == null && Green[0] == null) {
                        Red[c3] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c3--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Brown[0] == null && Yellow[0] == null) {
                        Red[c3] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c3--;
                        c4--;
                        c6--;
                    } else if (Blue[0] == null && Brown[0] == null && Purple[0] == null) {
                        Red[c3] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c3--;
                        c4--;
                        c5--;
                    } else if (Blue[0] == null && Red[0] == null && Green[0] == null) {
                        Brown[c2] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c2--;
                        c5--;
                        c6--;
                    } else if (Blue[0] == null && Red[0] == null && Yellow[0] == null) {
                        Brown[c2] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c2--;
                        c4--;
                        c6--;
                    } else if (Blue[0] == null && Red[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c2--;
                        c4--;
                        c5--;
                    } else if (Blue[0] == null && Green[0] == null && Yellow[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Purple[c6] = null;
                        c2--;
                        c3--;
                        c6--;
                    } else if (Blue[0] == null && Green[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        c2--;
                        c3--;
                        c5--;
                    } else if (Blue[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Brown[c2] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        c2--;
                        c3--;
                        c4--;
                    } else if (Brown[0] == null && Red[0] == null && Green[0] == null) {
                        Blue[c1] = null;
                        Yellow[c5] = null;
                        Purple[c6] = null;
                        c1--;
                        c5--;
                        c6--;
                    } else if (Brown[0] == null && Red[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Green[c4] = null;
                        Purple[c6] = null;
                        c1--;
                        c4--;
                        c6--;
                    } else if (Brown[0] == null && Red[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Green[c4] = null;
                        Yellow[c5] = null;
                        c1--;
                        c4--;
                        c5--;
                    } else if (Brown[0] == null && Green[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Purple[c6] = null;
                        c1--;
                        c3--;
                        c6--;
                    } else if (Brown[0] == null && Green[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Yellow[c5] = null;
                        c1--;
                        c3--;
                        c5--;
                    } else if (Brown[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Red[c3] = null;
                        Green[c4] = null;
                        c1--;
                        c3--;
                        c4--;
                    } else if (Red[0] == null && Green[0] == null && Yellow[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Purple[c6] = null;
                        c1--;
                        c2--;
                        c6--;
                    } else if (Red[0] == null && Green[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Yellow[c5] = null;
                        c1--;
                        c2--;
                        c5--;
                    } else if (Red[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Green[c4] = null;
                        c1--;
                        c2--;
                        c4--;
                    } else if (Green[0] == null && Yellow[0] == null && Purple[0] == null) {
                        Blue[c1] = null;
                        Brown[c2] = null;
                        Red[c3] = null;
                        c1--;
                        c2--;
                        c3--;
                    }
                }
            }
        }
        int adSkel = 0;
        int ChSkel = 0;
        int FamSkel = 0;
        counter = 0;
        while(skelUp[counter] != null && skelDown[counter] != null){
            adSkel++;
            counter++;
        }
        counter = 0;
        while(skelMinUp[counter] != null && skelMinDown[counter] != null){
            ChSkel++;
            counter++;
        }
        if(adSkel == 1 && ChSkel == 0){
            setTotalPoints(totalPoints + 1);
        }
        else if(adSkel == 0 && ChSkel == 1){
            setTotalPoints(totalPoints + 1);
        }
        else if(adSkel == 1 && ChSkel == 1){
            setTotalPoints(totalPoints + 2);
        }
        else if(adSkel == 1 && ChSkel == 2){
            setTotalPoints(totalPoints + 3);
        }
        else if(adSkel/2 == ChSkel){
            FamSkel = ChSkel;
        }
        else if(adSkel/2 > ChSkel){
            FamSkel = ChSkel;
            setTotalPoints(totalPoints + (adSkel-FamSkel));
        }
        else{
            FamSkel = adSkel/2;
            setTotalPoints(totalPoints + (ChSkel - FamSkel));
        }
        if(FamSkel != 0){
            setTotalPoints(totalPoints + (6 * FamSkel));
        }
        else {
            setTotalPoints(totalPoints);
        }
    }


    /**
     * <b>Transformer</b>Sets the number of the Caryatid tiles the GraveRobber has
     * <b>Postcondition:</b>The number of the Caryatid tiles the GraveRobber has is set.
     * @param caryatidNum
     */
    public void setCaryatidNum(int caryatidNum) {
        this.caryatidNum = caryatidNum;
    }

    /**
     * <b>Accessor:</b> Returns the number of the Caryatid tiles the GraveRobber has
     * <b>Postcondition:</b> The number of the Caryatid tiles the GraveRobber has has been returned
     * @return int caryatidNum
     */
    public int getCaryatidNum() {
        return caryatidNum;
    }

    /**
     * <b>Transformer</b>Sets the number of the Sphinx tiles the GraveRobber has
     * <b>Postcondition:</b>The number of the Sphinx tiles the GraveRobber has is set.
     * @param sphinxNum
     */
    public void setSphinxNum(int sphinxNum) {
        this.sphinxNum = sphinxNum;
    }

    /**
     * <b>Accessor:</b> Returns the number of the Sphinx tiles the GraveRobber has
     * <b>Postcondition:</b> The number of the Sphinx tiles the GraveRobber has has been returned
     * @return int sphinxNum
     */
    public int getSphinxNum() {
        return sphinxNum;
    }
}
