package org.knight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnightFonction {

    public static Stream<Knight> moveKnight(Knight k) {
        Knight[] moves = {
                new Knight(k.x() + 2, k.y() - 1), new Knight(k.x() + 2, k.y() + 1), new Knight(k.x() - 2, k.y() - 1), new Knight(k.x() - 2, k.y() + 1),
                new Knight(k.x() + 1, k.y() - 2), new Knight(k.x() + 1, k.y() + 2), new Knight(k.x() - 1, k.y() - 2), new Knight(k.x() - 1, k.y() + 2) };

        List<Knight> validMoves = new ArrayList<>();
        for (Knight move : moves) {
            if (isKnightOnBoard(move)) {
                validMoves.add(move);
            }
        }
        return validMoves.stream();
    }

    public static List<Knight> in3(Knight knight) {
        return Stream.of(knight)
                .flatMap(KnightFonction::moveKnight)
                .flatMap(KnightFonction::moveKnight)
                .flatMap(KnightFonction::moveKnight)
                .collect(Collectors.toList());
    }

    public static Boolean canReachIn3(Knight start, Knight end) {
        return in3(start).contains(end);
    }

    private static Boolean isKnightOnBoard(Knight k) {
        return k.x() >= 1 && k.x() <= 8 && k.y() >= 1 && k.y() <= 8;
    }
}
