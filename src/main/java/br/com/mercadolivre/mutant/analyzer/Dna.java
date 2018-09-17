package br.com.mercadolivre.mutant.analyzer;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dna dna1 = (Dna) o;

        if (height != dna1.height) return false;
        if (width != dna1.width) return false;
        if (size != dna1.size) return false;
        return Arrays.deepEquals(dna, dna1.dna);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(dna);
        result = 31 * result + height;
        result = 31 * result + width;
        result = 31 * result + size;
        return result;
    }
}
