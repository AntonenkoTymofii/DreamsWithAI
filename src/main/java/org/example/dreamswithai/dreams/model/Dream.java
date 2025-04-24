package org.example.dreamswithai.dreams.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "dreams")
@Getter
@Setter
public class Dream {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "dream_categories",
            joinColumns = @JoinColumn(name = "dream_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    private String title;

    private String description;

    private LocalDateTime dreamDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private boolean isPrivate;


}
