package pl.countedmacrobackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "vitamins_and_minerals")
public class VitaminsAndMinerals {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private double vit_A;
    private double vit_B6;
    private double vit_B12;
    private double vit_D;
    private double vit_D3;
    private double vit_E;
    private double vit_K;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public VitaminsAndMinerals() {
    }

    public VitaminsAndMinerals(final Long id, final double vit_A, final double vit_B6, final double vit_B12, final double vit_D, final double vit_D3, final double vit_E, final double vit_K, final Product product) {
        this.id = id;
        this.vit_A = vit_A;
        this.vit_B6 = vit_B6;
        this.vit_B12 = vit_B12;
        this.vit_D = vit_D;
        this.vit_D3 = vit_D3;
        this.vit_E = vit_E;
        this.vit_K = vit_K;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public double getVit_A() {
        return vit_A;
    }

    public void setVit_A(final double vit_A) {
        this.vit_A = vit_A;
    }

    public double getVit_B6() {
        return vit_B6;
    }

    public void setVit_B6(final double vit_B6) {
        this.vit_B6 = vit_B6;
    }

    public double getVit_B12() {
        return vit_B12;
    }

    public void setVit_B12(final double vit_B12) {
        this.vit_B12 = vit_B12;
    }

    public double getVit_D() {
        return vit_D;
    }

    public void setVit_D(final double vit_D) {
        this.vit_D = vit_D;
    }

    public double getVit_D3() {
        return vit_D3;
    }

    public void setVit_D3(final double vit_D3) {
        this.vit_D3 = vit_D3;
    }

    public double getVit_E() {
        return vit_E;
    }

    public void setVit_E(final double vit_E) {
        this.vit_E = vit_E;
    }

    public double getVit_K() {
        return vit_K;
    }

    public void setVit_K(final double vit_K) {
        this.vit_K = vit_K;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }
}