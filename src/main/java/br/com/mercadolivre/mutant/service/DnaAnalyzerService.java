package br.com.mercadolivre.mutant.service;

import br.com.mercadolivre.mutant.analyzer.Dna;
import br.com.mercadolivre.mutant.analyzer.DnaAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnaAnalyzerService {

    @Autowired
    private DnaAnalyzer dnaAnalyzer;

    public boolean isMutant(final Dna dna) {
        return dnaAnalyzer.isMutant(dna);
    }

}
