<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Follower</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/src/main/webapp/templates/user/css/list-follower.css" />
  </head>
  <body>
    <main>
      <!-- api = listfollower{avatar, lastName, midName ,firstName} -->
      <!-- Placeholder for follower item -->
      <!-- <div class="list-follower">
      <c:forEach items="${listfollower}" var="item" varStatus="STT">
      <div class="follower-container">
        <img class="follower__avatar" src="${item.avatar}"" alt="avatar" />
        <span class="follower__name">${item.lastName} ${item.midName} ${item.firstName}</span>
        <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
      </div>
      </c:forEach>
      </div> -->
      <!-- Thay thể mã html bên dưới bằng code phía trên  + chỉnh đường dẫn file css là oke-->
      <div class="list-follower">
        <div class="follower-container">
          <img class="follower__avatar" src="/src/main/webapp/resource-test/avatar.jpg" alt="" />
          <span class="follower__name">Thanh Thảo</span>
          <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
        </div>
        <div class="follower-container">
          <img class="follower__avatar" src="/src/main/webapp/resource-test/avatar.jpg" alt="" />
          <span class="follower__name">Đăng Công Tuấn</span>
          <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
        </div>
        <div class="follower-container">
          <img class="follower__avatar" src="/src/main/webapp/resource-test/avatar.jpg" alt="" />
          <span class="follower__name">Thanh Thao</span>
          <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
        </div>
        <div class="follower-container">
          <img class="follower__avatar" src="/src/main/webapp/resource-test/avatar.jpg" alt="" />
          <span class="follower__name">Thanh Thao</span>
          <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
        </div>
        <div class="follower-container">
          <img class="follower__avatar" src="/src/main/webapp/resource-test/avatar.jpg" alt="" />
          <span class="follower__name">Thanh Thao</span>
          <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
        </div>
        <div class="follower-container">
          <img class="follower__avatar" src="/src/main/webapp/resource-test/avatar.jpg" alt="" />
          <span class="follower__name">Việt Hoàng</span>
          <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
        </div>
      </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
