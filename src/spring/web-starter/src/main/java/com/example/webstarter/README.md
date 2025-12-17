# Web Starter Project 
Demonstrate two approaches of building a small bookmark CRUD web API.

Common files: BookmarkInfo interface, BookmarkNotFoundException, WebStarterApplication

The first approach uses local JPA with in-memory DB.
Files used are BookmarkLocal, BookmarkLocalRepository

The second approach uses JPA with PostgresSql DB.
Files used are BookMark, BookmarkRepository


## Local JPA + In-memory DB

### Add H2 (MAVEN)
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### application.properties

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.h2.console.enabled=true
```

### create the entity manually
- file: `BookmarkLocal.java`

### Seed Tiny Sample Data
- file: `src/main/resources/data.sql`
```sql
insert into bookmark_local (title, url) values ('JetBrains', 'https://www.jetbrains.com');
insert into bookmark_local (title, url) values ('Spring', 'https://spring.io');
```

## JPA + Postgres DB
### docker Postgres Setup
1. download postgres image
    ```sql
    docker pull postgres
    docker ps
    ```
2. create a postgres container
    ```sql
    docker run -p 5432:5432 \
    -e POSTGRES_PASSWORD=postgres \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_DB=postgres \
    postgres:17
    ```
3. connect to Intellij IDEA's database
   - click `view | tool windows | database`
   - set  User=postgres, DB=postgres
   
4. DB setup using an SQL script 
   - navigate to postgres console and then run the following sql script
   ```sql
   create sequence bookmark_id_seq start with 1 increment by 50;
   create table bookmarks
   (
        id bigint not null default nextval('bookmark_id_seq'),
        title varchar(200) not null,
        url varchar(500) not null,
        created_at timestamp not null default now(),
        updated_at timestamp,
        primary key (id)
   );
   
   insert into bookmarks(title, url, created_at) values
   ('IntelliJ IDEA documentation', 'https://www.jetbrains.com/help/idea/getting-started.html', '2021-06-26'),
   ('IntelliJ IDEA YouTube channel', 'https://www.youtube.com/intelljidea', '2021-10-10'),
   ('JetBrains Guide', 'https://www.jetbrains.com/guide/', '2023-12-05'),
   ('Java Guide', 'https://www.jetbrains.com/guide/java', '2024-08-15');
   ```
5. configure database connection properties in `application.properties`
    ```properties
   spring.datasource.url=jdbc:postgresql:
   spring.datasource.username=postgres
   spring.datasource.password=postgres
    ```
### Generate entities from DB
Go to `Settings | Plugins | Marketplace`, search for "JPA buddy" plugin.

Then generate JPA entities from DB by right click `com.example.webstarter` java project package.
and select `New | JPA Entities from DB` from the context menu.

The JPA entity `Bookmark` is generated at `Bookmark.java`

### Create Spring data JPA repository
Right click on `com.example.webstarter` java package, then select `New | Spring Data JPA Repostiory`.

Select Bookmark as **Entity** and click **OK**.

Since I did not find this choice in IntelliJ, I created the `BookmarkRepository` interface manually.

```java

package com.example.webstarter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<BookMarkInfo> findAllByOrderByCreatedAtDesc();
    // Optional<BookmarkInfo> because a bookmark with the given id may or may not exist
    Optional<BookMarkInfo> findBookmarkById(Long id);

}
```

### Implement BookmarkController 


### Setup Postgres DB in properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres
```


### Test API endpoints using HTTP Client

IntelliJ IDEA provides a built-in HTTP Client, which we can use to invoke our API endpoints and assert the responses.

You can open the HTTP Client by selecting Tools | HTTP Client | Create request in HTTP Client. Alternatively, you can also click on the API gutter icon on the API handler methods in BookmarkController.

