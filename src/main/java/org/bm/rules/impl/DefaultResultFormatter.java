package org.bm.rules.impl;

import org.bm.rules.Entry;
import org.bm.rules.KeyPair;
import org.bm.rules.Result;
import org.bm.rules.ResultFormatter;
import org.bm.rules.Rule;

/**
 * @author Baptiste Morin
 */
public class DefaultResultFormatter implements ResultFormatter {
   @Override
   public String format(Result result) {
      StringBuilder sb = new StringBuilder();

      KeyPair<Entry,Rule> entryRuleKeyPair = result.getEntryRuleKeyPair();
      sb.append("Result for \n\tEntry (").append(entryRuleKeyPair.getFirst().toString()).append("),\n\tRule (").append(entryRuleKeyPair.getSecond().toString()).append(")\n");
      sb.append("\tStatus:\tseverity=").append(result.getStatus().getSeverity()).append("\n");
      sb.append("\t\t\t\tdescription=").append(result.getStatus().getDescription()).append("\n");
      sb.append("\t\t\t\tpossible resolution=").append(result.getStatus().getPossibleResolution()).append("\n");




      return sb.toString();
   }
}
