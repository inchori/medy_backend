package medy.medy.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class MedicineBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicinebag_id")
    private Long id;

    @Column(name = "medicinebag_name")
    private String name;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "medicineBag", cascade = CascadeType.ALL)
    private List<Medicine> medicines = new ArrayList<>();

    private void setMember(Member member) {
        this.member = member;
        member.getMedicineBags().add(this);
    }
}
