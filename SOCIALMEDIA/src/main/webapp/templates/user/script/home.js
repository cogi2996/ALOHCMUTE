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
btn_inputCreatePost.addEventListener("click", function () {
  const modalCreatePost = document.querySelector(".create-post__modal");
  const body = document.querySelector(".home-content");
  modalCreatePost.style.display = "block";
});

btn_closeCreatePost.addEventListener("click", function () {
  const createPostModal = document.querySelector(
    ".create-post .create-post__modal"
  );
  createPostModal.style.display = "none";
});




