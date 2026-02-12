package hellojpa;

import jakarta.persistence.*;

@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
