package com.teamC.income;
import com.teamC.clients.income.Income;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("incomes")
public class IncomeController {
    private IncomeService incomeService;

    @GetMapping("all")
    public List<Income> getAllIncome(){
        return incomeService.getAllIncome();
    }

    @GetMapping("person/{person_id}")
    public Income getIncomeByPersonId(@PathVariable("person_id") String id){
        return incomeService.getIncomeByPersonId(id);
    }

    @GetMapping("{income_id}")
    public Optional<Income> getIncomeById(@PathVariable("income_id") String incomeId){
        return incomeService.getIncomeById(incomeId);
    }

    @PostMapping("{person_id}")
    public ResponseEntity<Income> addIncome(@PathVariable("person_id") String personId, @RequestBody Income income){
        Income newIncome = incomeService.addIncome(personId, income);
        return new ResponseEntity<>(newIncome, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteIncomeById(@PathVariable("id") String id){
        incomeService.deleteIncomeById(id);
    }

    @PutMapping("{id}")
    public Income updateIncomeById(@PathVariable("id") String id, @RequestBody Income income){
        return incomeService.updateIncomeById(id, income);
    }
}
