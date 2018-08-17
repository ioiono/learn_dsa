package fmt.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    private Map<String, Integer> map = new HashMap<>(); // msg : lst print timestamp
    private int limiter = 10;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {

    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false. If this method
     * returns false, the message will not be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            if (timestamp - map.get(message) >= limiter) {
                map.put(message, timestamp);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

// logging string "foo" at timestamp 1
        logger.shouldPrintMessage(1, "foo");

// logging string "bar" at timestamp 2
        logger.shouldPrintMessage(2, "bar");

// logging string "foo" at timestamp 3
        logger.shouldPrintMessage(3, "foo");

// logging string "bar" at timestamp 8
        logger.shouldPrintMessage(8, "bar");

// logging string "foo" at timestamp 10
        logger.shouldPrintMessage(10, "foo");

// logging string "foo" at timestamp 11
        logger.shouldPrintMessage(11, "foo");
    }
}
