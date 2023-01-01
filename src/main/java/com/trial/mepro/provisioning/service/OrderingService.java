package com.trial.mepro.provisioning.service;

import com.trial.mepro.provisioning.Constants.GeneralConstants;
import com.trial.mepro.provisioning.domain.Ordering;
import com.trial.mepro.provisioning.helper.BaseResponse;
import com.trial.mepro.provisioning.repository.OrderingRepository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class OrderingService {

    @Autowired
    OrderingRepository orderingRepository;

    private final Logger log = LoggerFactory.getLogger(OrderingService.class);


    //Mono 0 - 1 //single
    //Flux 0 - N //reactive sequence of items

    public Mono<Ordering> getOrderingById(Long id){
        log.debug("Request to get ordering by id ");
        return orderingRepository.findById(id);
    }

    public Flux<Ordering> getOrdering() {
        return orderingRepository.findAll().delayElements(Duration.ofSeconds(2L));
    }

    public Mono<Map<String, Object>> getOrdering2(){
        log.debug("Request to get all ordering ");
        List<Ordering> list = new ArrayList<>();
        List<Ordering> data = (List<Ordering>) orderingRepository.findAll()
                .collectList()
                .map(list::addAll);
//                .flatMapMany(list -> Flux.generate(sink -> sink.next(list)));
        Mono<Map<String, Object>> res = Mono.just(BaseResponse.success(200L, data, GeneralConstants.SUCCESS));

        return res;
    }


    public void addOrdering(Ordering orderings){
        orderingRepository.save(orderings).subscribe();
    }

    public Mono<Ordering> updateOrdering(Ordering ordering){
        return orderingRepository.findById(ordering.getId())
                .switchIfEmpty(Mono.error(new Exception("Ordering Not Found")))
                .map(olderOrdering ->{
                    if(ordering.getName() != null) olderOrdering.setName(ordering.getName());
                    return  olderOrdering;
                })
                .flatMap(orderingRepository::save);
    }

    public Mono<Void> deleteOrdering(Long id){
        return orderingRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new Exception("Ordering Not found")));
    }
}