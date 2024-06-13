package com.timeless.toyotaimdbtest.model;

import lombok.Data;

@Data
public class TitleRating {

    private String tconst;
    private double averageRating;
    private int numVotes;
    private double rankingScore;
}
