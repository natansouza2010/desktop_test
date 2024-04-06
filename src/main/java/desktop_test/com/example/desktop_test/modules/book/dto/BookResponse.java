package desktop_test.com.example.desktop_test.modules.book.dto;

import desktop_test.com.example.desktop_test.modules.book.entities.BookEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.UUID;
@Data
public class BookResponse {
    private UUID id;
    private String title;
    private String author;

    public static BookResponse of(BookEntity book){
        var response = new BookResponse();
        BeanUtils.copyProperties(book, response);
        return response;
    }
}
