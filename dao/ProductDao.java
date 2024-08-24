package productcrudapp_new2024.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp_new2024.entities.Product;

@Repository
public class ProductDao {

	@Autowired
	public HibernateTemplate hibernateTemplate;

	// Save or Add the product in the database
	@Transactional
	public void saveProduct(Product product) {
		this.hibernateTemplate.save(product);
	}

	// Get a single product
	public Product getProduct(int productId) {
		Product product = this.hibernateTemplate.get(Product.class, productId);
		return product;
	}

	// Get all products
	public List<Product> getAllProducts() {
		List<Product> allProducts = this.hibernateTemplate.loadAll(Product.class);
		return allProducts;
	}

	// Delete a single product
	@Transactional
	public void deleteProduct(int productId) {
		Product prod = this.hibernateTemplate.load(Product.class, productId);
		this.hibernateTemplate.delete(prod);
	}

	// Update a single product
	@Transactional
	public void updateProduct(Product product) {
		System.out.println(product);
		this.hibernateTemplate.update(product);
	}

}
