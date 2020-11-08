package pl.sda.spring_start.repository;

import javafx.geometry.Pos;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.spring_start.model.Category;
import pl.sda.spring_start.model.Post;
import pl.sda.spring_start.model.User;

import java.util.List;
import java.util.Map;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // Filtrowanie po kategorii i sortowanie po dacie
    List<Post> findAllByCategory(Category caregory, Sort sort);

    // Szukanie postów po autorze i kategorii
    List<Post> findAllByCategoryAndAuthor(Category category, User author, Sort sort);

    // szukanie słów kluczowych w tytule i zawartości posta
    List<Post> findAllByTitleInOrContentIn(List<String> titleWords, List<String> contentWords);

    // Statystyki postów - grupowanie postów po kategorii
    @Query(
            value = "SELECT category, count(*) FROM Post p GROUP BY p.category ORDER BY 2 DESC",
            nativeQuery = true
    )
    Map<Object, Object> postStatistics();


}