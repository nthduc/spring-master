package io.github.nthduc.springboot.springbootmaster.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Course {

    @Id
    private long id;
    private String name;
    private String author;

    //Constructor
    //Getters
    //toString


    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Course() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
