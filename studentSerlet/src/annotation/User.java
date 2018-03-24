package annotation;
@Table(name = "MyAnnotation")
public class User {

    @Cloumn(name= "name",type = "varchar",length = 10)
    String name;

    @Cloumn(name= "sex",type = "varchar",length = 10)
    String sex;

    User(String name,String sex)
    {
        this.name=name;
        this.sex=sex;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
