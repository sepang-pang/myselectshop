package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.domain.Folder;
import com.sparta.myselectshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);

    List<Folder> findAllByUser(User user);

//    @Query("select f from Folder f where f.user = :user and f.name in :names")
//    List<Folder> findAllByUserAndName(@Param("user") User user, @Param("names") List<String> folderNames);

}
