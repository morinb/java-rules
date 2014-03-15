package org.bm.rules.impl;

import com.google.common.collect.Maps;
import org.bm.rules.Engine;
import org.bm.rules.Entry;
import org.bm.rules.KeyPair;
import org.bm.rules.Result;
import org.bm.rules.Rule;
import org.bm.rules.Status;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Baptiste Morin
 */
public class ProceduralEngine implements Engine {


    @Override
    public Map<KeyPair<Entry, Rule>, Result> process(List<Entry> entries, List<Rule> rules) {
        Map<KeyPair<Entry, Rule>, Result> results = Maps.newLinkedHashMap();

        Collections.sort(rules);

        for (Entry entry : entries) {
            if(skipEmptyLines() && entry.getContent().isEmpty()) {
                continue;
            }
            for (Rule rule : rules) {
                Result result = rule.apply(entry);
                results.put(new KeyPairImpl<>(entry, rule), result);
                if(stopAfterFirstError() && result.isError()) {
                    return results;
                }
            }
        }
        return results;
    }

    @Override
    public boolean stopAfterFirstError() {
        return false;
    }

    @Override
    public boolean skipEmptyLines() {
        return true;
    }


}
