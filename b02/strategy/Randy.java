package b02.strategy;

import b02.game.IGame;
import b02.game.IMove;
import b02.game.TTTMove;

import java.util.List;
import java.util.Random;

/**
 * Created by acahri on 14.05.17.
 */
public class Randy implements IGameStrategy {

    public Randy() {

    }

    @Override
    public IMove nextMove(IGame g) {

        IMove move;

        List<IMove> moves = g.remainingMoves();
        do {

            move = new TTTMove(new Random().nextInt(3), new Random().nextInt(3));
            for (int i = 0; i < moves.size(); i++) {
                if (((TTTMove) moves.get(i)).compareTo(move) == 0) {
                    return move;
                }

            }

        } while (true);


    }
}
