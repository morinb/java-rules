package org.bm.rules.impl;

import java.util.Collection;
import java.util.Map;

import org.bm.rules.Engine;
import org.bm.rules.Entry;
import org.bm.rules.KeyPair;
import org.bm.rules.Result;
import org.bm.rules.Rule;

import com.google.common.collect.Maps;

/**
 * @author Baptiste Morin
 */
public class ProceduralEngine implements Engine {
   @Override
   public Map<KeyPair<Entry, Rule>, Result> process(Collection<Entry> entries, Collection<Rule> rules) {

      Map<KeyPair<Entry, Rule>, Result> results = Maps.newHashMap();

      for(Entry entry : entries) {
         for(Rule rule : rules) {

            Result result = rule.apply(entry);
            results.put(new KeyPair<Entry, Rule>(entry, rule), result);

         }

      }

      return results;
   }

   @Override
   public boolean stopAfterFirstError() {
      return false;
   }
}
