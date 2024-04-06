package desktop_test.com.example.desktop_test.modules.book.entities;

import desktop_test.com.example.desktop_test.modules.book.dto.CategoryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "category")
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;


    public static CategoryEntity of(CategoryRequest category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(category,categoryEntity);
        categoryEntity.setCreatedAt(LocalDateTime.now());
        return categoryEntity;
    }
}
