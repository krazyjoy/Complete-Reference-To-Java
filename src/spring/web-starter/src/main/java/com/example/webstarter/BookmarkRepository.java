package com.example.webstarter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<BookMarkInfo> findAllByOrderByCreatedAtDesc();
    // Optional<BookmarkInfo> because a bookmark with the given id may or may not exist
    Optional<BookMarkInfo> findBookmarkById(Long id);

}
