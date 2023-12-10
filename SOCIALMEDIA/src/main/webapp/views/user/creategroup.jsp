<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="creategroup" method="post">
		<!-- 2 column grid layout with text inputs for the Group ID and Creater ID -->
		<div class="row mb-4">
			<div class="col">
				<div data-mdb-input-init class="form-outline">
					<label class="form-label" for="creategroup">Group ID</label> <input
						type="text" id="creategroup" class="form-control"
						readonly="readonly" name="GroupID" />
				</div>
			</div>
			<div class="col">
				<div data-mdb-input-init class="form-outline">
					<label class="form-label" for="creategroup">Creater ID</label> <input
						readonly="readonly" type="text" id="creategroup"
						class="form-control" name="CreaterID" />
				</div>
			</div>
		</div>

		<!-- Group Name input -->
		<div data-mdb-input-init class="form-outline mb-4">
			<label class="form-label" for="creategroup">Group Name</label> <input
				type="text" id="creategroup" class="form-control" naem="GroupName" />
		</div>

		<!-- Create Time input -->
		<div data-mdb-input-init class="form-outline mb-4">
			<label class="form-label" for="creategroup">Create Time</label> <input
				type="date" id="creategroup" class="form-control" name="CreateTime" />
		</div>

		<!-- Submit button -->
		<button data-mdb-ripple-init class="btn btn-primary btn-block mb-4"
			type="submit" value="Insert group">Add new Group</button>
	</form>
</body>
</html>