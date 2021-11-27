package com.pulselive.demo;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LeagueTableTest {

  @Test
  @DisplayName("Sanity test")
  public void test_00() {
    LeagueTable table = new LeagueTable(
        new LinkedList<>()
    );

    Assertions.assertNotNull(table);
  }

  @Test
  @DisplayName("Add a list of matches and check the queue values")
  public void test_01() {
    String teamA = "Team A";
    String teamB = "Team B";
    String teamC = "Team C";

    Match matchAB = new Match(teamA, teamB, 1, 3);
    Match matchAC = new Match(teamA, teamC, 3, 1);
    Match matchBC = new Match(teamB, teamC, 3, 3);

    List<Match> matches = new LinkedList<>();
    matches.add(matchAB);
    matches.add(matchAC);
    matches.add(matchBC);

    LeagueTable table = new LeagueTable(matches);

    List<LeagueTableEntry> orderedEntries = table.getTableEntries();

    // Verify the team are ordered correctly: TeamB, TeamA, TeamC
    Assertions.assertEquals(teamB, orderedEntries.get(0).getTeamName());
    Assertions.assertEquals(teamA, orderedEntries.get(1).getTeamName());
    Assertions.assertEquals(teamC, orderedEntries.get(2).getTeamName());
  }
}
