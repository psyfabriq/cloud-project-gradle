package ru.psyfabriq.enterprise.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.psyfabriq.enterprise.entity.FolderMO;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FolderRepository extends CrudRepository<FolderMO, String> {
    @Override
    <S extends FolderMO> S save(S entity);
    @Override
    void delete(FolderMO entity);
    Optional<FolderMO> findByPath(String path);
    Optional<FolderMO>  findById(String id);
    boolean existsByPath(String path);
    boolean existsById(String od);
    List<FolderMO> findAllByParrent(FolderMO parrent);
    List<FolderMO> findAll();

}
