package br.com.mercadolivre.mutant.service;

import br.com.mercadolivre.mutant.analyzer.Dna;
import br.com.mercadolivre.mutant.analyzer.DnaAnalyzer;
import br.com.mercadolivre.mutant.repository.StatsRepository;
import br.com.mercadolivre.mutant.vo.Stats;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DnaAnalyzerServiceTest {

    @Mock
    private StatsRepository statsRepository;

    @Mock
    private DnaAnalyzer dnaAnalyzer;

    @InjectMocks
    private DnaAnalyzerService dnaAnalyzerService = new DnaAnalyzerService();

    @Test
    public void itShouldReturnFalseWhenItIsHuman () {

        final Dna dna = mock(Dna.class);

        when(dnaAnalyzer.isMutant(eq(dna))).thenReturn(false);

        boolean actual = dnaAnalyzerService.isMutant(dna);

        verify(statsRepository,times(1)).incrementHumanCount();

        Assert.assertFalse(actual);

    }

    @Test
    public void itShouldReturnTrueWhenItIsMutant () {

        final Dna dna = mock(Dna.class);

        when(dnaAnalyzer.isMutant(eq(dna))).thenReturn(true);

        boolean actual = dnaAnalyzerService.isMutant(dna);

        verify(statsRepository,times(1)).incrementMutantCount();

        Assert.assertTrue(actual);

    }

    @Test
    public void itShouldReturnStats () {

        Stats stats = mock(Stats.class);

        when(statsRepository.getStats()).thenReturn(stats);

        Stats actual = dnaAnalyzerService.getStats();

        verify(statsRepository,times(1)).getStats();

        Assert.assertEquals(stats,actual);

    }

}
