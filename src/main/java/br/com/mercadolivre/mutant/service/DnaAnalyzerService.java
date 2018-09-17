package br.com.mercadolivre.mutant.service;

import br.com.mercadolivre.mutant.analyzer.Dna;
import br.com.mercadolivre.mutant.analyzer.DnaAnalyzer;
import br.com.mercadolivre.mutant.repository.StatsRepository;
import br.com.mercadolivre.mutant.vo.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnaAnalyzerService {

    @Autowired
    private DnaAnalyzer dnaAnalyzer;

    @Autowired
    private StatsRepository statsRepository;

    public boolean isMutant(final Dna dna) {

        final boolean mutant = dnaAnalyzer.isMutant(dna);

        if(mutant){
            statsRepository.incrementMutantCount();
        } else {
            statsRepository.incrementHumanCount();
        }

        return mutant;
    }

    public Stats getStats () {
        return statsRepository.getStats();
    }

}
