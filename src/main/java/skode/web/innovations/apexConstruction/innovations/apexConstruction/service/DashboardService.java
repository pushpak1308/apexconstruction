package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ExpenseRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Expense;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Map<String, Object> getFilteredSummary(Long projectId, Long groupId, Long categoryId,
                                                  LocalDate startDate, LocalDate endDate) {

        List<Expense> allExpenses = expenseRepository.findAll();

        List<Expense> filtered = allExpenses.stream()
                .filter(e -> (projectId == null || e.getProject().getProjectId().equals(projectId)))
                .filter(e -> (groupId == null || e.getGroup().getGroupId().equals(groupId)))
                .filter(e -> (categoryId == null || e.getCategory().getCategoryId().equals(categoryId)))
                .filter(e -> (startDate == null || !e.getExpenseDate().isBefore(startDate)))
                .filter(e -> (endDate == null || !e.getExpenseDate().isAfter(endDate)))
                .collect(Collectors.toList());

        double totalExpense = filtered.stream().mapToDouble(Expense::getAmount).sum();
        double totalGST = filtered.stream().filter(Expense::isGstIncluded)
                .mapToDouble(Expense::getAmount).sum() * 0.18; // assume 18%

        Map<String, Double> expenseByPerson = filtered.stream()
                .collect(Collectors.groupingBy(e -> e.getPerson().getPersonName(),
                        Collectors.summingDouble(Expense::getAmount)));

        Map<String, Double> expenseBySubcategory = filtered.stream()
                .collect(Collectors.groupingBy(e -> e.getSubcategory().getSubcategoryName(),
                        Collectors.summingDouble(Expense::getAmount)));

        Map<String, Double> monthlyExpense = filtered.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getExpenseDate().getMonth().toString(),
                        Collectors.summingDouble(Expense::getAmount)
                ));

        Map<String, Object> result = new HashMap<>();
        result.put("totalExpense", totalExpense);
        result.put("totalGST", totalGST);
        result.put("expenseByPerson", expenseByPerson);
        result.put("expenseBySubcategory", expenseBySubcategory);
        result.put("monthlyExpense", monthlyExpense);

        return result;
    }
}
