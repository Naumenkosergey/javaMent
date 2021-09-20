package module3oop.filtertexttask;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract Label getLabel();

    protected abstract String[] getKeywords();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}
