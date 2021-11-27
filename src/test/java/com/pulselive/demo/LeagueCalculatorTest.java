package com.pulselive.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LeagueCalculatorTest {

  @Test
  @DisplayName("Sanity test")
  public void test_00() {
    ICalculator calculator = new LeagueCalculator();

    Assertions.assertNotNull(calculator);
  }

  @Test
  @DisplayName("Create Home League Table Entry, expected a new entry with the values correctly " +
      "calculated")
  public void test_01() {
    String homeTeamName = "Team A";
    String awayTeamName = "Team B";

    ICalculator calculator = new LeagueCalculator();
    Match match = new Match(homeTeamName, awayTeamName, 1, 3);

    LeagueTableEntry entry = calculator.getHomeEntry(match);

    Assertions.assertEquals(homeTeamName, entry.getTeamName());
    Assertions.assertEquals(0, entry.getDrawn());
    Assertions.assertEquals(-2, entry.getGoalDifference());
    Assertions.assertEquals(3, entry.getGoalsAgainst());
    Assertions.assertEquals(1, entry.getGoalsFor());
    Assertions.assertEquals(1, entry.getLost());
    Assertions.assertEquals(0, entry.getWon());
    Assertions.assertEquals(1, entry.getPlayed());
    Assertions.assertEquals(0, entry.getPoints());
  }

  @Test
  @DisplayName("Create Away League Table Entry, expected a new entry with the values correctly " +
      "calculated")
  public void test_02() {
    String homeTeamName = "Team A";
    String awayTeamName = "Team B";

    ICalculator calculator = new LeagueCalculator();
    Match match = new Match(homeTeamName, awayTeamName, 1, 3);

    LeagueTableEntry entry = calculator.getAwayEntry(match);

    Assertions.assertEquals(awayTeamName, entry.getTeamName());
    Assertions.assertEquals(0, entry.getDrawn());
    Assertions.assertEquals(2, entry.getGoalDifference());
    Assertions.assertEquals(1, entry.getGoalsAgainst());
    Assertions.assertEquals(3, entry.getGoalsFor());
    Assertions.assertEquals(0, entry.getLost());
    Assertions.assertEquals(1, entry.getWon());
    Assertions.assertEquals(1, entry.getPlayed());
    Assertions.assertEquals(3, entry.getPoints());
  }

  @Test
  @DisplayName("Create Away League Table Entry, expected a new entry with the values correctly " +
      "calculated when the match is drawn.")
  public void test_03() {
    String homeTeamName = "Team A";
    String awayTeamName = "Team B";

    ICalculator calculator = new LeagueCalculator();
    Match match = new Match(homeTeamName, awayTeamName, 1, 1);

    LeagueTableEntry entry = calculator.getAwayEntry(match);

    Assertions.assertEquals(awayTeamName, entry.getTeamName());
    Assertions.assertEquals(1, entry.getDrawn());
    Assertions.assertEquals(0, entry.getGoalDifference());
    Assertions.assertEquals(1, entry.getGoalsAgainst());
    Assertions.assertEquals(1, entry.getGoalsFor());
    Assertions.assertEquals(0, entry.getLost());
    Assertions.assertEquals(0, entry.getWon());
    Assertions.assertEquals(1, entry.getPlayed());
    Assertions.assertEquals(1, entry.getPoints());
  }

  @Test
  @DisplayName("Update Home League Table Entry, expected an updated entry with the values " +
      "correctly calculated")
  public void test_04() {
    String homeTeamName = "Team A";
    String awayTeamName = "Team B";

    ICalculator calculator = new LeagueCalculator();

    // First mach played
    Match match1 = new Match(homeTeamName, awayTeamName, 1, 3);
    LeagueTableEntry entry = calculator.getHomeEntry(match1);

    // Second mach played
    Match match2 = new Match(homeTeamName, awayTeamName, 2, 1);
    LeagueTableEntry entryUpdated = calculator.getHomeEntry(match2, entry);

    Assertions.assertEquals(homeTeamName, entryUpdated.getTeamName());
    Assertions.assertEquals(0, entryUpdated.getDrawn());
    Assertions.assertEquals(-1, entryUpdated.getGoalDifference());
    Assertions.assertEquals(4, entryUpdated.getGoalsAgainst());
    Assertions.assertEquals(3, entryUpdated.getGoalsFor());
    Assertions.assertEquals(1, entryUpdated.getLost());
    Assertions.assertEquals(1, entryUpdated.getWon());
    Assertions.assertEquals(2, entryUpdated.getPlayed());
    Assertions.assertEquals(3, entryUpdated.getPoints());
  }

  @Test
  @DisplayName("Update Away League Table Entry, expected an updated entry with the values " +
      "correctly calculated")
  public void test_05() {
    String homeTeamName = "Team A";
    String awayTeamName = "Team B";

    ICalculator calculator = new LeagueCalculator();

    // First mach played
    Match match1 = new Match(homeTeamName, awayTeamName, 1, 3);
    LeagueTableEntry entry = calculator.getAwayEntry(match1);

    // Second mach played
    Match match2 = new Match(homeTeamName, awayTeamName, 2, 1);
    LeagueTableEntry entryUpdated = calculator.getAwayEntry(match2, entry);

    Assertions.assertEquals(awayTeamName, entryUpdated.getTeamName());
    Assertions.assertEquals(0, entryUpdated.getDrawn());
    Assertions.assertEquals(1, entryUpdated.getGoalDifference());
    Assertions.assertEquals(3, entryUpdated.getGoalsAgainst());
    Assertions.assertEquals(4, entryUpdated.getGoalsFor());
    Assertions.assertEquals(1, entryUpdated.getLost());
    Assertions.assertEquals(1, entryUpdated.getWon());
    Assertions.assertEquals(2, entryUpdated.getPlayed());
    Assertions.assertEquals(3, entryUpdated.getPoints());
  }

  @Test
  @DisplayName("Update Away League Table Entry, expected an updated entry with the values " +
      "correctly calculated when the match is drawn")
  public void test_06() {
    String homeTeamName = "Team A";
    String awayTeamName = "Team B";

    ICalculator calculator = new LeagueCalculator();

    // First mach played
    Match match1 = new Match(homeTeamName, awayTeamName, 1, 3);
    LeagueTableEntry entry = calculator.getAwayEntry(match1);

    // Second mach played
    Match match2 = new Match(homeTeamName, awayTeamName, 2, 2);
    LeagueTableEntry entryUpdated = calculator.getAwayEntry(match2, entry);

    Assertions.assertEquals(awayTeamName, entryUpdated.getTeamName());
    Assertions.assertEquals(1, entryUpdated.getDrawn());
    Assertions.assertEquals(2, entryUpdated.getGoalDifference());
    Assertions.assertEquals(3, entryUpdated.getGoalsAgainst());
    Assertions.assertEquals(5, entryUpdated.getGoalsFor());
    Assertions.assertEquals(0, entryUpdated.getLost());
    Assertions.assertEquals(1, entryUpdated.getWon());
    Assertions.assertEquals(2, entryUpdated.getPlayed());
    Assertions.assertEquals(4, entryUpdated.getPoints());
  }
}
