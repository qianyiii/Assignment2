public class DiplomaData {
    private String category;
    private String name;
    private int total;
    private int max;
    private int min;
    // Parameterized Constructor
    public DiplomaData(String program,String course,int sumIntake,int maxNum,int minNum){
        this.category = program;
        this.name = course;
        this.total = sumIntake;
        this.max = maxNum;
        this.min = minNum;
    }

    // Getters and setters
    public String getCategory(){
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Program = "+category+", Course = "+name+", Sum of Intakes = "+total+", Maximum Number of Intakes = "+max+", Minimum Number of Intakes = "+min;
    }
}
