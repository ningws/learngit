package com.lxs.security.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lxs.core.common.page.PageAction;
import com.lxs.core.common.page.PageResult;
import com.lxs.core.service.IBaseService;
import com.lxs.security.domain.Dept;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/security")
@Action(value="dept")
@Results({
	@Result(name="add", location="/WEB-INF/jsp/security/dept/add.jsp"),
	@Result(name="update", location="/WEB-INF/jsp/security/dept/update.jsp"),
	@Result(name="list", location="/WEB-INF/jsp/security/dept/list.jsp"),
	@Result(name="listAction", type="redirect", location="/security/dept!findPage.action")
	
})
public class DeptAction extends PageAction implements ModelDriven<Dept> {
	
	private Dept dept = new Dept();
	
	
	@Resource
	private IBaseService baseService;

	@Override
	public Dept getModel() {
		return dept;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public String findPage() {
		//根据实体类产生criteria
		DetachedCriteria criteria = DetachedCriteria.forClass(Dept.class);
		
		//查询条件
		if (null != dept.getDeptName() && !"".equals(dept.getDeptName())) {
			criteria.add(Restrictions.like("deptName", dept.getDeptName(),
					MatchMode.ANYWHERE));
		}
		
		//调用业务方法
		PageResult page = baseService.find(criteria, start, pageSize);
		
		ActionContext.getContext().put("page", page);
		return "list";
	}
	
	
}
