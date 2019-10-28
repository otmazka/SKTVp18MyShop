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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sveta
 */
public class SaveToFile implements Saveble{
    @Override
    public void saveProducts(List<Product> listProducts){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("Products.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listProducts);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: на диске нет файла Products.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка: записать в файл не удалось");
        } finally{
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка освобождения ресурса oos", ex);
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка освобождения ресурса fos", ex);
                }
            }
        }
    }
    @Override
    public List<Product> loadProducts(){
        List<Product> listProducts = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("Products.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listProducts = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: не найден файл Products.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка: чтение файла Products.txt не удaлось");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ошибка: нет класса Products");
        }finally{
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listProducts;
    }   
    @Override
    public void saveBuyers(List<Buyer> listBuyers){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("Buyers.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listBuyers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: на диске нет файла Buyers.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка: записать в файл не удалось");
        } finally{
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка освобождения ресурса oos", ex);
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка освобождения ресурса fos", ex);
                }
            }
        }
    }
    @Override
    public List<Buyer> loadBuyers(){
        List<Buyer> listBuyers = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("Buyers.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listBuyers = (List<Buyer>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: не найден файл Buyers.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка: чтение файла Buyers.txt не удолось");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ошибка: нет класса Buyers");
        }finally{
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listBuyers;
    }   
    @Override
    public void saveHistories(List<History> listHistories) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("Histories.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listHistories);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: на диске нет файла Histories.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка: записать в файл не удалось");
        } finally{
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка освобождения ресурса oos", ex);
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, "Ошибка освобождения ресурса fos", ex);
                }
            }
        }
    }

 
    @Override
    public List<History> loadHistories() {
        List<History> listHistories = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("Histories.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listHistories = (List<History>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: не найден файл Histories.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка: чтение файла Histories.txt не удолось");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ошибка: нет класса History");
        }finally{
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listHistories;
    }
}
