package controller;

import java.util.List;
import org.hibernate.Session;
import util.GCException;
import util.HibernateUtil;

public abstract class Controller<T> {

    protected Session session;
    protected T entity;

    public abstract List<T> read();

    protected abstract void controlCreate() throws GCException;

    protected abstract void controlUpdate() throws GCException;

    protected abstract void controlDelete() throws GCException;

    public Controller() {

        session = HibernateUtil.getSession();

    }

    public T create() throws GCException {
        controlCreate();
        save();
        return entity;
    }

    public T update() throws GCException {
        controlUpdate();
        save();
        return entity;
    }

    public T delete() throws GCException {
        controlDelete();
        save();
        return entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    private void save() {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }
}
