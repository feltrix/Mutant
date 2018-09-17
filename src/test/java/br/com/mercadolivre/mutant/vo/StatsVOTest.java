package br.com.mercadolivre.mutant.vo;

import org.junit.Assert;
import org.junit.Test;

public class StatsVOTest {

    @Test
    public void itShouldReturnRatio0WhenCountsAre0() {
        long mCount = 0;
        long hCount = 0;

        Stats stats = new Stats(mCount,hCount);

        double expected = 0.0;
        Long exCount = 0L;

        Assert.assertEquals(exCount,stats.getCountMutantDna());
        Assert.assertEquals(exCount,stats.getCountHumanDna());
        Assert.assertEquals(expected,stats.getRatio(),0);

    }

    @Test
    public void itShouldReturnRatio1() {
        long mCount = 1;
        long hCount = 0;

        Stats stats = new Stats(mCount,hCount);

        double expected = 1;

        Assert.assertEquals(expected,stats.getRatio(),0);

    }

    @Test
    public void itShouldReturnRatio05() {
        long mCount = 1;
        long hCount = 1;

        Stats stats = new Stats(mCount,hCount);

        double expected = 0.5;

        Assert.assertEquals(expected,stats.getRatio(),0);

    }

}
