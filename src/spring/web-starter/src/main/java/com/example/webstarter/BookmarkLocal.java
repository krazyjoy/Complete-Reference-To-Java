package com.example.webstarter;

import jakarta.persistence.*;

// use local cache
// include dependencies h2database, spring-boot-starter-data-jpa

@Entity
@Table(name = "bookmark_local")
public class BookmarkLocal {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;

    protected BookmarkLocal(){};

    public BookmarkLocal(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getUrl(){
        return this.url;
    }
    public void setTitle(String title) {};
    public void setUrl(String url) {};

}
