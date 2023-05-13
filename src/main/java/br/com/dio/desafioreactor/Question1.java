package br.com.dio.desafioreactor;

import java.lang.reflect.Array;
import java.util.Arrays;
import reactor.core.publisher.Flux;

import java.util.List;
import reactor.core.publisher.Mono;

public class Question1 {

    /*
    Recebe uma lista de longs, incrementa 1 nos valores e retorna um flux dos resultados
     */
    public Flux<Long> inc(final List<Long> numbers){
        Mono<List<Long>> monoNumbers = Mono.just(numbers);
        Flux<Long> fluxNumbers = monoNumbers.flatMapMany(Flux::fromIterable);
        Flux<Long> result = fluxNumbers.map(n -> n + 1);
        return result;
    }

}
