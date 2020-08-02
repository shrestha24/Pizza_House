package com.example.itemsdata;

import java.util.ArrayList;
import java.util.List;

public class ItemsData {
    public List<Items> itemList;

    public ItemsData(String category) {
        itemList=new ArrayList<>();
        load(category);

    }
    public void load(String category){
        if (category.equals("Nepolitan Pizza")){
            Items data = new Items();
            data.setDescription("Neapolitan pizza, made with San Marzano tomatoes, mozzarella cheese, fresh basil, salt and extra-virgin olive oil. ");
            data.setImageUrl("https://assets.biggreenegg.eu/app/uploads/2018/06/28115815/topimage-pizza-special17-800x500.jpg");
            data.setItemName("Margerita");
            data.setPrice(15);
            itemList.add(data);

            Items data1 = new Items();
            data1.setDescription("Neapolitan pizza, made with San Marzano tomatoes, mozzarella cheese, fresh basil, salt and extra-virgin olive oil with extra cheese.");
            data1.setImageUrl("https://img.sunset02.com/sites/default/files/image/recipes/su/10/02/pizzetta-margherita-pizza-su-x.jpg");
            data1.setItemName("Double Cheese Margerita");
            data1.setPrice(12);
            itemList.add(data1);

            Items data2 = new Items();
            data2.setDescription("Barbecue chicken seasoned and coated in a spice rub, barbecue sauce,");
            data2.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSYcRUbOAdfgv_YcPhuriZyFgOi4Hs5BvYmlQ&usqp=CAU");
            data2.setItemName("Hamburger barbeque chicken");
            data2.setPrice(14);
            itemList.add(data2);

        }else if (category.equals("CHICAGO PIZZA")){
            Items data3 = new Items();
            data3.setDescription("Chicago-style pizza prepared in deep-dish style and as a stuffed pizza with large amounts of cheese and a chunky tomato sauce.");
            data3.setImageUrl("https://www.recipegirl.com/wp-content/uploads/2018/03/Chicago-Style-Deep-Dish-Pizza-RecipeGirl-3.jpg");
            data3.setItemName("Chicago Pizza");
            data3.setPrice(10);
            itemList.add(data3);

            Items data4 = new Items();
            data4.setDescription("Thick Chicago crust, filled with cheese and tomato sauce gives a tangy taste");
            data4.setImageUrl("https://bloximages.chicago2.vip.townnews.com/madison.com/content/tncms/assets/v3/editorial/9/9d/99dfa361-1164-591d-9e3d-2afcaae1e3a5/5c3633d40a3e0.image.jpg?resize=1200%2C798");
            data4.setItemName("Deep-dish with Red Sauce");
            data4.setPrice(12);
            itemList.add(data4);

            Items data5 = new Items();
            data5.setDescription("The crust is covered with cheese (mozzarella), followed by various meat options such as pepperoni or sausage,  other toppings such as onions, mushrooms, and bell peppers are then also used ");
            data5.setImageUrl("https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/vimdb/193376.jpg");
            data5.setItemName("deep-dish chigago style");
            data5.setPrice(11);
            itemList.add(data5);

            Items data6 = new Items();
            data6.setDescription("Barbecued chicken and bacon cheeseburgers.");
            data6.setImageUrl("https://media.tacdn.com/media/attractions-splice-spp-674x446/07/b7/ab/cc.jpg");
            data6.setItemName("Grilled deep-dish");
            data6.setPrice(12);
            itemList.add(data6);


        }else if (category.equals("NewYork pizza")){
            Items data7 = new Items();
            data7.setDescription("Pepperoni soft, slightly smoky, and bright red in color. Thinly sliced pepperoni pizza topping in American pizzerias.");
            data7.setImageUrl("https://vnafood.com/wp-content/uploads/2018/01/New-York-Style-Pizza.jpg");
            data7.setItemName("Peperoni pizza");
            data7.setPrice(12);
            itemList.add(data7);

            Items data8 = new Items();
            data8.setDescription(" Topped with anchovies, mushrooms, onions, olives, pineapple, meat, and cheese.");
            data8.setImageUrl("https://d16jhsvmsopai9.cloudfront.net/img/corporate/corporatefood.jpg");
            data8.setItemName("Framhouse pizza");
            data8.setPrice(9);
            itemList.add(data8);

            Items data9 = new Items();
            data9.setDescription("Crust is thick and crisp only along its edge, yet soft, thin, and pliable enough beneath its toppings with tomato sauce and shredded mozzarella cheese.");
            data9.setImageUrl("https://www.pizzarecipe.org/wp-content/uploads/2019/01/New-York-Style-Pizza-1020x766.jpg");
            data9.setItemName("Margerita newyork style");
            data9.setPrice(11);
            itemList.add(data9);

            Items data10 = new Items();
            data10.setDescription("Thin crust pizza with cheese, pepperoni, and sausage.");
            data10.setImageUrl("https://www.tripsavvy.com/thmb/adPjJgTKxo3WLelkuDDd_NeJ6nU=/1920x1280/filters:no_upscale():max_bytes(150000):strip_icc()/PizzaWithThinCrust-5c40f440c9e77c0001ce1bcf.jpg ");
            data10.setItemName("Fresh Pan fried pizza");
            data10.setPrice(15);
            itemList.add(data10);


        }else if (category.equals("Greek pizza")){
            Items data12 = new Items();
            data12.setDescription("Crust is spongy, airy, and light with cheese and tomato sauce");
            data12.setImageUrl("https://www.cookingclassy.com/wp-content/uploads/2013/10/greek-pizza3+srgb..jpg");
            data12.setItemName("Greek pizza");
            data12.setPrice(11);
            itemList.add(data12);

            Items data14 = new Items();
            data14.setDescription("This cauliflower crust pizza recipe is tasty and perfect for gluten-free eaters. It tastes just like pizza, if not better! Give it a shot.");
            data14.setImageUrl("https://realhousemoms.com/wp-content/uploads/Cauliflower-Pizza-Crust-IG1.jpg");
            data14.setItemName("Cauliflower crust spl.");
            data14.setPrice(12);
            itemList.add(data14);


        }else if (category.equals("Detroit pizza with peperoni")){
            Items data17 = new Items();
            data17.setDescription("Rectangular pizza with a thick crispy and chewy crust. Topped with Wisconsin brick cheese, then tomato sauce layered on top of the other toppings ");
            data17.setImageUrl("https://images-gmi-pmc.edge-generalmills.com/bf16edf2-2d0c-427a-9768-a5b41858ecae.jpg");
            data17.setItemName("Detroit pizza with peperoni");
            data17.setPrice(17);
            itemList.add(data17);

        }else if (category.equals("Sicilian Pizza")){
            Items data15 = new Items();
            data15.setDescription("Topped with onions, anchovies, tomatoes, herbs and strong cheese such as caciocavallo and toma.");
            data15.setImageUrl("https://static01.nyt.com/images/2018/12/05/dining/05kitchenrex1/merlin_147457287_3700e223-72be-4dd8-a70e-275066fd386f-articleLarge.jpg");
            data15.setItemName("Sicilian Pizza");
            data15.setPrice(16);
            itemList.add(data15);

            Items data16 = new Items();
            data16.setDescription("Topped with sausage, peppers, onions, anchovies, tomatoes, herbs and strong cheese such as caciocavallo and toma");
            data16.setImageUrl("https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/10/2/0/FNM_110112-Sicilian-Pizza-With-Sausage-and-Peppers-Recipe_s4x3.jpg.rend.hgtvcom.826.620.suffix/1382455226932.jpeg");
            data16.setItemName("Sicilian Pizza with Sausage and peppers");
            data16.setPrice(15);
            itemList.add(data16);

        }else {
            Items data18 = new Items();
            data18.setDescription("Topped with different varities of fresh vegetables, sweet corn and herbs.");
            data18.setImageUrl("https://artisanpizzakitchen.com/wp-content/uploads/2018/05/373_photo3.jpg");
            data18.setItemName("Fresh Veggie");
            data18.setPrice(14);
            itemList.add(data18);

            Items data19 = new Items();
            data19.setDescription("A pizza that decidedly staggers under an overload of golden corn, exotic black olives, crunchy onions, crisp capsicum, succulent mushrooms, juicyfresh tomatoes and jalapeno - with extra cheese to go all around.");
            data19.setImageUrl("https://therecipecritic.com/wp-content/uploads/2019/05/besthomemadepizzahero.jpg");
            data19.setItemName("Veg Extravaganza");
            data19.setPrice(11);
            itemList.add(data19);

            Items data20 = new Items();
            data20.setDescription("Order hot & fresh veggie pizzas CHEESE N CORN with Golden Corn");
            data20.setImageUrl("https://www.dominos.co.in/files/items/Double_Cheese_Margherita.jpg");
            data20.setItemName("Cheese and corn");
            data20.setPrice(9);
            itemList.add(data20);

            Items data21 = new Items();
            data21.setDescription("Non veg pepper barbecue chicken pizza. Enjoy your favourite non veg pizzas with extra cheese.");
            data21.setImageUrl("https://www.dominos.co.in/files/items/Pepper_Barbeque.jpg");
            data21.setItemName("Pepper Barbeque");
            data21.setPrice(12);
            itemList.add(data21);

            Items data22 = new Items();
            data22.setDescription("Cheesy Indian pizza topped with delicious Chicken Tikka Masala.");
            data22.setImageUrl("https://rasamalaysia.com/wp-content/uploads/2012/06/chicken-tikka-masala-pizza-thumb-480x360.jpg");
            data22.setItemName("Chicken Tikka Masala");
            data22.setPrice(12);
            itemList.add(data22);

            Items data23 = new Items();
            data23.setDescription("Barbeque chicken with a topping of golden corn loaded with extra cheese.");
            data23.setImageUrl("https://www.dominos.co.in/files/items/IndianChickenTikka.jpg");
            data23.setItemName("Indi Chicken Pizza");
            data23.setPrice(11);
            itemList.add(data23);

            Items data24 = new Items();
            data24.setDescription("Bite into supreme delight of Black Olives, Onions, Grilled Mushrooms, Pepper BBQ Chicken, Peri-Peri Chicken, Grilled Chicken Rashers.");
            data24.setImageUrl("https://www.dominos.co.in/files/items/Non-Veg_Supreme.jpg");
            data24.setItemName("Non-Veg Supreme");
            data24.setPrice(12);
            itemList.add(data24);

            Items data25 = new Items();
            data25.setDescription("Grilled chicken, crunchy fresh onions, and not one, not two, but three cheeses: mozzarella, provolone and cheddar on our hand-tossed crust.");
            data25.setImageUrl("https://5.imimg.com/data5/PO/AG/GLADMIN-33163948/chicken-fiesta-pizza-500x500.png");
            data25.setItemName("Barbeque Chicken Fiesta");
            data25.setPrice(9);
            itemList.add(data25);

        }

    }

    public List<Items> getItemList() {
        return itemList;
    }

    public void setItemList(List<Items> itemList) {
        this.itemList = itemList;
    }
}
