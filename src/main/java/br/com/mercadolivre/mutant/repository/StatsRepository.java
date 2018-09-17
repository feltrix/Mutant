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

        final Long mutantCount = getValue(MUTANT_KEY);
        final Long humanCount = getValue(HUMAN_KEY);

        return new Stats(mutantCount,humanCount);
    }

    private Long getValue(final String key){
        final String value = redisTemplate.boundValueOps(key).get(0,-1);
        if(value!=null && !value.isEmpty()) {
            return Long.valueOf(value);
        }
        return 0L;
    }



}
