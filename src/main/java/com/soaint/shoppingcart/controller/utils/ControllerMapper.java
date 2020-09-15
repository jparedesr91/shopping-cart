package com.soaint.shoppingcart.controller.utils;
import com.soaint.shoppingcart.controller.ClientController;
import com.soaint.shoppingcart.controller.ProductController;
import com.soaint.shoppingcart.controller.SaleController;
import com.soaint.shoppingcart.controller.UserController;

public class ControllerMapper {

    public static void writeLog(String name, String text) {
        if (name.contains(ClientController.class.getCanonicalName())) {
            ClientController.writeLog(text);

        } else {
            if (name.contains(SaleController.class.getCanonicalName())) {
                SaleController.writeLog(text);
            } else {
                if (name.contains(ProductController.class.getCanonicalName())) {
                    ProductController.writeLog(text);

                } else {
                    if (name.contains(UserController.class.getCanonicalName())) {
                        UserController.writeLog(text);

                    }
                }
            }
        }
    }
}