package org.example;

import java.util.List;

public class Producto {
    private String codigoP;
    private String nombreP;
    private double precioP;
    private int cantidadP;

    public Producto() {
    }

    public Producto(String codigoP, String nombreP, double precioP, int cantidadP) {
        this.codigoP = codigoP;
        this.nombreP = nombreP;
        this.precioP = precioP;
        this.cantidadP = cantidadP;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(double precioP) {
        this.precioP = precioP;
    }

    public int getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadP = cantidadP;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoP=" + codigoP +
                ", nombreP='" + nombreP + '\'' +
                ", precioP=" + precioP +
                ", cantidadP=" + cantidadP +
                '}';
    }

    public boolean venderProducto(int cantidad) {
        if (cantidad <= cantidadP) {
            cantidadP -= cantidad;
            System.out.println("Se vendieron " + cantidad + " unidades de " + nombreP);
            return true;
        } else {
            System.out.println("No tenemos suficiente inventario para vender " + cantidad+" unidades de "+nombreP);
            return false;
        }
    }

    public void reponerStock(int cantidad){
        cantidadP+=cantidad;
        System.out.println("Se han adicionado "+cantidad+" unidades de "+nombreP+" en el stock");
    }

    public void aplicarDescuento(double porcentaje){
        double descuento = (precioP*0.02);
        precioP -= descuento;
        System.out.println("El precio de " + nombreP + " se ha reducido en " + porcentaje + "%"+
                "\n Su nuevo precio es: "+ precioP);
    }

    public void mostrarInformacion(){
        System.out.println("Codigo: "+codigoP);
        System.out.println("Nombre: "+nombreP);
        System.out.println("Precio: "+precioP);
        System.out.println("Cantidad: "+cantidadP);

    }

    public void aumentarPrecio(double porcentaje){
        double incremento =(precioP*0.06);
        precioP += incremento;
        System.out.println("El precio de "+ nombreP+ " ha sido incrementado en: "+porcentaje+"%"
                +"\n El nuevo precio es: "+precioP);
    }

    public double calcularValorTotalInventario(){
        return precioP*cantidadP;
    }

    public static boolean eliminarProductosPorCodigo(String codigo, List<Producto> productos) {
        for (Producto producto : productos) {
            if (producto.getCodigoP() == codigo) {
                productos.remove(producto);
                System.out.println("El producto con codigo " + codigo + " ha sido eliminado");
                return true;
            }
        }
        System.out.println("El producto con codigo "+codigo+" no se encuentra en el inventario");
        return false;
    }
}
