import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringProcessor {
    private static final int DATA_SIZE = 10000;
    
    public static void main(String[] args) {
        System.out.println("Starting string processing...");
        List<String> results = processData();
        System.out.println("Processing completed. Results: " + results.size());
    }
    
    private static List<String> processData() {
        List<String> data = generateData();
        List<String> results = new ArrayList<>();
        
        // this part
        for (String str : data) {
            String processed = "";
            for (int i = 0; i < str.length(); i++) {
                processed += str.charAt(i);
                
                if (i % 3 == 0) {
                    processed += "-";
                }
            }
            results.add(processed);
        }
        
        return results;
    }
    
    private static List<String> generateData() {
        List<String> data = new ArrayList<>();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        for (int i = 0; i < DATA_SIZE; i++) {
            int length = 50 + random.nextInt(50); // رشته‌های 50 تا 100 کاراکتری
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }
            data.add(sb.toString());
        }
        
        return data;
    }
}