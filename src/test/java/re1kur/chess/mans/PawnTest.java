package re1kur.chess.mans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import re1kur.chess.core.ESide;
import re1kur.chess.core.impl.TChessBoard;
import re1kur.chess.core.impl.TChessMove;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    private TChessBoard board;

    @BeforeEach
    public void setup() {
        board = new TChessBoard();
    }

    @Test
    public void testPawnSingleStepForward() {
        Pawn pawn = new Pawn(board.getField('e', '2'), ESide.WHITE, board);
        TChessMove move = pawn.goToPosition(board.getField('e', '3'));
        assertNotNull(move);
        assertEquals("Pe2-e3", move.asString());
    }

    @Test
    public void testPawnDoubleStepFromStart() {
        Pawn pawn = new Pawn(board.getField('e', '2'), ESide.WHITE, board);
        TChessMove move = pawn.goToPosition(board.getField('e', '4'));
        assertNotNull(move);
        assertEquals("Pe2-e4", move.asString());
    }

    @Test
    public void testPawnCaptureLeftDiagonal() {
        new Pawn(board.getField('d', '5'), ESide.BLACK, board);
        Pawn pawn = new Pawn(board.getField('e', '4'), ESide.WHITE, board);
        TChessMove move = pawn.goToPosition(board.getField('d', '5'));
        assertNotNull(move);
        assertEquals("Pe4xd5", move.asString());
    }

    @Test
    public void testPawnInvalidBackwardMove() {
        Pawn pawn = new Pawn(board.getField('e', '4'), ESide.WHITE, board);
        assertNull(pawn.goToPosition(board.getField('e', '3')));
    }

    @Test
    public void testPawnBlockedForward() {
        new Pawn(board.getField('e', '3'), ESide.WHITE, board);
        Pawn pawn = new Pawn(board.getField('e', '2'), ESide.WHITE, board);
        assertNull(pawn.goToPosition(board.getField('e', '3')));
    }

    @Test
    public void testPawnCaptureRightDiagonal() {
        new Pawn(board.getField('f', '5'), ESide.BLACK, board);
        Pawn pawn = new Pawn(board.getField('e', '4'), ESide.WHITE, board);
        TChessMove move = pawn.goToPosition(board.getField('f', '5'));
        assertNotNull(move);
        assertEquals("Pe4xf5", move.asString());
    }

    @Test
    public void testPawnBlockedDoubleStep() {
        new Pawn(board.getField('e', '3'), ESide.WHITE, board);
        Pawn pawn = new Pawn(board.getField('e', '2'), ESide.WHITE, board);
        assertNull(pawn.goToPosition(board.getField('e', '4')));
    }

    @Test
    public void testPawnInvalidSideMove() {
        Pawn pawn = new Pawn(board.getField('e', '2'), ESide.WHITE, board);
        assertNull(pawn.goToPosition(board.getField('f', '2')));
    }

    @Test
    public void testPawnInvalidDiagonalWithoutCapture() {
        Pawn pawn = new Pawn(board.getField('e', '2'), ESide.WHITE, board);
        assertNull(pawn.goToPosition(board.getField('d', '3')));
    }
}
