/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Buyer;
import entity.History;
import entity.Product;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HistoryProvider {
     Scanner scanner = new Scanner(System.in);

    public History createHistory(List<Product> listProducts, List<Buyer> listBuyers) {
        History history = new History();
        System.out.println("Список книг: ");
        for(int i=0; i<listProducts.size();i++){
            if(listProducts.get(i).getCount() > 0){
                System.out.printf("%d. Название книги: %s, автор: %s, год издания: %d%n"
                    ,i+1
                    ,listProducts.get(i).getTitle()
                    ,listProducts.get(i).getModel()
                    ,listProducts.get(i).getPrice()
                );
            }
            
        }
        System.out.print("Выберите номер выдаваемой книги:"); 
        int takeProductNum = scanner.nextInt();
        Product product = listProducts.get(takeProductNum-1);
        product.setCount(product.getCount()-1);
        System.out.println("Список читателей: ");
        int i=0;
        for(Buyer b : listBuyers){
            System.out.printf("%d. Имя и фамилия читателя: %s %s, email: %s%n"
                    ,i+1
                    ,b.getName()
                    ,b.getLastname()
                    ,b.getEmail()
            );
            i++;
        }
        System.out.print("Выберите номер читателя:"); 
        int readerNum = scanner.nextInt();
        Buyer buyer = listBuyers.get(readerNum-1);
        history.setProduct(product);
        history.setBuyer(buyer);
        history.setTakeOn(new Date());
        return history;
    }
       
        
    }

