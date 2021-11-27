package com.pulselive.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Demo implements CommandLineRunner {

  private List<Match> generateRandomMatches() {
    List<Match> matches = new LinkedList<>();
    Random r = new Random(System.currentTimeMillis());
    r.nextInt(6);

    for (int i = 1; i <= 20; i++) {
      for (int j = 1; j <= 20; j++) {

        if (i != j) {
          String homeTeam = "Team " + i;
          int homeScore = r.nextInt(6);
          String awayTeam = "Team " + j;
          int awayScore = r.nextInt(6);

          matches.add(
              new Match(
                  homeTeam,
                  awayTeam,
                  homeScore,
                  awayScore));
        }

      }

    }
    return matches;
  }

  @Override
  public void run(String... args) throws Exception {
    List<Match> matches = generateRandomMatches();

    LeagueTable leagueTable = new LeagueTable(matches);

    System.out.println("======= League Results ========");
    System.out.print(leagueTable.getTableEntries());
  }
}
