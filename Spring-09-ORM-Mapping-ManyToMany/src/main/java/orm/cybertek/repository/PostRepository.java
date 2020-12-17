package orm.cybertek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orm.cybertek.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
