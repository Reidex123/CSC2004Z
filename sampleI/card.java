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

    public boolean equal(card other) {
        return this.getShape().equals(other.getShape()) && this.getColor().equals(other.getColor())
                && this.getPattern().equals(other.getPattern());
    }

    // Two cards are distinct if they do not have the same shape or colour or pattern i.e. none of their attributes match.
    public boolean distinct(card other) {
        return !this.getShape().equals(other.getShape()) && !this.getColor().equals(other.getColor())
                && !this.getPattern().equals(other.getPattern());
    }

    // A set of three cards is valid if it consists of (i) three distinct cards, or (ii) three of the same card.
    public boolean equals(card other1, card other2) {

        boolean identical = this.equal(other1) && this.equal(other2);

        boolean notIdentical = this.distinct(other1) && this.distinct(other2) && other1.distinct(other2);

        return identical || notIdentical;
    }

}
