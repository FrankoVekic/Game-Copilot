package controller;

import java.util.List;
import org.hibernate.Session;
import util.CopilotException;
import util.HibernateUtil;

public abstract class Controller<T> {

    protected Session session;
    protected T entity;

    public abstract List<T> read();

    protected abstract void controlCreate() throws CopilotException;

    protected abstract void controlUpdate() throws CopilotException;

    protected abstract void controlDelete() throws CopilotException;

    public Controller() {

        session = HibernateUtil.getSession();

    }

    public T create() throws CopilotException {
        controlCreate();
        save();
        return entity;
    }

    public T update() throws CopilotException {
        controlUpdate();
        save();
        return entity;
    }

    public void delete() throws CopilotException {
        controlDelete();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
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
