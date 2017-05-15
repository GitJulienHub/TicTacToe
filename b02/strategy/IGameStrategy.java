package b02.strategy;

import b02.game.IGame;
import b02.game.IMove;

public interface IGameStrategy {
    // Naechsten Zug berechnen
    IMove nextMove(IGame g);
}
