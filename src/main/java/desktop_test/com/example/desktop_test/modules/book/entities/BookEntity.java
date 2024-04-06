package desktop_test.com.example.desktop_test.modules.book.entities;

import desktop_test.com.example.desktop_test.modules.book.dto.BookRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
@Table(name = "book")
@Builder
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public static BookEntity of(BookRequest bookRequest, CategoryEntity category){

        return BookEntity.builder()
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .category(category)
                .build();

    }
}
