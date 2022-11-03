package com.petis.debtapp.service;

import com.petis.debtapp.repository.DebtRepository;
import com.petis.debtapp.entity.Debt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtService {
    private final DebtRepository debtRepository;

    public DebtService(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }

    public Debt saveDebt(Debt debt) {
        return debtRepository.save(debt);
    }

    public List<Debt> saveMoreDebts(List<Debt> debts) {
        return debtRepository.saveAll(debts);
    }

    public List<Debt> getDebts() {
        return debtRepository.findAll();
    }

    public Debt getDebtById(long id) {
        return debtRepository.findById(id).orElse(null);
    }

    public String deleteDebt(long id) {
        debtRepository.deleteById(id);
        return "Debt removed! " + id;
    }

    public Debt updateDebt(Debt debt){
        Debt existingDebt = debtRepository.findById(debt.getId()).orElse(null);
        if (existingDebt != null) {
            existingDebt.setAmount(debt.getAmount());
            existingDebt.setDescription(debt.getDescription());
            existingDebt.setUser(debt.getUser());
            return debtRepository.save(existingDebt);
        }
        return null;
    }
}
