package desktop_test.com.example.desktop_test.modules.book.repository;

import desktop_test.com.example.desktop_test.modules.book.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    Optional<BookEntity> findByTitleAndAuthor (String title, String author);
    Optional<BookEntity> findById(UUID id);
}
