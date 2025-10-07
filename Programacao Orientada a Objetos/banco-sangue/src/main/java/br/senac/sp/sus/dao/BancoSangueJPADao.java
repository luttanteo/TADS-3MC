package br.senac.sp.sus.dao;

import br.senac.sp.sus.model.BancoSangue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.sql.SQLException;
import java.util.List;

public class BancoSangueJPADao implements InterfaceDao<BancoSangue> {
    private EntityManager manager;

    public BancoSangueJPADao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void inserir(BancoSangue objeto) throws SQLException {
        this.manager.persist(objeto);
        this.manager.getTransaction().begin();
        this.manager.getTransaction().commit();
    }

    @Override
    public void alterar(BancoSangue objeto) throws SQLException {

    }

    @Override
    public void excluir(int id) throws SQLException {

    }

    @Override
    public List<BancoSangue> listar() throws SQLException {
        TypedQuery<BancoSangue> query = manager.createQuery("select b from BancoSangue b order by b.id", BancoSangue.class);
        return query.getResultList();
    }
}
