package com.example;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Category electronics = new Category("Електроніка");
        Category clothing = new Category("Одяг");

        Product laptop = new Product(1, "Ноутбук", 999.99, "Потужний ноутбук для всіх ваших потреб", electronics);
        Product tShirt = new Product(2, "Футболка", 19.99, "Зручна бавовняна футболка", clothing);
        Product smartphone = new Product(3, "Смартфон", 699.99, "Смартфон високого класу з розширеними функціями", electronics);
        Product jeans = new Product(4, "Джинси", 39.99, "Класичні джинси для повсякденного носіння", clothing);

        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);
        User currentUser = new User();
        int choice;
        do {
            System.out.println("1. Переглянути каталог товарів");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Переглянути вміст кошика");
            System.out.println("4. Видалити товар із кошика");
            System.out.println("5. Оформити замовлення");
            System.out.println("6. Переглянути історію замовлень");
            System.out.println("7. Вийти");
            System.out.print("Виберіть дію: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Каталог товарів:");
                    for (Product product : Arrays.asList(laptop, tShirt, smartphone, jeans)) {
                        System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice() + " - "
                                + product.getCategory().getName());
                    }
                    break;
                case 2:
                    System.out.print("Введіть ID товару, який ви бажаєте додати до кошика: ");
                    int productId = scanner.nextInt();
                    Product selectedProduct = getProductById(productId, laptop, tShirt, smartphone, jeans);
                    if (selectedProduct != null) {
                        cart.addProduct(selectedProduct);
                        System.out.println(selectedProduct.getName() + " успішно доданий до кошика.");
                    } else {
                        System.out.println("Товар із таким ID не знайдено.");
                    }
                    break;
                case 3:
                    System.out.println("Вміст кошика:");
                    for (Product product : cart.getProducts()) {
                        System.out.println(product.getName() + " - $" + product.getPrice() + " - "
                                + product.getCategory().getName());
                    }
                    break;
                case 4:
                    System.out.print("Введіть ID товару, який ви бажаєте видалити з кошика: ");
                    int removeProductId = scanner.nextInt();
                    cart.removeProduct(removeProductId);
                    break;
                case 5:
                    Order order = new Order(new ArrayList<>(cart.getProducts()));
                    currentUser.addOrder(order);
                    System.out.println("Замовлення оформлене!");
                    cart.getProducts().clear();
                    break;
                case 6:
                    System.out.println("Історія замовлень:");
                    List<Order> orders = currentUser.getOrderHistory().getOrders();
                    for (int i = 0; i < orders.size(); i++) {
                        System.out.println("№" + (i + 1) + " Замовлення:");
                        List<Product> products = orders.get(i).getProducts();
                        for (int j = 0; j < products.size(); j++) {
                            System.out.println((j + 1) + ". " + products.get(j).getName());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Вихід із програми.");
                    break;
                default:
                    System.out.println("Неправильне введення. Спробуйте знову.");
            }
        } while (choice != 7);

        scanner.close();
    }

    public static Product getProductById(int id, Product... products) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
