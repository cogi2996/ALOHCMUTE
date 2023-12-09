import {
  app,
  db,
  auth,
  onAuthStateChanged,
} from "/SOCIALMEDIA/templates/firebase/firebase.js";
//import { currentUser } from "/SOCIALMEDIA/templates/user/script/home.js"
import {
  ref as dbRef,
  set,
  onValue,
  push,
} from "https://www.gstatic.com/firebasejs/10.5.2/firebase-database.js";
onAuthStateChanged(auth, (user) => {
  if (user) {
    const uid = user.uid;
    console.log("uid current user1: " + uid);
  } else {
    // User is signed out
    currentUser = null;
    console.log("No one here");
  }
});
let currentObserverPost;
let listOservered = new Set();
let listCommentOsereverd = new Set(); // dùng để lấy các comment ( parent, child) của post tại
let listObserverCommentParent = new Set(); // dùng để lấy các parent commnet của post hiện tại

//console.log(currentUser);
// render one comment function
const renderComment = function (
  commentContainer,
  comment,
  commentId,
  isParent = false
) {
  // còn thiếu uid - link click vào tên --> hiển thị trang cá nhân
  // còn thiếu commentID --> có gì xoá commnent
  const timeCreated =
    (Date.now() - new Date(comment.createAt).getTime()) / 1000 / 60 / 60 / 24;
  let displayTime;
  if (timeCreated >= 1) {
    displayTime = `${timeCreated} ngày`;
  } else if (timeCreated * 24 >= 1) {
    displayTime = `${Math.floor(timeCreated * 24)} giờ`;
  } else if (timeCreated * 24 * 60 >= 1) {
    displayTime = `${Math.floor(timeCreated * 24 * 60)} phút`;
  } else {
    displayTime = `Vừa mới đây`;
  }
  const htmlForParent = `        
    <div class="card post__comment__item" data-comment-id ="${commentId}">
    <div class="card-body">
      <div class="row">
        <div class="col">
          <div class="d-flex flex-start">
            <img
              class="rounded-circle shadow-1-strong me-3"
              src="${comment.avatar}"
              alt="avatar"
              width="65"
              height="65"
            />
            <div class="flex-grow-1 flex-shrink-1 comment">
              <div class="comment__container">
                <div>
                  <div
                    class="d-flex justify-content-between align-items-center"
                  >
                    <p class="mb-1">
                    ${comment.username} 
                        
                        <span class="small">- ${displayTime} </span>
                    </p>
                    <a class="btn__show-more"
                      ><i class="fas fa-reply fa-xs"></i
                      ><span class="small"> reply</span></a
                    >
                  </div>
                  <p class="small mb-0">
                  ${comment.content} 
                  </p>
                </div>
              </div>
              <!-- inuput text -->
              <div class="card input_comment_container d-none">
                <div
                  class="mt-3 d-flex flex-row align-items-center p-3 form-color"
                >
                  <img
                    src="https://media.licdn.com/dms/image/C4D03AQFTEOiGeGdutQ/profile-displayphoto-shrink_100_100/0/1657024175293?e=1707350400&v=beta&t=8w5gteNGTFSB2Yua7kTDzX5a5Pd6CT5YTPHi-gZIbGQ"
                    width="50"
                    class="rounded-circle mr-2"
                    style="margin-right: 10px"
                  />
                  <input
                    type="text"
                    class="form-control input_comment"
                    placeholder="  Viết câu trả lời..."
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    `;
  // nút show more active thì bỏ đi d-none
  let displayNone;
  if (
    !isParent &&
    !commentContainer
      .querySelector(".btn__show-more")
      .classList.contains("active")
  ) {
    displayNone = "d-none";
  }

  const htmlForChild = `
    <div class="d-flex flex-start mt-4 post__comment__item-child ${displayNone} " data-comment-id ="${commentId} ">
    <a class="me-3" href="#">
      <img
        class="rounded-circle shadow-1-strong"
        src="${comment.avatar}"
        alt="avatar"
        width="45"
        height="45"
      />
    </a>
    <div class="flex-grow-1 flex-shrink-1">
      <div>
        <div
          class="d-flex justify-content-between align-items-center"
        >
          <p class="mb-1">
          ${comment.username} 
            <span class="small"
              >-  ${displayTime}</span
            >
          </p>
        </div>
        <p class="small mb-0">
        ${comment.content} 
        </p>
      </div>
    </div>
  </div>
    `;

  if (isParent) {
    commentContainer.insertAdjacentHTML("beforeend", htmlForParent);
  } else commentContainer.insertAdjacentHTML("beforeend", htmlForChild);
};

// hàm load số lượng comment con của một comment cha
const loadChildComment = function (parentComment) {
  // lấy số lượng commnet con
  const sizeOfChildComment = parentComment.querySelectorAll(
    ".post__comment__item-child"
  ).length;
  // cập nhật số lượng cho nút reply
  parentComment.querySelector(".btn__show-more .small").textContent = `${
    sizeOfChildComment != 0 ? ` ${sizeOfChildComment} ` : ""
  } Trả lời`;
};

