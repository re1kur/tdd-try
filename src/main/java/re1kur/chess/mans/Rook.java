package re1kur.chess.mans;

import re1kur.chess.core.EChessmanType;
import re1kur.chess.core.ESide;
import re1kur.chess.core.impl.TChessBoard;
import re1kur.chess.core.impl.TChessField;
import re1kur.chess.core.impl.TChessMove;
import re1kur.chess.core.impl.TChessman;

public class Rook extends TChessman {
    public Rook(TChessField position, ESide side, TChessBoard board) {
        super(EChessmanType.ROOK, position, side, board);
    }

    @Override
    public TChessMove goToPosition(TChessField target) {
        boolean sameRow = position.getRow() == target.getRow();
        boolean sameCol = position.getCol() == target.getCol();

        if (!(sameRow || sameCol)) return null;
        if (!isPathClear(target)) return null;

        boolean occupiedByEnemy = target.isBusy() != null && target.isBusy().side != this.side;
        if (target.isBusy() != null && !occupiedByEnemy) return null;

        TChessField from = position;
        boolean capture = target.isBusy() != null;

        position.setOccupiedBy(null);
        target.setOccupiedBy(this);
        position = target;

        TChessMove move = new TChessMove(this, from, target, capture);
        board.setLastMove(move);
        return move;
    }

    private boolean isPathClear(TChessField target) {
        char fromRow = position.getRow();
        char toRow = target.getRow();
        char fromCol = position.getCol();
        char toCol = target.getCol();

        if (fromRow == toRow) {
            for (char c = (char)(Math.min(fromCol, toCol) + 1); c < Math.max(fromCol, toCol); c++) {
                if (board.getField(c, fromRow).isBusy() != null) return false;
            }
        } else if (fromCol == toCol) {
            for (char r = (char)(Math.min(fromRow, toRow) + 1); r < Math.max(fromRow, toRow); r++) {
                if (board.getField(fromCol, r).isBusy() != null) return false;
            }
        }
        return true;
    }
}
