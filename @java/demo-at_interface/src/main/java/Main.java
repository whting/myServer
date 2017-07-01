public class Main {

    public static void main(String[] args) {
//        Class clazz = MyDescriptionHandle.class;
//        if(clazz.isAnnotationPresent(Description.class)){
//            Description desc = (Description)clazz.getAnnotation(Description.class);
//            System.out.println("desc.author:" + desc.author());
//            System.out.println("desc.size:" + desc.size());
//        }else{
//            System.out.println("没有在DescriptionTest上使用注解!");
//        }
        MyDescriptionHandle myDescriptionHandle = new MyDescriptionHandle();
        myDescriptionHandle.handle("liuxiang",18);

        MyDescriptionHandleCglib cglib = new MyDescriptionHandleCglib();
        MyDescriptionHandle myDescriptionHandleCglib = (MyDescriptionHandle) cglib.getInstance(new MyDescriptionHandle());
        myDescriptionHandleCglib.handle("liuxiang",18);
    }
}
