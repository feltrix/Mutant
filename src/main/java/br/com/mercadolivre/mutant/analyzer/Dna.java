package br.com.mercadolivre.mutant.analyzer;

import java.util.ArrayList;
import java.util.List;

public class Dna {

    private final char[][] dna;

    private final int height;
    private final int width;
    private final int size;

    public Dna(char[][] dna) {
        this.dna = dna;
        height = dna.length;
        width = dna[0].length;
        size = height * width;
    }

    public char getValue(final int position) {

        final int h = heightOf(position);
        final int w = widthOf(position);

        return dna[h][w];

    }

    private int widthOf(final int position) {
        return position % width;
    }

    private int heightOf(final int position) {
        return position / height;
    }

    public List<Integer> positionsRightFrom(final int position){

        final int w = widthOf(position);

        final List<Integer> positions = new ArrayList<>();

        int p = position;
        for (int i = w; i < width; i++) {
            positions.add(p++);
        }

        return positions;

    }

    public List<Integer> positionsDownFrom(final int position){

        final int h = heightOf(position);

        final List<Integer> positions = new ArrayList<>();

        int p = position;
        for (int i = h; i < height; i++) {
            positions.add(p);
            p+=width;
        }

        return positions;

    }

    public List<Integer> positionsLeftDiagonalFrom(final int position){

        final int h = heightOf(position);
        final int w = widthOf(position);

        final List<Integer> positions = new ArrayList<>();

        int p = position;
        for (int i = h, j=w; i < height && j >= 0; i++,j--) {
            positions.add(p);
            p+=width-1;
        }

        return positions;

    }

    public List<Integer> positionsRightDiagonalFrom(final int position){

        final int h = heightOf(position);
        final int w = widthOf(position);

        final List<Integer> positions = new ArrayList<>();

        int p = position;
        for (int i = h, j=w; i < height && j<width; i++, j++) {
            positions.add(p);
            p+=width+1;
        }

        return positions;

    }

    public List<Integer> positionsInDirectionFrom(final int position, final Directions direction) {
        switch (direction) {

            case RIGHT:
                return this.positionsRightFrom(position);

            case DOWN:
                return this.positionsDownFrom(position);

            case LEFT_DIAGONAL:
                return this.positionsLeftDiagonalFrom(position);

            default:
                return this.positionsRightDiagonalFrom(position);

        }
    }

    public int getSize() {
        return size;
    }
}
