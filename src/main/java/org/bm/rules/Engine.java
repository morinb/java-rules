package org.bm.rules;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * An Engine is the core of the Rules processing.
 *
 * @author Baptiste Morin
 */
public interface Engine {
    Logger LOG = Logger.getLogger(Engine.class);


    /**
     * Process the entries by applying rules on them.
     * The method return a <code>Map&lt;KeyPair&lt;Entry, Rule&gt;, Result&gt;</code>.
     * <p/>
     * <p><b>Rules will be sorted internally.</b></p>
     *
     * @param entries <code>Collection&lt;Entry&gt;</code> contains the entries to be checked.
     * @param rules   <code>Collection&lt;Rule&gt;</code> the rules to apply on entries
     * @return <code>Map&lt;KeyPair&lt;Entry, Rule&gt;, Result&gt;</code> applies rules on entries and produces results.
     */
    Map<KeyPair<Entry, Rule>, Result> process(List<Entry> entries, List<Rule> rules);

    /**
     * Flag to let the engine knows if it should stop after first error or not.
     *
     * @return <code>true</code> if the engine should stop after first error.
     */
    boolean stopAfterFirstError();

    /**
     * Flag to let the engine knows if it should skip empty lines or not.
     * @return <code>true</code> if the engine should skip empty lines.
     */
    boolean skipEmptyLines();
}
