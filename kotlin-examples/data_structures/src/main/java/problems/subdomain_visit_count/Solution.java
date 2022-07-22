package problems.subdomain_visit_count;

import java.util.*;

class Solution {
    private String concateStrings(String[] strings) {
        StringBuilder output = new StringBuilder(strings[0]);
        if (strings.length > 1) {
            for (int i = 1; i < strings.length; i++) {
                output.append(".").append(strings[i]);
            }
        }
        return output.toString();
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> cpMap = new HashMap<>();

        for (String string: cpdomains) {
            String[] arr = string.split(" ");
            int count = Integer.parseInt(arr[0]);
            String[] domainStrings = arr[1].split("\\.");
            for (int i=0; i<domainStrings.length; i++) {
                String key = concateStrings(Arrays.copyOfRange(domainStrings, i, domainStrings.length));
                cpMap.put(key, cpMap.getOrDefault(key, 0) + count);
            }
        }

        for (Map.Entry<String, Integer> entry: cpMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
