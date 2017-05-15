package b02.game;

import b02.game.IGame;
import b02.game.IMove;
import b02.game.IPlayer;
import b02.game.TTTMove;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Shrddd on 07.05.2017.
 */

public class Tictactoe implements IGame {
    private IPlayer playerX, playerO;
    private StringBuilder spielfeld;


    private char[][] moves = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
    private char[][] playedMoves = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
    private char[][] defaultMoves = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};

    private Map<IMove, Character> grid = new HashMap<IMove, Character>();
    private char winner;
    private IPlayer currPlayer = null;

    public Tictactoe() {}
    public char[][] getField(){
        return playedMoves;
    }
    private void generateField() {
        spielfeld = new StringBuilder();
        for (int i = 0; i < playedMoves.length; i++) {
            spielfeld.append("|");
            for (int j = 0; j < playedMoves[i].length; j++) {
                if (playedMoves[i][j] != 'o' && playedMoves[i][j] != 'x')
                    spielfeld.append("   |");
                else
                    spielfeld.append(" " + playedMoves[i][j] + " |");

            }
            spielfeld.append("\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");

        }

    }


    public void setFirstPlayer(IPlayer p) {
        this.currPlayer = p;
    }

    @Override
    public void setPlayerX(IPlayer p) {
        playerX = p;
    }


    @Override
    public void setPlayerO(IPlayer p) {
        playerO = p;
    }

    @Override
    public IPlayer currentPlayer() {
        return currPlayer;
    }

    @Override
    public List<IMove> remainingMoves() {
        List<IMove> movesList = new ArrayList<IMove>();
        for (int i = 0; i < playedMoves.length; i++) {
            for (int j = 0; j < playedMoves[i].length; j++) {

                if (playedMoves[i][j] != 'o' && playedMoves[i][j] != 'x') {
                    movesList.add(new TTTMove(i, j));

                }
            }

        }
        return movesList;
    }

    @Override
    public void doMove(IMove m) {
        playedMoves[m.getRow()][m.getColumn()] = currPlayer.getSymbol();

        moves[m.getRow()][m.getColumn()] = defaultMoves[m.getRow()][m.getColumn()];

        if (currPlayer == playerO)
            currPlayer = playerX;
        else
            currPlayer = playerO;
    }

    @Override
    public void undoMove(IMove m) {


        playedMoves[m.getRow()][m.getColumn()] = defaultMoves[m.getRow()][m.getColumn()];
        moves[m.getRow()][m.getColumn()] = currPlayer.getSymbol();


        if (currPlayer == playerO)
            currPlayer = playerX;
        else
            currPlayer = playerO;
    }

    @Override
    public boolean ended() {
        if (hasWon() || fieldFull()  )
            return true;
        return false;
    }

    private boolean fieldFull(){
        for(int i=0;i<playedMoves.length;i++){
            for(int j=0;j<playedMoves[i].length;j++){
                if(playedMoves[i][j] != 'o' && playedMoves[i][j] != 'x')
                    return false;
            }
        }
        return true;
    }
    private boolean hasWon() {

        for (int i = 0; i < playedMoves.length; i++) {
            if (playedMoves[i][0] == playedMoves[i][1] && playedMoves[i][0] == playedMoves[i][2]) {
                winner = playedMoves[i][0];
                return true;
            }
        }
        for (int i = 0; i < playedMoves.length; i++) {
            if (playedMoves[0][i] == playedMoves[1][i] && playedMoves[0][i] == playedMoves[2][i]) {
                winner = playedMoves[0][i];
                return true;
            }
        }

        if (playedMoves[0][0] == playedMoves[1][1] && playedMoves[0][0] == playedMoves[2][2]){
            winner = playedMoves[0][0];
            return true;
        }
        if (playedMoves[0][2] == playedMoves[1][1] && playedMoves[1][1] == playedMoves[2][0]){
            winner = playedMoves[0][2];
            return true;
        }

        winner = 'u';
        return false;
    }

    @Override
    public int evalState(IPlayer p) {
        if(p.getSymbol() == winner)
            return 1;
        if(winner == 'u')
            return 0;
        return -1;
    }

    @Override
    public void printField() {

        generateField();
        System.out.println(spielfeld.toString());
    }


}
