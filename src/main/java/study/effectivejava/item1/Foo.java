package study.effectivejava.item1;

import java.util.EnumSet;

import static study.effectivejava.item1.Project.MES4;


public class Foo {

    String name;

    String address;

    public Foo(){

    }

    public static final Foo SINGLE_TONE = new Foo();

    public static Foo getFoo(){
        return SINGLE_TONE;
    }

    public static Foo getFoo(boolean getSon) {
        return getSon ? new Bar() : new Foo();
    } 

    public static Foo getFooByChildClass(String fullPackageName) {
        Foo foo = null;
        try {
            Class<?> clildClass = Class.forName(fullPackageName);
            Object o = clildClass.getConstructors()[0].newInstance(null);
            foo = (Foo) o;
        } catch (Exception e){
            // 에러
        }
        return foo;
    }

    public static Foo withName(String s) {
        //Foo foo = new Foo();
        Foo foo = Foo.getFoo();
        foo.name = s;
        return foo;
    }

    public static Foo withAddress(String s) {
        Foo foo = new Foo();
        foo.address = s;
        return foo;
    }

    public static void main(String[] args) {
        Foo fooWithName = Foo.withName("이름");
        Foo fooWithAddress = Foo.withAddress("주소");
        Foo foodWithName2 = Foo.withName("이름2");

        System.out.println("getFoo 사용 : " +fooWithName.equals(foodWithName2));
        System.out.println("getFoo 마사용 : " +fooWithAddress.equals(foodWithName2));

        EnumSet<Project> projects = EnumSet.allOf(Project.class);
        EnumSet<Project> mes4 = EnumSet.of(MES4);

        Foo getSon = Foo.getFoo(true);
        Foo getParent = Foo.getFoo(false);

        System.out.println(getSon instanceof Bar);
        System.out.println(getParent instanceof Foo);


        Foo fooByChildClass = Foo.getFooByChildClass("_2_Creating_Destorying_Object.item1.Bar");

        System.out.println(fooByChildClass);


    }

}
