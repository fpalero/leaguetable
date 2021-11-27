package com.pulselive.demo;

import java.util.List;

public class LeagueTable {
  private OrderedTreeLeague orderedTreeLeague = null;

  public LeagueTable(final List<Match> matches) {

    this.orderedTreeLeague = new OrderedTreeLeague(
        new LeagueCalculator(),
        new LeagueComparator()
    );

    matches.forEach(match -> this.orderedTreeLeague.addMatch(match));
  }

  /**
   * Get the ordered list of league table entries for this league table.
   * @return list of {@link LeagueTableEntry}
   */
  public List<LeagueTableEntry> getTableEntries() {
    return this.orderedTreeLeague.getList();
  }
}