// function delegation
document.addEventListener("click", function (e) {
  // chủ tus tạo bình luận mới
  if (e.target.closest(".input_comment")) {
    const inputComment = e.target;
    const postID = inputComment.closest(".post").dataset.postId;
    inputComment.addEventListener("keypress", function (e) {
      // khi người dùng nhấn enter
      if (e.keyCode == 13 && inputComment.value != "") {
        const content = inputComment.value.trim();
        inputComment.value = "";
        //upload bình luận lên cloud

        uploadComment(postID, inputComment, content);
      }
    });
  } else if (e.target.closest(".post__feedback-comment")) {
    currentObserverPost = e.target
      .closest(".post__feedback-comment")
      .closest(".post");
    // hiển thị bình luận
    currentObserverPost
      .querySelector(".post__comment")
      .classList.toggle("d-none");

    let commentRef = dbRef(
      db,
      `posts/${currentObserverPost.dataset.postId}/comments`
    );
    // lắng nghe sự kiện comment post nếu đã lăng nghe rồi thì không khởi tạo lăng nghe nữa
    if (listOservered.has(currentObserverPost.dataset.postId)) return;
    // khởi tạo một array chỉ chứa các
    listOservered.add(currentObserverPost.dataset.postId);
    onValue(commentRef, (snapshot) => {
      const comments = snapshot.val();
      for (const commentKey in comments) {
        if (listCommentOsereverd.has(commentKey)) continue;
        listCommentOsereverd.add(commentKey);
        const comment = comments[commentKey];
        // kiểm tra commnet cha đã được quan sát chưa
        if (!comment.parentId) {
          listObserverCommentParent.add(commentKey);
        }
        // nếu là comment cha
        let commentContainer = null;
        // resert comment
        if (comment.parentId == null) {
          commentContainer = currentObserverPost.querySelector(
            ".post__comment__list"
          );
          renderComment(commentContainer, comment, commentKey, true);
        }
        // nếu là bình luận con
        else {
          commentContainer = currentObserverPost
            .querySelector(
              `.post__comment__item[data-comment-id='${comment.parentId}']`
            )
            .querySelector(".comment__container");
          renderComment(commentContainer, comment, commentKey);
        }
      }
      // khởi tạo các giá trị hiển thị số lượng comment con của comment cha

      [...listObserverCommentParent].forEach((commentParentId) => {
        // post__comment__item
        const parentComment = currentObserverPost.querySelector(
          `.post__comment__item[data-comment-id='${commentParentId}']`
        );
        // kiểm tra nếu parentComment có phải là parent comment hiện tại không
        if (!parentComment) return;
        loadChildComment(parentComment);
      });
    });

    // const inputComment = e.target;
    // const postID = inputComment.closest(".post").dataset.postId;
    // nếu hidden thì hiển load bình luận
    // nếu chưa hidden thì hidden
  } else if (e.target.closest(".btn__show-more")) {
    e.target.closest(".btn__show-more").classList.toggle("active");
    const commentElement = e.target
      .closest(".btn__show-more")
      .closest(".comment");
    // hiển thị comment con
    commentElement
      .querySelectorAll(".post__comment__item-child")
      .forEach((comment) => {
        comment.classList.toggle("d-none");
      });
    //hiển thị input comment con
    commentElement
      .querySelector(".input_comment_container")
      .classList.toggle("d-none");
  }
  if (e.target.closest(".btn__feedback-like")) {
    const btn_like = e.target.closest(".btn__feedback-like");
    const postId = e.target.closest(".btn__feedback-like").closest(".post")
      .dataset.postId;
    console.log(btn_like);
    console.log(postId);
    fetch(`/SOCIALMEDIA/api/v1/likePost?postId=${postId}`, {
      method: "GET",
      headers: {
        "Content-Type": "aplication/json",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        btn_like.querySelector("p").textContent = `${data} like`;
      });
  }
});

// upload bình luận với id và nội dung bình luận (postID, uid, text, time)
function uploadComment(postID, inputComment, content) {
  if (content == "") return;
  const currentUser = auth.currentUser;

  const uid = currentUser.uid;
  const username = currentUser.displayName;
  console.log(`displayname current : ${auth.currentUser}`);
  const createAt = Date.now();
  const avatar = currentUser.photoURL;
  const newComment = {
    uid: uid,
    username: username,
    content: content,
    createAt: createAt,
    avatar: avatar,
  };
  // nếu là bình luận con --> thêm parentId vào object
  if (inputComment.closest(".post__comment__item")) {
    const parentId = inputComment.closest(".post__comment__item").dataset
      .commentId;
    newComment.parentId = parentId;
  }
  let commentRef = push(dbRef(db, `posts/${postID}/comments`));
  // upload lên firebase
  set(commentRef, newComment)
    .then(() => {})
    .catch((error) => {
      console.error("Error writing comment: ", error);
    });
}
