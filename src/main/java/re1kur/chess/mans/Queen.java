package re1kur.chess.mans;

import re1kur.chess.core.EChessmanType;
import re1kur.chess.core.ESide;
import re1kur.chess.core.impl.TChessBoard;
import re1kur.chess.core.impl.TChessField;
import re1kur.chess.core.impl.TChessMove;
import re1kur.chess.core.impl.TChessman;

public class Queen extends TChessman {
    public Queen(TChessField position, ESide side, TChessBoard board) {
        super(EChessmanType.QUEEN, position, side, board);
    }

    @Override
    public TChessMove goToPosition(TChessField target) {
        return null; // не используется напрямую в тестах
    }
}
