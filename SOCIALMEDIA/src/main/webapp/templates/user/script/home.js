import {
	storage,
	ref,
	uploadBytesResumable,
	getDownloadURL,
	onAuthStateChanged,
	auth,
	getAuth,
} from "/SOCIALMEDIA/templates/firebase/firebase.js";

/*const insertPost = function(post) {
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
	document
		.querySelector(".post-container")
		.insertAdjacentHTML("beforeend", html);
};*/

const btn_inputCreatePost = document.querySelector(".create-post__input");
const btn_closeCreatePost = document.querySelector(".card-header .btn-close");
const btn_submit = document.querySelector(".form-createPost .btn-submit ");
let currentUser = null;

onAuthStateChanged(auth, (user) => {
	if (user) {
		currentUser = user;
		const uid = user.uid;
		console.log(currentUser);
		console.log("uid current user: " + currentUser.uid);
	} else {
		// User is signed out
		currentUser = null;
		console.log("No one here");
	}
});

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
let stateRequest = null;

$(window).scroll(function() {
	if ($(window).scrollTop() + $(window).height() + 1 >= $(document).height()) {
		if (stateRequest != null) return;
		console.log("Đã gửi request");
		stateRequest = 1; // reqeust dang được xử lí
		loadAjax();
	}
});
// callback render các post
const renderPost = function(post) {
	const listPost = document.querySelector(".list-post");
	if (post.img) {
		const htmlHasPic = `
    <li class="wrapper post" data-post-id="${post.postid}">
            <div class="post__header">
              <div class="main-author">
                <img class="main-author__avatar" alt="Subreddit Icon"
                  role="presentation"
                  src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
                <p class="main-author__name">KTX ĐHQG TP.HCM</p>
              </div>
              <div class="sub-author">
                <img class="sub-author__avatar" alt="Subreddit Icon"
                  role="presentation"
                  src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
                <p class="sub-author__name">${post.username}</p>
              </div>
            </div>
            <div class="post__content">
              <div class="content-text">${post.text}</div>
              <div class="content-media"
                  style="position: relative; display: flex; justify-content: center; align-items: center;">
                  <div class="background"
                    style="background-image: url(${post.img}); opacity: 0.1; position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></div>
                  <div class="content-media__img"
                    style="position: relative; z-index: 1">
                    <img
                      src="${post.img}"
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
              <button type="button"
                class="feedback__btn post__feedback-comment">
                <i class="fa-regular fa-comment icon"></i>
                <p>Comment</p>
              </button>
              <button type="button" class="feedback__btn">
                <i class="fa-solid fa-share icon"></i>
                <p>44 Comment</p>
              </button>
              <button type="button" class="feedback__btn">
                <i class="fa-solid fa-ellipsis-vertical"></i>
              </button>
            </div>
            <section class="gradient-custom post__comment d-none">
              <div class="container">
                <div
                  class="row d-flex justify-content-center post__comment__list custom-scrollbar">
                  <!-- bình luận cha -->
            
                </div>
              </div>
              <!-- input bình luận cha -->
              <div class="card">
                <div
                  class="mt-3 d-flex flex-row align-items-center p-3 form-color">
                  <img
                    src="https://media.licdn.com/dms/image/C4D03AQFTEOiGeGdutQ/profile-displayphoto-shrink_100_100/0/1657024175293?e=1707350400&v=beta&t=8w5gteNGTFSB2Yua7kTDzX5a5Pd6CT5YTPHi-gZIbGQ"
                    width="50" class="rounded-circle mr-2"
                    style="margin-right: 10px" /> <input type="text"
                    class="form-control input_comment"
                    placeholder="  Viết câu trả lời..." />
                </div>
              </div>
            </section>
          </li>
          
  `;
		listPost.insertAdjacentHTML("beforeend", htmlHasPic);
		return;
	}

	const htmlWithoutPic = `
		<li class="wrapper post" data-post-id="${post.postid}">
						<div class="post__header">
							<div class="main-author">
								<img class="main-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="main-author__name">KTX ĐHQG TP.HCM</p>
							</div>
							<div class="sub-author">
								<img class="sub-author__avatar" alt="Subreddit Icon"
									role="presentation"
									src="https://styles.redditmedia.com/t5_356bu/styles/communityIcon_ski6pyqvm4t11.png" />
								<p class="sub-author__name">${post.username}</p>
							</div>
						</div>
						<div class="post__content">
							<div class="content-text">${post.text}</div>
							</div>
						</div>
						<div class="post__feedback">
							<button type="button" class="feedback__btn active"
								onclick="handelToggleLike()">
								<i class="fa-solid fa-thumbs-up icon"></i>
								<p>100 Like</p>
							</button>
							<button type="button"
								class="feedback__btn post__feedback-comment">
								<i class="fa-regular fa-comment icon"></i>
								<p>Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-share icon"></i>
								<p>44 Comment</p>
							</button>
							<button type="button" class="feedback__btn">
								<i class="fa-solid fa-ellipsis-vertical"></i>
							</button>
						</div>
						<section class="gradient-custom post__comment d-none">
							<div class="container">
								<div
									class="row d-flex justify-content-center post__comment__list custom-scrollbar">
									<!-- bình luận cha -->
						
								</div>
							</div>
							<!-- input bình luận cha -->
							<div class="card">
								<div
									class="mt-3 d-flex flex-row align-items-center p-3 form-color">
									<img
										src="https://media.licdn.com/dms/image/C4D03AQFTEOiGeGdutQ/profile-displayphoto-shrink_100_100/0/1657024175293?e=1707350400&v=beta&t=8w5gteNGTFSB2Yua7kTDzX5a5Pd6CT5YTPHi-gZIbGQ"
										width="50" class="rounded-circle mr-2"
										style="margin-right: 10px" /> <input type="text"
										class="form-control input_comment"
										placeholder="  Viết câu trả lời..." />
								</div>
							</div>
						</section>
					</li>
	`;
	listPost.insertAdjacentHTML("beforeend", htmlWithoutPic);
};

