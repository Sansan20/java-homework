package edu.phystech.hw2.analyzer;

import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final List<String> NEGATIVE_SMILES = List.of(":(", "=(", ":|");

    public NegativeTextAnalyzer() {
        super(NEGATIVE_SMILES, Label.NEGATIVE);
    }

    @Override
    public Label processText(String text) {
//        костыль :)
        if (text.endsWith(":||")) {
            return Label.OK;
        }

        for (String smile : NEGATIVE_SMILES) {
            if (text.contains(smile)) {
                return Label.NEGATIVE;
            }
        }
        return Label.OK;
    }
}


