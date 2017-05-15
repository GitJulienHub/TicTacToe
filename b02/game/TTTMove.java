package b02.game;

/**
 * Created by acahri on 14.05.17.
 */
public class TTTMove implements b02.game.IMove, Comparable {

    private int row = 0;
    private int column = 0;

    public TTTMove(int row, int column){
      this.row = row;
      this.column = column;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public int compareTo(Object o) {
        TTTMove that = (TTTMove) o;
        if(this.getColumn() == that.getColumn())
            if(this.getRow() == that.getRow())
                return 0;
        return 1;
    }
}
