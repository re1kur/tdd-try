package re1kur.chess.core.impl;

import java.util.HashMap;
import java.util.Map;

public class TChessBoard {
    private final Map<String, TChessField> fields = new HashMap<>();

    public TChessBoard() {
        for (char col = 'a'; col <= 'h'; col++) {
            for (char row = '1'; row <= '8'; row++) {
                String key = "" + col + row;
                fields.put(key, new TChessField(col, row));
            }
        }
    }

    public TChessField getField(char col, char row) {
        return fields.get("" + col + row);
    }
}
