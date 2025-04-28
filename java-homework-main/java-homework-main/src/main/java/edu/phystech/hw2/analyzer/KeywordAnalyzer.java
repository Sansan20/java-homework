package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    private final List<String> keywords;
    private final List<String> negativeSmiles;
    private final Label label;

    public KeywordAnalyzer(List<String> keywords, Label label, List<String> negativeSmiles) {
        this.keywords = keywords;
        this.label = label;
        this.negativeSmiles = negativeSmiles;
    }

    @Override
    public Label processText(String text) {
        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            if (keywords.stream().anyMatch(keyword -> keyword.equalsIgnoreCase(word))) {
                return label;
            }
        }
        if (text.endsWith(":||")) {
            return Label.OK;
        }

        for (String smile : negativeSmiles) {
            if (text.contains(smile)) {
                return Label.NEGATIVE;
            }
        }

        return Label.OK;
    }
}
