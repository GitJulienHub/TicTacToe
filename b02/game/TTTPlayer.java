package b02.game; /**
 * Created by acahri on 14.05.17.
 */

import b02.strategy.IGameStrategy;

public class TTTPlayer implements IPlayer {
    private char symbol;
    private IGameStrategy strategy;

    public TTTPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void setStrategy(IGameStrategy s) {
        this.strategy = s;
    }

    @Override
    public IMove nextMove(IGame g) {
        return strategy.nextMove(g);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
