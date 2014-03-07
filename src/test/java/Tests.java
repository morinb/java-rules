import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.bm.rules.Engine;
import org.bm.rules.Entry;
import org.bm.rules.KeyPair;
import org.bm.rules.Result;
import org.bm.rules.Rule;
import org.bm.rules.RuleLoader;
import org.bm.rules.impl.GroovyRulesLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;

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

   @Autowired
   private ApplicationContext context;

   @Test
   public void firstTest() {
      assertEquals("2.0 = 2.0", 2.0, 2.0, 0.001);
   }


   @Test
   public void testKeyPair() {
      KeyPair<String, String> key1 = new KeyPair<String, String>("first", "second");
      KeyPair<String, String> key2 = new KeyPair<String, String>("first", "second");

      assertEquals(key1, key2);

      assertEquals("firset", key1.getFirst());
      assertEquals("second", key1.getSecond());

   }

   @Test
   public void testRulesLoading() throws IllegalAccessException, IOException, InstantiationException, URISyntaxException {

      URL url = getClass().getResource("rules"); // Search in resources/rules directory

      File directory = new File(url.toURI());

      RuleLoader grl = new GroovyRulesLoader(new File[]{directory});

      Collection<Rule> rules = grl.load();

      assertNotNull("The loaded rules collection is null.", rules);
      assertNotNull("Directory should not be empty", directory.listFiles());
      assertEquals("There is not as much Rules as script in the directory", directory.listFiles().length, rules.size());

   }

   @Test
   public void testSpringIoC() {
      assertNotNull("engine should not be null.", engine);
      assertNotNull("context should not be null", context);
   }

   @Test
   public void testEngine() {

      try {
         Entry sampleEntry = (Entry) context.getBean("test-Entry");
         Collection<Rule> sampleRules =  ((RuleLoader) context.getBean("test-RuleLoader")).load();

         Map<KeyPair<Entry,Rule>,Result> results = engine.process(Lists.newArrayList(sampleEntry), sampleRules);


         assertNotNull(results);
         Rule rule = sampleRules.iterator().next();

         KeyPair<Entry, Rule> kp = new KeyPair<Entry, Rule>(sampleEntry, rule);

         Result result = results.get(kp);
         assertNotNull(result);

         assertEquals("SimpleRule severity should have been 0", 0,  result.getStatus().getSeverity());


      } catch (IOException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (InstantiationException e) {
         e.printStackTrace();
      }

   }
}
