package desktop_test.com.example.desktop_test.modules.book.controller;

import desktop_test.com.example.desktop_test.modules.book.dto.BookRequest;
import desktop_test.com.example.desktop_test.modules.book.dto.BookResponse;
import desktop_test.com.example.desktop_test.modules.book.exception.SuccessResponse;
import desktop_test.com.example.desktop_test.modules.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public BookResponse save(@RequestBody BookRequest request) {
        return bookService.save(request);
//
    }

    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    @DeleteMapping("{id}")
    public SuccessResponse delete(@PathVariable UUID id) {
        return bookService.delete(id);

    }

    @PutMapping("{id}")
    public BookResponse update(@RequestBody BookRequest request, @PathVariable UUID id) {
        return bookService.update(request, id);

    }

}
