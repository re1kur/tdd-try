package re1kur.chessman;

import lombok.Getter;
import re1kur.chessfield.ChessField;
import re1kur.chessside.ChessSide;

public abstract class Chessman {
    protected ChessField position;
    @Getter
    protected final ChessSide side;

    protected Chessman(ChessField pos, ChessSide side) {
        this.position = pos;
        this.side = side;
    }

    protected ChessField getPosition() {
        return position;
    }

    protected abstract void validate(ChessField position);

    public void setPosition(ChessField position) {
        validate(position);
        this.position = position;
    }
}
