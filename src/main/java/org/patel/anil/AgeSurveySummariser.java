package org.patel.anil;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AgeSurveySummariser {
    public static void main(String[] args) {
        List<Integer> ageSurveyReported = List.of(23, 44, 56, 44, 34, 53, 45, 44, 56, 45, 34, 45, 55, 34, 67, 45);
        System.out.println(maximumNumberOfAgReported(ageSurveyReported, 2));
        System.out.println(maximumNumberOfAgReported(ageSurveyReported, 4));
    }

    /**
     * Find the maximum age (numbers) reportd in survey.
     *
     * @param ageSurveyReported the age numbers reported in survey.
     * @param n                 the number of age required.
     * @return the top list of ages reported in survey.
     */
    private static List<Integer> maximumNumberOfAgReported(List<Integer> ageSurveyReported, int n) {
        Map<Integer, Long> agesCounts = ageSurveyReported.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("map created = "+agesCounts);
        return agesCounts.entrySet().stream().sorted((e1 , e2) -> {
            if(e1.getValue() > e2.getValue()) {
                return -1;
            }
            if(e1.getValue() < e2.getValue()){
                return 1;
            }
            // e1 and e2 has same value. So, check for key.
            if(e1.getKey() > e2.getKey()) {
                return -1;
            }
            return 0;

        }).limit(n).map(entrySet -> entrySet.getKey()).collect(Collectors.toList());
    }
}
