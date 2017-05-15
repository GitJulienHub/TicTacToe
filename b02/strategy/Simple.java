package b02.strategy;

import b02.game.IGame;
import b02.game.IMove;
import b02.game.TTTMove;

import java.util.List;

/**
 * Created by acahri on 15.05.17.
 */
public class Simple implements IGameStrategy {
    private List<IMove> moves;
    @Override
    public IMove nextMove(IGame g) {
        moves = g.remainingMoves();
        if(!moveAlreadyPlayed(new TTTMove(1,1)))
            return new TTTMove(1,1);
        else if(!moveAlreadyPlayed(new TTTMove(0,0)))
            return new TTTMove(0,0);
        else if(!moveAlreadyPlayed(new TTTMove(2,2)))
            return new TTTMove(2,2);
        else if(!moveAlreadyPlayed(new TTTMove(2,1)))
            return new TTTMove(2,1);
        else if(!moveAlreadyPlayed(new TTTMove(2,0)))
            return new TTTMove(2,0);
        else if(!moveAlreadyPlayed(new TTTMove(1,0)))
            return new TTTMove(1,0);
        else if(!moveAlreadyPlayed(new TTTMove(1,2)))
            return new TTTMove(1,2);
        else if(!moveAlreadyPlayed(new TTTMove(0,1)))
            return new TTTMove(0,1);
        else if(!moveAlreadyPlayed(new TTTMove(0,2)))
            return new TTTMove(0,2);

        return null;
    }
    private boolean moveAlreadyPlayed(IMove mov) {
        for (int i = 0; i < moves.size(); i++) {
            if (((TTTMove) moves.get(i)).compareTo(mov) == 0) {

                return false;

            }
        }
        return true;
    }
}
