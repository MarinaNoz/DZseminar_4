//Написать программу позволяющую ввести разнотипные данные пользователей, такие как ФИО, возраст, пол итд. Хранение данных организовать в списках. 
//После ввода программа сортирует пользователей по возрасту и выводит отсортированный список на экран.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        LinkedList<Integer> id = new LinkedList<>();
        
        boolean exit = true;
        //int count = 0;
        while(exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            name.add(scanner.nextLine());
           System.out.println("Enter age: ");
           age.add(scanner.nextInt());
           id.add(name.size() -1);
          
           System.out.println("Выйти? y/n");
           scanner.nextLine();
           String ex = scanner.nextLine();
           if (ex.equals("y")) {
            exit = false;
           }
        }
        System.out.println("Список до сортировки:");
        for (int i = 0; i < id.size(); i++) {
            System.out.println(id.get(i) + " " + name.get(id.get(i)) + " " + age.get(id.get(i)));
        }
        //сортируем пользователей по возрасту
        System.out.println("Отсортированный список по возрасту");
        
        int count = id.size() - 1; // в count индекс последнего в списке индентификаторов
        while (count > -1) {
            int maxAge = age.get(id.get(count)); //взяли последний в возрасте
            int index = count;

            for (int i = 0; i < count; i++) { //циклом проходимся от первого до предпоследнего
                int j = id.get(i);
                if (maxAge < age.get(id.get(i))) { // если возраст меньше, то делаем равным и смещаем
                    index = i;
                    maxAge = age.get(id.get(i));
                } 
            }
            int temp = id.get(index); //меняем значение в списке идентификаторов, сортируем указатели на массивы 
            id.set(index, id.get(count));
            id.remove(count);
            id.add(temp);
            count--;
        }
        for (int i = 0; i < id.size(); i++) {

            System.out.println(id.get(i) + " " + name.get(id.get(i)) + " " + age.get(id.get(i)));
            
        } 
        }
    }

