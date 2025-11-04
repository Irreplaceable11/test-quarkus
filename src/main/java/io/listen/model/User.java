package io.listen.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.generator.Generator;

@Table(name = "users")
@Entity
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // 用户名
    public String name;

    // 性别
    public String gender;
}
