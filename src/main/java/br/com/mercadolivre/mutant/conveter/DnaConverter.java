package br.com.mercadolivre.mutant.conveter;

import br.com.mercadolivre.mutant.analyzer.Dna;
import br.com.mercadolivre.mutant.vo.DnaVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DnaConverter implements Converter<DnaVO, Dna> {

    @Nullable
    @Override
    public Dna convert(final DnaVO dnaVO) {

        final char[][] dnaCode = dnaVO.getDna()
                .stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        return new Dna(dnaCode);
    }
}
