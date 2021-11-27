package com.pulselive.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class OrderedTreeLeague extends TreeMap<String, LeagueTableEntry> {

  private ICalculator calculator;
  private Comparator<LeagueTableEntry> comparator;
  private boolean isUpdated = false;
  private List<LeagueTableEntry> listLeague;


  public OrderedTreeLeague(
      ICalculator calculator,
      Comparator<LeagueTableEntry> comparator) {
    this.calculator = calculator;
    this.comparator = comparator;
    this.listLeague = new LinkedList<>();
  }


  /**
   * addMatch calculates the for the home team and for the away the values:
   * - total points
   * - goal difference
   * - goals scored
   * - team name
   * After the calculation a new entries are created for the home team and the away team. If
   * already exist an entry of the teams this one is updated with the new match information.
   * @param match has the result of the teams match.
   */
  public void addMatch(Match match) {
    //Create new entries
    LeagueTableEntry homeTeamEntry = getHomeEntry(match);
    LeagueTableEntry awayTeamEntry = getAwayEntry(match);

    // Add or update entries
    this.put(match.getHomeTeam(), homeTeamEntry);
    this.put(match.getAwayTeam(), awayTeamEntry);

    this.isUpdated = true;
  }

  public List<LeagueTableEntry> getList() {

    if(this.isUpdated) {
      this.listLeague.clear();
      this.listLeague.addAll(this.values());
      this.listLeague.sort(this.comparator);

      this.isUpdated = false;

    }

    return listLeague;
  }

  private LeagueTableEntry getAwayEntry(Match match) {
    LeagueTableEntry entry = this.get(match.getAwayTeam());

    return (entry == null) ?
        this.calculator.getAwayEntry(match) :
        this.calculator.getAwayEntry(match, entry);
  }

  private LeagueTableEntry getHomeEntry(Match match) {
    LeagueTableEntry entry = this.get(match.getHomeTeam());

    return (entry == null) ?
        this.calculator.getHomeEntry(match) :
        this.calculator.getHomeEntry(match, entry);
  }
}
