package re1kur.chess.core.impl;

public class TChessMove {
    private final TChessman piece;
    private final TChessField from;
    private final TChessField to;
    private final boolean capture;

    public TChessMove(TChessman piece, TChessField from, TChessField to, boolean capture) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.capture = capture;
    }

    public String asString() {
        String prefix = piece.getClass().getSimpleName().charAt(0) + from.toString();
        return prefix + (capture ? "x" : "-") + to.toString();
    }
}
