package skode.web.innovations.apexConstruction.innovations.apexConstruction.dto;

public class SubcategoryRequest {
    private String subcategoryName;
    private Long categoryId;

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
