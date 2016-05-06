package com.dao;

import com.entity.ContactCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 04.05.2016.
 */
@Component
public class ContactCategoriesDao {
    public List<ContactCategory> getContactCategories() {
        //TODO
        List<ContactCategory> contactCategoryList = new ArrayList<>();
        contactCategoryList.add(new ContactCategory("General", 1));
        contactCategoryList.add(new ContactCategory("All", 2));
        return contactCategoryList;
    }
}
