package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Acessorio;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ConsultandoAcessorioVeiculo {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();

        Veiculo veiculo= manager.find(Veiculo.class,4L);
        System.out.println("Veiculo: "+veiculo.getModelo());

        for (Acessorio acessorio: veiculo.getAcessorios()
             ) {
            System.out.println("Acessorio: "+acessorio.getDescricao());
        }

        manager.close();
        JPAUtil.close();

    }
}
