package br.com.mercadolivre.mutant.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

    private final Long countMutantDna;
    private final Long countHumanDna;
    private final double ratio;

    public Stats(final Long countMutantDna, final Long countHumanDna) {
        this.countMutantDna = countMutantDna!=null?countMutantDna:0;
        this.countHumanDna = countHumanDna!=null?countHumanDna:0;
        long total = countMutantDna + countHumanDna;
        if(total>0) {
            this.ratio =  countMutantDna / total;
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
