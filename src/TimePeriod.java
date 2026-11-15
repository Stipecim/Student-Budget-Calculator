public enum TimePeriod {
    WEEKLY(52),
    MONTHLY(12),
    YEARLY(1);
    
    final int value;
    TimePeriod(int value) {
        
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
