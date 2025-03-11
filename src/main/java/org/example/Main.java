package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Producto> lstproductos = new ArrayList<>();
        Scanner consola = new Scanner(System.in);
        int a = 0;
        do {
            System.out.println("--- Menú de la Tienda ---");
            System.out.println(" ");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Vender Producto");
            System.out.println("3. Reponer Stock");
            System.out.println("4. Aplicar Descuento");
            System.out.println("5. Aumentar Precio");
            System.out.println("6. Mostrar Información de Productos");
            System.out.println("7. Calcular Valor Total del Inventario");
            System.out.println("8. Eliminar Producto por Código");
            System.out.println("9. Salir");
            Scanner teclado = new Scanner(System.in);
            a = teclado.nextInt();
            switch (a) {
                case 1:
                    System.out.print("¿Cuántos productos deseas ingresar? ");
                    int cantidadProductos = consola.nextInt();
                    consola.nextLine();

                    for (int i = 0; i < cantidadProductos; i++) {
                        System.out.println("Ingresando producto #" + (i + 1));

                        System.out.print("Código del producto: ");
                        String codigo = consola.nextLine();

                        System.out.print("Nombre del producto: ");
                        String nombre = consola.nextLine();

                        System.out.print("Precio del producto: ");
                        double precio = consola.nextDouble();
                        consola.nextLine();

                        System.out.print("Cantidad en stock: ");
                        int cantidad = consola.nextInt();
                        consola.nextLine();

                        Producto nuevoProducto = new Producto(codigo, nombre, precio, cantidad);
                        lstproductos.add(nuevoProducto);

                        System.out.println("Producto ingresado correctamente: " + nuevoProducto);
                    }
                    break;
                case 2:
                    System.out.print("\n¿Quieres vender algún producto? (Si/No): ");
                    String respuesta = consola.nextLine();
                    if (respuesta.equalsIgnoreCase("Si")) {
                        System.out.print("Introduce el código del producto a vender: ");
                        String codigoVender = consola.nextLine();
                        System.out.print("Cantidad a vender: ");
                        int cantidadVender = consola.nextInt();
                        consola.nextLine();

                        boolean productoVendido = false;
                        for (Producto producto : lstproductos) {
                            if (producto.getCodigoP().equals(codigoVender)) {
                                productoVendido = producto.venderProducto(cantidadVender);
                                break;
                            }
                        }

                        if (!productoVendido) {
                            System.out.println("No se pudo realizar la venta.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("\n¿Quieres reponer el stock de algún producto? (Si/No): ");
                    respuesta = consola.nextLine();
                    if (respuesta.equalsIgnoreCase("Si")) {
                        System.out.print("Introduce el código del producto a reponer: ");
                        String codigoReponer = consola.nextLine();
                        System.out.print("Cantidad a reponer: ");
                        int cantidadReponer = consola.nextInt();
                        consola.nextLine();

                        boolean productoRepuesto = false;
                        for (Producto producto : lstproductos) {
                            if (producto.getCodigoP().equals(codigoReponer)) {
                                producto.reponerStock(cantidadReponer);
                                productoRepuesto = true;
                                break;
                            }
                        }

                        if (!productoRepuesto) {
                            System.out.println("No se pudo reponer el stock.");
                        }
                    }
                    break;
                case 4:
                    System.out.print("\n¿Quieres aplicar un descuento a algún producto? (Si/No): ");
                    respuesta = consola.nextLine();
                    if (respuesta.equalsIgnoreCase("Si")) {
                        System.out.print("Introduce el código del producto al que aplicar descuento: ");
                        String codigoDescuento = consola.nextLine();
                        for (Producto producto : lstproductos) {
                            if (producto.getCodigoP().equals(codigoDescuento)) {
                                producto.aplicarDescuento(2);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("\nInformación de los productos en el inventario:");
                    for (Producto producto : lstproductos) {
                        producto.mostrarInformacion();
                    }
                    break;
                case 6:
                    System.out.print("\n¿Quieres aumentar el precio de algún producto? (Si/No): ");
                    respuesta = consola.nextLine();
                    if (respuesta.equalsIgnoreCase("Si")) {
                        System.out.print("Introduce el código del producto al que aumentar el precio: ");
                        String codigoAumentar = consola.nextLine();
                        for (Producto producto : lstproductos) {
                            if (producto.getCodigoP().equals(codigoAumentar)) {
                                producto.aumentarPrecio(6);
                            }
                        }
                    }
                    break;
                case 7:
                    double valorTotalInventario = 0;
                    for (Producto producto : lstproductos) {
                        valorTotalInventario += producto.calcularValorTotalInventario();
                    }
                    System.out.println("\nEl valor total del inventario es: " + valorTotalInventario);
                    break;
                case 8:
                    System.out.print("\n¿Quieres eliminar algún producto por código? (Si/No): ");
                    respuesta = consola.nextLine();
                    if (respuesta.equalsIgnoreCase("Si")) {
                        System.out.print("Introduce el código del producto a eliminar: ");
                        String codigoEliminar = consola.nextLine();
                        Producto.eliminarProductosPorCodigo(codigoEliminar, lstproductos);
                    }
                    break;
            }
        } while (a != 9);
    }
}