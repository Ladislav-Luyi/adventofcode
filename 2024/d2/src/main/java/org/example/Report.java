package org.example;

import java.util.List;

public record Report(boolean isSafe, boolean isFixable, int errorIndex, List<Integer> levels) {
}
