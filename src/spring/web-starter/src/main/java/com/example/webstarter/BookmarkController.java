package com.example.webstarter;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {
    private final BookmarkRepository repo;
    BookmarkController(BookmarkRepository repo){
        this.repo = repo;
    }
    @GetMapping
    List<BookMarkInfo> getBookmarks(){
        return repo.findAllByOrderByCreatedAtDesc();
    }
    @GetMapping("/{id}")
    ResponseEntity<BookMarkInfo> getBookmarkById(@PathVariable Long id){
        var bookmark = repo.findBookmarkById(id).orElseThrow(
                ()-> new BookmarkNotFoundException("Bookmark Not Found")
        );
        return ResponseEntity.ok(bookmark);
    }

    record CreateBookmarkPayload(
            @NotEmpty(message="Title is required")
            String title,
            @NotEmpty(message="Url is required")
            String url
    ){

    }

    @PostMapping
    ResponseEntity<BookMarkInfo> createBookmark(@Valid @RequestBody CreateBookmarkPayload payload){
        var bookmark = new Bookmark();
        bookmark.setTitle(payload.title());
        bookmark.setUrl(payload.url());
        bookmark.setCreatedAt(Instant.now());
        var savedBookmark = repo.save(bookmark);

        // construct URL for the newly created bookmark and send it as the "Location" header
        var url = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(savedBookmark.getId());
        return ResponseEntity.created(url).build();
    }

    record UpdateBookmarkPayload(
            @NotEmpty(message="Title is required")
            String title,
            @NotEmpty(message="Url is required")
            String url
    ){}

    @PutMapping("/{id}")
    ResponseEntity<Void> updateBookmark(@PathVariable Long id,
                                        @Valid @RequestBody UpdateBookmarkPayload payload){
        var bookmark = repo.findById(id)
                .orElseThrow(() -> new BookmarkNotFoundException("Bookmark Not Found"));
        bookmark.setTitle(payload.title());
        bookmark.setUrl(payload.url());
        bookmark.setUpdatedAt(Instant.now());
        repo.save(bookmark);
        // handle 400 BAD Request
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    void deleteBookmark(@PathVariable Long id){
        var bookmark = repo.findById(id)
                .orElseThrow(()->new BookmarkNotFoundException("Bookmark Not Found"));
        repo.delete(bookmark);
    }

    // Implement 404 Not Found instead of 500 Internal Server Error when
    // throw a BookmarkNotFoundException
    @ExceptionHandler(BookmarkNotFoundException.class)
    ResponseEntity<Void> handle(BookmarkNotFoundException e){
        return ResponseEntity.notFound().build();
    }



}

