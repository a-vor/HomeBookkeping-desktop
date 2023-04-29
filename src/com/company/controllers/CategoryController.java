package com.company.controllers;

import com.company.models.Category;

import java.util.ArrayList;

public class CategoryController {
    ArrayList<Category>  categories = new ArrayList<Category>();
    public void addCategory(String title) {
        this.categories.add(new Category(assignId(), title));
    }

    public int assignId() {
        if (this.categories.isEmpty()) return 1;
        else return this.categories.size();
    }
}
