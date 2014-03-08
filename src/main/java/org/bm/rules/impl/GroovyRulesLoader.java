package org.bm.rules.impl;

import com.google.common.collect.Lists;
import groovy.lang.GroovyClassLoader;
import org.bm.rules.Rule;
import org.bm.rules.RuleLoader;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author Baptiste Morin
 */
public class GroovyRulesLoader implements RuleLoader {

   private final FileFilter GROOVY_SCRIPT_FILE_FILTER = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
         return pathname.getName().endsWith(".groovy");
      }
   };
   private final File[] groovyClassDirectories;

   public GroovyRulesLoader(File[] groovyClassDirectories) {
      this.groovyClassDirectories = groovyClassDirectories;
   }


   @Override
   public Collection<Rule> load() throws IOException, IllegalAccessException, InstantiationException {

      GroovyClassLoader ccl = new GroovyClassLoader(getClass().getClassLoader());

      List<Rule> rules = Lists.newArrayList();

      for (File groovyClassDirectory : groovyClassDirectories) {
         for (File groovyScript : groovyClassDirectory.listFiles(GROOVY_SCRIPT_FILE_FILTER)) {

            Class groovyClass = ccl.parseClass(groovyScript);

            if (Rule.class.isAssignableFrom(groovyClass)) {
               Rule rule = (Rule) groovyClass.newInstance();
               rules.add(rule);
            }
         }
      }

      return rules;
   }
}
