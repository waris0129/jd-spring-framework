package orm.cybertek.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import orm.cybertek.entity.Post;
import orm.cybertek.entity.Tag;
import orm.cybertek.repository.PostRepository;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        Post post = new Post("ORM","ManyToMany");
        Post post1 = new Post("MVC","Controller");


        Tag tag = new Tag("Springboot");
        Tag tag1 = new Tag("JPA");

        post.getTags().add(tag);
        post.getTags().add(tag1);

        tag.getPost().add(post);
        tag.getPost().add(post1);

        tag1.getPost().add(post);
        post.getTags().add(tag);


        postRepository.save(post);
        postRepository.save(post1);

    }
}
