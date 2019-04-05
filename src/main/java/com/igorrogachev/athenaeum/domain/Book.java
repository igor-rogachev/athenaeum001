package com.igorrogachev.athenaeum.domain;

        import org.springframework.format.annotation.DateTimeFormat;

        import javax.persistence.*;
        import javax.validation.constraints.NotEmpty;
        import javax.validation.constraints.NotNull;
        import java.util.Date;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"title", "year"})})
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull(message = "Title may not be null")
    @NotEmpty(message = "Title may not be empty")
    private String title;

    @NotNull(message = "Year may not be null")
    // @DateTimeFormat(pattern = "dd.mm.yyyy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;

    public Book() {
    }

    public Book(@NotNull(message = "Title may not be null")
                @NotEmpty(message = "Title may not be empty") String title,
                @NotNull(message = "Year may not be null") Date year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }
}
