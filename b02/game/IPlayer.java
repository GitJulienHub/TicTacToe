package b02.game;

import b02.strategy.IGameStrategy;

public interface IPlayer {
    // Spielstrategie setzen
    void setStrategy(IGameStrategy s);

    // Naechsten Zug berechnen (Delegation an Strategie!)
    IMove nextMove(IGame g);

    // Zeichen fuer den Spieler liefern
    char getSymbol();
}
