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

        if (isForward || isDoubleStep || isCapture) {
            TChessField from = position;
            boolean capture = target.isBusy() != null;

            position.setOccupiedBy(null);
            target.setOccupiedBy(this);
            position = target;

            return new TChessMove(this, from, target, capture);
        }
        return null;
    }
}
