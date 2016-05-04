package com.controller;

import com.dao.CategoriesDao;
import com.entity.Category;
import com.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @autor A_Nakonechnyi
 * @date 25.04.2016.
 */
@RestController
public class GreetingController {

        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @Autowired
        CategoriesDao categoriesDao;

        @RequestMapping("/greeting")
        public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
            return new Greeting(counter.incrementAndGet(),
                    String.format(template, name));
        }

        @RequestMapping("/categories")
        public List<Category> getCategories() {
                List<Category> result = categoriesDao.getCategories();
                return result;
        }

}
