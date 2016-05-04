package com.dao;

import com.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 04.05.2016.
 */
@Component
public class CategoriesDao {
    public List<Category> getCategories() {
        //TODO
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Registered", 1));
        categoryList.add(new Category("Not Registered", 2));
        return categoryList;
    }
}
