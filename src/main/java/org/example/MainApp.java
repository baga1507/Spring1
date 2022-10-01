package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.example");
        Scanner in = new Scanner(System.in);
        Cart cart = applicationContext.getBean(Cart.class);
        boolean work = true;

        System.out.println("Список команду - /help");
        while (work) {
            System.out.println("Введите комманду: ");
            String[] command = in.nextLine().split(" ");
            switch (command[0]) {
                case ("/help"): System.out.println("Добавить продукт в корзину - /add *id продукта*");
                    System.out.println("Убрать продукт из корзины - /delete *id продукта*");
                    System.out.println("Список продуктов - /list");
                    System.out.println("Список продуктов в корзине - /cartList");
                    System.out.println("Новая корзина - /new");
                    System.out.println("Завершить выполнение программы - /end");
                    break;
                case ("/add"): cart.addToCart(Long.parseLong(command[1]));
                    break;
                case ("/delete"): cart.discardFromCart(Long.parseLong(command[1]));
                    break;
                case ("/new"): cart = applicationContext.getBean(Cart.class);
                    break;
                case ("/list"): cart.printProducts();
                    break;
                case ("/cartList"): cart.printCartList();
                    break;
                case ("/end"): work = false;
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }
}
