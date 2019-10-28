/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Product;
import java.util.Scanner;

/**
 *
 * @author Sveta
 */
public class ProductProvider {
    public Product createProduct(){
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Фирма: ");
        product.setTitle(scanner.nextLine());
        System.out.println("Модель: ");
        product.setModel(scanner.nextLine());
        System.out.println("Стоимость: ");
        product.setPrice(new Integer(scanner.nextLine()));
        System.out.println("Количество: ");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }
}
