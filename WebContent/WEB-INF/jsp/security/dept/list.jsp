<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/global.jsp"%>
    <title>部门管理</title>
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-styles.jsp" %>
	<script type="text/javascript" src="${ctx}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${ctx }/js/grid.js"></script>
</head>

<body>

	<div id="navigatorDiv">
	  	<button type="button" id="addButton" class="button positive" actionUrl="${ctx }/security/dept!toAdd.action">
    		<img src="${ctx}/js/easyui/themes/icons/edit_add.png" alt=""/> 新建
  	  	</button>
	  	<button type="button" id="deleteButton" class="button positive">
    		<img src="${ctx}/js/easyui/themes/icons/edit_remove.png" alt=""/> 删除
  	  	</button>
	  	<button type="button" id="queryButton" class="button positive">
    		<img src="${ctx}/js/easyui/themes/icons/search.png" alt=""/> 查询
  	  	</button>
	</div>
	
	<div id="queryDiv">
	<form id="queryForm" class="form-horizontal" action="${ctx}/security/dept!findPage.action" method="post">
		<fieldset>
		<legend><small>部门查询</small></legend>
		<table >
			<tr>
				<td width="10%"><label>部门地址：</label></td>
				<td width="40%">
					<select name="select2" >
						<option value="1">1</option>
					</select>
				</td>
				<td width="20%"><label>部门名称1：</label></td>
				<td>
					<s:textfield name="deptName"></s:textfield>
				</td>
			</tr>
		</table>
		</fieldset>
	</form>
	</div>
  
  <form id="deleteForm" action="${ctx }/security/dept!delete.action">
	
	<div id="dataDiv">    
    <table width="100%" >
	  <thead>
	    <tr>
      	  <th  width="1%"><input type="checkbox" id="checkAllCheckBox"></th>
          <th>部门编号</th>
          <th>部门名称</th>
          <th>操作</th>
	    </tr>
	  <tbody>
  		<s:iterator value="#page.result">
  	    <tr>
          <td><input type="checkbox" name="ids" value="${id }"></td>
          <td>${id}</td>
          <td>${deptName }</td>
          <td><a href="${ctx}/security/dept!toUpdate.action?id=${id}">修改</a></td>
	    </tr>
		</s:iterator>
	  </tbody>
	</table>
    </div>
      	
  </form>
  
  <!-- 调用分页自定义标签，传递参数${page} -->
  <tags:pagination page="${page }"></tags:pagination>  
  
 </body>
</html>
