import com.sda.supermarket.order.persistence.dao.ProductDao;
import com.sda.supermarket.order.persistence.model.ProductModel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ProductDaoTest {

  private ProductDao productDao = new ProductDao();

  @Before
  public void clearFile() {
    productDao.setFileName("testProducts.txt");
  }

  @Test
  public void testAdd() {
    //before
    ProductModel produs = new ProductModel();
    produs.setPrice(2.3);
    //when
    productDao.add(produs);

    // after
    List<ProductModel> productsInFile = productDao.getAll();
    Assert.assertEquals(productsInFile.size(), 1);
  }


  @After
  public void afterTest() {

  }
}
