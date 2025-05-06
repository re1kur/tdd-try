package re1kur.chessfield;

import lombok.Data;
import re1kur.chessman.Chessman;

@Data
public class ChessField {
    private ChessRow row;
    private ChessColumn column;
    private Chessman chess;

    public ChessField(ChessRow row, ChessColumn col) {
        this.row = row;
        this.column = col;
    }

    public boolean isBusy() {
        return chess != null;
    }
}
