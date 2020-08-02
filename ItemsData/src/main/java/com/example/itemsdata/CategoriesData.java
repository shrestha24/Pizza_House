package com.example.itemsdata;

import java.util.ArrayList;
import java.util.List;

public class CategoriesData {
    public List<Category> listCategories;

    public CategoriesData() {
        listCategories=new ArrayList<>();
        loadData();

    }
    public void loadData(){
        Category obj=new Category();
        obj.setDescription(" A thin crust at the base, with dough that puffs up around the sides and provides for a very airy crust. A style of pizza made with tomatoes and mozzarella cheese.");
        obj.setImageUrl("https://assets.epicurious.com/photos/57aa24319a774aa934b6f09e/master/pass/neapolitan-style-pizza-pizza-alla-napoletana.jpg");
        obj.setItemName("Nepolitan Pizza");
        listCategories.add(obj);

        Category obj1 = new Category();
        obj1.setDescription("a deep-dish pizza has room for a larger quantity of toppings with a sturdier crust.");
        obj1.setImageUrl("https://www.recipegirl.com/wp-content/uploads/2018/03/Chicago-Style-Deep-Dish-Pizza-RecipeGirl-3.jpg");
        obj1.setItemName("CHICAGO PIZZA");
        listCategories.add(obj1);

        Category obj2 = new Category();
        obj2.setDescription(" Pizza made with a large hand-tossed thin crust.thick and crisp crust along its edge, yet soft, thin, and pliable enough beneath its toppings with tomato sauce and shredded mozzarella cheese.");
        obj2.setImageUrl("https://d16jhsvmsopai9.cloudfront.net/img/corporate/corporatefood.jpg");
        obj2.setItemName("NewYork pizza");
        listCategories.add(obj2);

        Category obj3 = new Category();
        obj3.setDescription("Pizza proofed and cooked in order and baked on the floor of the pizza oven making the crust spongy, airy, and light");
        obj3.setImageUrl("https://www.cookingclassy.com/wp-content/uploads/2013/10/greek-pizza3+srgb..jpg");
        obj3.setItemName("Greek pizza");
        listCategories.add(obj3);

        Category obj4 = new Category();
        obj4.setDescription("Rectangular pizza with a thick crispy and chewy crust topped with Wisconsin brick cheese, then tomato sauce layered on top of the other toppings");
        obj4.setImageUrl("https://images-gmi-pmc.edge-generalmills.com/bf16edf2-2d0c-427a-9768-a5b41858ecae.jpg");
        obj4.setItemName("Detroit pizza with peperoni");
        listCategories.add(obj4);

        Category obj5 = new Category();
        obj5.setDescription("Thick crusted and rectangular topped with onions, anchovies, tomatoes, herbs and strong cheese caciocavallo and toma");
        obj5.setImageUrl("https://static01.nyt.com/images/2018/12/05/dining/05kitchenrex1/merlin_147457287_3700e223-72be-4dd8-a70e-275066fd386f-articleLarge.jpg");
        obj5.setItemName("Sicilian Pizza");
        listCategories.add(obj5);

        Category obj6 = new Category();
        obj6.setDescription("Indian styled spicy pizzas in both Veg and Non-Veg. For those who love extra spicy and hot.");
        obj6.setImageUrl("https://i2.wp.com/www.eatthis.com/wp-content/uploads/2019/01/dominos-deluxe-pizza.jpg?w=640&ssl=1");
        obj6.setItemName("Indian's spicy Pizza");
        listCategories.add(obj6);

    }

    public List<Category> getListCategories() {
        return listCategories;
    }

    public void setListCategories(List<Category> listCategories) {
        this.listCategories = listCategories;
    }

}
