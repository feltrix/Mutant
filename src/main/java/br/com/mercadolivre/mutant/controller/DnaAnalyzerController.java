package br.com.mercadolivre.mutant.controller;

import br.com.mercadolivre.mutant.analyzer.Dna;
import br.com.mercadolivre.mutant.service.DnaAnalyzerService;
import br.com.mercadolivre.mutant.vo.DnaVO;
import br.com.mercadolivre.mutant.vo.Stats;
import com.sun.javafx.scene.layout.region.Margins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DnaAnalyzerController {

    @Autowired
    private DnaAnalyzerService dnaAnalyzerService;

    @Autowired
    private ConversionService conversionService;

    @PostMapping("/mutant")
    public ResponseEntity<Object> isMutant(@RequestBody final DnaVO dna) {
        boolean mutant = dnaAnalyzerService.isMutant(conversionService.convert(dna,Dna.class));
        if(mutant) {
            return ResponseEntity.ok(mutant);
        }else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mutant);
        }
    }

    @GetMapping("/stats")
    public Stats stats() {
       return dnaAnalyzerService.getStats();
    }



}
