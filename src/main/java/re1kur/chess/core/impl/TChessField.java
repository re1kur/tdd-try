package re1kur.chess.core.impl;

import lombok.Getter;
import lombok.Setter;

public class TChessField {
    @Getter
    private char row;
    @Getter
    private char col;
    @Setter
    private TChessman occupiedBy;

    public TChessField(char col, char row) {
        this.col = col;
        this.row = row;
    }

    public TChessman isBusy() { return occupiedBy; }

    public String toString() {
        return "" + col + row;
    }
}
