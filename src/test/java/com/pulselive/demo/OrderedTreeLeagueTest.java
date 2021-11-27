package com.pulselive.demo;

import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedTreeLeagueTest {

  @Test
  @DisplayName("Sanity test")
  public void test_00() {
    ICalculator calculator = new LeagueCalculator();
    Comparator<LeagueTableEntry> comparator = new LeagueComparator();

    OrderedTreeLeague orderedTreeLeague = new OrderedTreeLeague(calculator, comparator);

    Assertions.assertNotNull(orderedTreeLeague);
  }

  @Test
  @DisplayName("Add new match is added and the teams are not still stored. Expected: After " +
      "adding the match the tree should contain the teams information")
  public void test_01() {
    Comparator<LeagueTableEntry> comparator = new LeagueComparator();
    ICalculator calculator = new LeagueCalculator();

    String homeTeamName = "Team A";
    String awayTeamName = "Team B";
    OrderedTreeLeague orderedTreeLeague = new OrderedTreeLeague(calculator, comparator);

    Match match = new Match(homeTeamName, awayTeamName, 1, 3);

    orderedTreeLeague.addMatch(match);

    LeagueTableEntry homeEntry = orderedTreeLeague.get(homeTeamName);
    LeagueTableEntry awayEntry = orderedTreeLeague.get(awayTeamName);

    Assertions.assertNotNull(homeEntry);
    Assertions.assertNotNull(awayEntry);
  }

  @Test
  @DisplayName("Add new match is added and the teams are already stored. Expected: After " +
      "adding the match the tree should update the teams information")
  public void test_02() {
    Comparator<LeagueTableEntry> comparator = new LeagueComparator();
    ICalculator calculator = new LeagueCalculator();

    String teamA = "Team A";
    String teamB = "Team B";
    OrderedTreeLeague orderedTreeLeague = new OrderedTreeLeague(calculator, comparator);

    Match match1 = new Match(teamA, teamB, 1, 3);
    Match match2 = new Match(teamA, teamB, 2, 1);

    orderedTreeLeague.addMatch(match1);
    orderedTreeLeague.addMatch(match2);

    LeagueTableEntry entryA = orderedTreeLeague.get(teamA);
    LeagueTableEntry entryB = orderedTreeLeague.get(teamB);

    Assertions.assertNotNull(entryA);
    Assertions.assertEquals(teamA, entryA.getTeamName());
    Assertions.assertEquals(0, entryA.getDrawn());
    Assertions.assertEquals(-1, entryA.getGoalDifference());
    Assertions.assertEquals(4, entryA.getGoalsAgainst());
    Assertions.assertEquals(3, entryA.getGoalsFor());
    Assertions.assertEquals(1, entryA.getLost());
    Assertions.assertEquals(1, entryA.getWon());
    Assertions.assertEquals(2, entryA.getPlayed());
    Assertions.assertEquals(3, entryA.getPoints());


    Assertions.assertNotNull(entryB);
    Assertions.assertEquals(teamB, entryB.getTeamName());
    Assertions.assertEquals(0, entryB.getDrawn());
    Assertions.assertEquals(1, entryB.getGoalDifference());
    Assertions.assertEquals(3, entryB.getGoalsAgainst());
    Assertions.assertEquals(4, entryB.getGoalsFor());
    Assertions.assertEquals(1, entryB.getLost());
    Assertions.assertEquals(1, entryB.getWon());
    Assertions.assertEquals(2, entryB.getPlayed());
    Assertions.assertEquals(3, entryB.getPoints());

  }

  @Test
  @DisplayName("Add new match is added and one teams is already stored and the other not. " +
      "Expected: After " +
      "adding the match the tree should update the information of one team and the new team " +
      "should be stored")
  public void test_03() {
    ICalculator calculator = new LeagueCalculator();
    Comparator<LeagueTableEntry> comparator = new LeagueComparator();

    String teamA = "Team A";
    String teamB = "Team B";
    String teamC = "Team C";
    OrderedTreeLeague orderedTreeLeague = new OrderedTreeLeague(calculator, comparator);

    Match matchAB = new Match(teamA, teamB, 1, 3);
    Match matchAC = new Match(teamA, teamC, 3, 3);

    orderedTreeLeague.addMatch(matchAB);
    orderedTreeLeague.addMatch(matchAC);

    LeagueTableEntry entryA = orderedTreeLeague.get(teamA);
    LeagueTableEntry entryB = orderedTreeLeague.get(teamB);
    LeagueTableEntry entryC = orderedTreeLeague.get(teamC);

    Assertions.assertNotNull(entryA);
    Assertions.assertNotNull(entryB);
    Assertions.assertNotNull(entryC);
  }

  @Test
  public void test_algo() {
    ICalculator calculator = new LeagueCalculator();
    Comparator<LeagueTableEntry> comparator = new LeagueComparator();

    String teamA = "Team A";
    String teamB = "Team B";
    String teamC = "Team C";
    OrderedTreeLeague orderedTreeLeague = new OrderedTreeLeague(calculator, comparator);

    Match matchAB = new Match(teamA, teamB, 1, 3);
    Match matchAC = new Match(teamA, teamC, 3, 1);
    Match matchBC = new Match(teamB, teamC, 3, 3);

    orderedTreeLeague.addMatch(matchAB);
    orderedTreeLeague.addMatch(matchAC);
    orderedTreeLeague.addMatch(matchBC);

    System.out.println("List order: ---------> " + orderedTreeLeague.getList());
  }
}
