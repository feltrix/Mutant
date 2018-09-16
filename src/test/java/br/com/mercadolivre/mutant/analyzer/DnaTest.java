package br.com.mercadolivre.mutant.analyzer;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DnaTest {
    
      /*  map of positions
      {
            {0 , 1 , 2 , 3 , 4 , 5},
            {6 , 7 , 8 , 9 , 10, 11},
            {12, 13, 14, 15, 16, 17},
            {18, 19, 20, 21, 22, 23},
            {24, 25, 26, 27, 28, 29},
            {30, 31, 32, 33, 34, 35}
        };*/

    public static final char[][] DNACODE = new char[][]{
            {'A', 'T', 'G', 'C', 'A', 'T'},
            {'A', 'T', 'G', 'C', 'A', 'T'},
            {'T', 'A', 'C', 'G', 'T', 'A'},
            {'T', 'A', 'C', 'G', 'T', 'A'},
            {'A', 'T', 'G', 'C', 'A', 'T'},
            {'A', 'T', 'G', 'C', 'A', 'T'}
    };
    public static final Dna DNA = new Dna(DNACODE);

    @Test
    public void itShouldReturnAWhenAWhenPositionIs0() {
        

        Assert.assertEquals('A', DNA.getValue(0));

    }

    @Test
    public void itShouldReturnAWhenTWhenPositionIs1() {
        

        Assert.assertEquals('T', DNA.getValue(1));

    }

    @Test
    public void itShouldReturnAWhenTWhenPositionIs29() {
        

        Assert.assertEquals('T', DNA.getValue(29));


    }

    @Test
    public void itShouldReturnAWhenTWhenPositionIs26() {
        
        Assert.assertEquals('G', DNA.getValue(26));

    }

    @Test
    public void returningPositionsRightFromPosition0(){

        final List<Integer> positionsExpected = Stream.of(0,1,2,3,4,5).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsRightFrom(0);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void returningPositionsRightFromPosition3(){
        
        final List<Integer> positionsExpected = Stream.of(3,4,5).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsRightFrom(3);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void returningPositionsRightFromPosition26(){

        final List<Integer> positionsExpected = Stream.of(26,27,28,29).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsRightFrom(26);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void returningPositionsDownFromPosition0(){

        final List<Integer> positionsExpected = Stream.of(0,6,12,18,24,30).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsDownFrom(0);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void returningPositionsDownFromPosition20(){

        final List<Integer> positionsExpected = Stream.of(20,26,32).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsDownFrom(20);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void returningPositionsLeftDiagonalFromPosition5(){

        final List<Integer> positionsExpected = Stream.of(5,10,15,20,25,30).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsLeftDiagonalFrom(5);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void returningPositionsRightDiagonalFromPosition0(){

        final List<Integer> positionsExpected = Stream.of(0,7,14,21,28,35).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsRightDiagonalFrom(0);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void returningPositionsRightDiagonalFromPosition1(){

        final List<Integer> positionsExpected = Stream.of(1,8,15,22,29).collect(Collectors.toList());

        final List<Integer> positionsActual = DNA.positionsRightDiagonalFrom(1);

        Assert.assertEquals(positionsExpected, positionsActual);

    }

    @Test
    public void checkGetValueFromPositions() {

        Assert.assertEquals('A', DNA.getValue(0));
        Assert.assertEquals('T', DNA.getValue(5));

        Assert.assertEquals('A', DNA.getValue(19));
        Assert.assertEquals('T', DNA.getValue(22));

        Assert.assertEquals('G', DNA.getValue(32));
        Assert.assertEquals('C', DNA.getValue(33));

    }

}
