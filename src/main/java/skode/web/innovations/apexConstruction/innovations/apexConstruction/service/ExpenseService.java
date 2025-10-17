package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesBySubcategory(Subcategory subcategory) {
        return expenseRepository.findBySubcategory(subcategory);
    }

    public List<Expense> getExpensesByPerson(Person person) {
        return expenseRepository.findByPerson(person);
    }

    public List<Expense> getExpensesByDateRange(LocalDate start, LocalDate end) {
        return expenseRepository.findByExpenseDateBetween(start, end);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
