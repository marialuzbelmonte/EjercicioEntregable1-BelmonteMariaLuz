package org.app;

import org.app.Logic.Payment.*;
import org.app.Logic.Shipping.*;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****************** Datos del pago ******************");

        System.out.println("Ingrese el monto a pagar:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese el proveedor de pago (paypal o mercadopago):");
        String provider = scanner.nextLine().toLowerCase();

        System.out.println();

        System.out.println("****************** Datos del envio ******************");

        // Datos del envío
        System.out.println("Ingrese el peso del paquete (en kg):");
        double weight = scanner.nextDouble();

        System.out.println("Ingrese el ancho del paquete (en cm):");
        double width = scanner.nextDouble();
        System.out.println("Ingrese el alto del paquete (en cm):");
        double height = scanner.nextDouble();
        System.out.println("Ingrese largo del paquete (en cm):");
        double length = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Ingrese origen:");
        String origin = scanner.nextLine();

        System.out.println("Ingrese destino:");
        String destination = scanner.nextLine();

        System.out.println("Ingrese el metodo de envio (air, truck, boat):");
        String shippingMethod = scanner.nextLine().toLowerCase();

        scanner.close();

        System.out.println();
        System.out.println("********************************************************");

        CompletableFuture<Double> shippingCostFuture = CompletableFuture.supplyAsync(() -> {
            Dimensions dimensions = new Dimensions(height, width, length);
            ShippingStrategy strategy;

            switch (shippingMethod) {
                case "air":
                    strategy = new AirShippingStrategy();
                    break;
                case "truck":
                    strategy = new TruckShippingStrategy();
                    break;
                case "boat":
                    strategy = new BoatShippingStrategy();
                    break;
                default:
                    throw new IllegalArgumentException("Metodo invalido");
            }

            ShippingRequest shippingRequest = new ShippingRequest(weight, dimensions, origin, destination);
            ShippingCalculator calculator = new ShippingCalculator(shippingRequest, strategy);
            double cost = calculator.calculateCost();
            System.out.println("Costo de envio: $" + cost);
            return cost;
        });

        CompletableFuture<Void> paymentFuture = shippingCostFuture.thenAcceptAsync(shippingCost -> {
            double totalAmount = amount + shippingCost;
            PaymentRequest paymentRequest = new PaymentRequest(totalAmount, provider);
            PaymentManager paymentManager = new PaymentManager();
            paymentManager.processPayment(paymentRequest);
        });

        paymentFuture.join();

        System.out.println("*************** Pago y envio completados ***************");
    }
}