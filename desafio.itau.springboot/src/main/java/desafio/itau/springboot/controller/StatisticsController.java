package desafio.itau.springboot.controller;


import desafio.itau.springboot.dto.StatisticsResponse;
import desafio.itau.springboot.service.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final TransactionsService transactionsService;

    public StatisticsController(TransactionsService transactionsService){
        this.transactionsService = transactionsService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics(){
        DoubleSummaryStatistics stats = transactionsService.getStatistics();
        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
