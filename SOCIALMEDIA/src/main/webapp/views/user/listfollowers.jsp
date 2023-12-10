<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="wrapper-follower">
  <div>
    <!-- api = listfollower{avatar, lastName, midName ,firstName} -->
    <!-- Placeholder for follower item -->
    <!-- <div class="list-follower">
      <c:forEach items="${listfollower}" var="item" varStatus="STT">
      <div class="follower-container">
        <img class="follower__avatar" src="${item.avatar}"" alt="avatar" />
        <div class="follower__info">
       		<span class="follower__name">${item.lastName} ${item.midName} ${item.firstName}</span>
       		<span class="follower__address">{item.address}</span>
        </div>
        <button type="button" class="btn btn-secondary">Thêm bạn bè</button>
      </div>
      </c:forEach>
      </div> -->
    <!-- Thay thể mã html bên dưới bằng code phía trên  + chỉnh đường dẫn file css là oke-->
    <ul class="list-follower">
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
      <li class="follower-container">
        <img class="follower__avatar" src="templates/user/image-test/avatar.jpg" alt="" />
        <div class="follower__info">
          <span class="follower__name">Thanh Thảo</span>
          <span class="follower__address">Thành phố Hồ chí minh</span>
        </div>
        <button type="button" class="btn btn-secondary follower__btn">Thêm bạn bè</button>
      </li>
    </ul>
  </div>
  <link rel="stylesheet" href="templates/user/css/follower.css" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</div>
