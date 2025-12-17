package com.example.webstarter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkLocalRepository extends JpaRepository<BookmarkLocal, Long> {
//    Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
//    List<BookmarkInfo> bookmarks = bookmarkRepository.findAll(sort);
//    Optional<BookmarkInfo> findBookmarkById(Long id);

}
