package org.example;

import java.util.List;

public record Report(boolean isSafe, int errorIndex, List<Integer> levels) {
}
