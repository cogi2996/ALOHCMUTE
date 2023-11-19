/*document
	.querySelector(".btn-createPost")
	.addEventListener("click", function(e) {
		e.preventDefault();
		document.querySelector(".post-create-container").classList.toggle("hidden");
	});
*/
/*document
	.querySelector(".post-create-container .btn-post")
	.addEventListener("click", function() {
		const titleValue = document.querySelector(".post-title #title").value;
		const contentValue = document.querySelector(
			".post-content-create #content"
		).value;
		const post = {
			title: titleValue,
			contentPost: contentValue,
		};
		fetch("http://localhost:8080/POST/createNewPost", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(post),
		}).then((response) => {
			return response.json(); // Trả về dữ liệu JSON từ phản hồi
		})
			.then((data) => {
				console.log(data);
				insertPost(data);
			})
			.catch((error) => {
				console.error("Lỗi xảy ra: " + error);
			});
	});
*/
const insertPost = function(post) {
	const html = `
      <div class="post " data-post_id = ${post.post_id}>
        <div class="user-info">
          <img src="user-avatar.jpg" alt="Avatar" class="user-avatar" />
          <span class="user-name">#own'post</span>#
          <span class="user-id">#own's id</span>
        </div>
        <div class="post-content">
        <p>${post.title}</p>
        <br>
          <p>${post.contentPost}</p>
          <img src="post-image.jpg" alt="Post Image" class="post-image" />
        </div>

        <div class="post-actions">
          <button class="action-button">Like</button>
          <button class="action-button btn-comment">Comment</button>
          <button class="action-button">Share</button>
        </div>
        <div class="comment hidden">
          <div class="comment-list"></div>
          <form class="comment-submit" action="">
            <input class="comment-input" type="text" />
            <input type="submit" value="send" />
          </form>
        </div>
   
    </div>`;
	document.querySelector(".post-container").insertAdjacentHTML("beforeend", html);

}

const btn_inputCreatePost = document.querySelector(".create-post__input");
const btn_closeCreatePost = document.querySelector(".card-header .btn-close");
btn_inputCreatePost.addEventListener("click", function() {
	const modalCreatePost = document.querySelector(".create-post__modal");
	const body = document.querySelector(".home-content");
	modalCreatePost.style.display = "block";
});

btn_closeCreatePost.addEventListener("click", function() {
	const createPostModal = document.querySelector(
		".create-post .create-post__modal"
	);
	createPostModal.style.display = "none";
});
// xử lí phần gọi api nhận bài viết khi scroll đến cuối trang
$(window).scroll(
	function() {
		if ($(window).scrollTop() + $(window).height() +1>= $(
			document).height()) {
			loadAjax();
		}
	});
// callback render các post
const renderPost = function(post) {
	const listPost = document.querySelector(".list-post");
	const html = `
        <li class="wrapper post">
				<div class="post__header">
					<div class="main-author">
						<img class="main-author__avatar" alt="Subreddit Icon"
							role="presentation"
							src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
						<p class="main-author__name">${post.username} </p>
					</div>
				</div>
				<div class="post__content">
					<div class="content-text">${post.text} </div>
					<div class="content-media"
						style="position: relative; display: flex; justify-content: center; align-items: center;">
						<div class="background"
							style="background-image: url(/SOCIALMEDIA/image?fname=products/1697816290979.png); opacity: 0.1; position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></div>
						<div class="content-media__img"
							style="position: relative; z-index: 1">
							<img
								src="/SOCIALMEDIA/image?fname=products/1697816290979.png"
								alt="" width="500" height="500"
								style="display: block; margin: 0 auto" />
						</div>
					</div>
				</div>
				<div class="post__feedback">
					<button type="button" class="feedback__btn active"
						onclick="handelToggleLike()">
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
        `;
	listPost.insertAdjacentHTML("beforeend", html);
};

function loadAjax() {
	var amount = document.getElementsByClassName("post").length;
	console.log(`/SOCIALMEDIA/home/loadAjaxPost?exits=${amount}`)
	fetch(`/SOCIALMEDIA/home/loadAjaxPost?exits=${amount}`, {
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},
	}).then((res) => res.json())
		.then(data => {

			data.forEach((post) => {
				console.log("hello")
				renderPost(post)
			});
		});
};






