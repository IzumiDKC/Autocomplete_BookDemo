package Group8_Week3.DienNguyen.Entities;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotNull(message = "Id is required")
    @Min(value = 1, message = "Id phải là số dương")
    private Long id;
    @NotNull(message = "Title is required")
    @Size(min = 1, message = "Title phải có số ký tự >1")
    private String title;
    @NotNull(message = "Author is required")
    @Size(min = 1, message = "Author phải có số ký tự >1")
    private String author;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Giá phải lớn hơn 0")
    private Double price;
    @NotNull(message = "Category is required")
    @Size(min = 1, message = "Category phải có số ký tự >1")
    private String category;
}
