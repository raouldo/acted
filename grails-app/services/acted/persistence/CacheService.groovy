package acted.persistence

import grails.transaction.Transactional

import reactor.event.Event
import reactor.function.Consumer

@Transactional
class CacheService implements Consumer<Event<Integer>>, CacheInterface  {

    void accept(Event<Integer> ev) {

    }

}
