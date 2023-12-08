document.addEventListener("DOMContentLoaded", function () {

});

function setScrollChat() {
    // Lấy phần tử chứa thanh cuộn
    var chatContainer = document.querySelector(".msg_history");
    // Cuộn xuống dưới cùng khi trang được tải
    chatContainer.scrollTop = chatContainer.scrollHeight;
}

function loadUser() {
    // Promise getApi
    fetch("https://...")
        .then((response) => response.json())
        .then((data) => {
            // Xử lý dữ liệu sau khi nhận được
            console.log(data);

            // Hiển thị dữ liệu lên giao diện
            data.forEach((user) => {
                let chatElement = document.createElement("div");
                chatElement.className = "chat_list";
                chatElement.innerHTML = `
            <div class="chat_people" data-user-id="${user.userID}">
                <div class="chat_img">
                    <img src="${user.avatar}" alt="No image" />
                </div>
                <div class="chat_ib">
                    <h5>${user.firstName} ${user.midName} ${user.lastName}<span class="chat_date">${user.lastLogin}</span></h5>
                    //<p>${user.message}</p>
                </div>
            </div>
        `;
                chatContainer.appendChild(chatElement);
            });
        })
        .catch((error) => console.error("Error fetching data:", error));
}

fetch("http://..")
    .then((response) => response.json())
    .then(data)
    .catch();
