package br.com.dio.desafioreactor;

import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Question2 {

    /*
    Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista
     */
    public Mono<Long> countAdmins(final List<User> users){
        Mono<List<User>> monoUsers = Mono.just(users);
        Flux<User> fluxUsers = monoUsers.flatMapMany(Flux::fromIterable);
        Mono<Long> total = fluxUsers
            .filter(User::isAdmin)
            .count();
        return total;
    }

}
