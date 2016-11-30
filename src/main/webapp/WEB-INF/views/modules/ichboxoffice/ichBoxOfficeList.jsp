<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>财盒机构信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/ichboxoffice/ichBoxOffice/">财盒机构信息列表</a></li>
		<shiro:hasPermission name="ichboxoffice:ichBoxOffice:edit"><li><a href="${ctx}/ichboxoffice/ichBoxOffice/form">财盒机构信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ichBoxOffice" action="${ctx}/ichboxoffice/ichBoxOffice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>ICHID：</label>
				<form:input path="ichId" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>归属公司：</label>
				<sys:treeselect id="office" name="office.id" value="${ichBoxOffice.office.id}" labelName="office.name" labelValue="${ichBoxOffice.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>ICHID</th>
				<th>归属公司</th>
				<th>备注信息</th>
				<shiro:hasPermission name="ichboxoffice:ichBoxOffice:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ichBoxOffice">
			<tr>
				<td><a href="${ctx}/ichboxoffice/ichBoxOffice/form?id=${ichBoxOffice.id}">
					${ichBoxOffice.ichId}
				</a></td>
				<td>
					${ichBoxOffice.office.name}
				</td>
				<td>
					${ichBoxOffice.remarks}
				</td>
				<shiro:hasPermission name="ichboxoffice:ichBoxOffice:edit"><td>
    				<a href="${ctx}/ichboxoffice/ichBoxOffice/form?id=${ichBoxOffice.id}">修改</a>
					<a href="${ctx}/ichboxoffice/ichBoxOffice/delete?id=${ichBoxOffice.id}" onclick="return confirmx('确认要删除该财盒机构信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>