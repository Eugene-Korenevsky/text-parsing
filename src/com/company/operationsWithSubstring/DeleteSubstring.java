package com.company.operationsWithSubstring;

public class DeleteSubstring {

    public String deleteSubstring(String string, char first, char second) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        int start;
        int end;
        start = string.indexOf(first);
        end = string.lastIndexOf(second) + 1;
        if (start < end && start > 0) {
            stringBuilder.delete(start, end);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
