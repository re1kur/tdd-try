package re1kur.chess.core.impl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TChessMove {
    public final TChessman piece;
    public final TChessField from;
    public final TChessField to;
    public final boolean capture;
    public final boolean promotion;
    public final boolean enPassant;

    public TChessMove(TChessman piece, TChessField from, TChessField to, boolean capture) {
        this(piece, from, to, capture, false, false);
    }

    public TChessMove(TChessman piece, TChessField from, TChessField to, boolean capture, boolean promotion, boolean enPassant) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capture = capture;
        this.promotion = promotion;
        this.enPassant = enPassant;
    }

    public String asString() {
        String prefix = piece.getClass().getSimpleName().charAt(0) + from.toString();
        String action = capture ? "x" : "-";
        String suffix = to.toString();
        if (promotion) return prefix + action + suffix + "=Q";
        if (enPassant) return prefix + action + suffix + " e.p.";
        return prefix + action + suffix;
    }
}
