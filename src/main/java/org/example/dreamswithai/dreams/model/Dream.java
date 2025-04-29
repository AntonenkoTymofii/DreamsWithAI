package org.example.dreamswithai.dreams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.dreamswithai.users.model.User;

import java.time.LocalDateTime;
import java.util.Set;

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
