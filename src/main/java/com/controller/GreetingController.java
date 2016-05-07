package com.controller;

import com.dao.ContactCategoriesDao;
import com.entity.ContactCategory;
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
        ContactCategoriesDao contactCategoriesDao;

        @RequestMapping("/greeting")
        public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
            return new Greeting(counter.incrementAndGet(),
                    String.format(template, name));
        }

        @RequestMapping("/categor")
        public List<ContactCategory> getCategories() {
                List<ContactCategory> result = contactCategoriesDao.getContactCategories();
                return result;
        }

        /*@RequestMapping("/jsp")
        public String getPage(Map<String, Object> model){
                System.out.println("PageController");
                model.put("time", new Date());
                model.put("message", "JSP Hello!");
                return "jsp";
        }*/

}
