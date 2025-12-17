package com.example.webstarter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/local/bookmarks")
public class BookmarkLocalController {
    private final BookmarkLocalRepository repo;
    public record BookmarkRequest(String title, String url){};

    public BookmarkLocalController(BookmarkLocalRepository repo) {
        this.repo = repo;
    }

    // READ all
    @GetMapping
    public List<BookmarkLocal> findAll() {
        return repo.findAll();
    }

    // READ one
    @GetMapping(value = "/{id}")
    public ResponseEntity<BookmarkLocal> findById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // return an HTTP 404 Not Found

    }


    // CREATE
    @PostMapping
    public ResponseEntity<BookmarkLocal> create(@RequestBody BookmarkRequest req,
                                                UriComponentsBuilder uriBuilder) {
        BookmarkLocal newBookmark = repo.save(new BookmarkLocal(req.title(),  req.url()));
        URI location = uriBuilder
                .path("/api/bookmarks/{id}")
                .buildAndExpand(newBookmark.getId())
                .toUri();

        // return location and body
        return ResponseEntity.created(location).body(newBookmark);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<BookmarkLocal> update(@PathVariable Long id,
                                                @RequestBody BookmarkRequest req) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setTitle(req.title());
                    existing.setUrl(req.url());
                    return ResponseEntity.ok(repo.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<BookmarkLocal> delete(@PathVariable Long id) {
        if(!repo.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build(); // successful delete 204 No Content
    }


}

