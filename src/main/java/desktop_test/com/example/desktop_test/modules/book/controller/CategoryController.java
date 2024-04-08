package desktop_test.com.example.desktop_test.modules.book.controller;

import desktop_test.com.example.desktop_test.modules.book.dto.CategoryRequest;
import desktop_test.com.example.desktop_test.modules.book.dto.CategoryResponse;
import desktop_test.com.example.desktop_test.modules.book.services.CategoryService;
import desktop_test.com.example.desktop_test.modules.config.exception.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<CategoryResponse> findAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping("/save")
    public CategoryResponse save(@RequestBody CategoryRequest request) {
        return categoryService.save(request);
    }

    @DeleteMapping("{id}")
    public SuccessResponse delete(@PathVariable UUID id) {

        return categoryService.delete(id);

    }

    @PutMapping("{id}")
    public CategoryResponse update(@RequestBody CategoryRequest categoryRequest, @PathVariable UUID id) {
        return categoryService.update(categoryRequest , id);

    }
}
