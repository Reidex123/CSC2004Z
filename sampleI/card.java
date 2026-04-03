package sampleI;

// representaion of a card
public class card {
    private String shape;
    private String color;
    private String pattern;

    public card(String[] cardAttributes) {

        this.shape = cardAttributes[0];
        this.color = cardAttributes[1];
        this.pattern = cardAttributes[2];
    }

    public String getShape() {
        return this.shape;
    }

    public String getColor() {
        return this.color;
    }

    public String getPattern() {
        return this.pattern;
    }

    // Two cards are distinct if they do not have the same shape or colour or pattern i.e. none of their attributes match.
    public boolean equals(card other) {
        return (this.getShape().equals(other.getShape()) && this.getColor().equals(other.getColor()))
                && this.getPattern().equals(other.getPattern());
    }

    public boolean equals(card other1, card other2) {

        boolean threeSameShape = (this.getShape().equals(other1.getShape())
                && this.getShape().equals(other2.getShape())) && other1.getShape().equals(other2.getShape());

        boolean threeSameColor = (this.getColor().equals(other1.getColor())
                && this.getColor().equals(other2.getColor())) && other1.getColor().equals(other2.getColor());

        boolean threeSamePattern = (this.getPattern().equals(other1.getPattern())
                && this.getPattern().equals(other2.getPattern())) && other1.getPattern().equals(other2.getPattern());

        if (threeSameShape && !(threeSameColor && threeSamePattern)) {
            return true;
        }

        if (threeSameColor && !(threeSameShape && threeSamePattern)) {
            return true;
        }

        return threeSamePattern && !(threeSameShape && threeSameColor);
    }

}