function loadAjax() {
	var amount = document.getElementsByClassName("post").length;
	fetch(`/SOCIALMEDIA/api/v1/posts/loadAjaxPost?exits=${amount}`, {
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},
	})
		.then((res) => res.json())
		.then((data) => {
			console.log("chuyển trạng thái về lại");
			stateRequest = null;
			data.forEach((post) => {
				renderPost(post);
			});
		});
}

// hàm tải ảnh lên storage
function uploadImage(file) {
	return new Promise((resolve, reject) => {
		const metadata = {
			contentType: file.type,
		};
		const fileName = Date.now();
		console.log(fileName);

		const storageRef = ref(storage, `images/${fileName}`);
		const uploadTask = uploadBytesResumable(storageRef, file, metadata);

		uploadTask.on(
			"onStateChanged",
			(snapshot) => {
				// Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
				const progress =
					(snapshot.bytesTransferred / snapshot.totalBytes) * 100;
				console.log("Upload is " + progress + "% done");
				switch (snapshot.state) {
					case "paused":
						console.log("Upload is paused");
						break;
					case "running":
						console.log("Upload is running");
						break;
				}
			},
			(error) => {
				reject(`Có lỗi ở upload ảnh lên firebase: ` + error);
			},
			() => {
				// Upload completed successfully, now we can get the download URL
				getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {
					console.log("File available at", downloadURL);
					resolve(downloadURL);
				});
			}
		);
	});
}

btn_submit.addEventListener("click", function(e) {
	e.preventDefault();
	const text = document.querySelector(".form-createPost #content").value;
	const uid = currentUser.uid;
	if (!document.getElementById("image").files[0]) {
		fetch(`/SOCIALMEDIA/api/v1/posts`, {
			method: "POST",
			headers: {
				"Content-Type": "aplication/json",
			},
			body: JSON.stringify({
				userid: uid,
				text: text,
			}),
		});
	} else {
		const img = uploadImage(document.getElementById("image").files[0]);
		img.then((urlImg) => {
			fetch(`/SOCIALMEDIA/api/v1/posts`, {
				method: "POST",
				headers: {
					"Content-Type": "aplication/json",
				},
				body: JSON.stringify({
					userid: uid,
					text: text,
					img: urlImg,
				}),
			});
		});
	}

	const createPostModal = document.querySelector(
		".create-post .create-post__modal"
	);
	createPostModal.style.display = "none";
});

// làm phần lắng nghe sự kiện follow
document.querySelectorAll(".btn__follow").forEach((btn_follow) => {
	btn_follow.addEventListener("click", (e) => {
		const targetFollowId = btn_follow.dataset.userId;

		fetch(`/SOCIALMEDIA/api/v1/userFollow?targetID=${targetFollowId}`, {
			method: "GET",
			headers: {
				"Content-Type": "aplication/json",
			},
		}).then(() => {
			btn_follow.innerHTML = `<i class="fa-solid fa-user-plus"></i>`;
		});
	});
});
