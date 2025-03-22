/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    private double[] marks;
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }
    
    /**
    *number 13   
    * Return the number of accesses recorded in the log file. */ 
    public int numberOfAccesses() { 
        int total = 0;
        // Add the value in each element of hourCounts to // total. ...
        for( int counts : hourCounts)
        {
            total+=counts;
        }
        return total; 
    }
    
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    /**
     * Code for #10
     */
    public void printHourlyCounts2()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while(hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
       /** * Print all the values in the marks array that are greater than mean.
     * @param marks An array of mark values.
     * @param mean The mean (average) mark. */ 
        public void printGreater(double mean) { 
        double[] marks= {1.1, 5.7, 6.6, 9.2,18.4};
        for(int index = 0; index < marks.length; index++) {
            if(marks[index] > mean) {
                System.out.println(marks[index]);
            } 
        } 
    }
    
    /**
     * number 15
     */
    public int busiestHour()
    {
        int maxCount = 0;
        int busiestHour = 0;
        for(int i = 0; i < hourCounts.length; i++){
            if (hourCounts[i] > maxCount) {
                maxCount = hourCounts[i];
                busiestHour = i;
            }
        }
        return busiestHour;
    }
    
     /**
     * number 16
        */
    public int quietestHour()
    {
        int minCount = Integer.MAX_VALUE;
        int quietestHour = 0;
        for (int i = 0; i < hourCounts.length; i++){
            if (hourCounts[i] < minCount) {
                minCount = hourCounts[i];
                quietestHour = i;
            }
        }
        return quietestHour;
    }
    
    
    /**
     * number 18
     */
    public int busiestTwoHour2()
    {
        int maxSum = 0;
        int busiestStartHour = 0;
        for (int i = 0; i < hourCounts.length - 1;i++){
            int twoHourSum = hourCounts[i] + hourCounts[i+1];
            if(twoHourSum > maxSum){
                maxSum = twoHourSum;
                busiestStartHour = i;
            }
        }
        return busiestStartHour;
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    /**
     * 1. It is 18,with 237
     * 2. Person[] people;
     * 3. Boolean[] vacant;
     * 4. it is used in the two methods analyzeHourlyData() and printHourlyCounts()
     * 5. int[] counts; / boolean[] occupied; 
     * 6. a) readings = new double[60] b) urls = new String[90] c) machines = new TicketMachine[5]
     * 7. none
     * 8. double[] prices = new double[50];
     * 9. an error appears saying the index is out of bounds for the length 24
     * 17. The hour that appears first with the largest count
     */
}

