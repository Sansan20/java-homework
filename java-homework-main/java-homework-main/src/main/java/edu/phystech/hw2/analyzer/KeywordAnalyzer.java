package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    private final List<String> keywords;
    private final Label label;

    public KeywordAnalyzer(List<String> keywords, Label label) {
        this.keywords = keywords;
        this.label = label;
    }

    @Override
    public Label processText(String text) {
        var words = text.split(" ");
        for (String word : words) {
            if (keywords.contains(word)) {
                return label;
            }
        }
        return Label.OK;
    }
}
