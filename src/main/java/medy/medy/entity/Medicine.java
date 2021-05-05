package medy.medy.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Medicine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Long id;

    @Column(name = "medicine_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicinebag_id")
    private MedicineBag medicineBag;

    private void setMedicineBag(MedicineBag medicineBag) {
        this.medicineBag = medicineBag;
        medicineBag.getMedicines().add(this);
    }
}
