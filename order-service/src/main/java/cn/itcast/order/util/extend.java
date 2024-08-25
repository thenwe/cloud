package cn.itcast.order.util;
interface fatherMethod {
    void toSaying();
}
public abstract class extend implements fatherMethod{
    private String name;

    abstract void amethod();

    static int y = 1;

    void showy() {
        System.out.println("y" + y);
    }

    extend() {

    }
}

class son extends extend {
    static int y = 1;

    @Override
    void amethod() {

    }

    void showy() {
        System.out.println("y" + y);
    }

    private String department;

    son() {

    }

    public String toSay() {
        return "name";
    }

    public void modify() {
        int i, j, k = 0;
        i = 100;
        while (i > 0) {
            j = i * 2;
            k = k + 1;
            i--;
        }
    }

    @Override
    public void toSaying() {

    }
}

class test {
    public static void main(String[] args) {
        son e = new son();
        //son.y+=1;
        e.y++;
        e.showy();
    }
}