<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css" />
</head>
<body>
<main>
      <div class="wrapper create-post">
        <a class="create-post__avatar">
          <img
            alt="User avatar"
            src="https://styles.redditmedia.com/t5_6tgdza/styles/profileIcon_snoob64c08dd-9253-4a17-9006-378fff570d44-headshot.png?width=256&amp;height=256&amp;crop=256:256,smart&amp;s=975f806419bee0b32ca65c2dcc6e1a9ef4ad2108"
          />
        </a>
        <input class="create-post__input" placeholder="Create Post" />
        <a class="create-post__link">
          <i class="fa-solid fa-image icon"></i>
        </a>
        <a class="create-post__link">
          <i class="fa-solid fa-link icon"></i>
        </a>
      </div>
      <ul class="list-post">
        <li class="wrapper post">
          <div class="post__header">
            <div class="main-author">
              <img
                class="main-author__avatar"
                alt="Subreddit Icon"
                role="presentation"
                src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png"
              />
              <p class="main-author__name">KTX ĐHQG TP.HCM</p>
            </div>
            <div class="sub-author">
              <img
                class="sub-author__avatar"
                alt="Subreddit Icon"
                role="presentation"
                src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png"
              />
              <p class="sub-author__name">Mỹ Phụng</p>
            </div>
          </div>
          <div class="post__content">
            <div class="content-text">
              GỬI CON. Có ai khen con đẹp. Con hãy cảm ơn và quên đi lời khen ấy
              Ai bảo con ngoan. Hãy cảm ơn và nhớ ngoan hiền hơn nữa Với người
              òa khóc vì nỗi đau mà họ đang mang… See more
            </div>
            <div class="content-media"></div>
          </div>
          <div class="post__feedback">
            <button
              type="button"
              class="feedback__btn active"
              onclick="handelToggleLike()"
            >
              <i class="fa-solid fa-thumbs-up icon"></i>
              <p>100 Like</p>
            </button>
            <button type="button" class="feedback__btn">
              <i class="fa-regular fa-comment icon"></i>
              <p>44 Comment</p>
            </button>
            <button type="button" class="feedback__btn">
              <i class="fa-solid fa-share icon"></i>
              <p>44 Comment</p>
            </button>
            <button type="button" class="feedback__btn">
              <i class="fa-solid fa-ellipsis-vertical"></i>
            </button>
          </div>
        </li>
      </ul>

      <ul class="list-post">
        <li class="wrapper post">
          <div class="post__header">
            <div class="main-author">
              <img
                class="main-author__avatar"
                alt="Subreddit Icon"
                role="presentation"
                src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png"
              />
              <p class="main-author__name">Mỹ Phụng</p>
            </div>
          </div>
          <div class="post__content">
            <div class="content-text">
              GỬI CON. Có ai khen con đẹp. Con hãy cảm ơn và quên đi lời khen ấy
              Ai bảo con ngoan. Hãy cảm ơn và nhớ ngoan hiền hơn nữa Với người
              òa khóc vì nỗi đau mà họ đang mang… See more
            </div>
            <div class="content-media"></div>
          </div>
          <div class="post__feedback">
            <button
              type="button"
              class="feedback__btn active"
              onclick="handelToggleLike()"
            >
              <i class="fa-solid fa-thumbs-up icon"></i>
              <p>100 Like</p>
            </button>
            <button type="button" class="feedback__btn">
              <i class="fa-regular fa-comment icon"></i>
              <p>44 Comment</p>
            </button>
            <button type="button" class="feedback__btn">
              <i class="fa-solid fa-share icon"></i>
              <p>44 Comment</p>
            </button>
            <button type="button" class="feedback__btn">
              <i class="fa-solid fa-ellipsis-vertical"></i>
            </button>
          </div>
        </li>
      </ul>
    </main>
	<script type="module" src="home.js"></script>
	<script type="module" src="loadCommentHome.js"></script>
</body>
</html>