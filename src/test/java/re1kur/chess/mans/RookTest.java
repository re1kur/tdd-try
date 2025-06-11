package re1kur.chess.mans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import re1kur.chess.core.ESide;
import re1kur.chess.core.impl.TChessBoard;
import re1kur.chess.core.impl.TChessMove;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    private TChessBoard board;

    @BeforeEach
    public void setup() {
        board = new TChessBoard();
    }

    @Test
    public void testRookValidMove() {
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        TChessMove move = rook.goToPosition(board.getField('a', '4'));
        assertNotNull(move);
        assertEquals("Ra1-a4", move.asString());
    }

    @Test
    public void testRookCapture() {
        new Pawn(board.getField('a', '4'), ESide.BLACK, board);
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        TChessMove move = rook.goToPosition(board.getField('a', '4'));
        assertNotNull(move);
        assertEquals("Ra1xa4", move.asString());
    }

    @Test
    public void testRookBlockedByAlly() {
        new Pawn(board.getField('a', '3'), ESide.WHITE, board);
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        assertNull(rook.goToPosition(board.getField('a', '4')));
    }

    @Test
    public void testRookValidVerticalMove() {
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        TChessMove move = rook.goToPosition(board.getField('a', '4'));
        assertNotNull(move);
        assertEquals("Ra1-a4", move.asString());
    }

    @Test
    public void testRookValidHorizontalMove() {
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        TChessMove move = rook.goToPosition(board.getField('d', '1'));
        assertNotNull(move);
        assertEquals("Ra1-d1", move.asString());
    }


    @Test
    public void testRookCaptureOwnPiece() {
        new Pawn(board.getField('a', '4'), ESide.WHITE, board);
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        assertNull(rook.goToPosition(board.getField('a', '4')));
    }

    @Test
    public void testRookInvalidDiagonalMove() {
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        assertNull(rook.goToPosition(board.getField('b', '2')));
    }

    @Test
    public void testRookMoveToSamePosition() {
        Rook rook = new Rook(board.getField('a', '1'), ESide.WHITE, board);
        assertNull(rook.goToPosition(board.getField('a', '1')));
    }
}
