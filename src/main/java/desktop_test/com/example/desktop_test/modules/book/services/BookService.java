package desktop_test.com.example.desktop_test.modules.book.services;

import desktop_test.com.example.desktop_test.modules.book.dto.BookRequest;
import desktop_test.com.example.desktop_test.modules.book.dto.BookResponse;
import desktop_test.com.example.desktop_test.modules.book.entities.BookEntity;
import desktop_test.com.example.desktop_test.modules.book.entities.CategoryEntity;
import desktop_test.com.example.desktop_test.modules.book.exception.ValidationException;
import desktop_test.com.example.desktop_test.modules.book.repository.BookRepository;
import desktop_test.com.example.desktop_test.modules.book.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public BookResponse save(BookRequest bookRequest) {
        validateParamsBook(bookRequest);
        var category = findCategoryByUUID(bookRequest.getCategoryId());
        var book = bookRepository.save(BookEntity.of(bookRequest, category));
        return BookResponse.of(book);
    }

    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream().map(BookResponse::of).toList();
    }


    public CategoryEntity findCategoryByUUID(UUID id){
        if(isEmpty(id)){
            throw new ValidationException("A categoria não foi informada");
        }
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Não foi encontrada nenhuma categoria."));
    }
    private void validateParamsBook(BookRequest bookRequest){
        if(isEmpty(bookRequest.getAuthor())){
            throw new ValidationException("O autor não foi informado.");
        }
        if(isEmpty(bookRequest.getTitle())){
            throw new ValidationException("O titúlo não foi informado.");
        }


    }
}
