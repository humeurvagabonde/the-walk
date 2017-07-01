package org.knight;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.knight.Knight.knightOf;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class KnightTest {

    @Test
    public void testRecherche() {
        // moveKnight (6,2) => [(8,1),(8,3),(4,1),(4,3),(7,4),(5,4)]
        List<Knight> moves = KnightFonction.moveKnight(knightOf(6, 2)).collect(Collectors.toList());
        assertThat(moves, hasItems(knightOf(8, 1), knightOf(8, 3), knightOf(4, 1), knightOf(4, 3), knightOf(7, 4), knightOf(5, 4)));
    }

    @Test
    public void testCanReach() {
        assertTrue(KnightFonction.canReachIn3(knightOf(6, 2), knightOf(6, 1)));
        assertFalse(KnightFonction.canReachIn3(knightOf(6, 2), knightOf(7, 3)));
    }
}
