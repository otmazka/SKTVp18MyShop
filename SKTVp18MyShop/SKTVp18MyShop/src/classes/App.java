/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Buyer;
import entity.History;
import entity.Product;
import interfaces.Saveble;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sveta
 */
public class App {

    List<Product> listProducts = new ArrayList<>();
    List<Buyer> listBuyers = new ArrayList<>();
    List<History> listHistories = new ArrayList<>();

    Saveble saveble;

    public App(String flag) {
        if(flag.equals("base")){
            saveble = new SaveToBase();
        }else if(flag.equals("file")){
            saveble = new SaveToFile();
        }else{
            saveble = new SaveToBase();
        }
        listProducts = saveble.loadProducts();
        listBuyers = saveble.loadBuyers();
        listHistories = saveble.loadHistories();
    }

    public void run() {
       Scanner scanner = new Scanner(System.in);
        
        HistoryProvider historyProvider = new HistoryProvider();
                           
        boolean flagExit = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Закрыть программу");
            System.out.println("1. Новый продукт");
            System.out.println("2. Новый покупатель");
            System.out.println("3. Список продуктов");
            System.out.println("4. Список покупателей");
            System.out.println("5. Купить продукт");
            System.out.println("6. Список сделанных покупок");

            System.out.println("Введите номер задачи:");
            String numberTask = scanner.nextLine();
            if (null != numberTask) {
                switch (numberTask) {
                    case "0":
                        flagExit = false;
                        System.out.println("Заканчиваем работу программы");
                        break;
                    case "1":
                        System.out.println("Новый продукт.");
                        ProductProvider productProvider = new ProductProvider();
                        Product product = productProvider.createProduct();
                        listProducts.add(product);
                        saveble.saveProducts(listProducts);
                        listProducts.forEach((p) -> {
                            System.out.println(p.toString());
                        });
                        break;
                    case "2":
                        System.out.println("Новый покупатель.");
                        BuyerProvider buyerProvider = new BuyerProvider();
                        Buyer buyer = buyerProvider.createBuyer();
                        listBuyers.add(buyer);
                        saveble.saveBuyers(listBuyers);
                        listBuyers.forEach((b) -> {
                            System.out.println(b.toString());
                        });
                        break;
                    case "3":
                        System.out.println("Список продуктов:");
                        int i = 1;
                        for (Product p : listProducts) {
                            System.out.println(i + ". " + p.toString());
                            i++;
                        }
                        break;
                    case "4":
                        System.out.println("Список покупателей:");
                        for (int j = 0; j < listBuyers.size(); j++) {
                            System.out.println(j + 1 + ". " + listBuyers.get(j).toString());
                        }
                        break;
                    case "5":
                        System.out.println("Купить продукт");
                        History history = historyProvider.createHistory(listProducts, listBuyers);
                        listHistories.add(history);
                        saveble.saveHistories(listHistories);
                        break;
                    case "6":
                        System.out.println("Список купленных продуктов");
                        i = 1;
                        for (History h : listHistories) {
                            if (h.getTakeOn() != null) {
                                System.out.println(i + ". " + h.toString());
                                i++;
                            }
                        }
                        if (i < 1) {
                            System.out.println("Нет купленных продуктов");
                            System.out.println();
                        }
                        break;
                }
            }
        } while (flagExit);

    }
}
