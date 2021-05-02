package logic;

import data.ProductData;
import entities.Product;
import java.util.ArrayList;

public class ProductsLogic {

    private ProductData pd = new ProductData();

    public ArrayList<Product> getAllProducts(){

        ArrayList<Product> products = new ArrayList<Product>();
        products = pd.getAllProducts();

        return products;
    }

    public Product getAProduct(Product product){
        pd.getOneProduct(product);
        return product;
    }

    public Product createProduct(Product product){

        pd.createProduct(product);

        return product;
    }

    public void deleteProduct(Product product){
            pd.deleteProduct(product);
    }

    public void updateProduct(Product product){
            pd.updateProduct(product);
    }

}
