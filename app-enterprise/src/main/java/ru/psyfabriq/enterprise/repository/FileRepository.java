package ru.psyfabriq.enterprise.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.psyfabriq.enterprise.entity.FileMO;
import ru.psyfabriq.enterprise.entity.FolderMO;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FileRepository extends CrudRepository<FileMO, String> {
    @Override
    <S extends FileMO> S save(S entity);
    @Override
    void delete(FileMO entity);
    boolean existsByPath(String path);
    boolean existsById(String id);
    Optional<FileMO>  findByPath(String path);
    Optional<FileMO> findById(String id);
    List<FileMO> findAllByParrent(FolderMO parrent);
    List<FileMO> findAll();



}
