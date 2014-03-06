import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;

import org.bm.rules.Engine;
import org.bm.rules.KeyPair;
import org.bm.rules.Rule;
import org.bm.rules.impl.GroovyRulesLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Baptiste Morin
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context-for-tests.xml"})
public class Tests {

   @Autowired
   private Engine engine;

   @Test
   public void firstTest() {
      assertEquals("2.0 = 2.0", 2.0, 2.0, 0.001);
   }


   @Test
   public void testKeyPair() {
      KeyPair<String, String> key1 = new KeyPair<String, String>("first", "second");
      KeyPair<String, String> key2 = new KeyPair<String, String>("first", "second");

      assertEquals(key1, key2);

      assertEquals("first", key1.getFirst());
      assertEquals("second", key1.getSecond());

   }

   @Test
   public void testRulesLoading() throws IllegalAccessException, IOException, InstantiationException, URISyntaxException {

      URL url = getClass().getResource("rules"); // Search in resources/rules directory

      File directory = new File(url.toURI());

      GroovyRulesLoader grl = new GroovyRulesLoader(new File[]{directory});

      Collection<Rule> rules = grl.load();

      assertNotNull("The loaded rules collection is null.", rules);
      assertNotNull("Directory should not be empty", directory.listFiles());
      assertEquals("There is not as much Rules as script in the directory", directory.listFiles().length, rules.size());

   }

   @Test
   public void testSpringIoC() {
      assertNotNull("engine should not be null.", engine);

   }


}
