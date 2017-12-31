package cn.it.shop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.ProductDao;
import cn.it.shop.daoImpl.BaseDaoImpl;
import cn.it.shop.model.Pager;
import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;

/*
 * 模块自身的业务逻辑
 */
@SuppressWarnings("unchecked")
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql = "from Product p LEFT JOIN FETCH p.category where p.name LIKE :name";
		return getSession().createQuery(hql).setString("name", "%" + name + "%").setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	@Override
	public Long getCount(String name) {
		String hql = "select count(p) from Product p where p.name LIKE :name";
		return (Long) getSession().createQuery(hql).setString("name", "%" + name + "%").uniqueResult();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		String hql = "from Product p JOIN FETCH p.category where p.commend=true and p.open=true and p.category.id=:cid ORDER by p.date DESC";
		return getSession().createQuery(hql).setInteger("cid", cid).setFirstResult(0).setMaxResults(4).list();
	}

	@Override
	public List<Product> queryAllPro(int cid) {
		String hql = "from Product p JOIN FETCH p.category where p.commend=true AND p.open=true AND p.category.id=:cid ORDER BY p.date DESC";
		return getSession().createQuery(hql).setInteger("cid", cid).list();
	}

	@Override
	public List<String> getProName(String proname) {
		String hql = "select p.name from Product p where p.name like :name ORDER by p.id DESC limit 1,10";
		return getSession().createSQLQuery(hql).setString("name", "%" + proname + "%").list();
	}

	@Override
	public Pager<Product> getSearchProduct(int pageNum, int pageSize, String name) {
		Pager<Product> result = null;

		int fromIndex = pageSize * (pageNum - 1);

		String hql = "from Product p where p.commend=true and p.open=true and p.name like :name ORDER BY p.date DESC  limit "
				+ fromIndex + ", " + pageSize;
		// 计算总记录条数
		String countHql = "select count(p.id) from Product p where p.name like :name";

		// 存放product
		List<Product> productList = new ArrayList<Product>();
		productList = getSession().createQuery(hql).setString("name", "%" + name + "%").setFirstResult(fromIndex)
				.setMaxResults(pageSize).list();

		// 计算总记录条数
		List countResult = getSession().createQuery(countHql).setString("name", "%" + name + "%").list();
		int totalRecord = ((Number) countResult.get(0)).intValue();

		// 获取总页数
		int totalPage = totalRecord / pageSize;
		if (totalRecord % pageSize != 0) {
			totalPage++;
		}
		result = new Pager<Product>(pageSize, pageNum, totalRecord, totalPage, productList);
		return result;
	}
}
