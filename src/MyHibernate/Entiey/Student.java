package MyHibernate.Entiey;

import MyHibernate.Column;
import MyHibernate.Table;

@Table(name = "studentTable")
public class Student {
    @Column(name="name",type="varchar",length = 10)
    String name;
    @Column(name="age",type="int",length = 10)
    int age;
    @Column(name="sex",type="varchar",length = 10)
    String sex;
}
