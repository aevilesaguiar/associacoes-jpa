package com.treinamento.principal;

import com.treinamento.dao.JPAUtil;
import com.treinamento.model.Proprietario;
import com.treinamento.model.Veiculo;

import javax.persistence.EntityManager;

public class BuscaProprietarioListaVeiculo {
    public static void main(String[] args) {

        EntityManager manager= JPAUtil.getEntityManager();

        Proprietario proprietario=manager.find(Proprietario.class,2L);

        System.out.println("Proprietario: "+proprietario.getNome());

        for (Veiculo veiculo: proprietario.getVeiculos()
             ) {
            System.out.println("Veiculo: "+veiculo.getModelo());

        }

        manager.close();
        JPAUtil.close();








    }
}
