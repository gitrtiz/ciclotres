package com.mintic.ciclotres.dao;

import com.mintic.ciclotres.entities.Category;
import com.mintic.ciclotres.entities.CategoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrud categoryCrudRepository;
    
    public List<Category> getAll() {return (List<Category>) categoryCrudRepository.findAll();};
    
    public Optional<Category> getCategory(int id) {return categoryCrudRepository.findById(id);};
    
    public Category save(Category category) {return categoryCrudRepository.save(category);};
    
}
