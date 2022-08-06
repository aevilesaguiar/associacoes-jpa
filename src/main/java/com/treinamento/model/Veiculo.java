package com.treinamento.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tab_veiculos")
public class Veiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @Column(length = 60, nullable = false)
    private String fabricante;
    @Column(length = 60, nullable = false)
    private String modelo;
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;
    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;
    @Column(precision = 10, scale = 2, nullable = true)
    private Double valor;

    @Column(name = "tipo_combustivel",nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_compra",nullable = false)
    private Date dataCompra;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "cod_proprietario")
    private Proprietario proprietario;

    @ManyToMany
    @JoinTable(name = "veiculo_acessorios",
            joinColumns = @JoinColumn(name = "cod_veiculo"),
            inverseJoinColumns = @JoinColumn(name = "cod_acessorio")
    )
    private Set<Acessorio> acessorios=new HashSet<>();


    public Veiculo() {

    }

    public Veiculo(String fabricante, String modelo, Integer anoFabricacao, Integer anoModelo, Double valor, TipoCombustivel tipoCombustivel, Date dataCompra, LocalDate dataCadastro, Proprietario proprietario) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.valor = valor;
        this.tipoCombustivel = tipoCombustivel;
        this.dataCompra = dataCompra;
        this.dataCadastro = dataCadastro;
        this.proprietario = proprietario;
    }

    public Veiculo(String fabricante, String modelo, Integer anoFabricacao, Integer anoModelo, Double valor, TipoCombustivel tipoCombustivel, Date dataCompra, LocalDate dataCadastro, Proprietario proprietario, Set<Acessorio> acessorios) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.valor = valor;
        this.tipoCombustivel = tipoCombustivel;
        this.dataCompra = dataCompra;
        this.dataCadastro = dataCadastro;
        this.proprietario = proprietario;
        this.acessorios = acessorios;
    }


    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Set<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Set<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(codigo, veiculo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
