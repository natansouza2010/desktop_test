package desktop_test.com.example.desktop_test.modules.book.controller;

import desktop_test.com.example.desktop_test.modules.book.dto.BookRequest;
import desktop_test.com.example.desktop_test.modules.book.dto.BookResponse;
import desktop_test.com.example.desktop_test.modules.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/books")
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

}
