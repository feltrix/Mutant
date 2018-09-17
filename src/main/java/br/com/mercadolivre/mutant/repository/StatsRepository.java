package br.com.mercadolivre.mutant.repository;

import br.com.mercadolivre.mutant.vo.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatsRepository {

    private static final String MUTANT_KEY = "count:mutant";
    private static final String HUMAN_KEY = "count:human";

    @Autowired
    private RedisTemplate<String, Long> redisTemplate;

    public void incrementMutantCount(){

        redisTemplate.opsForValue().increment(MUTANT_KEY,1);

    }

    public void incrementHumanCount(){

        redisTemplate.opsForValue().increment(HUMAN_KEY,1);

    }

    public Stats getStats() {

        final Long mutantCount = redisTemplate.opsForValue().get(MUTANT_KEY);
        final Long humanCount = redisTemplate.opsForValue().get(HUMAN_KEY);

        return new Stats(mutantCount,humanCount);
    }



}
