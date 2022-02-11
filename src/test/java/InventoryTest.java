import com.techelevator.Chips;
import com.techelevator.Inventory;
import com.techelevator.Product;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;
import java.util.TreeMap;

public class InventoryTest {

    @Test
    public void loadInventory() throws Exception {

        Inventory inventory = new Inventory();

        Assert.assertEquals(0, inventory.getInventory().size());

        inventory.loadInventory();

        Assert.assertEquals(16, inventory.getInventory().size());

        Product product = inventory.getInventory().get("A1");

        Assert.assertEquals("Potato Crisps", product.getName());

        product = inventory.getInventory().get("B2");
        Assert.assertEquals(150, product.getPrice());


//        TreeMap<String, String> expected = new TreeMap<>();
//        expected.put("A1", null);
//


    }

}
