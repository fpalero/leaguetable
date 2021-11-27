package com.pulselive.demo;

import java.util.Comparator;

public class LeagueComparator
    implements Comparator<LeagueTableEntry> {


  @Override public int compare(LeagueTableEntry o1, LeagueTableEntry o2) {
    // This comparator calculates the ascending order
    int result = Comparator
        .comparing(LeagueTableEntry::getPoints)
        .thenComparingInt(LeagueTableEntry::getGoalDifference)
        .thenComparingInt(LeagueTableEntry::getGoalsFor)
        .compare(o1, o2);

    // To make the descendant order it's necessary change the signe
    result *= -1;

    return (result != 0) ? result :
        Comparator.comparing(LeagueTableEntry::getTeamName).compare(o1, o2);
  }
}
