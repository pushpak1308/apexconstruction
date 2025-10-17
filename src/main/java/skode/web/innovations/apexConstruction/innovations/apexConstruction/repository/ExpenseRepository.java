package skode.web.innovations.apexConstruction.innovations.apexConstruction.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Expense;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Subcategory;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Person;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findBySubcategory(Subcategory subcategory);

    List<Expense> findByPerson(Person person);

    List<Expense> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);
}

