package org.rest.quest.domain.init.wrapper;

/**
 * @author Roman Uholnikov
 */
public class MottoComparisonWrapper {
    private int motto1;
    private int motto2;

    public MottoComparisonWrapper(final int motto1, final int motto2) {
        this.motto1 = motto1;
        this.motto2 = motto2;
    }

    public MottoComparisonWrapper() {
    }

    public int getMotto1() {
        return motto1;
    }

    public void setMotto1(final int motto1) {
        this.motto1 = motto1;
    }

    public int getMotto2() {
        return motto2;
    }

    public void setMotto2(final int motto2) {
        this.motto2 = motto2;
    }

    @Override
    public String toString() {
        return "{" +
                "\"motto1\"=\"" + motto1 +
                "\",\"" +
                " \"motto2\"=\"" + motto2 +
                "\"}";
    }
}
