package br.com.mercadolivre.mutant.converter;

import br.com.mercadolivre.mutant.analyzer.Dna;
import br.com.mercadolivre.mutant.conveter.DnaConverter;
import br.com.mercadolivre.mutant.vo.DnaVO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DnaConverterTest {

    @Test
    public void convertDnaVoToDna() {

        final List<String> dnaCodeList = new ArrayList<>();

        dnaCodeList.add("ATGCAT");
        dnaCodeList.add("ATGCAT");
        dnaCodeList.add("TACGTA");
        dnaCodeList.add("TACGTA");
        dnaCodeList.add("ATGCAT");
        dnaCodeList.add("ATGCAT");

        final DnaVO dnaVO = new DnaVO();

        dnaVO.setDna(dnaCodeList);

        final char[][] dnaCodeExpected = new char[][]{
                {'A', 'T', 'G', 'C', 'A', 'T'},
                {'A', 'T', 'G', 'C', 'A', 'T'},
                {'T', 'A', 'C', 'G', 'T', 'A'},
                {'T', 'A', 'C', 'G', 'T', 'A'},
                {'A', 'T', 'G', 'C', 'A', 'T'},
                {'A', 'T', 'G', 'C', 'A', 'T'}
        };

        final Dna dnaExpected = new Dna(dnaCodeExpected);

        final DnaConverter dnaConverter = new DnaConverter();

        final Dna dnaActual = dnaConverter.convert(dnaVO);

        Assert.assertEquals(dnaExpected,dnaActual);

    }

}
