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

        System.out.println("Список телефонов: ");
        int countCurrentProducts = 0;
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getCount() > 0) {
                System.out.printf("%d. Марка: %s, модель: %s, стоимость: %s%n",
                         i + 1,
                         listProducts.get(i).getTitle(),
                         listProducts.get(i).getModel(),
                         listProducts.get(i).getPrice()
                );
                countCurrentProducts++;
            }
        }
        if (countCurrentProducts == 0) {
            System.out.println("Все телефоны проданы.");
            return null;
        }
        System.out.print("Выберите номер покупаемого телефона: ");
        int takeCarNum = scanner.nextInt();
        Product product = listProducts.get(takeCarNum - 1);
        if (product.getCount() > 0) {
            product.setCount(product.getCount()-1);
            System.out.println("Список клиентов: ");
            int i=0;
            for(Buyer b : listBuyers){
                System.out.printf("%d. Имя и фамилия клиента: %s%s, email: %s количество денег: %s%n"
                ,i+1
                ,b.getName()
                ,b.getLastname()
                ,b.getEmail()
                ,b.getMoney()
                );
                i++;
            }
            System.out.println("Выберите номер клиента: ");
            int buyerNum = scanner.nextInt();
            Buyer buyer = listBuyers.get(buyerNum-1);
            buyer.setMoney(buyer.getMoney()- product.getPrice());
            if (buyer.getMoney() < product.getPrice()){
                System.out.printf("Недостаточно денег");
            }else{
               System.out.println("Спасибо за покупку!"); 
            }
            history.setProduct(product);
            history.setBuyer(buyer);
            history.setTakeOn(new Date());
            return history;
        }else{
            System.out.println("Телефоны \""
            +product.getModel()
            +"\" уже все проданы."
            );
            return null;
        }
        
       
        
    }
}
