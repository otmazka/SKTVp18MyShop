package classes;

import entity.Buyer;
import java.util.Scanner;

public class BuyerProvider {
    public Buyer createBuyer(){
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = new Buyer();
        System.out.println("Имя клиента: ");
        buyer.setName(scanner.nextLine());
        System.out.println("Фамилия клиента: ");
        buyer.setLastname(scanner.nextLine());
        System.out.println("Электронная почта: ");
        buyer.setEmail(scanner.nextLine());
        System.out.println("Количество денег: ");
        buyer.setMoney(Integer.parseInt(scanner.nextLine()));
        return buyer;
        
    } 
}
