package skode.web.innovations.apexConstruction.innovations.apexConstruction.dto;

public class CategoryRequest {
    private String categoryName;
    private Long groupId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
