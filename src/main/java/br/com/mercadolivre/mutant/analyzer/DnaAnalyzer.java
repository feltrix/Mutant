package br.com.mercadolivre.mutant.analyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static br.com.mercadolivre.mutant.analyzer.Directions.*;

public class DnaAnalyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DnaAnalyzer.class);

    private final static Directions[] DIRECTIONS = Directions.values();

    public boolean isMutant(final Dna dna) {

        final Map<Directions,Set<Integer>> positionsVisited = new HashMap<>();

        for (Directions direction : DIRECTIONS) {
            positionsVisited.put(direction,new HashSet<>());
        }

        for (int i = 0; i < dna.getSize(); i++) {

            for (final Directions direction: DIRECTIONS) {

                final Set<Integer> visitedDirection = positionsVisited.get(direction);

                if(!visitedDirection.contains(i)){
                    final List<Integer> positions = dna.positionsInDirectionFrom(i,direction);
                    visitedDirection.addAll(positions);
                    if(hasMutation(dna,positions)){
                        LOGGER.info("Mutation detected in {} direction",direction);
                        return true;
                    }
                }

            }

        }

        LOGGER.info("No mutation detected");

        return false;
    }

    private boolean hasMutation(final Dna dna, final List<Integer> positions) {

        if(positions.size()<4) {
            return false;
        }

        int count = 1;
        char last = '@';

        for (final Integer position : positions) {

            char current = dna.getValue(position);

            if(current == last){
                count++;
                if(count >= 4) {
                    return true;
                }
            }else{
                count=1;
                last=current;
            }

        }
        return false;
    }


}
