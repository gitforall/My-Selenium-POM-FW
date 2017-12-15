package unit_test;

class Rectangle {
    int length;
    int width;

    Rectangle(int l, int b) {
        this.length = l;
        this.width = b;
        System.out.println(length);
        System.out.println(width);
       
    }
    
    void test(){
    	System.out.println("test");
    }

    void area(Rectangle r1) {
    	int sum = length + width ;
    	System.out.println("sum = " + sum);
        int areaOfRectangle = length * width;
        System.out.println("Area of Rectangle : " 
                                + areaOfRectangle);
        
        
    }
}
