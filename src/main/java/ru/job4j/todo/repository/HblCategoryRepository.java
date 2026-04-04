package ru.job4j.todo.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Category;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class HblCategoryRepository implements CategoryRepository {

    private CrudRepository crudRepository;

    @Override
    public List<Category> getAll() {
        return crudRepository.query("FROM Category", Category.class);
    }

    @Override
    public List<Category> findById(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }
        return crudRepository.query("FROM Category c WHERE c.id IN :ids",
                Category.class, Map.of("ids", ids));
    }
}
