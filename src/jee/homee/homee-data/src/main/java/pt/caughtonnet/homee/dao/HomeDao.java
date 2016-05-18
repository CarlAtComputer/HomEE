package pt.caughtonnet.homee.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.caughtonnet.homee.entity.Home;
import pt.caughtonnet.homee.entity.User;

@Local
@Stateless
public class HomeDao {

	@PersistenceContext(unitName = "homee")
	private EntityManager em;

	public List<Home> getUserHomes(User user) {
		TypedQuery<Home> q = em.createQuery("select h from Home h where h.user = :user", Home.class);
		q.setParameter("user", user);
		return q.getResultList();
	}

	public Home createHome(Home home) {
		em.persist(home);
		return home;
	}

}
