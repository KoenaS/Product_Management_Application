package productcrudapp_new2024.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import productcrudapp_new2024.dao.ProductDao;
import productcrudapp_new2024.entities.Product;

@Controller
public class MainController {
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/home")
	public String home(Model model) {
		List<Product> allProducts = productDao.getAllProducts();
		model.addAttribute("products", allProducts);
		return "home";
	}

	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.saveProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable int productId, HttpServletRequest request) {
		productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView; 
	}
	
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable int productId, Model model) {
		Product product = productDao.getProduct(productId);
		model.addAttribute("product", product);
		return "update_form"; 
	}
	
	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public RedirectView updatedProduct(@ModelAttribute Product product, HttpServletRequest request) {
		productDao.updateProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}

}
