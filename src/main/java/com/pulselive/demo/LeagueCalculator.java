package com.pulselive.demo;

public class LeagueCalculator implements ICalculator {


  @Override public LeagueTableEntry getHomeEntry(Match match) {

    return createLeagueEntryTable(
        match.getHomeTeam(),
        match.getHomeScore(),
        match.getAwayScore()
    );
  }

  @Override public LeagueTableEntry getAwayEntry(Match match) {
    return createLeagueEntryTable(
        match.getAwayTeam(),
        match.getAwayScore(),
        match.getHomeScore()
    );
  }

  @Override public LeagueTableEntry getHomeEntry(Match match, LeagueTableEntry homeEntry) {
    return updateEntry(
        homeEntry,
        getHomeEntry(match)
    );
  }

  @Override public LeagueTableEntry getAwayEntry(Match match, LeagueTableEntry awayEntry) {
    return updateEntry(
        awayEntry,
        getAwayEntry(match)
    );
  }

  private LeagueTableEntry updateEntry(LeagueTableEntry entry, LeagueTableEntry newEntryData) {

    entry.setPlayed(entry.getPlayed() + newEntryData.getPlayed());
    entry.setWon(entry.getWon() + newEntryData.getWon());
    entry.setDrawn(entry.getDrawn() + newEntryData.getDrawn());
    entry.setLost(entry.getLost() + newEntryData.getLost());
    entry.setGoalsFor(entry.getGoalsFor() + newEntryData.getGoalsFor());
    entry.setGoalsAgainst(entry.getGoalsAgainst() + newEntryData.getGoalsAgainst());
    entry.setGoalDifference(entry.getGoalDifference() + newEntryData.getGoalDifference());
    entry.setPoints(entry.getPoints() + newEntryData.getPoints());

    return entry;
  }

  private LeagueTableEntry createLeagueEntryTable(String teamName, int teamAscore, int teamBscore) {
    return new LeagueTableEntry(teamName,
        1, // This is always 1, because every time a match is played a new Match entry is added
        isWin(teamAscore, teamBscore),
        isDrawn(teamAscore, teamBscore),
        isLost(teamAscore, teamBscore),
        teamAscore,
        teamBscore,
        getGoalDifference(teamAscore, teamBscore),
        calculatePoints(teamAscore, teamBscore)
    );
  }

  private int getGoalDifference(int scoreTeamA, int scoreTeamB) {
    return scoreTeamA - scoreTeamB;
  }

  private int isWin(int scoreTeamA, int scoreTeamB) {
    return scoreTeamA > scoreTeamB ? 1 : 0;
  }

  private int isLost(int scoreTeamA, int scoreTeamB) {
    return scoreTeamA < scoreTeamB ? 1 : 0;
  }

  private int isDrawn(int scoreTeamA, int scoreTeamB) {
    return scoreTeamA == scoreTeamB ? 1 : 0;
  }

  private int calculatePoints(int scoreTeamA, int scoreTeamB) {
    int points = 0;

    if (scoreTeamA > scoreTeamB) {
      points = 3;
    } else if (scoreTeamA == scoreTeamB) {
      points = 1;
    }
    return points;
  }
}
