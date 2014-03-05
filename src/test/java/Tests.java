import org.junit.Assert;
import org.junit.Test;

/**
 * @author Baptiste Morin
 */
public class Tests {

   @Test
   public void firstTest() {
      Assert.assertEquals("2.0 = 2.0", 2.0, 2.0, 0.001);
   }

}
