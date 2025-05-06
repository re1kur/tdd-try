package re1kur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import re1kur.chessfield.ChessColumn;
import re1kur.chessfield.ChessField;
import re1kur.chessfield.ChessRow;
import re1kur.chessman.impl.KingChessman;
import re1kur.chessside.ChessSide;
import re1kur.exception.InvalidPositionException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KingChessmanTest {
    @Mock
    private KingChessman king;

    @Test
    void getPosition_shouldReturnCorrectPosition() {
        ChessField mock = new ChessField(ChessRow.EIGHT, ChessColumn.d);

        when(king.getPosition()).thenReturn(mock);

        assertThat(king).returns(mock, KingChessman::getPosition);
    }

    @Test
    void setPosition_shouldSetPosition_whenPositionIsValid() {
        ChessSide side = ChessSide.BLACK;
        ChessField start = new ChessField(ChessRow.EIGHT, ChessColumn.d);
        ChessField mock = new ChessField(ChessRow.SEVEN, ChessColumn.d);

        king = new KingChessman(start, side);
        king.setPosition(mock);


        assertThat(king).returns(mock, KingChessman::getPosition);
    }

    @Test
    void setPosition_shouldNotSetPosition_whenPositionIsInvalid() {
        ChessSide side = ChessSide.BLACK;
        ChessField start = new ChessField(ChessRow.EIGHT, ChessColumn.d);
        ChessField mock = new ChessField(ChessRow.FOUR, ChessColumn.d);

        king = new KingChessman(start, side);
        Assertions.assertThrows(InvalidPositionException.class, () -> king.setPosition(mock));

        assertThat(king).returns(start, KingChessman::getPosition);

    }

}
