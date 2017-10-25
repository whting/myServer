
public class DBEntryDemo {

    public static void main(String[] args) {
        TableNameEntry tableNameEntry = new TableNameEntry();
        tableNameEntry.setName("lx");
        System.out.println(tableNameEntry.getName());// null
        System.out.println(tableNameEntry.getAge());// 0

        /* ??:???new?????,??update???,???????age????0??????????.*/
        // TableNameService.update(tableNameEntry);// getDB?????????,???????DB???????
    }
}

class TableNameEntry {
    private int id;
    private String name;
    private Long age = 0L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}