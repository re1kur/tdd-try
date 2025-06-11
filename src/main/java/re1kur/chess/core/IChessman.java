package re1kur.chess.core;

import re1kur.chess.core.impl.TChessField;
import re1kur.chess.core.impl.TChessMove;

public interface IChessman {
    TChessMove goToPosition(TChessField target);
}
