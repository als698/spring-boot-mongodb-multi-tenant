package com.example.tenant.category;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final MongoTemplate mongoTemplate;

    public CategoryService(@Lazy MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Category> getAllCategories() {
        return mongoTemplate.findAll(Category.class);
    }

    public void saveCategory(Category category) {
        mongoTemplate.save(category);
    }

}
