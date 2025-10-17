package skode.web.innovations.apexConstruction.innovations.apexConstruction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Bill;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Expense;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByExpense(Expense expense);
}
