package com.petis.debtapp.controller;

import com.petis.debtapp.entity.Debt;
import com.petis.debtapp.service.DebtService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DebtController {

    private final DebtService debtService;

    public DebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("/debts")
    public List<Debt> getAllDebts(){
        return debtService.getDebts();
    }

    @GetMapping("/debt/{id}")
    public Debt getDebtById(@PathVariable Long debtId){
        return debtService.getDebtById(debtId);
    }

    @PostMapping("/addDebt")
    public Debt saveDebt(@RequestBody Debt debt){
        return debtService.saveDebt(debt);
    }

    @PostMapping("/addDebts")
    public List<Debt> saveDebt(@RequestBody List<Debt> debtList){
        return debtService.saveMoreDebts(debtList);
    }

    @PostMapping("debt/{id}/delete")
    public void deleteDebt(@PathVariable Long debtId){
        debtService.deleteDebt(debtId);
    }

    @PostMapping("/addDebt/update")
    public Debt updateDebt(@RequestBody Debt debt){
        return debtService.updateDebt(debt);
    }
}
