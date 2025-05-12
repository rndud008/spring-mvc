package hello.hellobasic.hellojpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;

    @Transient
    private int temp;

    //     create table Member (
    //        age integer,
    //        testLocalDate date,
    //        createdDate timestamp(6),
    //        id bigint not null,
    //        lastModifiedDate timestamp(6),
    //        testLocalDateTime timestamp(6),
    //        name varchar(255) not null,
    //        description clob,
    //        roleType enum ('ADMIN','USER'),
    //        primary key (id)
    //    )

}
