package desktop_test.com.example.desktop_test.modules.book.repository;

import desktop_test.com.example.desktop_test.modules.book.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
}
