package br.com.mercadolivre.mutant.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

    private final long countMutantDna;
    private final long countHumanDna;
    private final double ratio;

    public Stats(final long countMutantDna, final long countHumanDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        long total = countMutantDna + countHumanDna;
        if(total>0) {
            this.ratio =  countMutantDna / (double) total;
        }else{
            this.ratio = 0;
        }
    }

    @JsonProperty("count_mutant_dna")
    public Long getCountMutantDna() {
        return countMutantDna;
    }

    @JsonProperty("count_human_dna")
    public Long getCountHumanDna() {
        return countHumanDna;
    }

    @JsonProperty("ratio")
    public double getRatio() {
        return ratio;
    }
}
