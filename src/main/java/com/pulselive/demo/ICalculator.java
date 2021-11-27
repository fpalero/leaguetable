package com.pulselive.demo;

/**
 * This interface defines the methods used for the OrderedTreeLeague to recover home and away
 * teams data.
 */
public interface ICalculator {

  /**
   * Calculate the league match data for the home team.
   * @param match contains the {@link Match} data
   * @return {@link LeagueTableEntry}
   */
  LeagueTableEntry getHomeEntry(Match match);

  /**
   * Calculate the league match data for the away team.
   * @param match contains the {@link Match} data
   * @return {@link LeagueTableEntry}
   */
  LeagueTableEntry getAwayEntry(Match match);

  /**
   * Calculate the league match data for the home team and update previous results.
   * @param match contains the {@link Match} data
   * @param homeEntry contains the previous league results
   * @return {@link LeagueTableEntry}
   */
  LeagueTableEntry getHomeEntry(Match match, LeagueTableEntry homeEntry);

  /**
   * Calculate the league match data for the home team and update previous results.
   * @param match contains the {@link Match} data
   * @param awayEntry contains the previous league results
   * @return {@link LeagueTableEntry}
   */
  LeagueTableEntry getAwayEntry(Match match, LeagueTableEntry awayEntry);
}
