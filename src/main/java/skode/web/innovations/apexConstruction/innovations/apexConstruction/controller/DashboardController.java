package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.web.bind.annotation.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/summary")
    public Map<String, Object> getDashboardSummary(
            @RequestParam(required = false) Long projectId,
            @RequestParam(required = false) Long groupId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end
    ) {
        LocalDate startDate = (start != null) ? LocalDate.parse(start) : null;
        LocalDate endDate = (end != null) ? LocalDate.parse(end) : null;

        return dashboardService.getFilteredSummary(projectId, groupId, categoryId, startDate, endDate);
    }
}
