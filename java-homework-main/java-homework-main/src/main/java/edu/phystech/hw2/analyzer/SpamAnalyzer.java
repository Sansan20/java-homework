package edu.phystech.hw2.analyzer;

import java.util.List;

public class SpamAnalyzer extends KeywordAnalyzer {
    private static final List<String> EMPTY_SMILES = List.of();
    public SpamAnalyzer(List<String> keywords) {
        super(keywords, Label.SPAM, EMPTY_SMILES);
    }
}
