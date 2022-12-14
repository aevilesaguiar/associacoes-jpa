package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Proprietario;
import com.treinamento.model.TipoCombustivel;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Date;

public class PersistindoDados {
    public static void main(String[] args) {
        EntityManager manager= JPAUtil.getEntityManager();
        EntityTransaction tx= manager.getTransaction();

        //quando o JPA faz alguma operação que não é uma simples leitura do BD ele precisa de uma transação
        tx.begin();//inicia uma transação com o BD


        Proprietario proprietario=new Proprietario("Jose alfredo","11 5656-8989","jose@gmail.com");
        Proprietario proprietario2=new Proprietario("Maria da Silva","11 5656-8989","jose@gmail.com");

        manager.persist(proprietario);
        manager.persist(proprietario2);

        //persistir objetos(inserir registros no Bancod e dados)
        Veiculo veiculo= new Veiculo("Honda","Civic",2012,2013,90000.00, TipoCombustivel.ALCOOL, new Date(), LocalDate.now(),proprietario);
        Veiculo veiculo1= new Veiculo("Corsa ","Sedan",2022,2022,110000.00,TipoCombustivel.DIESEL, new Date(),LocalDate.now(),proprietario2);
        Veiculo veiculo2= new Veiculo("VW","Gol",2019,2019,70000.00,TipoCombustivel.GASOLINA, new Date(),LocalDate.now(),proprietario2);

        manager.persist(veiculo);
        manager.persist(veiculo1);
        manager.persist(veiculo2);

        tx.commit();


        manager.close();
        JPAUtil.close();


    }
}
