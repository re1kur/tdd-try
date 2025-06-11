package re1kur.chess.core.impl;

import lombok.Getter;
import re1kur.chess.core.EChessmanType;
import re1kur.chess.core.ESide;
import re1kur.chess.core.IChessman;

public abstract class TChessman implements IChessman {
    protected EChessmanType type;
    @Getter
    protected TChessField position;
    public ESide side;
    protected TChessBoard board;

    public TChessman(EChessmanType type, TChessField position, ESide side, TChessBoard board) {
        this.type = type;
        this.position = position;
        this.side = side;
        this.board = board;
        position.setOccupiedBy(this);
    }

}
