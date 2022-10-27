package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell checkPs = bishopBlack.position();
        assertThat(checkPs).isEqualTo(Cell.A1);
    }

    @Test
    void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure newBishopBlack = bishopBlack.copy(Cell.D3);
        Cell checkPs = newBishopBlack.position();
        assertThat(checkPs).isEqualTo(Cell.D3);
    }

    @Test
    void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.G5);
        Cell[] cells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl).isEqualTo(cells);
    }
}