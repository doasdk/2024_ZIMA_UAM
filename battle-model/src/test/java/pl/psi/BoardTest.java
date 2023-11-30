// ******************************************************************
//  
// Copyright 2023 PSI Software SE. All rights reserved.
// PSI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms
//  
// ******************************************************************

package pl.psi;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
class BoardTest
{
    @Test
    void shouldHasCreatureAfterAddToBoard(){
        Creature c1 = new Creature();
        Board board = new Board();

        board.add(c1, new Point(1,1));

        assertThat(board.getCreatureLocation(c1)).isEqualTo(Optional.of(new Point(1,1)));
    }

    @Test
    void shouldMoveProperly(){
        Creature c1 = new Creature();
        Board board = new Board();
        board.add(c1, new Point(1,1));

        board.move(c1, new Point(5,5));

        assertThat(board.getCreatureLocation(c1)).isEqualTo(Optional.of(new Point(5,5)));
    }
}