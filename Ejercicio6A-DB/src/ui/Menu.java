package ui;

import entities.Product;
import logic.ProductsLogic;

import java.lang.reflect.Array;
import java.util.*;

public class Menu {

    private boolean exit = false;
    private Scanner input = new Scanner(System.in);
    private ProductsLogic pl = new ProductsLogic();

    public void init() {
        do {
            String command = readCommand();
            executeCommand(command);
        } while (!exit);
    }

    private String readCommand() {
        System.out.println("COMANDOS");
        System.out.println();
        System.out.println("list -> Listar todos los productos");
        System.out.println("search -> Buscar un producto");
        System.out.println("new -> Cargar un producto");
        System.out.println("delete -> Borrar un producto");
        System.out.println("update -> Actualizar un producto");
        System.out.println("exit -> Salir del programa");
        System.out.println();
        System.out.print("Elija una opción: ");
        String option = input.nextLine();

        return option;
    }

    private void executeCommand(String command) {
        switch (command) {
            case "exit":
                close();
                break;
            case "list":
                showAllProducts();
                break;
            case "search":
                showAProduct();
                break;
            case "new":
                insertProduct();
                break;
            case "delete":
                deleteProduct();
                break;
            case "update":
                updateProduct();
                ;
                break;

        }
    }

    private void close() {
        exit = true;
        input.close();
    }

    private void showAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        products = pl.getAllProducts();

        for (Product pr : products) {
            System.out.println(pr);
        }
    }

    private void showAProduct() {
        Product product = new Product();
        System.out.println();
        System.out.print("ID del producto a buscar: ");
        product.setProductId(Integer.parseInt(input.nextLine()));

        System.out.println(pl.getAProduct(product));

    }

    private void insertProduct() {
        Product product = new Product();
        System.out.println();
        System.out.print("Ingrese nombre del producto: ");
        product.setProductName(input.nextLine());
        System.out.println();
        System.out.print("Ingrese descripción del producto: ");
        product.setProductDescription(input.nextLine());
        System.out.println();
        System.out.print("Ingrese precio del producto: ");
        product.setProductPrice((Double.parseDouble(input.nextLine())));
        System.out.println();
        System.out.print("Ingrese stock del producto: ");
        product.setProductStock(Integer.parseInt(input.nextLine()));
        product.setShippingIncluded(getBooleanAnswer("El producto incluye envíos"));

        pl.createProduct(product);

        System.out.println(product);


    }

    private void deleteProduct() {
        Product product = new Product();
        System.out.println();
        System.out.print("Ingrese id del producto a eliminar: ");
        product.setProductId(Integer.parseInt(input.nextLine()));
        pl.deleteProduct(product);

    }

    private void updateProduct() {
        Product product = new Product();
        System.out.println();
        System.out.print("ID del producto a actualizar: ");
        product.setProductId(Integer.parseInt(input.nextLine()));
        pl.getAProduct(product);
        updateProductMenu(product);
        pl.updateProduct(product);
    }

    private void updateProductMenu(Product product) {
        String changingAttribute = "";
        boolean keepModifying = true;
        HashMap<String, String> attributes = new HashMap<String, String>();
        ArrayList<String> attributesKeys = new ArrayList<String>();
        do {
            initializeAttributes(attributes, product);
            changingAttribute = selectAttribute(attributes, attributesKeys);
            updateAttribute(changingAttribute, product);
            System.out.println();
            keepModifying = getBooleanAnswer("Desea seguir modificando atributos");
        } while (keepModifying);


    }

    private void initializeAttributes(HashMap<String, String> attributes, Product product) {
        attributes.put("name", product.getProductName());
        attributes.put("description", product.getProductDescription());
        attributes.put("price", Double.toString(product.getProductPrice()));
        attributes.put("stock", Integer.toString(product.getProductStock()));
        attributes.put("shipping", (product.isShippingIncluded() ? "SI" : "NO"));
    }

    private String selectAttribute(HashMap<String, String> attributes, ArrayList<String> attributesKeys) {
        String changingAttribute = "";
        do {
            for (Map.Entry<String, String> element : attributes.entrySet()) {
                attributesKeys.add(element.getKey());
                System.out.println(element.getKey() + " --> " + element.getValue());
            }
            System.out.println();
            System.out.print("Ingrese el atributo a modificar: ");
            changingAttribute = input.nextLine();
        }
        while (!attributesKeys.contains(changingAttribute));

        return changingAttribute;
    }

    private void updateAttribute(String attribute, Product product) {
        String value = "";
        boolean shippingValue = product.isShippingIncluded();
        System.out.println();
        if (attribute.equals("shipping")) {
            shippingValue = getBooleanAnswer("El producto incluye envíos");
        } else {
            System.out.print("Ingrese nuevo valor para " + attribute + ": ");
            value = input.nextLine();
        }

        switch (attribute) {
            case "name":
                product.setProductName(value);
                break;
            case "description":
                product.setProductDescription(value);
                break;
            case "price":
                product.setProductPrice(Double.parseDouble(value));
                break;
            case "stock":
                product.setProductStock(Integer.parseInt(value));
                break;
            case "shipping":
                product.setShippingIncluded(shippingValue);
                break;

        }
    }

    private boolean getBooleanAnswer(String question) {
        String answer = "";
        do {
            System.out.print(question + "? S/N: ");
            answer = input.nextLine();
            answer = answer.toUpperCase();
        } while (!(answer.equals("S")) && !(answer.equals("N")));

        return answer.equals("S");
    }


}


