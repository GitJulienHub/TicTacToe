import b02.game.*;
import b02.strategy.Aggressiv;
import b02.strategy.MinMaxStrategy;
import b02.strategy.Randy;
import b02.strategy.Simple;

import java.util.List;

/**
 * Created by Shrddd on 07.05.2017.
 */
public class Main {

    public static void main(String[] args) {
        Tictactoe spiel = new Tictactoe();

        TTTPlayer playerO = new TTTPlayer('o');
        playerO.setStrategy(new MinMaxStrategy());
        TTTPlayer playerX = new TTTPlayer('x');
        playerX.setStrategy(new Aggressiv());

        spiel.setPlayerO(playerO);
        spiel.setPlayerX(playerX);
        spiel.setFirstPlayer(playerO);

        while (!spiel.ended()) {
            spiel.doMove(spiel.currentPlayer().nextMove(spiel));
            spiel.printField();


        }
        if(spiel.evalState(playerO) == 1)
            System.out.println("Player O wonnered");
        else if(spiel.evalState(playerO) == -1)
            System.out.println("Player X wonnered");
        else
            System.out.println("No one wonnered");


    }

}