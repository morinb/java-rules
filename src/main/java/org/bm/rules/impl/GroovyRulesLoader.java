package org.bm.rules.impl;

import com.google.common.collect.Lists;
import groovy.lang.GroovyClassLoader;
import org.bm.rules.Rule;
import org.bm.rules.RuleLoader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
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
    protected ApplicationContext context;


    public GroovyRulesLoader(File[] groovyClassDirectories) {
        this.groovyClassDirectories = groovyClassDirectories;
    }

    @Override
    public List<Rule> load() throws IOException, IllegalAccessException, InstantiationException {

        GroovyClassLoader ccl = new GroovyClassLoader(getClass().getClassLoader());

        List<Rule> rules = Lists.newArrayList();

        for (File groovyClassDirectory : groovyClassDirectories) {
            for (File groovyScript : groovyClassDirectory.listFiles(GROOVY_SCRIPT_FILE_FILTER)) {

                Class groovyClass = ccl.parseClass(groovyScript);

                if (Rule.class.isAssignableFrom(groovyClass)) {
                    Rule rule = (Rule) groovyClass.newInstance();
                    rule.setApplicationContext(context);
                    rules.add(rule);
                }
            }
        }

        return rules;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
