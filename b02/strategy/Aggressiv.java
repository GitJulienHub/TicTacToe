package b02.strategy;

import b02.game.IGame;
import b02.game.IMove;
import b02.game.TTTMove;
import b02.game.Tictactoe;

import java.util.List;
import java.util.Random;

/**
 * Created by acahri on 14.05.17.
 */
public class Aggressiv implements IGameStrategy {
    private List<IMove> moves;
    private boolean gotMid = false, muehle = false;
    private char symbol, enemySymbol;
    boolean strat=false;

    @Override
    public IMove nextMove(IGame g) {
        symbol = g.currentPlayer().getSymbol();
        enemySymbol = symbol == 'o'?'x':'o';
        moves = g.remainingMoves();
        IMove move = new TTTMove(1,1);

/*        for(int i = 0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(moveAlreadyPlayed(new TTTMove(i,j))) {
                    if(Tictactoe.field[i][j] != 'i')
                        if(Tictactoe.field[i][j]==symbol)
                            Tictactoe.field[i][j] = symbol == 'o'?'x':'o';
                }

            }
        }*/


        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (!moveAlreadyPlayed(new TTTMove(i, j)))
                    return new TTTMove(i, j);
            }
        }

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
