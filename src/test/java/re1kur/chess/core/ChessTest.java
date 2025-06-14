package re1kur.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import re1kur.chess.core.impl.TChessBoard;
import re1kur.chess.core.impl.TChessMove;
import re1kur.chess.mans.Rook;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessTest {
    private TChessBoard board;

    @BeforeEach
    public void setup() {
        board = new TChessBoard();
    }
    @Test
    public void testFieldToString() {
        assertEquals("c6", board.getField('c', '6').toString());
    }

    @Test
    public void testMoveToStringNormal() {
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        TChessMove move = new TChessMove(rook, board.getField('a', '1'), board.getField('a', '3'), false);
        assertEquals("Ra1-a3", move.asString());
    }

    @Test
    public void testMoveToStringCapture() {
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        TChessMove move = new TChessMove(rook, board.getField('a', '1'), board.getField('a', '3'), true);
        assertEquals("Ra1xa3", move.asString());
    }
}
