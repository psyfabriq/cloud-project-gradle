package ru.psyfabriq.enterprise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.psyfabriq.enterprise.entity.FileMO;
import ru.psyfabriq.enterprise.repository.FileRepository;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FileRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FileRepository fileRepository;

    @Test
    public void whenFindByPath_thenReturnFileMO() {
        // given
        FileMO fileMO = FileMO.builder()
                .id("001")
                .isImage(false)
                .mimeType("pdf")
                .name("test")
                .path("test")
                .rights("777")
                .size(2048)
                .userId("00000001")
                .build();
        entityManager.persist(fileMO);
        entityManager.flush();

        // when
        Optional<FileMO> found = fileRepository.findByPath(fileMO.getPath());
        // then
        assertThat(found.get().getName())
                .isEqualTo(fileMO.getName());
    }
}
