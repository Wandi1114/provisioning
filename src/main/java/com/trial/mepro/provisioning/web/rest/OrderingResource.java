package com.trial.mepro.provisioning.web.rest;

import com.trial.mepro.provisioning.domain.Ordering;
import com.trial.mepro.provisioning.helper.BaseResponse;
import com.trial.mepro.provisioning.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderingResource {
//    @Autowired
//    OrderingService orderingService;

    private OrderingService orderingService;

    private OrderingResource(OrderingService service) {
        this.orderingService = service;
    }


    @GetMapping(value = "/orderings2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Map<String, Object>> findAllOrderings2(){
        return orderingService.getOrdering2();
    }

    @GetMapping(value = "/orderings", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<Ordering> findAllOrderings(){
        return orderingService.getOrdering();
    }

    @GetMapping("/ordering/{id}")
    public Mono<Ordering> findOrderingById(@PathVariable Long id){return orderingService.getOrderingById(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrdering(@RequestBody Ordering ordering){orderingService.addOrdering(ordering);}


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Ordering> updateOrdering(@RequestBody Ordering ordering){return orderingService.updateOrdering(ordering);}

    @DeleteMapping("/ordering/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<Void> deleteOrdering(@PathVariable Long id){return  orderingService.deleteOrdering(id);}
}
