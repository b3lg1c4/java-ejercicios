package data;

import entities.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductData {

    private void setProductAttributes(Product product, ResultSet rs) {
        try {
            product.setProductId(rs.getInt("product_id"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setProductName(rs.getString("product_name"));
            product.setProductStock(rs.getInt("product_stock"));
            product.setProductDescription(rs.getString("product_description"));
            product.setShippingIncluded(rs.getBoolean("product_shippingIsIncluded"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn;
        DbConnection instance = DbConnection.getDbInstance();
        try {
            conn = instance.getConn();
            rs = conn.prepareStatement("SELECT * FROM products").executeQuery();
            while (rs.next()) {
                Product product = new Product();
                setProductAttributes(product, rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                instance.releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;

    }

    public Product getOneProduct(Product product) {
        DbConnection instance = DbConnection.getDbInstance();
        Connection conn = instance.getConn();
        ResultSet rs = null;
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("SELECT * FROM products WHERE product_id = ?");
            statement.setInt(1, product.getProductId());
            rs = statement.executeQuery();
            if (rs.next()) {
                setProductAttributes(product, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                instance.releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public Product createProduct(Product product) {

        DbConnection instance = DbConnection.getDbInstance();
        Connection conn = instance.getConn();
        ResultSet rs = null;
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement("INSERT INTO products (product_name,product_description," +
                    "product_price,product_stock,product_shippingIsIncluded) VALUES (" +
                    "?,?,?,?,?)", statement.RETURN_GENERATED_KEYS);

            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductDescription());
            statement.setDouble(3, product.getProductPrice());
            statement.setInt(4, product.getProductStock());
            statement.setBoolean(5, product.isShippingIncluded());
            int rowCount = statement.executeUpdate();
            if (rowCount == 1) {
                rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    product.setProductId(rs.getInt(1));
                }
            } else {
                throw new SQLException("No se pudo agregar el registro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                instance.releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

    public void deleteProduct(Product product) {
        DbConnection instance = DbConnection.getDbInstance();
        Connection conn = instance.getConn();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("DELETE FROM products WHERE product_id = ?");
            statement.setInt(1, product.getProductId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                instance.releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateProduct(Product product){
        DbConnection instance = DbConnection.getDbInstance();
        Connection conn = instance.getConn();
        PreparedStatement statement = null;

        try{
            statement = conn.prepareStatement("UPDATE products SET product_name=?,product_description= ?," +
                    "product_price=?,product_stock=?,product_shippingIsIncluded=? WHERE product_id = ?");
            statement.setString(1,product.getProductName());
            statement.setString(2,product.getProductDescription());
            statement.setDouble(3,product.getProductPrice());
            statement.setInt(4,product.getProductStock());
            statement.setBoolean(5,product.isShippingIncluded());
            statement.setInt(6,product.getProductId());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                instance.releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
