package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com os dados do cliente: ");
        System.out.println("Nome: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client cliente = new Client(name, email, birthDate);

        System.out.println(cliente);

        System.out.println("Entre com os dados do pedido");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, cliente);

        System.out.println("Quantos itens para esse pedido? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            System.out.println("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Preço do produto: ");
            Double productPrice = sc.nextDouble();

            Product produto = new Product(productName, productPrice);

            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, produto);

            order.addItem(orderItem);

        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);



    }

}
