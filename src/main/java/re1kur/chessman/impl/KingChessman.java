package re1kur.chessman.impl;

import re1kur.chessfield.ChessField;
import re1kur.chessman.Chessman;
import re1kur.chessside.ChessSide;
import re1kur.exception.InvalidPositionException;

public class KingChessman extends Chessman {

    public KingChessman(ChessField field, ChessSide side) {
        super(field, side);
    }

    @Override
    public ChessField getPosition() {
        return position;
    }

    @Override
    protected void validate(ChessField newPosition) {
        if (newPosition.equals(this.position)) {
            throw new InvalidPositionException("King cannot stay on the same position");
        }

        int currentRow = this.position.getRow().ordinal();
        int currentCol = this.position.getColumn().ordinal();
        int newRow = newPosition.getRow().ordinal();
        int newCol = newPosition.getColumn().ordinal();

        int rowDiff = Math.abs(newRow - currentRow);
        int colDiff = Math.abs(newCol - currentCol);

        if (rowDiff > 1 || colDiff > 1) {
            throw new InvalidPositionException("King can move only one square in any direction");
        }

        if (newPosition.isBusy() && newPosition.getChess().getSide().ordinal() == this.side.ordinal()) {
            throw new InvalidPositionException("Target position is occupied by your own piece");
        }
    }

}
