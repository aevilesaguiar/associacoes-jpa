package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Acessorio;
import com.treinamento.model.Proprietario;
import com.treinamento.model.TipoCombustivel;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Date;

public class PersistirRelacionarAcessoriosVeiculos {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();
        EntityTransaction tx= manager.getTransaction();
        tx.begin();

        //instacia proprietario
        Proprietario proprietario=new Proprietario("Jose alfredo","11 5656-8989","jose@gmail.com");
        Proprietario proprietario2=new Proprietario("Maria da Silva","11 5656-8989","jose@gmail.com");
        //persiste veiculo
        manager.persist(proprietario);
        manager.persist(proprietario2);

        //Instancia acessórios
        Acessorio alarme = new Acessorio("Alarme");
        Acessorio arCondicionado = new Acessorio("Ar Condicionado");
        Acessorio bancosDeCouro = new Acessorio("Bancos de Couro");
        Acessorio direcaoHidraulica = new Acessorio("Direção Hidraúlica");
        //persiste acessorio
        manager.persist(alarme);
        manager.persist(arCondicionado);
        manager.persist(bancosDeCouro);
        manager.persist(direcaoHidraulica);

        //Instancia Veiculo
        Veiculo veiculo= new Veiculo("Hyundai","I30",2012,2013,90000.00, TipoCombustivel.ALCOOL, new Date(), LocalDate.now(),proprietario);
        Veiculo veiculo1= new Veiculo("Corsa ","Sedan",2022,2022,110000.00,TipoCombustivel.DIESEL, new Date(),LocalDate.now(),proprietario2);
        Veiculo veiculo2= new Veiculo("VW","Gol",2019,2019,70000.00,TipoCombustivel.GASOLINA, new Date(),LocalDate.now(),proprietario2);


        veiculo.getAcessorios().add(arCondicionado);
        veiculo.getAcessorios().add(alarme);
        veiculo.getAcessorios().add(bancosDeCouro);
        veiculo.getAcessorios().add(direcaoHidraulica);

        veiculo1.getAcessorios().add(alarme);
        veiculo1.getAcessorios().add(arCondicionado);

        veiculo2.getAcessorios().add(alarme);

        //persiste veiculo
        manager.persist(veiculo);
        manager.persist(veiculo1);
        manager.persist(veiculo2);

        tx.commit();
        manager.close();
        JPAUtil.close();




    }
}
