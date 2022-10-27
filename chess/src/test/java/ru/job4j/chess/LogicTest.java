package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException() {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () ->
                logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo(
                "Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellExceptionException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.B2));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () ->
                logic.move(Cell.C1, Cell.A3));
        assertThat(exception.getMessage()).isEqualTo(
                "the movement of the figure is blocked by another figure");
    }

    @Test
    public void whenImpossibleMoveException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () ->
                logic.move(Cell.C1, Cell.A4));
        assertThat(exception.getMessage()).isEqualTo(
                "Could not way by diagonal from C1 to A4");
    }

    @Test
    public void whenMove() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.B5));
        logic.move(Cell.C1, Cell.A3);
    }
}