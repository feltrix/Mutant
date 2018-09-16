package br.com.mercadolivre.mutant.analyzer;

import org.junit.Assert;
import org.junit.Test;

public class DnaAnalyzerTest {

    private DnaAnalyzer dnaAnalyzer = new DnaAnalyzer();

    @Test
    public void itShouldReturnFalseWhenThereAreNoMutation(){

        final char[][] dnaCode = {
                {'A','T','G','C','A','T'},
                {'A','T','G','C','A','T'},
                {'T','A','C','G','T','A'},
                {'T','A','C','G','T','A'},
                {'A','T','G','C','A','T'},
                {'A','T','G','C','A','T'}
        };

        final Dna dna = new Dna(dnaCode);

        boolean actual = dnaAnalyzer.isMutant(dna);

        Assert.assertFalse(actual);

    }

    @Test
    public void itShouldReturnTrueWhenThereIsHorizontalMutation(){

        final char[][] dnaCode = {
                {'A','C','C','C','C','T'},
                {'A','T','G','C','A','T'},
                {'T','A','C','G','T','A'},
                {'T','A','C','G','T','A'},
                {'A','T','G','C','A','T'},
                {'A','T','G','C','A','T'}
        };

        final Dna dna = new Dna(dnaCode);

        boolean actual = dnaAnalyzer.isMutant(dna);

        Assert.assertTrue(actual);

    }

    @Test
    public void itShouldReturnTrueWhenThereIsVerticalMutation(){

        final char[][] dnaCode = {
                {'A','T','G','C','A','T'},
                {'A','T','G','C','A','A'},
                {'T','A','C','G','T','T'},
                {'T','A','C','G','T','T'},
                {'A','T','G','C','A','T'},
                {'A','T','G','C','A','T'}
        };

        final Dna dna = new Dna(dnaCode);

        boolean actual = dnaAnalyzer.isMutant(dna);

        Assert.assertTrue(actual);

    }

    @Test
    public void itShouldReturnTrueWhenThereIsLeftDiagonalMutation(){

        final char[][] dnaCode = {
                {'A','T','G','C','A','T'},
                {'A','T','C','C','A','T'},
                {'T','C','C','G','T','A'},
                {'C','A','C','G','T','A'},
                {'A','T','G','C','A','T'},
                {'A','T','G','C','A','T'}
        };

        final Dna dna = new Dna(dnaCode);

        boolean actual = dnaAnalyzer.isMutant(dna);

        Assert.assertTrue(actual);

    }

    @Test
    public void itShouldReturnTrueWhenThereIsRightDiagonalMutation(){

        final char[][] dnaCode = {
                {'A','T','G','C','A','T'},
                {'A','T','G','G','A','T'},
                {'T','A','C','G','G','A'},
                {'T','A','C','G','T','G'},
                {'A','T','G','C','A','T'},
                {'A','T','G','C','A','T'}
        };

        final Dna dna = new Dna(dnaCode);

        boolean actual = dnaAnalyzer.isMutant(dna);

        Assert.assertTrue(actual);

    }



}
