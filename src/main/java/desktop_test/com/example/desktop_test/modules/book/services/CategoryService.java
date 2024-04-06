package desktop_test.com.example.desktop_test.modules.book.services;

import desktop_test.com.example.desktop_test.modules.book.dto.CategoryRequest;
import desktop_test.com.example.desktop_test.modules.book.dto.CategoryResponse;
import desktop_test.com.example.desktop_test.modules.book.entities.CategoryEntity;
import desktop_test.com.example.desktop_test.modules.book.repository.BookRepository;
import desktop_test.com.example.desktop_test.modules.book.repository.CategoryRepository;
import desktop_test.com.example.desktop_test.modules.config.exception.SuccessResponse;
import desktop_test.com.example.desktop_test.modules.config.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream().map(CategoryResponse::of).toList();
    }

    public CategoryResponse save(CategoryRequest request) {
        validateParamsCategoryRequest(request);
        var category = categoryRepository.save(CategoryEntity.of(request));
        return CategoryResponse.of(category);
    }

    public CategoryResponse update(CategoryRequest request, UUID id) {
        validateParamsCategoryRequest(request);
        validateIdCategory(id);
        verifyIfExistCategoryId(id);
        var category = CategoryEntity.of(request);
        category.setId(id);
        categoryRepository.save(category);
        return CategoryResponse.of(category);

    }

    public SuccessResponse delete(UUID id) {
        validateIdCategory(id);
        verifyIfExistCategoryId(id);
        if(bookRepository.existsByCategory_Id(id)){
            throw new ValidationException("Não pode deletar uma categoria vinculada a um livro");
        }
        categoryRepository.deleteById(id);
        return SuccessResponse.create("Categoria deletada com sucesso");
    }




    private void validateParamsCategoryRequest(CategoryRequest categoryRequest){
        if(isEmpty(categoryRequest.getName())) {
            throw new ValidationException("Nome da categoria é requerido");
        }
        if(isEmpty(categoryRequest.getDescription())) {
            throw new ValidationException("Descrição da categoria é requerido");
        }

    }


    private void validateIdCategory(UUID id){
        if(isEmpty(id)) {
            throw new ValidationException("Id não informado");
        }


    }

    private void verifyIfExistCategoryId(UUID id){
        var category = categoryRepository.findById(id);
        if(isEmpty(category)) {
            throw new ValidationException("Categoria não encontrada");
        }
    }
}
