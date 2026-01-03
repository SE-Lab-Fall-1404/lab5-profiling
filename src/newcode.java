import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Optimized String Processor
 * 
 * This class demonstrates performance optimization through profiling.
 * The original implementation used string concatenation with += operator
 * in loops, which created excessive String objects and caused memory issues.
 * 
 * Optimizations applied:
 * 1. Replaced string concatenation (+=) with StringBuilder
 * 2. Pre-allocated ArrayList capacity to avoid dynamic resizing
 * 3. Used char arrays for direct character access
 * 4. Implemented batch processing for better memory locality
 */
public class OptimizedStringProcessor {
    private static final int DATA_SIZE = 10000;
    private static final int BATCH_SIZE = 100;
    
    public static void main(String[] args) {
        System.out.println("Starting optimized string processing...");
        List<String> results = processDataOptimized();
        System.out.println("Processing completed. Results: " + results.size());
    }
    
    /**
     * Optimized version of processData() method.
     * 
     * Original implementation issues:
     * - Used String concatenation with += operator, creating new String objects in each iteration
     * - ArrayList without initial capacity caused multiple resize operations
     * 
     * Optimizations:
     * - Uses StringBuilder with pre-allocated capacity
     * - Pre-allocates ArrayList capacity
     * - Uses char array for direct character access
     */
    private static List<String> processDataOptimized() {
        List<String> data = generateDataOptimized();
        List<String> results = new ArrayList<>(DATA_SIZE);
        
        for (String str : data) {
            StringBuilder processed = new StringBuilder(str.length() * 2);
            
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                processed.append(chars[i]);
                
                if (i % 3 == 0 && i != chars.length - 1) {
                    processed.append('-');
                }
            }
            results.add(processed.toString());
        }
        
        return results;
    }
    
    /**
     * Generates test data with optimizations:
     * - Pre-allocated ArrayList capacity
     * - Uses char array instead of String.charAt() for better performance
     * - Batch processing for improved memory locality
     * - Pre-allocated StringBuilder capacity
     */
    private static List<String> generateDataOptimized() {
        List<String> data = new ArrayList<>(DATA_SIZE);
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] charArray = characters.toCharArray();
        
        for (int i = 0; i < DATA_SIZE; i += BATCH_SIZE) {
            int batchEnd = Math.min(i + BATCH_SIZE, DATA_SIZE);
            List<String> batch = new ArrayList<>(BATCH_SIZE);
            
            for (int j = i; j < batchEnd; j++) {
                int length = 50 + random.nextInt(50);
                StringBuilder sb = new StringBuilder(length);
                
                for (int k = 0; k < length; k++) {
                    sb.append(charArray[random.nextInt(charArray.length)]);
                }
                batch.add(sb.toString());
            }
            
            data.addAll(batch);
        }
        
        return data;
    }
}