package main.java;

/**
 * Created by ali on 05/03/15.
 */
enum BanksConfig {
    HSBC("HSBC Canada", 0, 1),
    ROYAL("Royal Bank of Canada", 0, 4),
    AMERICAN("American Express", 15, 17);

    private final String name;
    private final int startPosition;
    private final int endPosition;

    BanksConfig(String name, int startPosition, int endPosition) {
        this.name = name;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public String getName() {
        return name;
    }

}