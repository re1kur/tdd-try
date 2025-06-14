package re1kur.chess.mans;

import re1kur.chess.core.EChessmanType;
import re1kur.chess.core.ESide;
import re1kur.chess.core.impl.TChessBoard;
import re1kur.chess.core.impl.TChessField;
import re1kur.chess.core.impl.TChessMove;
import re1kur.chess.core.impl.TChessman;

public class Pawn extends TChessman {
    public Pawn(TChessField position, ESide side, TChessBoard board) {
        super(EChessmanType.PAWN, position, side, board);
    }

    @Override
    public TChessMove goToPosition(TChessField target) {
        if (target == null) return null;

        int direction = (side == ESide.WHITE) ? 1 : -1;
        int rowDiff = target.getRow() - position.getRow();
        int colDiff = target.getCol() - position.getCol();

        boolean isForward = colDiff == 0 && rowDiff == direction && target.isBusy() == null;
        boolean isDoubleStep = colDiff == 0 && rowDiff == 2 * direction &&
                               ((side == ESide.WHITE && position.getRow() == '2') ||
                                (side == ESide.BLACK && position.getRow() == '7')) &&
                               board.getField(position.getCol(), (char)(position.getRow() + direction)).isBusy() == null &&
                               target.isBusy() == null;

        boolean isCapture = Math.abs(colDiff) == 1 && rowDiff == direction &&
                            target.isBusy() != null && target.isBusy().side != this.side;

        boolean enPassant = false;
        if (Math.abs(colDiff) == 1 && rowDiff == direction && target.isBusy() == null) {
            TChessMove lastMove = board.getLastMove();
            if (lastMove != null && lastMove.piece instanceof Pawn) {
                int lastRowDiff = lastMove.to.getRow() - lastMove.from.getRow();
                if (Math.abs(lastRowDiff) == 2 &&
                    lastMove.to.getCol() == target.getCol() &&
                    lastMove.to.getRow() == position.getRow()) {
                    isCapture = true;
                    enPassant = true;
                    board.getField(lastMove.to.getCol(), lastMove.to.getRow()).setOccupiedBy(null);
                }
            }
        }

        if (isForward || isDoubleStep || isCapture) {
            TChessField from = position;
            boolean promotion = (side == ESide.WHITE && target.getRow() == '8') ||
                                (side == ESide.BLACK && target.getRow() == '1');

            position.setOccupiedBy(null);
            if (promotion) {
                target.setOccupiedBy(new Queen(target, side, board));
                position = target;
                TChessMove move = new TChessMove(this, from, target, isCapture, true, false);
                board.setLastMove(move);
                return move;
            }
            else {
                target.setOccupiedBy(this);
                position = target;
                TChessMove move = new TChessMove(this, from, target, isCapture, false, enPassant);
                board.setLastMove(move);
                return move;
            }
        }

        return null;
    }
}
