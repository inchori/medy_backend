package medy.medy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long id;

    @Column(name = "hospital_name")
    private String name;

    @Embedded
    private Address address;

    private String phone;

    private String doctor;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<MemberHospital> memberHospitals = new ArrayList<>();
}
