package com.example.webstarter;

import java.time.Instant;

public interface BookMarkInfo {
    Long getId();
    String getTitle();
    String getUrl();
    Instant getCreatedAt();

}
